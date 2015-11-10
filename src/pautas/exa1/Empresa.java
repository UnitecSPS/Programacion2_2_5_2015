/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pautas.exa1;

import java.util.ArrayList;

/**
 *
 * @author Aula
 */
public class Empresa {
    ArrayList<Empleado> empleados = new ArrayList<>();
    
    public Empleado buscar(int c){
        return buscar(c,0);
    }

    private Empleado buscar(int c, int pos) {
        if(pos < empleados.size()){
            Empleado e = empleados.get(pos);
            if(e.getCodigo()==c)
                return e;
            return buscar(c, pos+1);
        }
        return null;
    }
    
    public void agregarEmpleado(int c, String n, double s,String t){
        if(buscar(c)==null){
            switch(t){
                case "TEMPORAL":
                    empleados.add(new EmpleadoTemporal(c, n, s));
                    break;
                case "VENTA":
                    empleados.add(new EmpleadoVentas(c, n, s));
            }
        }
    }
    
    public double pagarEmpleado(int cod){
        Empleado e = buscar(cod);
        if( e != null )
            return e.pago();
        return 0;
    }
    
    public void registrarVentas(int cod, double m){
        Empleado e = buscar(cod);
        if( e instanceof EmpleadoVentas){
            ((EmpleadoVentas)e).actualizarVenta(m);
        }
    }
    
    public void imprimir(){
        for(Empleado e : empleados){
            System.out.println(e);
            if( e instanceof EmpleadoVentas)
                System.out.println("Venta Anual: "+
                        ((EmpleadoVentas)e).ventaAnual());
        }
    }
    
}
