/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enums;

/**
 *
 * @author Aula
 */
public class Carro {
    private String marca, modelo;
    public Ejes eje;
    
    public Carro(Ejes e){
        eje = e;
    }
    
    public static void main(String[] args) {
        Carro c = new Carro(Ejes.NUM4);
        System.out.println(c.eje.peaje);
        
    }
}
