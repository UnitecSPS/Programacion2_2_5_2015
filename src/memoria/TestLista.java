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
public class TestLista {
    public static void main(String[] args) {
        Lista list = new Lista();
        
        list.add(new Nodo(1,"Luis"));
        list.add(new Nodo(2,"Rob"));
        list.add(new Nodo(3,"Ada"));
        list.add(new Nodo(4,"Jose"));
        
        list.print();
    }
}
