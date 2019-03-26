/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.aviones;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author teguii
 */
public abstract class Avion {
    
    private String nombre;
    private boolean volando=false;
    HashMap<String,Silla> sillas;
    

    public Avion(String nombre) {
        this.nombre = nombre;
        sillas=new HashMap();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public boolean isVolando() {
        return volando;
    }

    public void setVolando(boolean volando) {
        this.volando = volando;
    }

    public HashMap<String, Silla> getSillas() {
        return sillas;
    }

    public void setSillas(HashMap<String, Silla> sillas) {
        this.sillas = sillas;
    }

    
    public double calcularVuelo(){
        double total=0;
        for (Map.Entry<String, Silla> entry : sillas.entrySet()) {
            String key = entry.getKey();
            Silla value = entry.getValue();
            if(value.isComprada()==true){
                total+=value.getValor();
            }
            
        }
        return total;
    }
}
