/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Aula
 */
public class MiCommandPrompt {
    static String ROOT = System.getProperty("user.dir");
    final static Scanner lea = new Scanner(System.in);
    
    /*
    COMANDOS:
        - CREATE name ->Crea un archivo
        - MKDIR name ->Crea un directorio
        - INFO name ->Ver info
        - DELETE name
        - RENAME name path
        - DIR
        - TREE
        - VIRULOSO name
        - CD path/ ..
        - EXIT
    */
    public static void main(String[] args) {
        do{
            System.out.print("\n"+ROOT+">");
            String data= lea.next();
            try{
                switch(data.toUpperCase()){
                    case "CREATE":
                        create(lea.next());
                        break;
                    case "MKDIR":
                        //TODO: Crear el directorio
                        break;
                    case "INFO":
                        //TODO: Desplegar la info del
                            //file seleccionado
                        break;
                    case "DELETE":
                        /*TODO Intentar borrar un 
                            archivo o folder. 
                        */
                        break;
                    case "RENAME":
                        /*
                        TODO: Renombrar un archivo o folder
                        */
                        break;
                    case "DIR":
                        dir();
                        break;
                    case "TREE":
                        tree();
                        break;
                    case "VIRULOSO":
                        /*
                        TODO Crear X cantidad de folder
                        dentro de un folder especifico
                        y cada folder tiene X cantidad
                        de archivos
                        */
                        break;
                    case "CD":
                        cd(lea.next());
                        break;
                    case "EXIT":
                        return;
                    default:
                        System.out.println(data+
                                " no se reconoce como un comando.");
                }
            }
            catch(Exception e){
                System.out.println(e);
            }
        }while(true);
    }

    private static void create(String path)throws IOException {
        File f = new File(ROOT+"/"+path);
        if(f.createNewFile())
            System.out.println("Creado bien...");
        else
            System.out.println("No se puede crear...");
    }

    private static void dir() {
        File f = new File(ROOT);
        int cfiles=0, cdirs=0, abytes=0;
        System.out.println("Directorio de: "+f.getName());
        System.out.println("---------------------------");
        
        for(File child : f.listFiles()){
            if( !child.isHidden() ){
                //ultima fecha de modif
                Date modified = new Date(child.lastModified());
                System.out.print(modified+"\t");
                //ver si es dir o file
                if(child.isDirectory()){
                    cdirs++;
                    System.out.print("<DIR>\t");
                }
                else if(child.isFile()){
                    cfiles++;
                    abytes += child.length();
                    System.out.print("     \t");
                    System.out.print(child.length()+" ");
                }
                //nombre
                System.out.println(child.getName());
            }
        }
        System.out.println(cfiles+" archivos\t"+
                abytes+" bytes");
        System.out.println(cdirs+" folders\t"+
                f.getFreeSpace()+" bytes libres");
    }

    private static void tree() {
        File f = new File(ROOT);
        tree(f, "");
    }
    
    private static void tree(File f, String tab) {
        if(f.isDirectory()){
            System.out.println(tab+"-"+f.getName());
            for(File child : f.listFiles()){
                if(!child.isHidden())
                    tree(child,tab+"\t");
            }
        }
    }

    private static void cd(String path) {
        File f = new File(ROOT);
        
        switch(path){
            case "..":
                ROOT = f.getParent();
                break;
            default:
                f = new File(ROOT+"/"+path);
                if(f.exists())
                    ROOT = f.getAbsolutePath();
                else
                    System.out.println("No Existe la ruta especificada.");
        }
        
    }
}
