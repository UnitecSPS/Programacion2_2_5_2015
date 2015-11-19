/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pautas.exalab1;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;


public class Muelle {
    public static ArrayList <Barco> barcos = new ArrayList();
    public static Scanner lea = new Scanner(System.in);
    
    public static Barco buscar(String nombre){
        for(Barco barco : barcos){
            if(barco.getNombre().equals(nombre))
                return barco;
        }
        return null;
    }
    
    public static void agregarBarco(String tipo, String nombre, double precio){
        if(buscar(nombre) == null){
            switch(tipo){
                case "PESQUERO":
                    barcos.add(new BarcoPesquero(nombre, precio));
                    break;
                case "PASAJERO":
                    System.out.println("Capacidad: ");
                    int cap = lea.nextInt();
                    barcos.add(new BarcoPasajero(nombre, cap, precio));
                    break;
            }
            System.out.println("Barco agregado.");
        }else{
            System.out.println("Barco ya existe.");
        }
    }
    
    public static void agregarElemento(String nombre){
        Barco barco = buscar(nombre);
        if( barco != null )
            barco.agregarElemento();
    }
    
    public static double vaciarBarco(String nombre){
        Barco barco = buscar(nombre);
        if( barco != null ){
            System.out.println(barco);
            return barco.vaciarCobrar();
        }
        return 0;
    }
    
    public static void listarPasajeros(){
        listarPasajeros(0);
    }
    
    private static void listarPasajeros(int n){
        if(n < barcos.size()){
            Barco barco = barcos.get(n);
            
            if(barco instanceof BarcoPasajero){
                ((BarcoPasajero)barco).listarPasajeros();
            }
            
            listarPasajeros(n+1);
        }
    }
    
    private static void agregarCardumen(String nombre, int cantidad){
        Barco barco = buscar(nombre);
        if( barco instanceof BarcoPesquero )
            ((BarcoPesquero)barco).agregarCardumen(cantidad);
    }
    
    public static void barcosDesde(int year){
        for(Barco barco : barcos){
            if(barco.getFechaCirc().get(Calendar.YEAR) >= year)
                System.out.println("-"+barco.getNombre()+"-"+
                        barco.getFechaCirc().getTime());
        }
    }
    
    
    public static void main(String[] args) {
        int decision;
        String tipo, nombre;
        int ct, cap = 0;
        double precio;
        
        do{
            System.out.println("\n\tPUERTO CORTES - MUELLE PRINCIPAL");
            System.out.println("1 - Agregar Barco");
            System.out.println("2 - Agregar Elemento");
            System.out.println("3 - Vaciar Barco");
            System.out.println("4 - Listar Pasajeros");
            System.out.println("5 - Agregar Cardumen");
            System.out.println("6 - Barcos por Circulacion");
            System.out.println("7 - Salir");
            System.out.print("\nEscoja una opcion: ");
            decision = lea.nextInt();
            
            switch(decision){
                case 1:
                    System.out.print("Tipo de Barco: ");
                    tipo = lea.next().toUpperCase();
                    System.out.print("Nombre de Barco: ");
                    nombre = lea.next();
                    System.out.print("Precio: ");
                    precio = lea.nextDouble();
                    agregarBarco(tipo, nombre, precio);
                    break;
                case 2:
                    System.out.print("Barco: ");
                    nombre = lea.next();
                    agregarElemento(nombre);
                    break;
                case 3:
                    System.out.print("Barco: ");
                    nombre = lea.next();
                    vaciarBarco(nombre);
                    break;
                case 4:
                    listarPasajeros();
                    break;
                case 5:
                    System.out.print("Barco: ");
                    nombre = lea.next();
                    System.out.print("Cantidad a agregar: ");
                    ct = lea.nextInt();
                    agregarCardumen(nombre,ct);
                    break;
                case 6:
                    System.out.print("Año: ");
                    int year = lea.nextInt();
                    System.out.println("\tBARCOS CIRCULANDO DESDE "+year);
                    barcosDesde(year);
                    break;     
            }
            
        }while(decision != 7);
    }
    
}