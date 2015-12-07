/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos.serializar;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Aula
 */
public class SuperSerializado {
    private FileOutputStream writerHelp;
    private FileInputStream readerHelp;
    
    public SuperSerializado(){
        try {
            writerHelp = new FileOutputStream("productos.ser");
            readerHelp = new FileInputStream("productos.ser");
        } catch (FileNotFoundException ex) { 
        }
    }
    
    public void addProduct(Producto p) throws IOException{
        if(p!=null){
           try(ObjectOutputStream writer=new ObjectOutputStream(writerHelp)){
                writer.writeObject(p);
           }
        }
    }
    
    public void readProduct() throws IOException, ClassNotFoundException{
        ObjectInputStream reader = new ObjectInputStream(readerHelp);
        Producto p = (Producto)reader.readObject();
        System.out.println(p);
    }
}
