/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos.binarios;

import java.io.File;
import java.io.FileWriter;
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
        int items
            int cod producto
            int cantidad del producto
            double precio unitario del prod en ese momento
        double st
        double inte
        double desc
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
        rProds.writeInt(1);
        return true;
    }
    
    public String[] encabezados(){
        String head[] = {"Codigo","Titulo","Tipo",
            "Precio", "Existencia"};
        return head;
    }
    
    /*
    retornar CUANTOS productos tiene el archivo
    */
    public int productCount()throws IOException{
      rCods.seek(PRODUCTO_OFFSET);
      int cod = rCods.readInt();
      return cod-1;
    }
    
    public Object[][] toTable()throws IOException{
        int filas = productCount();
        Object table[][] = new Object[filas][5];
        
        rProds.seek(0);
        for(int f=0; f < filas; f++){
            table[f][0] = rProds.readInt();
            table[f][1] = rProds.readUTF();
            table[f][2] = rProds.readUTF();
            table[f][3] = rProds.readDouble();
            table[f][4] = rProds.readInt();
        }
        
        return table;
    }
    
    /*
    Imprima todos los datos de todos los productos
    agregados
    */
    public void list() throws IOException{
        rProds.seek(0);
        while(rProds.getFilePointer() < rProds.length()){
            int c = rProds.readInt();
            String title = rProds.readUTF();
            String tipo = rProds.readUTF();
            double p = rProds.readDouble();
            int cant = rProds.readInt();
            System.out.println(c+"-"+title+"-"+tipo+
                    " Lps."+p+" - "+cant+" items.");
        }
    }
    
    /*
    Busca un producto con codigo "codp" dentro
    del archivo, si lo encuentra retorna true
    pero deja el apuntador justo antes del nombre
    de dicho producto. Retorna false si no esta
    */
    public boolean search(int codp)throws IOException{
        rProds.seek(0);
        while(rProds.getFilePointer() < rProds.length()){
            if(codp == rProds.readInt())
                return true;
            rProds.readUTF();
            rProds.readUTF();
            rProds.skipBytes(12);
        }
        return false;
    }
    
    /*
    Busca un producto con ese codigo, si lo encuentra
    le suma cant al monto que existencia que tenga
    Retorna true si se pudo agregar o no
    */
    public boolean addItemToProduct(int codp, int cant) throws IOException{
        boolean result = search(codp);
        
        if(result){
            rProds.readUTF();
            rProds.readUTF();
            rProds.readDouble();
            int ex = rProds.readInt();
            
            rProds.seek(rProds.getFilePointer()-4);
            rProds.writeInt(ex+cant);
        }
        
        return result;
    }
    
    /*
    Busca un producto con ese codigo y actualiza
    su precio si existe.
    Retorna true si pudo hacer o no
    */
    public boolean setOfferToProduct(int codp, double newPrice) throws IOException{
        boolean result = search(codp);
        if(result){
            rProds.readUTF();
            rProds.readUTF();
            rProds.writeDouble(newPrice);
        }
        return result;
    }

    /*
    Pauta Prueba 5, sin usar rProds
    */
    public boolean insuficienteReport() {
        try{
            RandomAccessFile r = new RandomAccessFile(ROOT_FOLDER+"/productos.sml",
                "rw");
            FileWriter fw = new FileWriter("Insuficiente.txt");
            fw.write("LISTADO DE PRODUCTOS INSUFICIENTES");
            fw.write("\r\n----------------------------------\r\n");
            
            while(r.getFilePointer() < r.length()){
                int c = r.readInt();
                String t = r.readUTF();
                String ti = r.readUTF();
                r.readDouble();
                int cant = r.readInt();
                
                if(cant < 2)
                    fw.write(c+"-"+t+"-"+ti+"-"+cant+
                        " items disponibles\r\n");
            }
            
            fw.close();
            r.close();
            return true;
        }catch(IOException e){
            return false;
        }
    }
    
    public boolean createInvoice(String cliente, PaymentType tipo, InvoiceItem items[]){
        return false;
    }
}
