/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos.serializar;

import java.io.IOException;

/**
 *
 * @author Aula
 */
public class TestSerializable {
    public static void main(String[] args){
        SuperSerializado ser = new SuperSerializado();
        try{
            Producto p = new Producto(1, "PS3", 299.99);
            p.setTipo(new Tipo("VideoGame Console"));
            
            ser.addProduct(p);
            ser.readProduct();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
