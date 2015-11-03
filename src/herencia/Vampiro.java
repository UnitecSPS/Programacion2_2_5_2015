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
public final class Vampiro extends Ficha {
    public static final int FUERZA = 5;
    
    public Vampiro() {
        super(4,FUERZA,4);
    }
    
    @Override
    public void quienSoy(){
        System.out.println("Soy Vampiro bla bla bla");
    }

    @Override
    public String toString() {
        return "Vampiro "+super.toString(); 
    }
    
    
}
