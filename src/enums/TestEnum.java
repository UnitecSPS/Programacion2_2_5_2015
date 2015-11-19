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
public class TestEnum {
    public static void main(String[] args) {
        
        for(Ejes ej : Ejes.values())
            System.out.println("-"+ej.name());
        
        Ejes e = Ejes.NUM6;
        System.out.println(e.name());
        System.out.println(e.ordinal());
        
        if(e == Ejes.NUM6)
            System.out.println("Es Num6");
        
        switch(e){
            case NUM6:
                System.out.println("Es Num6");
        }
        
        Scanner lea = new Scanner(System.in);
        System.out.println("Ingrese el tipo de Eje: ");
        e = Ejes.valueOf(lea.next().toUpperCase());
        System.out.println("Escogiste el eje "+
                e+" y pagaras en el peaje L."+
                e.peaje);
    }
}
