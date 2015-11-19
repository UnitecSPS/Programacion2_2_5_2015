/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package errores;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aula
 */
public class TestCB {
    static CuentaBancaria cb = new CuentaBancaria();
    
    public static void main(String[] args) {
        
         try {
            depositar();
        } catch (IOException ex) {
            Logger.getLogger(TestCB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void depositar()throws IOException {
        try{
            A();
        }
        catch(TransactionException e){
            System.out.println(e);
        }
    }

    private static void A()throws TransactionException, IOException {
        cb.deposito(100);
    }
}
