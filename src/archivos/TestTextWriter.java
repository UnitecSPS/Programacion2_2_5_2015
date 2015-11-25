/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Aula
 */
public class TestTextWriter {
    static Scanner lea = new Scanner(System.in);
    
    public static void main(String[] args) {
        String path = lea.nextLine();
        System.out.println("Append?: ");
        String app = lea.nextLine();
        
        try{
            escribirEn(path, app.equalsIgnoreCase("si"));
    
        }
        catch(IOException e){
            System.out.println(e);
        }
    }
    private static void escribirEn(String path, boolean app) throws IOException {
        FileWriter fw = new FileWriter(path,app);
        
        do{
            String data = lea.nextLine();
            
            if(!data.equals("$%&")){
                fw.write(data+"\r\n");
            }
            else
                break;
        }while(true);
        
        fw.close();
    }
}
