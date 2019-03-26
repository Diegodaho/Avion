/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.aviones;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author teguii
 */
public class Principal {
    Map<Integer,Avion> aviones;
    Map<Integer,Cliente> clientes;
    public static BufferedReader entrada=new BufferedReader(new InputStreamReader(System.in));
    
    AvionVip avip=new AvionVip("AvionVip");
    AvionMixto amix=new AvionMixto("AvionMix");
    AvionEconomico aeco=new AvionEconomico("AvionEco");
    
    int i=0;
    String puesto="              ";


    public Principal() throws IOException {
        aviones=new HashMap<Integer,Avion>();
        clientes=new HashMap<Integer,Cliente>();
        aviones.put(1, avip);
        aviones.put(2, amix);
        aviones.put(3, aeco);

        menuAviones();
                
    }  

    public void menuAviones() {
    System.out.print("Que avion desea comprar?\n"+"1.Avion Vip\n"+ "2.Avion Mixto \n"+ "3.Avion Economico \n"+"4.Despegar avion vip \n"
            + "5.Despegar avion mixto \n"+ "6.Despegar avion economico \n"+ "7.Agregar cliente \n"+ "0.Salir \n"+ "Seleccione su opcion: ");
    Integer cedula=0;
    String silla="";
    try{
    int opcion=Integer.parseInt(entrada.readLine());
    switch(opcion){
        case 1:
            if(!avip.isVolando()==true){
                imprimirAvionVip();
                cedula=recogerUsuario();
                silla=recogerSilla();
                comprarSillaVip(silla, cedula);
            }else{
                System.out.println("El avion esta despegando");
            }
            menuAviones();
            break;
        case 2:
            if(!amix.isVolando()==true){
                imprimirAvionMixto();
                cedula=recogerUsuario();
                silla=recogerSilla();
                comprarSillaMix(silla, cedula);
            }else{
                System.out.println("El avion esta despegando");
            }
            menuAviones();
            break;
        case 3:
            if(!aeco.isVolando()==true){
                imprimirAvionEco();
                cedula=recogerUsuario();
                silla=recogerSilla();
                comprarSillaEco(silla, cedula);
            }else{
                System.out.println("El avion esta despegando");
            }
            menuAviones();
            break;
        case 4:
            System.out.println("El avion Vip vendio: \n"+"$"+avip.calcularVuelo()+"\n");
            avip.setVolando(true);
            menuAviones();
            break;
        case 5:
            System.out.println("El avion mixto vendio: "+"$"+amix.calcularVuelo()+"\n");
            amix.setVolando(true);
            menuAviones();
            break;
        case 6:
            System.out.println("El avion economico vendio: \n"+"$"+aeco.calcularVuelo()+"\n");
            aeco.setVolando(true);
            menuAviones();
            break;
        case 7:
            agregarClientes();
            menuAviones();
            break;
        case 0:
            System.exit(0);
             break;
        default:
            System.out.println("Opcion incorrecta intente otra vez");
            menuAviones();
    }
    }catch(Exception ex){
            System.out.println("Debe ser un numero");
            menuAviones();
            }
    
    }
    public String recogerSilla(){
        String silla="";
        System.out.println("Seleccione la silla que desea ocupar: \n");
        try{
           silla=entrada.readLine().toUpperCase();
         }catch(Exception ex){
             System.out.println(ex);
         }
        return silla;
    }
    
    public Integer recogerUsuario(){
        Integer cedula=0;
        System.out.println("Digite la identificacion del cliente: \n");
        try{
           cedula=Integer.parseInt(entrada.readLine());
         }catch(Exception ex){
             System.out.println(ex);
         }
        return cedula;
    }
    
    public void comprarSillaEco(String code,Integer id){
        if(!clientes.containsKey(id)){
            System.out.println("No existe la identificacion: "+id);
            menuAviones();
        }
        Cliente comprador = clientes.get(id);
        if(!aeco.getSillas().containsKey(code)){
            System.out.println("La silla no existe.");
        }if(aeco.getSillas().containsKey(code)){
            if(!aeco.getSillas().get(code).isComprada()){
                aeco.getSillas().get(code).setPersona(comprador);
                aeco.getSillas().get(code).setComprada(true);                
            }else{                
                System.out.println("La silla no esta disponible.");
            }
        }
    }
    public void comprarSillaVip(String code,Integer id){
        if(!clientes.containsKey(id)){
            System.out.println("No existe el cliente con la identificacion: "+id);
            menuAviones();
        }
        Cliente comprador = clientes.get(id);
        if(!avip.getSillas().containsKey(code)){
            System.out.println("La silla no existe.");
        }
        if(avip.getSillas().containsKey(code)){
            if(!avip.getSillas().get(code).isComprada()){
                avip.getSillas().get(code).setPersona(comprador);
                avip.getSillas().get(code).setComprada(true);                
            }else{                
                System.out.println("La silla no esta disponible.");
            }
        }
    }

   
    public void comprarSillaMix(String code,Integer id){
        if(!clientes.containsKey(id)){
            System.out.println("No existe el cliente con la identificacion: "+id);
            menuAviones();
        }
        Cliente comprador = clientes.get(id);
        if(!amix.getSillas().containsKey(code)){
            System.out.println("La silla no existe.");
        }if(amix.getSillas().containsKey(code)){
            if(!amix.getSillas().get(code).isComprada()){
                amix.getSillas().get(code).setPersona(comprador);
                amix.getSillas().get(code).setComprada(true);                
            }else{                
                System.out.println("La silla no esta disponible.");
            }
        }
    }

