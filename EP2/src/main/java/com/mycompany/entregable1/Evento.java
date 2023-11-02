package com.mycompany.entregable1;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


public class Evento {
    
    private String nombre;
    private Date fecha;
    private String direccion;
    private String ciudad;
    private String deporte;
    private int cantMaxima;
    private int valor;
    private Scanner sn;
    
    //CONSTRUCTORES
    
    public Evento(){
        this.nombre = "";
        this.fecha = null;
        this.direccion = "";
        this.ciudad = "";
        this.deporte = null;
        this.cantMaxima = 0;
        this.valor = 0;
        this.sn = new Scanner(System.in);
    }
    
    public Evento(String nombre, Date fecha, String direccion, String ciudad, String deporte, int cantMaxima, int valor) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.deporte = "";
        this.cantMaxima = cantMaxima;
        this.valor = valor;
    }
    
    //ACCESORES

    public String getNombre() {
        return this.nombre;
    }

    public Date getFecha() {
        return this.fecha;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public String getCiudad() {
        return this.ciudad;
    }

    public String getDeporte() {
        return this.deporte;
    }

    public int getCantMaxima() {
        return this.cantMaxima;
    }

    public int getValor() {
        return this.valor;
    }
   
    //MUTADORES

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }

    public void setCantMaxima(int cantMaxima) {
        this.cantMaxima = cantMaxima;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
    
    public Evento crearDato() throws ParseException{
        System.out.println("Ingrese el nombre del evento");
        this.nombre = sn.next();
        
        System.out.println("Ingrese la fecha del evento");
        this.fecha= new SimpleDateFormat("dd/mm/YYYY").parse(sn.next());
        
        System.out.println("Ingrese la direccion del evento");
        this.direccion = sn.next();
        
        System.out.println("Ingrese la ciudad donde se hara el evento");
        this.ciudad = sn.next();
        
        System.out.println("Ingrese la deporte del evento");
        this.deporte = sn.next();
        
        System.out.println("Ingrese la cantidad de participantes del evento");
        this.cantMaxima = sn.nextInt();
        
        System.out.println("Ingrese el valor del evento");
        this.valor = sn.nextInt();
        
        return new Evento(this.nombre, this.fecha, this.direccion, this.ciudad, this.deporte, this.cantMaxima, this.valor);   
    }
    
    public void leerDatos(ArrayList<Evento> lista){
        lista.forEach(evento->{
            System.out.println("Nombre evento: " + evento.nombre);
            System.out.println("Fecha relizacion: " + evento.fecha);
            System.out.println("Direccion evento: " + evento.direccion);
            System.out.println("Ciudad: " + evento.ciudad);
            System.out.println("Deporte: " + evento.deporte);
            System.out.println("Valor evento: " + evento.valor);    
        });
        
        
    }
    
}
