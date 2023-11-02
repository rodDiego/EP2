package com.mycompany.entregable1;

import java.util.ArrayList;
import java.util.Scanner;

public class Deporte {
    private int id;
    private String nombre;
    private Scanner entrada;
    
    public Deporte(){
        this.entrada = new Scanner(System.in);
        this.id = 0;
        this.nombre = "";
    }
    public Deporte(int id, String nombre) {
        this.entrada = new Scanner(System.in);
        this.id = id;
        this.nombre = nombre;
    }
 
    //getters y setters
 
    public int getId() {
        return this.id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
    public String getNombre() {
        return this.nombre;
    }
 
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
     public Deporte crearDeporte(){
         
        do{
            System.out.print("Ingrese el ID del deporte: ");
            this.id = entrada.nextInt();
            
            if(this.id<0)
                return null;
            
        }while(this.id < 0);
       

        System.out.print("Ingrese el nombre del deporte: ");
        this.nombre = entrada.next();
        
        return new Deporte(this.id,this.nombre);
     }
     
     public void leerDatos(ArrayList<Deporte> lista){
        lista.forEach(deporte->{
            System.out.println("Nombre deporte: " + deporte.nombre);
            System.out.println("ID: " + deporte.id);
        });
    }
}

