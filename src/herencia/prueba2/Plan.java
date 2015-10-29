/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herencia.prueba2;

/**
 *
 * @author Aula
 */
public class Plan {
    protected int num, fijo;
    
    public Plan(int n, int f){
        num = n;
        fijo = f;
    }
    
    @Override
    public String toString(){
        return "["+num+"-"+fijo+"]";
    }
}
