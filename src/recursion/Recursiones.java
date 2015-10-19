/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursion;

/**
 *
 * @author Aula
 */
public class Recursiones {
    
    public void foo(int x){
        int y=0;
        y++;
        System.out.println("y: "+y);
        if(x<10)
            foo(++x);
        System.out.println("Recursion Foo con x:"+
                x);
    }
    
    /**
     * Imprime los numeros desde 1 hasta N
     * @param n Numero limite
     */
    public void print(int n){
        if(n>1)
            print(n-1);
        System.out.println(n);
    } 
    
    /**
     * Retorna la suma de los numeros desde 1 hasta n
     * @param n Limite
     * @return La suma
     */
    public int sumaUp(int n){
        if(n > 1)
            return sumaUp(n-1) + n;
        return 1;
    }
}
