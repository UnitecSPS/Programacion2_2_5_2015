/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursion.tg1;

import java.util.Scanner;

/**
 *
 * @author Aula
 */
public class ArrayRecs {
    
    private int array[];
    private Scanner lea = new Scanner(System.in);
    
    public ArrayRecs(int longi){
        array = new int[longi];
    }
    //Funcion Auxiliar.
    public void llenar(){
        llenar(0);
    }
    private void llenar(int pos){
        if(pos < array.length){
            array[pos] = lea.nextInt();
            llenar(pos+1);
        }
    }
    
    //Funcion Auxiliar.
    public int suma(){
        return suma(0);
    }
    private int suma(int pos){
        if(pos < array.length)
            return array[pos]+suma(pos+1);
        return 0;
    }
    
    //Funcion Auxiliar.
    public boolean buscar(){
        return buscar(lea.nextInt(),0);
    }
    private boolean buscar(int n, int pos){
        if(pos < array.length){
            if(array[pos] == n)
                return true;
            return buscar(n, pos+1);
        }
        return false;
    }
    
    //Funcion para imprimir.
    public void print(){
        print(0);
    }
    private void print(int pos){
        if(pos<array.length){
            System.out.println(array[pos]);
            print(pos+1);
        }
    }
    
    public int maximo(){
        return maximo(0, Integer.MIN_VALUE);
    }

    private int maximo(int pos, int mayor) {
        if(pos < array.length){
            if(mayor < array[pos])
                mayor = array[pos];
            return maximo(pos+1, mayor);
        }
        return mayor;
    }
    
    public int factorial(int pos){
        if(pos >=0 && pos < array.length)
            return factorial2(array[pos]);
        System.out.println("Posicion no existe");
        return 0;
    }

    private int factorial2(int n) {
        if(n>1)
            return n * factorial2(n-1);
        else if(n==0)
            return 0;
        return 1;
    }
    
    //Mi parte comienza aqui. -RobertoMelara
    public int divisible(){
        return divisible(lea.nextInt(),0,0);
    }
    private int divisible(int n, int acum, int pos){
        if(pos<array.length){
            if(array[pos]%n==0){
                return divisible(n,acum+1,pos+1);
            }else{
                return divisible(n,acum,pos+1);
            }
        }
        return acum;
    }
    
    public boolean palindromo(){
        return palindromo(0,array.length-1);
    }
    private boolean palindromo(int posi,int posf){
        if(posi<=posf){
            if(array[posi]==array[posf]){
                return palindromo(posi+1,posf-1);
            }else{
                return false;
            }
        }
        return true;
    }
    
    public void remplazar(){
        remplazar(lea.nextInt(),lea.nextInt(), 0);
    }
    private void remplazar(int n, int m, int pos){
        if(pos < array.length){
            if(array[pos] == m){
                array[pos] = n;
                remplazar(n,m,pos+1);
            }
        }
    }
    
    //Ordenamiento por Quicksorting.
    public void quicksort(){
        quickSort(array);
    }

    public void quickSort(int[] arr) { 
        quickSortPrimerPivote(arr, 0, arr.length - 1); 
    } 
    
    //Aqui se trabaja en posicionar el primer pivote en su posicion ordenada
    //es decir los numeros menores que el a la izquierda y los mayores a la derecha.
    public void quickSortPrimerPivote(int[] array, int startIdx, int endIdx) {
        int idx = partition(array, startIdx, endIdx); 
        if (startIdx < idx - 1) {
            quickSortPrimerPivote(array, startIdx, idx - 1);
        }
        if (endIdx > idx) {
            quickSortPrimerPivote(array, idx, endIdx); 
        }
    } 
    
    //Aqui se trabaja con las "partitions" o los "arreglos" que se forman
    //al dividir el arreglo original en los mayores que el primer pivote y 
    //los menos al primer pivote.
    public static int partition(int[] array, int left, int right) {
        int pivot = array[left];
        
        while (left <= right) { 
            while (array[left] < pivot) { 
                left++; 
            }
            while (array[right] > pivot) { 
                right--; 
            } 
 
            if (left <= right) { 
                int tmp = array[left]; 
                array[left] = array[right]; 
                array[right] = tmp; 
                 
                left++; 
                right--; 
            }
        } 
        return left; 
    }
}
