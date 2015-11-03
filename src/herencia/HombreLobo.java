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
public final class HombreLobo extends Ficha {
    
    private boolean soportaElDia;
    public static final int FUERZA = 4;
    
    public HombreLobo(int v){
        super(v,FUERZA,3);
        System.out.println("Llamando a la Luna");
    }

    public final boolean isSoportaElDia() {
        return soportaElDia;
    }
    
    @Override
    public void quienSoy(){
        System.out.println("Soy Hombre Lobo Auuuuuu");
    }

    @Override
    public String toString() {
        return "HombreLobo "+super.toString()+
                ", SoportaElDia?="+soportaElDia; 
    }
    
    public void lunaLlena(boolean esDeDia){
        if(soportaElDia && esDeDia){
            System.out.println("Soporta el dia");
        }
        else if(!soportaElDia && esDeDia){
            System.out.println("No Soporta el dia");
            System.out.println("Se hace debil por ahora");
            vida -= 3;
        }
        else{
            vida = 5;
        }   
    }

    public void setSoportaElDia(boolean soportaElDia) {
        this.soportaElDia = soportaElDia;
    }
    
    
}
