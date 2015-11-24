/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aula
 */
public class IntroFile {
    public static void main(String[] args) {
        Scanner lea = new Scanner(System.in);
        File f = new File(lea.next()) ;
        
        if(!f.exists()){
            System.out.println("No existe");
            boolean creo = false;
            switch(lea.next()){
                case "FILE":
                    try {
                        creo = f.createNewFile();
                    } catch (IOException ex) {
                        System.out.println("Error: "+ex.getMessage());
                    }
                    break;
                case "DIR":
                    creo = f.mkdirs();
            }
            if(creo)
                System.out.println("Se creo bien");
            else
                System.out.println("No se creo nada");
        }
        else{
            System.out.println("Nombre: "+
                    f.getName());
            System.out.println("Path: "+
                    f.getPath());
            System.out.println("Absoluta: "+
                    f.getAbsolutePath());
            System.out.println("Bytes: "+
                    f.length());
            System.out.println("Parent: "+
                    f.getAbsoluteFile().getParent());
            Date d = new Date(f.lastModified());
            //Calendar c = Calendar.getInstance();
            //c.setTimeInMillis(f.lastModified());
            System.out.println("Ultima Modif: "+d);
            
            if(f.isDirectory())
                System.out.println("Es un directorio");
            if(f.isFile())
                System.out.println("Es un archivo");
            if(f.isHidden())
                System.out.println("Esta Escondido");
            
            if(lea.next().equals("SI")){
                if(f.delete())
                    System.out.println("Se borro");
                else
                    System.out.println("No se pudo borrar");
            }
        }
    }
}
