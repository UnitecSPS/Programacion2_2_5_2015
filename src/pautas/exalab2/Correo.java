/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pautas.exalab2;

import java.io.IOException;

public class Correo {
    public static void main(String[] args) {
        
        try{
            JavaMail jm = new JavaMail();
            jm.crearAccount("CGochez","Barcelona");
            if(jm.login("CGochez","Barcelona")){
                jm.createEmail("messi@fcb.com", "Hola", "Sos genio!");
                jm.inbox();
                jm.read(1);
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
