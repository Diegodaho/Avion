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
public class AvionVip extends Avion{

    public AvionVip(String nombre) {
        super(nombre);
        sillas.put("A1", new Silla("A1",true));
        sillas.put("A2", new Silla("A2",true));
        sillas.put("B1", new Silla("B1",true));
        sillas.put("B2", new Silla("B2",true));
        sillas.put("C1", new Silla("C1",true));
        sillas.put("C2", new Silla("C2",true));
        sillas.put("D1", new Silla("D1",true));
        sillas.put("D2", new Silla("D2",true));
        sillas.put("E1", new Silla("E1",true));
        sillas.put("E2", new Silla("E2",true));
        sillas.put("F1", new Silla("F1",true));
        sillas.put("F2", new Silla("F2",true));
    }
    
    
}
