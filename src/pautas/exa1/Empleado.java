/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pautas.exa1;

/**
 *
 * @author Aula
 */
public abstract class Empleado {
    protected int codigo;
    protected String nombre;
    protected double salario;

    public Empleado(int codigo, String nombre, double salario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.salario = salario;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getSalario() {
        return salario;
    }
    
    public abstract double pago();

    @Override
    public String toString() {
        return "codigo=" + codigo + 
                ", nombre=" + nombre + ", salario=" 
                + salario;
    }
    
    
    
}
