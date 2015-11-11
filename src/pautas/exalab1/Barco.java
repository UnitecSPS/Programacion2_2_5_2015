/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pautas.exalab1;

import java.util.Calendar;

public abstract class Barco {
    
    protected String nombre;
    protected Calendar fecha;
    
    public Barco(String nombre){
        this.nombre = nombre;
        fecha = Calendar.getInstance();
    }
    
    public final String getNombre(){
        return nombre;
    }
    
    public final Calendar getFechaCirc(){
        return fecha;
    }
    
    @Override
    public String toString(){
        return "Nombre: " + nombre + " - Fecha: " + fecha.getTime();
    }
    
    public abstract void agregarElemento();
    
    public abstract double vaciarCobrar();
}
