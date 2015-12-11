/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos.serializar;

import java.io.Serializable;

/**
 *
 * @author Aula
 */
public class Producto implements Serializable{
    private int codigo, cantidad=0;
    private String nombre;
    private double precio;
    private transient Tipo tipo=null;

    public Producto(int codigo, String nombre, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public void setCantidad(int cantidad) {
        this.cantidad += cantidad;
    }

    public int getCodigo() {
        return codigo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return "Producto{" + "codigo=" + codigo + ", cantidad=" + cantidad +
                ", nombre=" + nombre + ", precio=" +
                precio + " tipo: "+ tipo+ '}';
    }

}
