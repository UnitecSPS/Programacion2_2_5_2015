/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursion.tg1;

import java.util.Scanner;

/**
 *
 * @author Aula
 */
public class ArrayRecs {
    
    private int array[];
    private Scanner lea = new Scanner(System.in);
    
    public ArrayRecs(int longi){
        array = new int[longi];
    }
    
    public void llenar(int pos){
        if(pos < array.length){
            array[pos] = lea.nextInt();
            llenar(pos+1);
        }
    }
    
    public int suma(int pos){
        if(pos < array.length)
            return array[pos]+suma(pos+1);
        return 0;
    }
    
    public boolean buscar(int n, int pos){
        if(pos < array.length){
            if(array[pos] == n)
                return true;
            return buscar(n, pos+1);
        }
        return false;
    }
    
    public int maximo(){
        return maximo(0, Integer.MIN_VALUE);
    }

    private int maximo(int pos, int mayor) {
        if(pos < array.length){
            if(mayor < array[pos])
                mayor = array[pos];
            return maximo(pos+1, mayor);
        }
        return mayor;
    }
    
    public int factorial(int pos){
        if(pos >=0 && pos < array.length)
            return factorial2(array[pos]);
        System.out.println("Posicion no existe");
        return 0;
    }

    private int factorial2(int n) {
        if(n>1)
            return n * factorial2(n-1);
        else if(n==0)
            return 0;
        return 1;
    }
}
