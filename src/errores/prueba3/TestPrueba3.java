/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package errores.prueba3;

/**
 *
 * @author Aula
 */
public class TestPrueba3 {
    int numeros[]=new int[10];
    
    public void addToArray(int pos, int v){
        
        try{
            if(v<0)
                throw new InvalidValueException(v);
            numeros[pos] = v;
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        TestPrueba3 t  =new TestPrueba3();
        t.addToArray(0, 10);//esto pasa bien
        t.addToArray(10, 5);//esto dar un OutOfBound
        t.addToArray(5, -5);//truena con Invalid...
    }
    
}
