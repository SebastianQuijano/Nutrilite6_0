/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

/**"Comida","Cantidad","Nombre","Porción","Calorías"
 *
 * @author Sebastian
 */
public class ObjetoAlimentoDieta {
    private String comida;
    private int cantidad;
    private String nombre;
    private String porcion;
    private String calorias;
    
    public ObjetoAlimentoDieta(){
        
    }
    
    public ObjetoAlimentoDieta(String comida, int cantidad, String nombre, String porcion, String calorias){
        this.comida = comida;
        this.cantidad = cantidad;
        this.nombre = nombre;
        this.porcion = porcion;
        this.calorias = calorias;
    }

    public String getComida() {
        return comida;
    }

    public void setComida(String comida) {
        this.comida = comida;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPorcion() {
        return porcion;
    }

    public void setPorcion(String porcion) {
        this.porcion = porcion;
    }

    public String getCalorias() {
        return calorias;
    }

    public void setCalorias(String calorias) {
        this.calorias = calorias;
    }
    
}
