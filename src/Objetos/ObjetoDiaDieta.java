/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import java.util.ArrayList;

/**
 *
 * @author Sebastian
 */
public class ObjetoDiaDieta {
    private ArrayList<ObjetoAlimentoDieta> desayuno;
    private ArrayList<ObjetoAlimentoDieta> refrigerio1;
    private ArrayList<ObjetoAlimentoDieta> almuerzo;
    private ArrayList<ObjetoAlimentoDieta> refrigerio2;
    private ArrayList<ObjetoAlimentoDieta> cena;
    private int contadorDesayuno;
    private int contadorAlmuerzo;
    private int contadorCena;
    
    public ObjetoDiaDieta(){
        this.desayuno = new ArrayList();
        this.almuerzo = new ArrayList();
        this.cena = new ArrayList();
        this.refrigerio1 = new ArrayList();
        this.refrigerio2 = new ArrayList();
    }

    public ArrayList<ObjetoAlimentoDieta> getDesayuno() {
        return desayuno;
    }
    
    public void limpiarDesayuno(){
        this.desayuno = new ArrayList();
    }
    
    public void limpiarRefrigerio1(){
        this.refrigerio1 = new ArrayList();
    }
    
    public void limpiarAlmuerzo(){
        this.almuerzo = new ArrayList();
    }
    
    public void limpiarRefrigerio2(){
        this.refrigerio2 = new ArrayList();
    }
    
    public void limpiarCena(){
        this.cena = new ArrayList();
    }
    
    public void setDesayuno(ObjetoAlimentoDieta desayuno) {
        this.desayuno.add(desayuno);
    }

    public ArrayList<ObjetoAlimentoDieta> getRefrigerio1() {
        return refrigerio1;
    }

    public void setRefrigerio1(ObjetoAlimentoDieta refrigerio1) {
        this.refrigerio1.add(refrigerio1);
    }

    public ArrayList<ObjetoAlimentoDieta> getAlmuerzo() {
        return almuerzo;
    }

    public void setAlmuerzo(ObjetoAlimentoDieta almuerzo) {
        this.almuerzo.add(almuerzo);
    }

    public ArrayList<ObjetoAlimentoDieta> getRefrigerio2() {
        return refrigerio2;
    }

    public void setRefrigerio2(ObjetoAlimentoDieta refrigerio2) {
        this.refrigerio2.add(refrigerio2);
    }

    public ArrayList<ObjetoAlimentoDieta> getCena() {
        return cena;
    }

    public void setCena(ObjetoAlimentoDieta cena) {
        this.cena.add(cena);
    }

    public int getContadorDesayuno() {
        return contadorDesayuno;
    }

    public void setContadorDesayuno(int contadorDesayuno) {
        this.contadorDesayuno = contadorDesayuno;
    }

    public int getContadorAlmuerzo() {
        return contadorAlmuerzo;
    }

    public void setContadorAlmuerzo(int contadorAlmuerzo) {
        this.contadorAlmuerzo = contadorAlmuerzo;
    }

    public int getContadorCena() {
        return contadorCena;
    }

    public void setContadorCena(int contadorCena) {
        this.contadorCena = contadorCena;
    }

    
    
}
