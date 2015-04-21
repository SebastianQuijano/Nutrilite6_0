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
public class ObjetoAlimento {
    private int idAlimento;
    private String nombre;
    private double porcion;
    private String medida;
    private double calorias;
    private int idTipoAlimento;
    
    public ObjetoAlimento(){
        
    }
    
    public ObjetoAlimento(int idAlimento, String nombre, double porcion, double calorias, int idTipoAlimento){
        this.idAlimento = idAlimento;
        this.nombre = nombre;
        this.porcion = porcion;
        this.calorias = calorias;
        this.idTipoAlimento = idTipoAlimento;
    }

    public String getMedida(){
        return medida;
    }
    
    public void setMedida(String medida){
        this.medida = medida;
    }
    
    public int getIdAlimento() {
        return idAlimento;
    }

    public void setIdAlimento(int idAlimento) {
        this.idAlimento = idAlimento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPorcion() {
        return porcion;
    }

    public void setPorcion(double porcion) {
        this.porcion = porcion;
    }

    public double getCalorias() {
        return calorias;
    }

    public void setCalorias(double calorias) {
        this.calorias = calorias;
    }

    public int getIdTipoAlimento() {
        return idTipoAlimento;
    }

    public void setIdTipoAlimento(int idTipoAlimento) {
        this.idTipoAlimento = idTipoAlimento;
    }
    
}
