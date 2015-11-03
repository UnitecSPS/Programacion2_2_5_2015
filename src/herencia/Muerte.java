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
public final class Muerte extends Ficha {
    public static final int FUERZA = 3;
    
    public Muerte(){
        super(3,FUERZA,3);
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
