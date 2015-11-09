/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pautas.exa1;

import java.util.Calendar;

/**
 *
 * @author Aula
 */
public class EmpleadoVentas extends Empleado {
    private double ventas[];
    public static final double tasaXVenta = 0.1;
    
    public EmpleadoVentas(int c, String n, double s){
        super(c,n,s);
        ventas = new double[12];
    }
    
    public int mesActual(){
        return Calendar.getInstance().get(Calendar.MONTH);
    }
    
    public void actualizarVenta(double v){
        ventas[mesActual()] += v;
    }
    
    @Override
    public double pago(){
        return salario + 
                (ventas[mesActual()]*tasaXVenta);
    }
    
    public double ventaAnual(){
        return ventaAnual(0);
    }

    private double ventaAnual(int pos) {
        if(pos < ventas.length){
            return ventaAnual(pos+1) + ventas[pos];
        }
        return 0;
    }
}
