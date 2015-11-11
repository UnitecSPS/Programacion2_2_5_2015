/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pautas.exalab1;


public final class BarcoPesquero extends Barco{
    private int pecesCapturados;
    private final double precioPorPescado;
    
    public BarcoPesquero(String nombre, double precio){
        super(nombre);
        pecesCapturados = 0;
        precioPorPescado = precio;
    }
    
    @Override
    public void agregarElemento(){
        pecesCapturados++;
    }
    
    @Override
    public double vaciarCobrar(){
        double total = pecesCapturados*precioPorPescado;
        pecesCapturados = 0;
        return total;
    }
    
    public void agregarCardumen(int car){
        pecesCapturados+=car;
    }
    
    @Override
    public String toString(){
        return super.toString() + " - Peces Capturados: " + pecesCapturados;
    }
}
