package Utilidades;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import Objetos.ObjetoDiaDieta;
import java.util.ArrayList;

public class CrearPDF {

//    Document documento = new Document(PageSize.LETTER, 80, 80, 75, 75);
    Document documento = new Document(PageSize.LETTER, 80, 80, 75, 75);

    String nombreImagen = "Nutrilite.png";
    ArrayList<ObjetoDiaDieta> arregloDiaDieta = null;

    public CrearPDF(ArrayList<ObjetoDiaDieta> dieta) {
        this.arregloDiaDieta = dieta;
    }

    public void CambiarNombre(String nombreImagen) {
        this.nombreImagen = nombreImagen;
    }

    //Ruta del archivo, esto es dentro del proyecto Netbeans
    public static String archivo = System.getProperty("user.dir") + "/receta.pdf";

    //Clase para manejar los Header y los Footer
    //Toma los metodos de PdfPageEventHelper
    class HeaderFooter extends PdfPageEventHelper {

        //Declaramos la imagen y texto de la cabecera

        Phrase imgCabecera, txtCabecera;
        Image imagen;

        //Evento cuando que se ejecuta en cada nueva pagina del pdf

        @Override
        public void onStartPage(PdfWriter writer, Document document) {
            try {
                imagen = Image.getInstance(nombreImagen);//Obtenemos la imagen

                //Convertimos la imagen a un Chunck
                //Chunck es la parte mas pequeña que puede ser añadida a un documento
                Chunk chunk = new Chunk(imagen, 0, -30);

                //Convertimos el Chunk en un Phrase
                //Phrase es una serie de Chunks
                imgCabecera = new Phrase(chunk);
            } catch (BadElementException | IOException e) {
                e.getMessage();
            }

            //Creamos un objeto PdfContentByte donde se guarda el contenido de una página en el pdf. Gráficos y texto.
            PdfContentByte cb = writer.getDirectContent();

            //Agregamos la imagen y el texto al documento con la siguiente nomenclaruta
            //ColumnText.showTextAligned(lienzo, alineacion, Phrase, posicion x, posicion y, rotacion);
            //Esta es la imágen
            ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, imgCabecera,
                    (document.right() - document.left()) / 2 + document.leftMargin(),
                    document.top() + 30, 0);
        }

    }

    public void createPdf() {
       
        /*Declaramos documento como un objeto Document
         *Asignamos el tamaño de hoja y los margenes 
         */
//    Document documento = new Document(PageSize.LETTER, 80, 80, 75, 75);

        //writer es declarado como el método utilizado para escribir en el archivo
        PdfWriter writer = null;

        try {
            //Obtenemos la instancia del archivo a utilizar
            writer = PdfWriter.getInstance(documento, new FileOutputStream(archivo));

            HeaderFooter event = new HeaderFooter();
            writer.setPageEvent(event);
        } catch (FileNotFoundException | DocumentException ex) {
            ex.getMessage();
        }

        documento.addTitle("Receta");//Agregamos un titulo al archivo
        documento.addAuthor("Nutrilite");//Agregamos el autor del archivo
        documento.open();//Abrimos el documento para edición

      //Declaramos un texto como Paragraph
        //Le podemos dar formado como alineación, tamaño y color a la fuente.
        Paragraph dieta = new Paragraph();
        dieta.setAlignment(Paragraph.ALIGN_LEFT);
        dieta.setFont(FontFactory.getFont("Helvetica", 9, Font.BOLD, BaseColor.BLACK));

        Paragraph seccion = new Paragraph();
        seccion.setAlignment(Paragraph.ALIGN_LEFT);
        seccion.setFont(FontFactory.getFont("Helvetica", 9, Font.BOLD, BaseColor.BLACK));

        Paragraph fecha = new Paragraph();
        fecha.setAlignment(Paragraph.ALIGN_RIGHT);
        fecha.setFont(FontFactory.getFont("Helvetica", 9, Font.NORMAL, BaseColor.BLACK));
        fecha.add("\nFecha: ______________\n\n\n");

        Paragraph texto = new Paragraph();
        texto.setAlignment(Paragraph.ALIGN_LEFT);
        texto.setFont(FontFactory.getFont("Helvetica", 9, Font.NORMAL, BaseColor.BLACK));
        try {
          //Agregamos el texto al documento

            documento.add(fecha);
            seccion.add("SOCIO");
            documento.add(seccion);
            texto.add("Nombre completo: ___________________________________________________________________\n\n");
            documento.add(texto);
            seccion.clear();
            seccion.add("DATOS PERSONALES");
            documento.add(seccion);
            texto.clear();
            texto.add("Nombre completo: ___________________________________________________________________\nEdad: _______ Sexo: _____________\n\n");
            documento.add(texto);
            seccion.clear();
            seccion.add("DATOS MÉDICOS");
            documento.add(seccion);
            texto.clear();
            texto.add("Peso: ____________ kg.   IMC: ___________ \n\n");
            documento.add(texto);
            seccion.clear();

            
//          documento.add(tablita(arreglo)); // mando a llamar al método, y le paso el arreglo, la tabla se agrega al documento
            documento.setPageSize(PageSize.LETTER.rotate());
            documento.setMargins(30, 30, 30, 30);
            documento.newPage(); //nueva página

            seccion.clear();
            seccion.add("DIETA SUGERIDA\n\n");
            documento.add(seccion);
            agregarDieta2();

//          documento.add(crearTablaDieta());
        } catch (DocumentException ex) {
            ex.getMessage();
        }

        documento.close(); //Cerramos el documento
        writer.close();//Cerramos writer
    }

    private void agregarDieta() throws DocumentException {
        Paragraph dia = crearParrafoDia();
        Paragraph comida = crearParrafoComida();
        Paragraph alimento = crearParrafoTexto();

        //Este for se mueve en los dias de la dieta.
        for (int i = 0; i < arregloDiaDieta.size(); i++) {
//            dia.add(dia);
//            String diaSemana = dia();
            dia.clear();

            dia.add(dias(i));
            documento.add(dia);

            //Desayuno
            comida.clear();
            comida.add("Desayuno");
            documento.add(comida);
            for (int j = 0; j < arregloDiaDieta.get(i).getDesayuno().size(); j++) {
                alimento.add("Cantidad: " + arregloDiaDieta.get(i).getDesayuno().get(j).getCantidad());
                alimento.add(" " + arregloDiaDieta.get(i).getDesayuno().get(j).getNombre());
                alimento.add("  Porcion: " + arregloDiaDieta.get(i).getDesayuno().get(j).getPorcion());
                documento.add(alimento);
                alimento.clear();

//                System.out.print("  Cantidad: "+arregloDiaDieta.get(i).getDesayuno().get(j).getCantidad());
//                System.out.print("  Nombre: "+arregloDiaDieta.get(i).getDesayuno().get(j).getNombre());
//                System.out.print("  Porcion: "+arregloDiaDieta.get(i).getDesayuno().get(j).getPorcion());
            }

            comida.clear();
            comida.add("Refrigerio 1");
            documento.add(comida);
            for (int j = 0; j < arregloDiaDieta.get(i).getRefrigerio1().size(); j++) {
            //Refrigerio 1  

                alimento.add("Cantidad: " + arregloDiaDieta.get(i).getRefrigerio1().get(j).getCantidad());
                alimento.add(" " + arregloDiaDieta.get(i).getRefrigerio1().get(j).getNombre());
                alimento.add("  Porcion: " + arregloDiaDieta.get(i).getRefrigerio1().get(j).getPorcion());
                documento.add(alimento);
                alimento.clear();
//                System.out.print("  Cantidad: "+arregloDiaDieta.get(i).getRefrigerio1().get(j).getCantidad());
//                System.out.print("  Nombre: "+arregloDiaDieta.get(i).getRefrigerio1().get(j).getNombre());
//                System.out.print("  Porcion: "+arregloDiaDieta.get(i).getRefrigerio1().get(j).getPorcion());
            }

            comida.clear();
            comida.add("Almuerzo");
            documento.add(comida);
            for (int j = 0; j < arregloDiaDieta.get(i).getAlmuerzo().size(); j++) {
                //Almuerzo
                alimento.add("Cantidad: " + arregloDiaDieta.get(i).getAlmuerzo().get(j).getCantidad());
                alimento.add(" " + arregloDiaDieta.get(i).getAlmuerzo().get(j).getNombre());
                alimento.add("  Porcion: " + arregloDiaDieta.get(i).getAlmuerzo().get(j).getPorcion());
                documento.add(alimento);
                alimento.clear();
//                System.out.print("  Cantidad: "+arregloDiaDieta.get(i).getAlmuerzo().get(j).getCantidad());
//                System.out.print("  Nombre: "+arregloDiaDieta.get(i).getAlmuerzo().get(j).getNombre());
//                System.out.print("  Porcion: "+arregloDiaDieta.get(i).getAlmuerzo().get(j).getPorcion());
            }

            comida.clear();
            comida.add("Refrigerio 2");
            documento.add(comida);
            for (int j = 0; j < arregloDiaDieta.get(i).getRefrigerio2().size(); j++) {
                //Refrigerio 2
                alimento.add("Cantidad: " + arregloDiaDieta.get(i).getRefrigerio2().get(j).getCantidad());
                alimento.add(" " + arregloDiaDieta.get(i).getRefrigerio2().get(j).getNombre());
                alimento.add("  Porcion: " + arregloDiaDieta.get(i).getRefrigerio2().get(j).getPorcion());
                documento.add(alimento);
                alimento.clear();
//                System.out.print("  Cantidad: "+arregloDiaDieta.get(i).getCena().get(j).getCantidad());
//                System.out.print("  Nombre: "+arregloDiaDieta.get(i).getRefrigerio2().get(j).getNombre());
//                System.out.print("  Porcion: "+arregloDiaDieta.get(i).getRefrigerio2().get(j).getPorcion());
            }

            comida.clear();
            comida.add("Cena");
            documento.add(comida);
            for (int j = 0; j < arregloDiaDieta.get(i).getCena().size(); j++) {
                //Cena
                alimento.add("Cantidad: " + arregloDiaDieta.get(i).getCena().get(j).getCantidad());
                alimento.add(" " + arregloDiaDieta.get(i).getCena().get(j).getNombre());
                alimento.add("  Porcion: " + arregloDiaDieta.get(i).getCena().get(j).getPorcion());
                documento.add(alimento);
                alimento.clear();
//                System.out.print("  Cantidad: "+arregloDiaDieta.get(i).getCena().get(j).getCantidad());
//                System.out.print("  Nombre: "+arregloDiaDieta.get(i).getCena().get(j).getNombre());
//                System.out.print("  Porcion: "+arregloDiaDieta.get(i).getCena().get(j).getPorcion());
            }
        }
    }
    
    private void  agregarDieta2() throws DocumentException {
        PdfPTable tablaDieta = new PdfPTable(6);
        
        tablaDieta.setWidthPercentage(80);
        tablaDieta.addCell(new Phrase(Element.ALIGN_MIDDLE, "Día", FontFactory.getFont("Helvetica", 11, Font.BOLD)));
        tablaDieta.addCell(new Phrase(Element.ALIGN_CENTER, "Desayuno", FontFactory.getFont("Helvetica", 11, Font.BOLD)));
        tablaDieta.addCell(new Phrase(Element.ALIGN_CENTER, "Refrigerio 1", FontFactory.getFont("Helvetica", 11, Font.BOLD)));
        tablaDieta.addCell(new Phrase(Element.ALIGN_CENTER, "Almuerzo", FontFactory.getFont("Helvetica", 11, Font.BOLD)));
        tablaDieta.addCell(new Phrase(Element.ALIGN_CENTER, "Refrigerio 2", FontFactory.getFont("Helvetica", 11, Font.BOLD)));
        tablaDieta.addCell(new Phrase(Element.ALIGN_CENTER, "Cena", FontFactory.getFont("Helvetica", 11, Font.BOLD)));
        
        
        
        for (int i = 0; i < 7; i++) { //recorro filas
            tablaDieta.addCell(new Phrase(Element.ALIGN_CENTER, dias(i), FontFactory.getFont("Helvetica", 11, Font.BOLD )));
                String desayuno="";

                for (int j = 0; j < arregloDiaDieta.get(i).getDesayuno().size(); j++) {
                    desayuno = desayuno + "Cantidad: "+arregloDiaDieta.get(i).getDesayuno().get(j).getCantidad()+" " + arregloDiaDieta.get(i).getDesayuno().get(j).getNombre()+ "  Porcion: "+arregloDiaDieta.get(i).getDesayuno().get(j).getPorcion()+ "\n";
                }
                tablaDieta.addCell(new Phrase(desayuno, FontFactory.getFont("Helvetica", 9)));
                
                String refrigerio1="";
                for (int j = 0; j < arregloDiaDieta.get(i).getRefrigerio1().size(); j++) {
                    refrigerio1 = refrigerio1 + "Cantidad: "+arregloDiaDieta.get(i).getRefrigerio1().get(j).getCantidad()+" " + arregloDiaDieta.get(i).getRefrigerio1().get(j).getNombre()+ "  Porcion: "+arregloDiaDieta.get(i).getRefrigerio1().get(j).getPorcion()+ "\n";
                }
                tablaDieta.addCell(new Phrase(refrigerio1, FontFactory.getFont("Helvetica", 9)));
                
                String almuerzo="";
                for (int j = 0; j < arregloDiaDieta.get(i).getAlmuerzo().size(); j++) {
                    almuerzo = almuerzo + "Cantidad: "+arregloDiaDieta.get(i).getAlmuerzo().get(j).getCantidad()
                    +" " + arregloDiaDieta.get(i).getAlmuerzo().get(j).getNombre()
                    + "  Porcion: "+arregloDiaDieta.get(i).getAlmuerzo().get(j).getPorcion()+ "\n";
                }
                tablaDieta.addCell(new Phrase(almuerzo, FontFactory.getFont("Helvetica", 9)));
                
                String refrigerio2="";
                for (int j = 0; j < arregloDiaDieta.get(i).getRefrigerio2().size(); j++) {
                    refrigerio2 = refrigerio2 + "Cantidad: "+arregloDiaDieta.get(i).getRefrigerio2().get(j).getCantidad()
                    +" " + arregloDiaDieta.get(i).getRefrigerio2().get(j).getNombre()
                    + "  Porcion: "+arregloDiaDieta.get(i).getRefrigerio2().get(j).getPorcion()+ "\n";
                }
                tablaDieta.addCell(new Phrase(refrigerio2, FontFactory.getFont("Helvetica", 9)));
                
                String cena="";
                for (int j = 0; j < arregloDiaDieta.get(i).getCena().size(); j++) {
                    cena = cena + "Cantidad: "+arregloDiaDieta.get(i).getCena().get(j).getCantidad()
                    +" " + arregloDiaDieta.get(i).getCena().get(j).getNombre()
                    + "  Porcion: "+arregloDiaDieta.get(i).getCena().get(j).getPorcion()+ "\n";
                }
                tablaDieta.addCell(new Phrase(cena, FontFactory.getFont("Helvetica", 9)));
                
            }
        
        documento.add(tablaDieta);

        }

        
        
        
    
    
    private Paragraph crearParrafoTexto() {
        Paragraph parrafo = new Paragraph();
        parrafo.setAlignment(Paragraph.ALIGN_LEFT);
        parrafo.setFont(FontFactory.getFont("Helvetica", 9, Font.NORMAL, BaseColor.BLACK));
        return parrafo;
    }

    private Paragraph crearParrafoDia() {
        Paragraph parrafo = new Paragraph();
        parrafo.setAlignment(Paragraph.ALIGN_LEFT);
        parrafo.setFont(FontFactory.getFont("Helvetica", 13, Font.BOLD, BaseColor.BLACK));
        return parrafo;
    }

    private Paragraph crearParrafoComida() {
        Paragraph parrafo = new Paragraph();
        parrafo.setAlignment(Paragraph.ALIGN_LEFT);
        parrafo.setFont(FontFactory.getFont("Helvetica", 11, Font.BOLD, BaseColor.BLACK));
        return parrafo;
    }

    private String dias(int dia) {
        String nDia = null;
        switch (dia) {
            case 0:
                nDia = "Lunes";
                break;
            case 1:
                nDia = "Martes";
                break;
            case 2:
                nDia = "Miércoles";
                break;
            case 3:
                nDia = "Jueves";
                break;
            case 4:
                nDia = "Viernes";
                break;
            case 5:
                nDia = "Sábado";
                break;
            case 6:
                nDia = "Domingo";
                break;
        }
        return nDia;
    }

    

    

    

    //String fecha, String nombreSocio, String nombreCliente, int edad, String sexo, int peso, float imc

    public void editarPDF(String fecha, String nombreSocio, String nombreCliente, int edad, String sexo, double peso, float imc) {

        try {
            //leo el contenido de mi pdf
            PdfReader reader = new PdfReader("receta.pdf");
            // Creo el stamper especificando el contenido base y el archivo de salida
            PdfStamper stamp = new PdfStamper(reader, new FileOutputStream("Final.pdf"));

        // Obtengo el contenido del pdf. Si utilizo getUnderContent lo que agregue aparecera debajo del contenido de mi PDF original
            // si utilizo getOverContent los elementos agregados apareceran encima del contenido de mi PDF original
            PdfContentByte cb = stamp.getOverContent(1);
            // Creo una fuente
            BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
//        BaseFont info = BaseFont.createFont("Calibri (cuerpo)",BaseFont.createFont(), true);
            // Indico que comienzo a escribir texto
            cb.beginText();
            // Indico la fuente a utilizar
            cb.setFontAndSize(bf, 9);

            //**Fecha**
            cb.setTextMatrix(475, 685);
            cb.showText(fecha);
          //****************************

            //*******Datos Socio ********
            cb.setTextMatrix(165, 621);
            cb.showText(nombreSocio);
        //****************************

            //******* Datos cliente *****
            cb.setTextMatrix(165, 573);
            cb.showText(nombreCliente);
            cb.setTextMatrix(110, 557);
            cb.showText(Integer.toString(edad));
            cb.setTextMatrix(170, 557);
            cb.showText(sexo);
        //*******************************

            //******* Datos médicos ********
            cb.setTextMatrix(115, 509);
            cb.showText(Double.toString(peso));
            cb.setTextMatrix(215, 509);
            cb.showText(Float.toString(imc));
            //******************************

            cb.endText();

            // Cierro el stamper y se crea el archivo.
            stamp.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//  public static void main(String[] args) {
//    //Llamamos por el método para generar el pdf
//    
//    new CrearPDF().createPdf();
//    new CrearPDF().editarPDF("10/04/2015", "Eduardito Jesus Berzunza León", "Teresa Guadalupe Barrientos Gómez", 22, "femenino", 50, (float) 17.2);
////    new CrearPDF().editarPDF();
//  }
}
