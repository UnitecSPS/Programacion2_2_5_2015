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
public class HombreLobo extends Ficha {
    
    private boolean soportaElDia;
    
    public HombreLobo(){
        vida = 5;
        fuerza = 4;
        escudo = 3;
    }

    public boolean isSoportaElDia() {
        return soportaElDia;
    }
    
    
}
