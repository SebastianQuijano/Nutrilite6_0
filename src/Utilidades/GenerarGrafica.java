/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import java.util.ArrayList;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYSplineRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author Erick
 */
public class GenerarGrafica {

    public static JFreeChart graficaLinea(String stringMedida, String fecha, ArrayList<Double> medidas) throws NumberFormatException{
        JFreeChart chart = null;
        XYSplineRenderer renderer = new XYSplineRenderer();
        XYSeriesCollection dataset = new XYSeriesCollection();

        ValueAxis x = new NumberAxis();
        ValueAxis y = new NumberAxis();

        XYSeries serie = new XYSeries("Datos");

        XYPlot plot;

        for (int fila = 0; fila < medidas.size(); fila++) {
            serie.add(fila, medidas.get(fila));
        }
        
        dataset.addSeries(serie);
        x.setLabel(fecha);
        y.setLabel(stringMedida);
        plot = new XYPlot(dataset, x, y, renderer);
        chart = new JFreeChart(plot);
        chart.setTitle("Grafica de " + stringMedida);
        return chart;
    }

}
