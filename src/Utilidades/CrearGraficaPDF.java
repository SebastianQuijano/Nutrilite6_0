/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.entity.StandardEntityCollection;

/**
 *
 * @author Erick
 */
public class CrearGraficaPDF {

    private final static String nombre = "medidas.png";
    //Ruta del archivo, esto es dentro del proyecto Netbeans
    private static final String archivo = System.getProperty("user.dir") + "/archivo.pdf";

    //Clase para manejar los Header y los Footer
    //Toma los metodos de PdfPageEventHelper
    private static class HeaderFooter extends PdfPageEventHelper {

        //Declaramos la imagen y texto de la cabecera
        Phrase imgCabecera;
        Phrase txtCabecera;
        Image imagen;

        //Evento cuando que se ejecuta en cada nueva pagina del pdf
        @Override
        public void onStartPage(PdfWriter writer, Document document) {
            try {
                //Obtenemos la imagen
                imagen = Image.getInstance(nombre);

                //Convertimos la imagen a un Chunck
                //Chunck es la parte mas pequeÃ±a que puede ser aÃ±adida a un documento
                Chunk chunk = new Chunk(imagen, -50, -300);

                //Convertimos el Chunk en un Phrase
                //Phrase es una serie de Chunks
                imgCabecera = new Phrase(chunk);

                //Agregamos tambien un texto que acompaÃ±e la imagen
                txtCabecera = new Phrase("");

            } catch (BadElementException | IOException e) {
                e.getMessage();
            }

            //Creamos un objeto PdfContentByte donde se guarda el contenido 
            //de una pÃ¡gina en el pdf. GrÃ¡ficos y texto.
            PdfContentByte cb = writer.getDirectContent();

            //Agregamos la imagen y el texto al documento
            //con la siguiente nomenclaruta
            //ColumnText.showTextAligned(lienzo, alineacion, Phrase, 
            //                           posicion x, posicion y, rotacion);
            //Esta es la imÃ¡gen
            ColumnText.showTextAligned(cb, Element.ALIGN_CENTER, imgCabecera,
                    (document.right() - document.left()) / 2 + document.leftMargin(),
                    document.top() + 60, 0);

            //Este es el texto
            ColumnText.showTextAligned(cb, Element.ALIGN_CENTER, txtCabecera,
                    (document.right() - document.left()) / 2 + document.leftMargin(),
                    document.top() + 10, 0);
        }

    }

    private static void createPdf(String nombreSocio, String nombreCliente) {
        /*Declaramos documento como un objeto Document
         *Asignamos el tamaÃ±o de hoja y los margenes 
         */

        Document documento = new Document(PageSize.LETTER, 80, 80, 75, 75);

        //writer es declarado como el mÃ©todo utilizado para escribir en el archivo
        PdfWriter writer = null;

        try {
            //Obtenemos la instancia del archivo a utilizar
            writer = PdfWriter.getInstance(documento, new FileOutputStream(archivo));

            HeaderFooter event = new HeaderFooter();
            writer.setPageEvent(event);
        } catch (FileNotFoundException | DocumentException ex) {
            ex.getMessage();
        }

        //Agregamos un titulo al archivo
        documento.addTitle("Grafica del " + nombreCliente);

        //Agregamos el autor del archivo
        documento.addAuthor(nombreSocio);

        //Abrimos el documento para ediciÃ³n
        documento.open();

        //Declaramos un texto como Paragraph
        //Le podemos dar formado como alineaciÃ³n, tamaÃ±o y color a la fuente.
        Paragraph parrafo = new Paragraph();
        parrafo.setAlignment(Paragraph.ALIGN_CENTER);
        parrafo.setFont(FontFactory.getFont("Sans", 20, Font.BOLD, BaseColor.BLUE));
        parrafo.add("Grafica");

        try {
            //Agregamos el texto al documento
            documento.add(parrafo);
        } catch (DocumentException ex) {
            ex.getMessage();
        }
        
        documento.close(); //Cerramos el documento
        writer.close(); //Cerramos writer
    }

    public static void generarImagen(String nombreSocio, String nombreCliente, JFreeChart grafica) throws IOException {
        final ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
        final File file1 = new File(nombre);
        ChartUtilities.saveChartAsPNG(file1, grafica, 600, 400, info);
        createPdf(nombreSocio, nombreCliente);
        file1.delete();
    }
    
}
