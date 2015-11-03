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
    public static final int version = 123;

    public Ficha(int v, int f, int e) {
        System.out.println("LLamando a Papa");
        vida = v;
        fuerza = f;
        escudo = e;
    }

    public final int getVida() {
        return vida;
    }

    public final int getFuerza() {
        return fuerza;
    }

    public final int getEscudo() {
        return escudo;
    }

    @Override
    public String toString() {
        return "{" + "vida=" + vida + ", fuerza=" + fuerza + ", escudo=" + escudo + '}';
    }
    
    public void quienSoy(){
        //version++;
        final int x=5;
        System.out.println("Soy una Ficha");
    }
    
    public void damage(Ficha atacante){
        if(escudo > 0)
            escudo -= atacante.fuerza;
        if(escudo < 0){
            vida += escudo;
            escudo = 0;
        }
    }
    
}
