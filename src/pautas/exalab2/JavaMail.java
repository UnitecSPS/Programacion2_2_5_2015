/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pautas.exalab2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.NoSuchElementException;

public class JavaMail {
    public RandomAccessFile users;
    public CurrentUser current;

    public JavaMail() {
        try {
            users=new RandomAccessFile("usuarios.eml","rw");
            current = null;
        } catch (FileNotFoundException ex) {
           
        }
    }
    
    public boolean login(String user,String pass) throws IOException{
        users.seek(0);
        while(users.getFilePointer() < users.length()){
            String u = users.readUTF();
            String p = users.readUTF();
            
            if(user.equals(u) && pass.equals(p)){
                current = new CurrentUser(u);
                current.loadFromFile();
                return true;
            }
        }
        return false;
    }
    
    public void crearAccount(String user, String pass) throws IOException{
        users.seek(0);
        while(users.getFilePointer() < users.length()){
            String u = users.readUTF();
            users.readUTF();
            
            if(user.equals(u)){
                return; //ya existe
            }
        }
        //si llego aca no existe y el puntero esta al final
        users.writeUTF(user);
        users.writeUTF(pass);
    }
    
    public void inbox(){
        try{
            System.out.println(current.username+"@javamail.org");
            current.inbox();
        }
        catch(NullPointerException e){
            System.out.println("Login Primero");
        }
    }
    
    public void createEmail(String from, String subject, String content) throws IOException{
        try{
            long pos = current.gotEmail(from, subject, content);
            current.add(new EmailNodo(pos, from, subject, false));
        }
        catch(NullPointerException e){
            System.out.println("Login Primero");
        }
    }
    
    public void read(int pos) throws IOException{
        try{
            current.readEmail(pos);
        }
        catch(NullPointerException e){
            System.out.println("Login Primero");
        }
        catch(NoSuchElementException e){
            System.out.println(e.getMessage());
        }
        
    }
}
