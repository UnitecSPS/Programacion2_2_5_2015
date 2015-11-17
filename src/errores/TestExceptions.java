/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package errores;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Aula
 */
public class TestExceptions {
    public static void main(String[] args) {
        System.out.println("Empezando Main");
        try{
            System.out.println("Comenzando el Try");
            A();
            System.out.println("Finalizando el Try");
        }
        catch(InputMismatchException e){
            System.out.println("Ingrese un entero.");
        }
        catch(IndexOutOfBoundsException e){
            System.out.println("Ingrese una posicion correcta");
        }
        catch(Exception e){
            System.out.println("ERROR: "+e);
            //e.printStackTrace();
            StackTraceElement ele = e.getStackTrace()[0];
            System.out.println(ele.getMethodName()+"-"+
                    ele.getLineNumber()+"-"+
                    ele.getFileName());
        }
        
        System.out.println("Terminando Main");
    }

    private static void A() {
        System.out.println("Empezando A");
        B();
        System.out.println("Finalizando A");
    }

    private static void B() {
        System.out.println("Empezando B");
        Scanner lea = new Scanner(System.in);//null;
        int x = lea.nextInt();
        int arr[] = {0,1,2,3};
        System.out.println(arr[x]);
        System.out.println(5/arr[x]);
        System.out.println("Finalizando B");
    }
}
