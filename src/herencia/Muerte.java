/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herencia;

/**
 *
 * @author Aula
 */
public class Muerte extends Ficha {
    public Muerte(){
        super(3,3,3);
    }
    
    @Override
    public void quienSoy(){
        System.out.println("Soy La Muerte TanTararan");
    }
    
    @Override
    public String toString() {
        return "La Muerte "+super.toString(); 
    }
}
