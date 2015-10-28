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
public class Batalla {
    public static void main(String[] args) {
        //UPCASTING
        Ficha hl = new HombreLobo(5);
        Ficha vam = new Vampiro();
        
        System.out.println(hl.toString());
        System.out.println(vam);
       
        //Formato:
        // obj instanceof Clase
        if(hl instanceof HombreLobo)
            System.out.println("Si es Hombre Lobo");
        if(hl instanceof Ficha)
            System.out.println("Si es Ficha Tambien");
        if(hl instanceof Object)
            System.out.println("Si es Object Tambien");
        
        
        //DOWNCASTING
        //a- Indirecto
        //((Vampiro)hl).quienSoy();<- ClassCastException
        HombreLobo lobo = (HombreLobo)hl;
        lobo.setSoportaElDia(true);
        lobo.lunaLlena(true);
        System.out.println(hl);
        //b- directo
        System.out.println("Soporta? "+((HombreLobo)hl).isSoportaElDia());
        
    }
}
