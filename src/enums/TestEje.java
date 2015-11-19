/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enums;

import java.util.Scanner;

/**
 *
 * @author Aula
 */
public class TestEje {
    public static void main(String[] args) {
        Eje e = Eje.NUM4;
        System.out.println(e.name());
        System.out.println(e.ordinal());
        
        if(e == Eje.NUM4)
            System.out.println("Es Num4");
        
        Scanner lea = new Scanner(System.in);
        System.out.println("Ingrese el tipo de Eje: ");
        e = Eje.valueOf(lea.next().toUpperCase());
        System.out.println("Escogiste el eje "+
                e+" y pagaras en el peaje L."+
                e.peaje);
    }
}
