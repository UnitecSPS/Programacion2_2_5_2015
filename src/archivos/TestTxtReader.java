/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Aula
 */
public class TestTxtReader {
    static Scanner lea = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("Ingrese direccion: ");
        String path = lea.nextLine();
        
        try{
            opcion1(path);
            opcion2(path);
        }
        catch(IOException e){
            System.out.println(e);
        }
    }

    private static void opcion1(String path) throws IOException {
        System.out.println("OPCION read()\n-----------");
        File f = new File(path);
        FileReader fr = new FileReader(f);
        
        char buffer[] = new char[(int)f.length()];
        int bytes = fr.read(buffer);
        
        System.out.println(buffer);
        System.out.println("Bytes leidos: "+bytes);
        fr.close();
    }

    private static void opcion2(String path)throws IOException {
        System.out.println("\nOPCION Scanner\n-----------");
        FileReader fr = new FileReader(path);
        Scanner lector = new Scanner(fr);
        
        while(lector.hasNext()){
            System.out.println(lector.nextLine());
        }
    }
}
