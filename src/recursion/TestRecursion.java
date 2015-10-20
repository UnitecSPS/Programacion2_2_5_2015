/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursion;

import java.util.Scanner;

/**
 *
 * @author Aula
 */
public class TestRecursion {
    public static void main(String[] args) {
        Recursiones rec = new Recursiones();
        Scanner lea = new Scanner(System.in);
        
        int resp, n;
        
        do{
            System.out.println("\n\n1- Print N");
            System.out.println("2- Suma N");
            System.out.println("3- Pot N");
            System.out.print("Escoja Opcion: ");
            resp = lea.nextInt();
            
            switch(resp){
                case 1:
                    //----print n
                    System.out.print("N: ");
                    n = lea.nextInt();
                    rec.print(n);
                    break;
                case 2:
                    //-----suma n
                    System.out.print("N: ");
                    n = lea.nextInt();
                    System.out.println("Suma Up: "+
                            rec.sumaUp(n));
                    System.out.println("Suma Down: "+
                            rec.sumaDown(n));
                    break;
                case 3:
                    //------ Potencia
                    System.out.print("Base: ");
                    int b = lea.nextInt();
                    System.out.print("Expo: ");
                    int e = lea.nextInt();
                    System.out.println("Pot Up: "+
                            rec.potUp(b,e));
                    System.out.println("Pot Down: "+
                            rec.PotDown(b,e));
                    break;
            }
        }while(true);
    }
}
