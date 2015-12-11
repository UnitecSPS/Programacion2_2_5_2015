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
public class Lista {
    private Nodo inicio = null;
    
    public boolean isEmpty(){
        return inicio == null;
    }
    
    public void add(Nodo obj){
        if(isEmpty())
            inicio = obj;
        else{
            //encontremos la cola
            Nodo tmp = inicio;
            
            while(tmp.next!=null)
                tmp = tmp.next;
            
            tmp.next = obj;
        }
    }
    
    /*
    Imprime todos los elementos de la lista
    */
    public void print(){
        Nodo tmp = inicio;
        System.out.println("\nLista\n-------");
        
        while(tmp != null){
            System.out.println(tmp);
            tmp = tmp.next;
        }
    }
    
    /*
    Remueve unobjeto de la lista que coincida
    con el codigo que se recibe de parametro
    */
    public boolean remove(int cod){
        return false;
    }
}
