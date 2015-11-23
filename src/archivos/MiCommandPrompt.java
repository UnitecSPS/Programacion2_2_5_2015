/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import java.io.File;
import java.io.IOException;
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
        - CD path/ ..
    */
    public static void main(String[] args) {
        do{
            System.out.println(ROOT+">");
            String data= lea.next();
            try{
                switch(data){
                    case "CREATE":
                        create(lea.next());
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
}
