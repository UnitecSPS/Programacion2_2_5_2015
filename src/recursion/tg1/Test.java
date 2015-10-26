/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursion.tg1;

/**
 *
 * @author Aula
 */
public class Test {
    public static void main(String[] args) {
        ArrayRecs ar = new ArrayRecs(5);
        ar.llenar();
        System.out.println("Suma: " + ar.suma());
        System.out.println("Esta el 3: "+ar.buscar());
        System.out.println("Mayor: "+ ar.maximo());
        System.out.println("Factorial: "+ ar.factorial(0));
    }
}
