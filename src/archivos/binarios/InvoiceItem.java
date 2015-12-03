/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos.binarios;

/**
 *
 * @author Aula
 */
public class InvoiceItem {
    public int codigo, cantidad;
    public double precio;
    public String nombre;

    public InvoiceItem(int codigo, int cantidad, double precio, String nombre) {
        this.codigo = codigo;
        this.cantidad = cantidad;
        this.precio = precio;
        this.nombre = nombre;
    }
    
    
}
