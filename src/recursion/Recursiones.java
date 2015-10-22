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
    
    public int sumaDown(int n){
        return sumaDown(n,0);
    }
    
    private int sumaDown(int n, int suma){
        if(n >= 1)
            return sumaDown(n-1, suma+n);
        return suma;
    }
    
    public int potUp(int b, int e){
        if(e>=1)
            return potUp(b,e-1)*b;
        return   1;        
    }
    
    public int PotDown(int b, int e){
        return PotDown(b, e, 1 );
    }

    private int PotDown(int b, int e,int pot) {
        if(e>=1)
            return PotDown(b,e-1,pot*b);
        return pot;
    }
    
    public int mcd(int n1,int n2){
        return mcd(n1,n2,2);
    }
    
    private int mcd(int n1, int n2, int d){
        if(n1 >= d && n2 >= d){
            if(n1 % d == 0 && n2 % d == 0)
                return mcd(n1/d, n2/d, d) * d;
            return mcd(n1, n2, d+1);
        }
        return 1;
    }
}
