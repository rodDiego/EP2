package com.mycompany.entregable1;

import com.opencsv.exceptions.CsvValidationException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Entregable1 {
    
    public static String file = "src/test/evento.txt";
    public static ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
    public static ArrayList<Deporte> listaDeportes = new ArrayList<Deporte>();
    public static ArrayList<Ciudad> listaCiudades = new ArrayList<Ciudad>();
    public static ArrayList<Evento> listaEventos = new ArrayList<Evento>();
    
    public static Excel excel; 
    
    
    public static void main(String[] args) throws ParseException, IOException, CsvValidationException{
        
        Menu menu = new Menu();
        int opcion;
        Scanner scanner = new Scanner(System.in);
        
        //LEER DESDE UN ARCHIVO PARA CLASE EVENTO
        leerDatos();
        
        //LEER DATOS DESDE EXCEL
        
        excel = new Excel("src/test/usuarios.csv");
        
        excel.LeerExcel();
        
        
        do{
            menu.menu();
            opcion = scanner.nextInt();
            
            //SWITCH PARA EL MENU
            switch (opcion){
                //AGREGAR
                case 1:
                    int agregar;
                    menu.agregar();
                    agregar = scanner.nextInt();
                    
                    //SWITCH PARA AGREGAR UN OBJETO
                    switch(agregar){
                        case 1:
                            Usuario usuario = new Usuario();
                            listaUsuarios.add(usuario.crearUsuario());
                            break; 
                        case 2:
                            Ciudad ciudad = new Ciudad();
                            listaCiudades.add(ciudad.crearCiudad());
                            break; 
                        case 3:
                            Evento evento = new Evento();
                            listaEventos.add(evento.crearDato());
                            break; 
                        case 4:
                            Deporte deporte = new Deporte();
                            listaDeportes.add(deporte.crearDeporte());
                            break;                            
                        default:
                            System.out.println("Opción no válida. Intente de nuevo.");
                            break;
                    }
                    break;
                    //FIN SWITCH AGREGAR 
                //LEER DATOS
                case 2:
                    int mostrar;
                    menu.leer();
                    mostrar = scanner.nextInt();
                    
                    //SWITCH PARA LEER DATOS DE LOS OBJETOS
                    switch(mostrar){
                        case 1:
                            Usuario usuario = new Usuario();
                            usuario.leerDatos(listaUsuarios);
                            break; 
                        case 2:
                            Ciudad ciudad = new Ciudad();
                            ciudad.leerDatos(listaCiudades);
                            break; 
                        case 3:
                            Evento evento = new Evento();
                            evento.leerDatos(listaEventos);
                            break; 
                        case 4:
                            Deporte deporte = new Deporte();
                            deporte.leerDatos(listaDeportes);
                            break;                            
                        default:
                            System.out.println("Opción no válida. Intente de nuevo.");
                            break;
                    }
                    break;  
                    //FIN SWITCH LEER DATOS
                
                //MODIFICAR 
                case 3:
                    int modificar;
                    menu.modificar();
                    modificar = scanner.nextInt();
                    switch(modificar)
                    {
                        case 1:
                            System.out.println("Indique el RUT del usuario que desea modificar: ");
                            String rutBuscado = scanner.next();
                            boolean encontrado = false;
                            Usuario usuarioaModificar = null;
                            for (Usuario usuario : listaUsuarios) {
                                if(usuario.getRut().equals(rutBuscado)){
                                    usuarioaModificar = usuario;
                                    encontrado = true;
                                    break;
                                }
                            }
                            if(encontrado == false)
                            {
                                System.out.println("Usuario con Rut " + rutBuscado + " no encontrado.");
                            }else{
                                System.out.println("Seleccione el atributo que desea modificar del usuario: ");
                                System.out.println("1. Modificar Nombre");
                                System.out.println("2. Modificar Apellido");
                                System.out.println("3. Modificar Rut");                          
                                System.out.println("4. Modificar Correo");
                                System.out.println("5. Modificar Numero telefonico");
                                System.out.println("6. Modificar Subcripcion Premium");
                                
                                int ModificarAtributo = scanner.nextInt();
                                switch(ModificarAtributo)
                                {
                                    case 1:
                                        System.out.println("Nuevo nombre:");
                                        String nuevoNombre = scanner.next();
                                        usuarioaModificar.setNombre(nuevoNombre);
                                        break;
                                    case 2:
                                        System.out.println("Nuevo apellido:");
                                        String nuevoApellido = scanner.next();
                                        usuarioaModificar.setApellido(nuevoApellido);
                                        break;
                                    case 3:
                                        System.out.println("Nuevo Rut:");
                                        String nuevoRut = scanner.next();
                                        usuarioaModificar.setRut(nuevoRut);
                                        break;
                                    case 4:
                                        System.out.println("Nuevo Correo:");
                                        String nuevoCorreo = scanner.next();
                                        usuarioaModificar.setCorreo(nuevoCorreo);
                                        break;
                                    case 5:
                                        System.out.println("Nuevo Numero telefonico:");
                                        int nuevoNumero = scanner.nextInt();
                                        usuarioaModificar.setNumeroTelefonico(nuevoNumero);
                                        break;
                                    case 6:
                                        if (usuarioaModificar.isEsPremium()==true) {
                                            System.out.println("Subscripción Cancelada");
                                            usuarioaModificar.setEsPremium(false);
                                        } else {
                                            System.out.println("Activando Subscripción Premium");
                                            usuarioaModificar.setEsPremium(true);
                                        }
                                        break;
                                }
                            }
                            break;
                        case 2:
                            System.out.println("Indique el Nombre de la ciudad que desea modificar: ");
                            String ciudadBuscada = scanner.next();
                            boolean encontrada = false;
                            Ciudad ciudadaModificar = null;
                            for (Ciudad ciudad : listaCiudades) {
                                if(ciudad.getNombre().equals(ciudadBuscada)){
                                    ciudadaModificar = ciudad;
                                    encontrada = true;
                                    break;
                                }
                            }
                            if(encontrada == false)
                            {
                                System.out.println("Ciudad con Nombre " + ciudadBuscada + " no encontrada.");
                            }else{
                                System.out.println("Seleccione el atributo que desea modificar de la ciudad: ");
                                System.out.println("1. Modificar Nombre");
                                System.out.println("2. Modificar Comuna");
                                System.out.println("3. Modificar Region");
                                int ModificarAtributo = scanner.nextInt();
                                switch(ModificarAtributo){
                                    case 1:
                                        System.out.println("Nuevo nombre:");
                                        String nuevoNombre = scanner.next();
                                        ciudadaModificar.setNombre(nuevoNombre);
                                        break;
                                    case 2:
                                        System.out.println("Nueva Comuna:");
                                        String nuevaComuna = scanner.next();
                                        ciudadaModificar.setComuna(nuevaComuna);
                                        break;
                                    case 3:
                                        System.out.println("Nueva Region:");
                                        String nuevaRegion = scanner.next();
                                        ciudadaModificar.setRegion(nuevaRegion);
                                        break; 
                                }
                            }
                            break;
                        case 3:
                            System.out.println("Indique el Nombre del evento que desea modificar: ");
                            String eventoBuscado = scanner.next();
                            boolean eventoEncontrado = false;
                            Evento eventoaModificar = null;
                            for (Evento evento : listaEventos) {
                                if(evento.getNombre().equals(eventoBuscado)){
                                    eventoaModificar = evento;
                                    eventoEncontrado = true;
                                    break;
                                }
                            }
                            if(eventoEncontrado == false)
                            {
                                System.out.println("Evento con Nombre " + eventoBuscado + " no encontrada.");
                            }else{
                                System.out.println("Seleccione el atributo que desea modificar del Evento: ");
                                System.out.println("1. Modificar Nombre");
                                System.out.println("2. Modificar Fecha");
                                System.out.println("3. Modificar Direccion");
                                System.out.println("4. Modificar Ciudad");
                                System.out.println("5. Modificar Deporte");
                                System.out.println("6. Modificar cantMaxima");
                                System.out.println("7. Modificar Valor");
                                int ModificarAtributo = scanner.nextInt();
                                switch(ModificarAtributo)
                                {
                                    case 1:
                                        System.out.println("Nuevo nombre:");
                                        String nuevoNombre = scanner.next();
                                        eventoaModificar.setNombre(nuevoNombre);
                                        break;
                                    case 2:
                                        System.out.println("Nueva fecha:");
                                        Date nuevaFecha = null;
                                        try{
                                            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                                            nuevaFecha= sdf.parse(scanner.next());                                            
                                        } catch (ParseException e) {
                                            System.out.println("Formato de fecha incorrecto. Use dd/MM/yyyy.");
                                        }
                                        if (nuevaFecha != null) {
                                            eventoaModificar.setFecha(nuevaFecha);
                                        }
                                        break;
                                    case 3:
                                        System.out.println("Nueva Direccion:");
                                        String nuevaDireccion = scanner.next();
                                        eventoaModificar.setDireccion(nuevaDireccion);
                                        break;
                                    case 4:
                                        System.out.println("Nueva Ciudad:");
                                        String nuevaCiudad = scanner.next();
                                        eventoaModificar.setDireccion(nuevaCiudad);
                                        break;
                                    case 5:
                                        System.out.println("Nuevo Deporte:");
                                        String nuevoDeporte = scanner.next();
                                        eventoaModificar.setDeporte(nuevoDeporte);
                                        break;
                                    case 6:
                                        System.out.println("Nueva cantMaxima:");
                                        int nuevaCant = scanner.nextInt();
                                        eventoaModificar.setCantMaxima(nuevaCant);
                                        break;
                                    case 7:
                                        System.out.println("Nuevo Valor:");
                                        int nuevoValor = scanner.nextInt();
                                        eventoaModificar.setValor(nuevoValor);
                                        break; 
                                }
                            }
                            break;                                                              
                    }                                
                    break;
                    //FIN SWITCH MODIFICAR
                    
                    
                    //ELIMINAR   
                    case 4:
                        int eliminar;
                        menu.eliminar();
                        eliminar = scanner.nextInt();
                        switch(eliminar){
                            
                            case 1:
                                System.out.println("Ingrese el rut del usuario que desea eliminar: ");
                                String rutBuscado = scanner.next();
                                boolean usuarioEncontrado = false;
                                for (int i = 0; i < listaUsuarios.size();i++){
                                    if (listaUsuarios.get(i).getRut().equals(rutBuscado)){
                                        usuarioEncontrado = true;
                                        listaUsuarios.remove(i);
                                        System.out.println("Usuario eliminado correctamente");
                                        break;
                                }else{
                                       System.out.println("Usuario no encontrado"); 
                                    }                                                                                                           
                                }
                                
                            case 2:    
                                System.out.println("Ingrese el nombre de la ciudad que desea eliminar: ");
                                String nombreCiudad = scanner.next();
                                boolean ciudadEncontrada = false;
                                for (int i = 0; i < listaCiudades.size();i++){
                                    if (listaCiudades.get(i).getNombre().equals(nombreCiudad)){
                                        ciudadEncontrada = true;
                                        listaCiudades.remove(i);
                                        System.out.println("Ciudad eliminada correctamente");
                                        break;
                                }else{
                                       System.out.println("Ciudad no encontrada"); 
                                    }                                                                                                           
                                }
                                
                            case 3:
                                System.out.println("Ingrese el nombre del evento desea eliminar: ");
                                String eventoBuscado = scanner.next();
                                boolean eventoEncontrado = false;
                                for (int i = 0; i < listaEventos.size();i++){
                                    if (listaEventos.get(i).getNombre().equals(eventoBuscado)){
                                        eventoEncontrado = true;
                                        listaEventos.remove(i);
                                        System.out.println("Evento eliminado correctamente");
                                        break;
                                }else{
                                       System.out.println("Evento no encontrado"); 
                                    }                                                                                                           
                                }
                            
                            case 4:
                                System.out.println("Ingrese el rut del deporte que desea eliminar: ");
                                int deporteBuscado = scanner.nextInt();
                                boolean deporteEncontrado = false;
                                for (int i = 0; i < listaDeportes.size();i++){
                                    if (listaDeportes.get(i).getId() == (deporteBuscado)){
                                        deporteEncontrado = true;
                                        listaDeportes.remove(i);
                                        System.out.println("Deporte eliminado correctamente");
                                        break;
                                }else{
                                       System.out.println("Deporte no encontrado"); 
                                    }                                                                                                           
                                }                                
                        }
                            break;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                        break;                    
            }             
        }while(opcion!=5);
    }
    

    //METODOS
    
    public static void leerDatos() throws IOException, ParseException{
        
        try{
            BufferedReader archivo = new BufferedReader(new FileReader(file));
            int i = 0;
            String linea;
            String []arreglo = new String[6];

            while((linea = archivo.readLine()) != null){
            if(i<0){
                arreglo = linea.split(";");
                Date fecha = new SimpleDateFormat("dd/mm/YYYY").parse(arreglo[1]);

                listaEventos.add(new Evento(arreglo[0],fecha,arreglo[2],arreglo[3],arreglo[4],(Integer.valueOf(arreglo[5])),(Integer.valueOf(arreglo[6]))));
            }
            i++;
            }   
            
        }catch (FileNotFoundException ex){
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
    }
}
