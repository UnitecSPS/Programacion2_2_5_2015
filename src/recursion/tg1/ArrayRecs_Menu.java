/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editoarr.
 */
package recursion.tg1;

import java.util.Scanner;

/**
 *
 * @author Roberto Melara
 */


public class ArrayRecs_Menu {
    public static void main(String[] args) {
        boolean lleno = false;
        Scanner lea = new Scanner(System.in);
        System.out.println("Bienvenido!");
        System.out.println("Cuantos espacios tendra su arreglo?");
        ArrayRecs arr = new ArrayRecs(lea.nextInt());
        
        do{
            System.out.println("Seleccione una opcion: ");
            System.out.println("1. Llenar Arreglo\n2. Sumar Elementos\n3. Buscar en Arreglo\n4. Maximo\n5. Print\n6. FactorialDe\n7. Divisibles Entre\n8. Palíndromo\n9. Reemplazar\n10.Sort");
            System.out.println("11.Salir");
            switch(lea.nextInt()){
                case 1:
                    arr.llenar();
                    lleno = true;
                    break;
                case 2:
                    if(lleno == true){
                        System.out.println(arr.suma());
                        break;
                    }else{
                        System.out.println("Arreglo vacio!");
                        break;
                    }
                case 3:
                    if(lleno == true){
                        System.out.println(arr.buscar());
                        break;
                    }else{
                        System.out.println("Arreglo vacio!");
                        break;
                    }
                case 4:
                    if(lleno == true){
                        System.out.println(arr.maximo());
                        break;
                    }else{
                        System.out.println("Arreglo vacio!");
                        break;
                    }
                case 5:
                    if(lleno == true){
                        arr.print();
                        break;
                    }else{
                        System.out.println("Arreglo vacio!");
                        break;
                    }                    
                case 6:
                    if(lleno == true){
                        System.out.println(arr.factorial(lea.nextInt()));
                        break;
                    }else{
                        System.out.println("Arreglo vacio!");
                        break;
                    }
                case 7:
                    if(lleno == true){
                        System.out.println(arr.divisible());
                        break;
                    }else{
                        System.out.println("Arreglo vacio!");
                        break;
                    } 
                case 8:
                    if(lleno == true){
                        System.out.println(arr.palindromo());
                        break;
                    }else{
                        System.out.println("Arreglo vacio!");
                        break;
                    }
                case 9:
                    if(lleno == true){
                        arr.remplazar();
                        break;
                    }else{
                        System.out.println("Arreglo vacio!");
                        break;
                    } 
                case 10:
                    if(lleno == true){
                        arr.quicksort();
                        break;
                    }else{
                        System.out.println("Arreglo vacio!");
                        break;
                    }
                case 11:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opcion Invalida.");
            }
        }while(true);
    }
}
