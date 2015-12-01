/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos.binarios;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author Aula
 */
public class SuperMercado {
    /*
        codigos.sml
        ------------
        int codigo dispo. de los productos
        int codigo dispo. de las facturas
    
        productos.sml
        -----------------
        int codigo
        String title
        String tipo
        double precio
        int existencia
    
        factura_cod_de_factura.sml
        ---------------------------
        int codfactura
        long fecha
        String cliente
        String forma de pago
        double st
        double inte
        double desc
        int items
            int cod producto
            int cantidad del producto
            double precio unitario del prod en ese momento
    */
    private RandomAccessFile rProds, rCods;
    public static final String ROOT_FOLDER = "market";
    public static final int PRODUCTO_OFFSET = 0;
    public static final int FACTURA_OFFSET = 4;
    
    public SuperMercado(){
        try{
            new File(ROOT_FOLDER).mkdir();
            rProds = new RandomAccessFile(ROOT_FOLDER+"/productos.sml","rw");
            rCods = new RandomAccessFile(ROOT_FOLDER+"/codigos.sml","rw");
            initCodigos();
        }
        catch(IOException e){
            System.out.println(e);
        }
    }

    private void initCodigos() throws IOException {
        if(rCods.length() == 0){
            rCods.writeInt(1);
            rCods.writeInt(1);
        }
    }
    
    public void shutdown() throws IOException{
        rProds.close();
        rCods.close();
    }
    
    public int getCodigo(long offset) throws IOException{
        rCods.seek(offset);
        int cod = rCods.readInt();
        rCods.seek(offset);
        rCods.writeInt(cod+1);
        return cod;
    }
    
    public boolean addProduct(String title, ProductType type, double price) throws IOException{
        rProds.seek(rProds.length());
        //codigo
        rProds.writeInt(getCodigo(PRODUCTO_OFFSET));
        //title
        rProds.writeUTF(title);
        //tipo
        rProds.writeUTF(type.name());
        //precio
        rProds.writeDouble(price);
        //existencia
        rProds.writeInt(10);
        return true;
    }
    
    /*
    Imprima todos los datos de todos los productos
    agregados
    */
    public void list(){
        
    }
}
