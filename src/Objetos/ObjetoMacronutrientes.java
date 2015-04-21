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
public class ObjetoMacronutrientes {
    private int idMacronutrientes;
    private String nombre;
    
    public ObjetoMacronutrientes(){
        
    }
    
    public ObjetoMacronutrientes(int idMacronutrientes, String nombre){
        this.idMacronutrientes = idMacronutrientes;
        this.nombre = nombre;
    }

    /**
     * @return the idMacronutrientes
     */
    public int getIdMacronutrientes() {
        return idMacronutrientes;
    }

    /**
     * @param idMacronutrientes the idMacronutrientes to set
     */
    public void setIdMacronutrientes(int idMacronutrientes) {
        this.idMacronutrientes = idMacronutrientes;
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
}
