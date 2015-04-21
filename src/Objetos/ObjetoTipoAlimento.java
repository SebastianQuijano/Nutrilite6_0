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
public class ObjetoTipoAlimento {
    private int idTipoAlimento;
    private int idMacronutriente;
    private String nombre;
    
    public ObjetoTipoAlimento(){
        
    }
    
    public ObjetoTipoAlimento(int idTipoAlimento, int idMacronutriente, String nombre){
        this.idMacronutriente = idMacronutriente;
        this.idTipoAlimento = idTipoAlimento;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdTipoAlimento() {
        return idTipoAlimento;
    }

    public void setIdTipoAlimento(int idTipoAlimento) {
        this.idTipoAlimento = idTipoAlimento;
    }

    public int getIdMacronutriente() {
        return idMacronutriente;
    }

    public void setIdMacronutriente(int idMacronutriente) {
        this.idMacronutriente = idMacronutriente;
    }
}
