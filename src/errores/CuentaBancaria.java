/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package errores;

import java.io.IOException;

/**
 *
 * @author Aula
 */
public class CuentaBancaria {
    public double saldo=500;
    
    public void deposito(double m)throws TransactionException,IOException{
        if(m < 0)
            throw new TransactionException("Monto a depositar negativo");
        saldo+=m;
    }
    
    public void retiro(double m){
        if(saldo > m)
            saldo -= m;
    }
}
