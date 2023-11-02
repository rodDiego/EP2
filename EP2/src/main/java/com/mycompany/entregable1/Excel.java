/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.entregable1;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author drodr
 */
public class Excel {
    
    private String ruta;
    private ArrayList<Usuario>ListaUsuarios = new ArrayList<Usuario>();
    
    public Excel(String ruta){
        this.ruta = ruta;
    }
    
    
    public void LeerExcel() throws CsvValidationException, ParseException{
        
        File file = new File(this.ruta);
        
        try{
            
            FileReader inputfile = new FileReader(file);
            CSVReader reader = new CSVReader(inputfile);

            String[] nextRecord;

            int i = 0;

            while((nextRecord = reader.readNext()) != null){
                
                Date fecha = new SimpleDateFormat("dd/mm/YYYY").parse(nextRecord[3]);
                
                if(i>0)
                    ListaUsuarios.add(new Usuario(nextRecord[0],nextRecord[1],nextRecord[2],fecha,nextRecord[4],Integer.valueOf(nextRecord[5]) ,Boolean.valueOf(nextRecord[6])));
                
                for (String cell : nextRecord) {
                    
                    System.out.print(cell + "\t");
                }
                i++;
                System.out.println();
            }
            
        }catch (IOException e){
            e.printStackTrace();
        }
        
        
        
    }
}
