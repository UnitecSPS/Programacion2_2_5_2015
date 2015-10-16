/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intro;

import java.util.ArrayList;

/**
 *
 * @author Aula
 */
public class ArrayListConPrimitivos {
    public static void main(String[] args) {
        /*
        int -> Integer
        double -> Double
        char -> Character
        boolean -> Boolean
        */
        ArrayList<Integer> numeros = new ArrayList<>();
        numeros.add(5);
        int x = numeros.get(0);
        numeros.add(0,10);
        numeros.add(7);
        
        for(int n : numeros)
            System.out.println("-"+n);
    }
}
