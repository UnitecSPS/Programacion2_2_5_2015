/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pautas.exalab2;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Calendar;
import java.util.NoSuchElementException;

public class CurrentUser {
    public String username;
    public RandomAccessFile re;
    public EmailNodo inicio=null;

    public CurrentUser(String u)throws IOException {
        username = u;
        re = new RandomAccessFile(u+"_emails.eml", "rw");
    }
    
    public void add(EmailNodo e){
       if(inicio == null){
           inicio=e;
       }else{
           EmailNodo tmp = inicio;
           while(tmp.next!=null){
               tmp = tmp.next;
           }
           tmp.next = e;
       } 
    }
    
    public void loadFromFile() throws IOException{
        re.seek(0);
        
        if(re.length() > 0){ //<-- no necesario en examen.
            inicio = null;
            while(re.getFilePointer()< re.length()){
                long pos=re.getFilePointer();
                re.readLong();
                String e = re.readUTF();
                String a = re.readUTF();
                re.readUTF();
                boolean l = re.readBoolean();
                add(new EmailNodo(pos, e, a, l));
            }
        }
    }
    
    public void inbox(){
        EmailNodo tmp = inicio;
        int c=0;
        while(tmp != null){
            int pos = c+1;
            System.out.println(pos+"-"+tmp.emisor+"-"+tmp.asunto+
                    (tmp.leido ? " - Leido" : " - Sin Leer"));
            c++;
        }
        System.out.println("Se han recibido " + c + " emails.");
    }
    
    public long gotEmail(String envia, String asunto, String contenido) throws IOException{
        re.seek(re.length());
        long pos=re.getFilePointer();
        re.writeLong(Calendar.getInstance().getTimeInMillis());
        re.writeUTF(envia);
        re.writeUTF(asunto);
        re.writeUTF(contenido);
        re.writeBoolean(false);
        return pos;
    }
    
    public void readEmail(int pos) throws IOException{
        EmailNodo tmp = inicio;
        Calendar cal = Calendar.getInstance();
        int index=1;
        
        while(tmp != null){
            if(pos == index){
                //me coloco en la posicion en bytes de ese email
                re.seek(tmp.pos);
                //la fecha
                cal.setTimeInMillis(re.readLong());
                String e = re.readUTF();
                String a = re.readUTF();
                String c = re.readUTF();
                //marcar como leido
                re.writeBoolean(true);
                //imprimir
                System.out.println(e+"-"+a+"-"+c+"-"+cal.getTime());
                //me salgo
                return;
            }
            else{
                tmp = tmp.next;
                index++;
            }
        }
        
        //si llego aca es que nunca encontre la posicion
        throw new NoSuchElementException("Posicion Incorrecta");
    }
    
    
}
