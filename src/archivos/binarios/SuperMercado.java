/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos.binarios;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Date;

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
            new File(ROOT_FOLDER+"/invoices").mkdirs();
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
    
    /*
    1- Devuelve un InvoiceItem con la info de un 
        producto que existe. Si no existe, regresa
        null (10%)
    */
    public InvoiceItem getProduct(int cod)throws IOException{
        int codigo=0;
        int cant=0;
        double p=0;
        String t="";
        
        RandomAccessFile r = new RandomAccessFile(ROOT_FOLDER+"/producto.sml","rw");
        InvoiceItem i = new InvoiceItem(codigo, cant,p, t);
      
        r.seek(0);
        while(r.getFilePointer()<r.length()){
             codigo = r.readInt();
             t = r.readUTF();
                r.readUTF();
             p = r.readDouble();
             cant = r.readInt();
            
            if(cod==codigo){
                return i;
            }
        }
        
        return null;
    }
        
    /*
    2- Crea una nueva factua con la informacion que se
    recibe.
    NOTA: Cuando se use esta funcion deben validar
        que haya existencia de cada producto, o
        que el producto escogido exista. (30%)
    */
    public boolean createInvoice(String cliente, PaymentType tipo, InvoiceItem items[]) throws IOException{
        try{
            RandomAccessFile factura = new RandomAccessFile(ROOT_FOLDER+"/invoices"+"/factura_" +FACTURA_OFFSET+".sml","rw");
            String opt = null;
            Date date = new Date();
            long d = date.getTime();
           
                factura.writeInt(FACTURA_OFFSET);
                factura.writeLong(d);
                factura.writeUTF(cliente);
                factura.writeUTF(tipo.name());
       
            while(rProds.getFilePointer()<rProds.length()){
                rProds.seek(0);
                rProds.readInt();
                rProds.readUTF();
                rProds.readUTF();
                rProds.readDouble();
                int exis = rProds.readInt();
                    if(exis<1){
                        System.out.println("No hay productos de este item");
                    }else{
                        int cod = rProds.readInt();
                        int cant = 0;
                        String name = rProds.readUTF();
                        rProds.readUTF();
                        double precio = rProds.readDouble();
                        rProds.readInt();
                        InvoiceItem item = new InvoiceItem(cod, cant, precio, name);
                        factura.writeUTF(item.toString());
                        double st = precio*cant;
                        double inte = 0;
                        double disc = st*tipo.discount;
                        double tot = st + inte - disc;
                       
                        factura.writeDouble(st);
                        factura.writeDouble(tot);
                    }
                   
                return true;    
            }
        }catch(FileNotFoundException ex){
            return false;
        }
        return false;
    }
    
    /*
        3- Genera en un archivo de texto llamado:
            factura_codigo_cliente.txt
        Con toda la informacion de la factura. Se
        mira como factura.
        Retorna true si existe la factura o false
        si no. (20%)
    */
   public boolean printInvoice(int codf)throws IOException{
        RandomAccessFile n = new RandomAccessFile(ROOT_FOLDER+"/invoice/factura_PrintInvoice.sml","rw");
        FileWriter fc = new FileWriter("factura.txt");      
        if(fc instanceof  FileWriter){
            long fecha = 0;
        Date f = new Date(fecha);
            fc.write("LISTADO DE FACTURA CODIGO DE CLIENTE");
            fc.write("\r\n----------------------------------\r\n");
            n.seek(0);
            while(n.getFilePointer() < n.length()){
                int codfactura = n.readInt();
                fecha = n.readLong();
                String cliente = n.readUTF();
                String forma = n.readUTF();
                int items = n.readInt();
                int codpro = n.readInt();
                int cantPro = n.readInt();
                double precio = n.readDouble();
                double st = n.readDouble();
                double inte = n.readDouble();
                double desc = n.readDouble();
               
                if(codfactura == codf){
                    fc.write(codfactura+"-"+ f+"-"+cliente+"-"+forma+"-"+items+"-"+codpro+"-"
                            + cantPro+"-"+precio+"-"+st+"-"+inte+"-"+desc );
                    return true;
                }
            }
        }
       
        return false;
    }
    /*
    4- Imprime cuantas facturas se han creado y
    el monto total generado en subtotal,
    monto total generado en intereses
    monto total generado en descuentos. (15%)
    */
    public void statistic(){
        
    }
    
    /*
    5- Imprime en un listado las facturas que se han
    generado. El formato es:
        CODIGO - CLIENTE - TOTAL LPS. - FECHA (15%)
    */
    public void printInvoices() throws IOException{
        RandomAccessFile f = new RandomAccessFile(ROOT_FOLDER+"/invoices/factura_"+FACTURA_OFFSET +".sml",
                "rw");
        long fecha = 0;
        Date fe = new Date(fecha);
        
        f.seek(0);
        while(f.getFilePointer()<f.length()){
            
            int cod = f.readInt();
            fecha = f.readLong();
            String cliente = f.readUTF();
            f.readUTF();
            f.skipBytes(20);
            double total = f.readDouble();
            f.skipBytes(16);
            
            System.out.println("CODIGO: "+cod+"-"+"CLIENTE: "+cliente+"-"+"TOTAL LPS.: "+total+"-"+"FECHA: "+fe);
            
        }
    }
    
    /*
    BONO: 10%
    6- Imprime la info total de un producto
    y luego imprime cuantos items de dicho producto
    se ha vendido historicamente y el monto total
    generado.
    */
    public void productPerfomance(int codp){
        
    }
    
    //7- AGREGAR CADA OPCION EN LA FORMA Menu
    //Aunque se haga en consola el proceso. (10%)
}
