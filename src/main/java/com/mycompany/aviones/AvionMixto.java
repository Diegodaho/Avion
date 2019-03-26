/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.aviones;

/**
 *
 * @author teguii
 */
public class AvionMixto extends Avion {
    
    public AvionMixto(String nombre) {
        super(nombre);
        sillas.put("A1", new Silla("A1",true));
        sillas.put("A2", new Silla("A2",true));
        sillas.put("B1", new Silla("B1",true));
        sillas.put("B2", new Silla("B2",true));
        sillas.put("C1", new Silla("C1",false));
        sillas.put("C2", new Silla("C2",false));
        sillas.put("C3", new Silla("C3",false));
        sillas.put("C4", new Silla("C4",false));
        sillas.put("C5", new Silla("C5",false));
        sillas.put("C6", new Silla("C6",false));
        sillas.put("D1", new Silla("D1",false));
        sillas.put("D2", new Silla("D2",false));
        sillas.put("D3", new Silla("D3",false));
        sillas.put("D4", new Silla("D4",false));
        sillas.put("D5", new Silla("D5",false));
        sillas.put("D6", new Silla("D6",false));
        sillas.put("E1", new Silla("E1",false));
        sillas.put("E2", new Silla("E2",false));
        sillas.put("E3", new Silla("E3",false));
        sillas.put("E4", new Silla("E4",false));
        sillas.put("E5", new Silla("E5",false));
        sillas.put("E6", new Silla("E6",false));
        sillas.put("F1", new Silla("F1",false));
        sillas.put("F2", new Silla("F2",false));
        sillas.put("F3", new Silla("F3",false));
        sillas.put("F4", new Silla("F4",false));
        sillas.put("F5", new Silla("F5",false));
        sillas.put("F6", new Silla("F6",false));
    }
    
}
