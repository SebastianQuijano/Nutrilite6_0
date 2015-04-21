/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

/**
 *
 * @author Erick
 */
public class ObjetoMedidaFecha {
    
    private double medida;
    private String fecha;

    
    public ObjetoMedidaFecha(double medida, String fecha) {
        this.medida = medida;
        this.fecha = fecha;
    }
    
    /**
     * @return the medida
     */
    public double getMedida() {
        return medida;
    }

    /**
     * @param medida the medida to set
     */
    public void setMedida(double medida) {
        this.medida = medida;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    
    
}
