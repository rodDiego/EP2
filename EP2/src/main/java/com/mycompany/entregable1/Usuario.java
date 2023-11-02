package com.mycompany.entregable1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Usuario {
    
    private String nombre;
    private String apellido;
    private String rut;
    private Date fechaNacimiento;
    private String correo;
    private int numeroTelefonico;
    private Scanner entrada;
    private ArrayList<Deporte> listaDeportes;
    private boolean esPremium;
   
    //CONSTRUCTORES
    
    public Usuario(){
        this.nombre = "";
        this.apellido = "";
        this.rut = "";
        this.fechaNacimiento = null;
        this.correo = "";
        this.numeroTelefonico = 0;
        this.entrada = new Scanner(System.in);
        listaDeportes = new ArrayList<Deporte>();
        this.esPremium = false;
        
    }
    
    public Usuario(String nombre, String apellido, String rut, Date fechaNacimiento, String correo, int numeroTelefonico, boolean esPremium) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.rut = rut;
        this.fechaNacimiento = fechaNacimiento;
        this.correo = correo;
        this.numeroTelefonico = numeroTelefonico;
        this.esPremium = esPremium;
    }

    //ACCESORES

    public String getNombre() {
        return this.nombre;
    }
    public String getApellido(){
        return this.apellido;
    }

    public String getRut() {
        return this.rut;
    }
    
    public Date getFechaNacimiento() {
        return this.fechaNacimiento;
    }
    
    public String getCorreo() {
        return this.correo;
    }
    
    public int getNumeroTelefonico() {
        return this.numeroTelefonico;
    }
    public boolean isEsPremium() {
        return esPremium;
    }
    
    
    //MUTADORES

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setApellido(String apellido){
        this.apellido = apellido;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setNumeroTelefonico(int numeroTelefonico) {
        this.numeroTelefonico = numeroTelefonico;
    }
    public void setEsPremium(boolean esPremium) {
        this.esPremium = esPremium;
    }
    
    //COMPORTAMIENTO O METODOS
    
    public Usuario crearUsuario() throws ParseException{
        System.out.println("Ingrese nombre");
        this.nombre = entrada.nextLine();
        
        System.out.println("Ingrese apellido");
        this.apellido = entrada.nextLine();
        
        System.out.println("Ingrese rut");
        this.rut = entrada.nextLine();
        
        System.out.println("Digite fecha de nacimiento dd/mm/YYYY");
        this.fechaNacimiento = new SimpleDateFormat("dd/mm/YYYY").parse(entrada.nextLine());
        
        System.out.println("Ingrese correo");
        this.correo = entrada.nextLine();
        
        System.out.println("Ingrese numero celular");
        this.numeroTelefonico= entrada.nextInt();
        
        System.out.println("Pagar Subcripicion Premium?");
        System.out.println("1. Si, 2. No");
        int opcion = entrada.nextInt();
        boolean esPremium;
        if (opcion == 1) {
            esPremium = true;
        } else {
            esPremium = false;
        }
        agregarDeporte();
        
        return new Usuario(this.nombre,this.apellido,this.rut,this.fechaNacimiento,this.correo,this.numeroTelefonico,this.isEsPremium());
    }
    
    public boolean agregarDeporte(){
        
        int cantDeportes,cont = 0;
        
        Deporte deporte = new Deporte();
        System.out.println("Ingrese la cantidad de deportes que realiza el usuario: ");
        cantDeportes = entrada.nextInt();
        System.out.println("Ingrese deportes que realiza");
        
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
    
    public void leerDatos(ArrayList<Usuario> lista){
        lista.forEach(usuario->{
            Deporte deporte = new Deporte();
            System.out.println("Nombre usuario: "+ usuario.nombre);
            System.out.println("Apellido Usuario: "+ usuario.apellido);
            System.out.println("Rut: "+ usuario.rut);
            System.out.println("Fecha de nacimiento: " + usuario.fechaNacimiento);
            System.out.println("Correo: " + usuario.correo);
            System.out.println("Numero celular: " + usuario.numeroTelefonico);
            deporte.leerDatos(usuario.listaDeportes);
        });
    }
    
}
