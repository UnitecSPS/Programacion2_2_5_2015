/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herencia;

import java.util.ArrayList;

/**
 *
 * @author Aula
 */
public class Tablero {
    public static void main(String[] args) {
        
        ArrayList<Ficha> fichas = new ArrayList<>();
        
        fichas.add(new HombreLobo(5));
        fichas.add(new Vampiro());
        fichas.add(new Muerte());
        fichas.add(new Ficha(5, 5, 5));
        
        for(Ficha ficha : fichas){
            ficha.quienSoy();
            System.out.println(ficha);
            if(ficha instanceof HombreLobo)
                ((HombreLobo)ficha).lunaLlena(true);
        }
    }
}
