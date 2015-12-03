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
public enum PaymentType {
    TARJETA(0), CONTADO(0.02), TARJETA_LOURDES(0.1);
    double discount;
    private PaymentType(double d){
        discount = d;
    }
}
