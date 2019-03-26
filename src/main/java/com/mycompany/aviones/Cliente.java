/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.aviones;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author teguii
 */
public class Cliente {
    private String nombre;
    private Integer cedula;
    private SimpleDateFormat  fechaNacimiento;

    public Cliente(String nombre, int cedula, SimpleDateFormat  fechaNacimiento) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCedula() {
        return cedula;
    }

}