    public void agregarClientes(){

        String nombre="";
        int cedula=0;
        String fecha="";
        
        System.out.println("Nombre del cliente: ");
        try {
            nombre = (entrada.readLine());
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Digite la cedula del cliente");
        try {
            cedula = (Integer.parseInt(entrada.readLine()));
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("digite fecha de nacimiento");
        try {
            fecha = ((entrada.readLine()));
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        SimpleDateFormat fechaact=new SimpleDateFormat(fecha);
        Cliente nuevo=new Cliente(nombre,cedula,fechaact);
        clientes.put(cedula, nuevo);
    }

    private void imprimirAvionMixto() {
        
        Map<String, Silla> treeMap = new TreeMap<String, Silla>(amix.getSillas());
        Set<String> llaves = treeMap.keySet();
        System.out.println("            /______________\\");

        for(String llav : llaves){
            if(treeMap.get(llav).isComprada()){
                treeMap.get(llav).setNombre("00");
            }
        }
        
        for(String llav : llaves){
            if(treeMap.get(llav).isVip()){
                puesto+=treeMap.get(llav).getNombre()+"       ";
                System.out.print(puesto);
                i++;
                if(i==1){
                    puesto=" ";
                }
                if(i>1){
                    System.out.println();
                    i=0;
                    puesto="              ";
                }
            }
           
        }
        
        System.out.println(" ___________|               |___________");
        System.out.println("|           |               |           |");
        System.out.println("|___________|               |___________|");
        for(String llav : llaves){
            if(treeMap.get(llav).isVip()){
                
            }
            else{
                puesto+=treeMap.get(llav).getNombre();
                System.out.print(puesto);
                i++;
                puesto="";
                if(i==3){
                    puesto=" ";
                }
                if(i>5){
                    System.out.println();
                    i=0;
                    puesto="              ";
                }
            }
           
        }
    }

    private void imprimirAvionVip() {
         Map<String, Silla> treeMap = new TreeMap<String, Silla>(avip.getSillas());
        Set<String> llaves = treeMap.keySet();

        System.out.println("            /______________\\");
        System.out.println("            |               |");
        System.out.println(" ___________|               |___________");
        System.out.println("|           |               |           |");
        System.out.println("|___________|               |___________|");
        for(String llav : llaves){
            if(treeMap.get(llav).isComprada()){
                treeMap.get(llav).setNombre("00");
            }
        }
        
        for(String llav : llaves){
            if(treeMap.get(llav).isVip()){
                puesto+=treeMap.get(llav).getNombre()+"       ";
                System.out.print(puesto);
                i++;
                if(i==1){
                    puesto=" ";
                }
                if(i>1){
                    System.out.println();
                    i=0;
                    puesto="              ";
                }
            }
           
        }
    }

    private void imprimirAvionEco() {
      Map<String, Silla> treeMap = new TreeMap<String, Silla>(aeco.getSillas());
        Set<String> llaves = treeMap.keySet();
        System.out.println("            /______________\\");
        System.out.println("            |               |");
        System.out.println(" ___________|               |___________");
        System.out.println("|           |               |           |");
        System.out.println("|___________|               |___________|");
        for(String llav : llaves){
            if(treeMap.get(llav).isComprada()){
                treeMap.get(llav).setNombre("00");
            }
        }
        for(String llav : llaves){
            if(treeMap.get(llav).isVip()){
                
            }
            else{
                puesto+=treeMap.get(llav).getNombre();
                System.out.print(puesto);
                i++;
                puesto="";
                if(i==3){
                    puesto=" ";
                }
                if(i>5){
                    System.out.println();
                    i=0;
                    puesto="              ";
                }
            }
        }
    }
}
