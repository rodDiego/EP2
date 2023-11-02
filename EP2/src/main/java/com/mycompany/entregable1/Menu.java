package com.mycompany.entregable1;

public class Menu {
    
    public Menu(){
        
    }
    
    //METODOS O FUNCIONES
    public void menu(){
        System.out.println("Menú: ");
        System.out.println("1. Agregar elemento");
        System.out.println("2. Mostrar elementos");
        System.out.println("3. Modificar elemento");
        System.out.println("4. Eliminar elemento");
        System.out.println("5. Salir");
        System.out.print("Elija una opción: ");
    }
    
    public void agregar(){
        System.out.println("Seleccione en que clase desea agregar: ");                    
        System.out.println("1. Agregar en Usuario");
        System.out.println("2. Agregar en Ciudad");
        System.out.println("3. Agregar en Evento");
        System.out.println("4. Agregar en Deporte");
    }
    
    public void leer(){
        System.out.println("Seleccione que clase desea mostrar por pantalla: ");
        System.out.println("1. Leer en Usuario");
        System.out.println("2. Leer en Ciudad");
        System.out.println("3. Leer en Evento");
        System.out.println("4. Leer en Deporte");
    }
    
    public void modificar(){
        System.out.println("Seleccione que clase desea modificar por pantalla: ");
        System.out.println("1. Modificar en Usuario");
        System.out.println("2. Modificar en Ciudad");
        System.out.println("3. Modificar en Evento");
        System.out.println("4. Modificar en Deporte");       
    }
    
    public void eliminar(){
        System.out.println("Seleccione que clase desea eliminar por pantalla: ");
        System.out.println("1. Eliminar en Usuario");
        System.out.println("2. Eliminar en Ciudad");
        System.out.println("3. Eliminar en Evento");
        System.out.println("4. Eliminar en Deporte");        
    }
    
}
