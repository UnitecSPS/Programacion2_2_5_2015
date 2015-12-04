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
import java.util.Date;
import java.util.Scanner;

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
    public InvoiceItem getProduct(int cod){
        return null;
    }
        
    /*
    2- Crea una nueva factua con la informacion que se
    recibe.
    NOTA: Cuando se use esta funcion deben validar
        que haya existencia de cada producto, o
        que el producto escogido exista. (30%)
    */
    /*public boolean createInvoice(String cliente, PaymentType tipo, InvoiceItem items[]){
        return false;
    }
    */
    
    public boolean createInvoice(String cliente, PaymentType tipo, InvoiceItem items[]) throws IOException{
        rCods.seek(FACTURA_OFFSET);
        int codFact=getCodigo(FACTURA_OFFSET);
        System.out.println("Ingrese el codigo"+codFact);
        RandomAccessFile factur = new RandomAccessFile(ROOT_FOLDER+"/invoices/FACTURA_"+codFact+".sml","rw");
        Date d = new Date();
        String fecha = d.toString();
        String formapago=tipo.name();
        factur.writeInt(codFact);
        factur.writeUTF(fecha);
        factur.writeUTF(cliente);
        factur.writeUTF(formapago);
        double st=0,imp,des;
        int con=0;
        for(InvoiceItem item: items){
            if(item!=null){
                con++;
            }
        }
        factur.writeInt(con);
        for(InvoiceItem item: items){
            if(item!=null){
                factur.writeInt(item.codigo);
                factur.writeInt(item.cantidad);
                factur.writeDouble(item.precio);
                st=+item.precio;
            }
        }
        imp=st*0.15;
        des=st*tipo.discount;
        factur.writeDouble(st);
        factur.writeDouble(imp);
        factur.writeDouble(des);
        factur.writeDouble((st+imp)-des);
        return true;
    }
    
    public InvoiceItem[] invoice() throws IOException{
        Scanner rd = new Scanner(System.in);
        rCods.seek(0);
        int codispo=rCods.readInt()-1,cod,lleva,pos=-1;
        String otro="";
        InvoiceItem productos[] = new InvoiceItem[50];
        do{
            rProds.seek(0);
            System.out.println("Ingrese el codigo");
            cod=rd.nextInt();
            System.out.println("Ingrese la cantidad");
            lleva=rd.nextInt();
            if(cod<=codispo){
                while(rProds.getFilePointer()<rProds.length()){
                    int coda=rProds.readInt();
                    String nom = rProds.readUTF();
                    rProds.readUTF();
                    double pre = rProds.readDouble();
                    int cant=rProds.readInt();
                    if(coda==cod){
                        if(lleva<=cant){
                            productos[pos+1] = new InvoiceItem(cod,lleva,pre,nom);
                            addItemToProduct(cod,-1*lleva);
                            System.out.println("Listo");
                        }
                    }
                }
            }
            System.out.println("¿Quiere otro?");
            otro=rd.next();
        }while(otro.equalsIgnoreCase("SI"));
        return productos;
    }
    
    
    public InvoiceItem getItem(int codigo,int lleva) throws IOException{
        rCods.seek(0);
        int codispo=rCods.readInt()-1;
        InvoiceItem produc=null;
        if(codigo<=codispo){
            rProds.seek(0);
            while(rProds.getFilePointer()<rProds.length()){
                int coda=rProds.readInt();
                String nom = rProds.readUTF();
                rProds.readUTF();
                double pre = rProds.readDouble();
                int cant=rProds.readInt();
                if(coda==codigo){
                    if(lleva<=cant){
                        produc = new InvoiceItem(codigo,lleva,pre,nom);
                        addItemToProduct(codigo,-1*lleva);
                        System.out.println("Listo");
                    }else{
                        System.out.println("No hay existencias");
                        return null;
                    }
                }
            }
        }else{
            return null;
        }
    return null;
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
        File buscar = new File(ROOT_FOLDER + "/invoices/FACTURA_" + codf + ".sml");
        if(buscar.exists()){
            File factura = new File(ROOT_FOLDER + "factura_codigo_" + codf + "_cliente.txt");
            FileWriter factura_print = new FileWriter(factura);
            RandomAccessFile factu = new RandomAccessFile(ROOT_FOLDER+"/invoices/FACTURA_"+codf+".sml","r");
            factu.seek(0);
            factura_print.write("" + factu.readInt() + "\n\r");//Codigo
            factura_print.write(factu.readUTF() + "\n\r");//Fecha
            factura_print.write("Cliente: " + factu.readUTF() + "\n\r");//Cliente
            factura_print.write("Forma de Pago: " + factu.readUTF() + "\n\r");//Forma de Pago
            int cant_items = factu.readInt();
            factura_print.write("Total Items: " + cant_items);//Cant Items.
            for(int cont = 0; cont < cant_items; cont++){//Items y Epecs.
                factura_print.write("Cod. Prod: " + factu.readInt());
                factura_print.write("Cant. Prod: " + factu.readInt());
                factura_print.write("Precio Prod: " + factu.readDouble());
            }
            factura_print.write("Subtotal: " + factu.readDouble() + "\n\r");//Subtotal
            factura_print.write("Intereses: " + factu.readDouble() + "\n\r");//Intereses
            factura_print.write("Descuento: " + factu.readDouble() + "\n\r");//Descuento
            factura_print.flush();
            return true;
        }else{
            return false;
        }
    }
    
    /*
    4- Imprime cuantas facturas se han creado y
    el monto total generado en subtotal,
    monto total generado en intereses
    monto total generado en descuentos. (15%)
    */
    public void statistic(){
        try {
            File fact = new File(ROOT_FOLDER + "/invoices");
            int facts_generadas =0;
            double todos_st =0, todos_imp=0, todos_desc=0;
            
            for (File facts : fact.listFiles()) {
                RandomAccessFile est = new RandomAccessFile(facts, "rw");
                est.readInt();
                est.readUTF();
                est.readUTF();
                est.readUTF();
                
                int cont_facts = est.readInt();
                for (int i = 0; i <= cont_facts; i++) {
                    est.readInt();
                    est.readInt();
                    est.readDouble();
                }
                double st =est.readDouble();
                double imp = est.readDouble();
                double desc = est.readDouble();
                
                facts_generadas++;
                
                todos_st += st;
                todos_imp += imp;
                todos_desc += desc;
            }
            System.out.println("Total de Facturas Generadas: "+facts_generadas+"\nTotal generado en Subtotales: "+todos_st+
                    "\nTotal generado en Impuestos: "+todos_imp+"\nTotal generado en Descuentos: "+todos_desc);
        } catch (Exception e) {}
        
    }
    
    /*
    5- Imprime en un listado las facturas que se han
    generado. El formato es:
        CODIGO - CLIENTE - TOTAL LPS. - FECHA (15%)
    */
    public void printInvoices()throws IOException{
        File folder_facturas = new File(ROOT_FOLDER + "/invoices");
        for(File f: folder_facturas.listFiles()){
            RandomAccessFile F_A = new RandomAccessFile(f, "r");
            System.out.print("Cod: " + F_A.readInt());
            F_A.readUTF();
            System.out.print("- Cliente: " + F_A.readUTF());
            F_A.readUTF();
            int cant_items = F_A.readInt();
            double total = 0;
            for(int cont = 0; cont < cant_items; cont++){//Items y Epecs.
                F_A.readInt();
                int cant_prod = F_A.readInt();
                double prec_prod = F_A.readDouble();
                total = total + (cant_prod *prec_prod);
            }
            total = total + F_A.readDouble();
            total = total - F_A.readDouble(); 
            System.out.print("- Total: " + total);
            F_A.seek(0);
            F_A.readInt();
            System.out.print("- Fecha: " + F_A.readUTF());
            System.out.println("");
        }
    }
    
    /*
    BONO: 10%
    6- Imprime la info total de un producto
    y luego imprime cuantos items de dicho producto
    se ha vendido historicamente y el monto total
    generado.
    */
    public void productPerfomance(int codp)throws IOException{
        int cont_items = 0; double monto_g = 0, subt_prod = 0;
        boolean buscar = search(codp);
        
        if (buscar) {
            rProds.seek(rProds.getFilePointer()-4);
            int code = rProds.readInt();
            String name = rProds.readUTF();
            String tipo = rProds.readUTF();
            double prec = rProds.readDouble();
            int exist = rProds.readInt();
            System.out.print("Codigo del Producto: "+code+"\nNombre: "+name+"\nTipo: "+tipo+"\nPrecio: "+prec+"\nExistencias: "+exist);
        }
        
        File facts = new File(ROOT_FOLDER+"/invoices");
        
        for (File fact : facts.listFiles()) {
            RandomAccessFile raf = new RandomAccessFile(fact, "rw");
            raf.readInt();
            raf.readUTF();
            raf.readUTF();
            raf.readUTF();

            int cont_facts = raf.readInt();
            for (int i = 0; i <= cont_facts; i++) {
                int cod =raf.readInt();
                int cant = raf.readInt();
                double precio = raf.readDouble();
                
                if (cod == codp) {
                    cont_items++;
                    subt_prod = cant*precio;
                }
                
                monto_g += subt_prod;
            }
        }
        System.out.println("Items Vendidos: "+cont_items+"\nMonto Generado: "+monto_g);
    }
    
    //7- AGREGAR CADA OPCION EN LA FORMA Menu
    //LISTO!
    //Aunque se haga en consola el proceso. (10%)
}
