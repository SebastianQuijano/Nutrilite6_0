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
public class ObjetoComplemento {
    
    private int idComplemento;
    private String nombre;
    private String descripcion;
    
    public ObjetoComplemento(){
        
    }
    
    public ObjetoComplemento(int idComplemento, String nombre, String descripcion) {
        this.idComplemento = idComplemento;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    /**
     * @return the idComplemento
     */
    public int getIdComplemento() {
        return idComplemento;
    }

    /**
     * @param idComplemento the idComplemento to set
     */
    public void setIdComplemento(int idComplemento) {
        this.idComplemento = idComplemento;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
}
