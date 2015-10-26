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
            System.out.println("4- Primo");
            System.out.println("5- El Perfecto");
            System.out.println("6- Al revez");
            System.out.println("7- Fibonacci");
            System.out.println("8- Vocales");
            System.out.println("9- Suma Digito");
            System.out.println("10- Derivadas");
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
                case 4:
                    //-----primo
                    n = lea.nextInt();
                    if(rec.primo(n))
                        System.out.println(n+" Es Primo.");
                    else
                        System.out.println(n+ " NO es primo.");
                    break;
                case 5:
                    //-----perfecto
                    n = lea.nextInt();
                    if(rec.raizPerfecta(n,1))
                        System.out.println(n+" Es Cuadrado Perfecto.");
                    else
                        System.out.println(n+ " NO es Cuadrado Perfecto.");
                    break;
                case 6:
                    //----Al revez
                    System.out.println("Numero: ");
                    rec.alRevez(lea.nextInt());
                    break;
                case 7:
                    //-----fibo
                    n = lea.nextInt();
                    System.out.println("F("+n+"): "+
                            rec.fibonacci(n));
                case 8:
                    //---------vocales
                    System.out.print("Texto: ");
                    String pal = lea.next();
                    System.out.println(pal+" tiene: "+
                            rec.vocales(pal) + 
                            " vocales.");
                    break;
                case 9:
                    //---- Suma digito
                    System.out.println("Numero: ");
                    System.out.println("Suma: " +
                            rec.sumaDigito(lea.nextInt()));
                    break;
                case 10:
                    //----------Derivadas
                    System.out.println("Numero: ");
                    n = lea.nextInt();
                    System.out.println("Exponente: ");
                    rec.derivadas(n, lea.nextInt());
            }
        }while(true);
    }
}
