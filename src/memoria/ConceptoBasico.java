/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memoria;

/**
 *
 * @author Aula
 */
public class ConceptoBasico {
    public static void main(String[] args) {
        Nodo a = new Nodo(1,"Luis");
        Nodo b = a;
        
        b.numero = 2;
        b.nombre = "Roberto";
        
        System.out.println(a);
        System.out.println(b);
        
        if(a == b)
            System.out.println("CIERTo!");
    }
}
