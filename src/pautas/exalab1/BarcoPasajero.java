/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pautas.exalab1;

import java.util.Scanner;

public final class BarcoPasajero extends Barco{
    private String[] pasajeros;
    private double precioBoleto;
    private int cuantos;
    
    public BarcoPasajero(String nombre, int max, double precio){
        super(nombre);
        pasajeros = new String[max];
        precioBoleto = precio;
        cuantos = 0;
    }
    
    public void listarPasajeros(){
        for(int p=0; p < cuantos; p++)
            System.out.println("-"+pasajeros[p]);
    }
    
    @Override
    public void agregarElemento(){
        Scanner lea = new Scanner(System.in);
        
        if(cuantos < pasajeros.length)
            pasajeros[cuantos++] = lea.next();
        else
            System.out.println("No hay espacio");
    }
    
    @Override
    public double vaciarCobrar(){
        double total = cuantos*precioBoleto;
        cuantos = 0;
        return total;
    }
    
    @Override
    public String toString(){
        return super.toString() + " - Cantidad de Pasajeros: "+ cuantos;
    }
}
