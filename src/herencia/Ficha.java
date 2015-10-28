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
public class Ficha {
    protected int vida, fuerza, escudo;

    public Ficha() {
        this.vida = 0;
        this.fuerza = 0;
        this.escudo = 0;
    }

    public int getVida() {
        return vida;
    }

    public int getFuerza() {
        return fuerza;
    }

    public int getEscudo() {
        return escudo;
    }

//    @Override
//    public String toString() {
//        return "Ficha{" + "vida=" + vida + ", fuerza=" + fuerza + ", escudo=" + escudo + '}';
//    }
    
    
    
}
