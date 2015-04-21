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
public class ObjetoEstado {

    private String nombre;
    private int idEstado;
    private int idPais;

    public ObjetoEstado() {
        
    }
    
    public ObjetoEstado(int idEstado, String nombre, int idPais) {
        this.idEstado = idEstado;
        this.nombre = nombre;
        this.idPais = idPais;
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
     * @return the id
     */
    public int getId() {
        return idEstado;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.idEstado = id;
    }

    /**
     * @return the idPais
     */
    public int getIdPais() {
        return idPais;
    }

    /**
     * @param idPais the idPais to set
     */
    public void setIdPais(int idPais) {
        this.idPais = idPais;
    }

}
