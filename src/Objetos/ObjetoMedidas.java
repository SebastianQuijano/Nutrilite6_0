/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

/**
 *
 * @author Sebastian
 */
public class ObjetoMedidas {

    private int idMedida, idCliente;
    private double cintura, muneca, pecho, cadera, cuello, peso, altura;
    private String fecha;

    public ObjetoMedidas() {

    }

    public ObjetoMedidas(int idMedida, double cintura, double muneca, double cadera, double pecho, String fecha, double cuello, double peso, double altura, int idCliente) {
        this.idMedida = idMedida;
        this.cintura = cintura;
        this.muneca = muneca;
        this.pecho = pecho;
        this.fecha = fecha;
        this.cadera = cadera;
        this.cuello = cuello;
        this.peso = peso;
        this.altura = altura;
        this.idCliente = idCliente;
    }

    /**
     * @return the idMedida
     */
    public int getIdMedida() {
        return idMedida;
    }

    /**
     * @param idMedida the idMedida to set
     */
    public void setIdMedida(int idMedida) {
        this.idMedida = idMedida;
    }

    /**
     * @return the idCliente
     */
    public int getIdCliente() {
        return idCliente;
    }

    /**
     * @param idCliente the idCliente to set
     */
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * @return the cintura
     */
    public double getCintura() {
        return cintura;
    }

    /**
     * @param cintura the cintura to set
     */
    public void setCintura(double cintura) {
        this.cintura = cintura;
    }

    /**
     * @return the muneca
     */
    public double getMuneca() {
        return muneca;
    }

    /**
     * @param muneca the muneca to set
     */
    public void setMuneca(double muneca) {
        this.muneca = muneca;
    }

    /**
     * @return the pecho
     */
    public double getPecho() {
        return pecho;
    }

    /**
     * @param pecho the pecho to set
     */
    public void setPecho(double pecho) {
        this.pecho = pecho;
    }

    /**
     * @return the cadera
     */
    public double getCadera() {
        return cadera;
    }

    /**
     * @param cadera the cadera to set
     */
    public void setCadera(double cadera) {
        this.cadera = cadera;
    }

    /**
     * @return the cuello
     */
    public double getCuello() {
        return cuello;
    }

    /**
     * @param cuello the cuello to set
     */
    public void setCuello(double cuello) {
        this.cuello = cuello;
    }

    /**
     * @return the peso
     */
    public double getPeso() {
        return peso;
    }

    /**
     * @param peso the peso to set
     */
    public void setPeso(double peso) {
        this.peso = peso;
    }

    /**
     * @return the altura
     */
    public double getAltura() {
        return altura;
    }

    /**
     * @param altura the altura to set
     */
    public void setAltura(double altura) {
        this.altura = altura;
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
