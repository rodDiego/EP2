package com.mycompany.entregable1;

import java.util.ArrayList;
import java.util.Scanner;

public class Ciudad {

    private String nombre;
    private String comuna;
    private String region;
    private ArrayList<Deporte> listaDeportes; 
    private Scanner lectura;
    
    //CONTRUCTORES
    
    public Ciudad() {

        this.nombre = "";
        this.comuna = "";
        this.region = "";
        this.listaDeportes = new ArrayList<>();
        this.lectura = new Scanner(System.in);
    }
 
    public Ciudad(String nombre, String comuna, String region) {
        this.nombre = nombre;
        this.comuna = comuna;
        this.region = region;
        this.listaDeportes = new ArrayList<>();
    }
    //getters y setters
    public String getNombre() {
        return this.nombre;
    }
 
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
 
    public String getComuna() {
        return this.comuna;
    }
 
    public void setComuna(String comuna) {
        this.comuna = comuna;
    }
 
    public String getRegion() {
        return this.region;
    }
 
    public void setRegion(String region) {
        this.region = region;
    }
    
    //COMPORTAMIENTO O METODOS
    
    public Ciudad crearCiudad(){
        
        System.out.println("Ingrese el Nombre ciudad: "); 
        this.nombre = lectura.next();

        System.out.println("Ingrese nombre de la comuna: "); 
        this.comuna = lectura.next();

        System.out.println("Ingrese region de la ciudad: "); 
        this.region = lectura.next();
        
        agregarDeporte();
        
        return new Ciudad(this.nombre,this.comuna,this.region);
    } 

    public boolean agregarDeporte(){

        int cantDeportes,cont = 0;

        Deporte deporte = new Deporte();
        System.out.println("Ingrese la cantidad de deportes que existen en la cuidad: ");
        cantDeportes = lectura.nextInt();
        System.out.println("Ingrese los deportes que existen: ");

        do{
            deporte = deporte.crearDeporte();
            if(deporte == null)
                return false;

            listaDeportes.add(deporte);
            System.out.println("Deporte agregado con exito");
            cont++;
        }while(cont < cantDeportes);
        return true;        
    }
    
    public void leerDatos(ArrayList<Ciudad> lista){
        
        lista.forEach(ciudad->{
            Deporte deporte = new Deporte();
            System.out.println("Nombre ciudad: " + ciudad.nombre);
            System.out.println("Region: " + ciudad.region);
            System.out.println("Comuna: " + ciudad.comuna);
            deporte.leerDatos(ciudad.listaDeportes);            
        });
    }
 
}

