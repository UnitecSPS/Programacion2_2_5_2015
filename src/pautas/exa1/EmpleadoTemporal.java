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
public class EmpleadoTemporal extends Empleado {
    private Calendar finContrato;
    
    public EmpleadoTemporal(int c, String n, double s){
        super(c,n,s);
        finContrato = Calendar.getInstance();
    }
    
    public void setFinContrato(int y,int m, int d){
        Calendar propuesta = Calendar.getInstance();
        propuesta.set(y,m,d);
        
        if(propuesta.after(Calendar.getInstance())){
            finContrato = propuesta;
        }
    }
    
    @Override
    public double pago(){
        if(finContrato.after(Calendar.getInstance()))
            return salario;
        return 0;
    }
    
    @Override
    public String toString(){
        return super.toString() + "Fin: "+
                finContrato.getTime();
    }
}
