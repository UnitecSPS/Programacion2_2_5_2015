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
public class Tigo {
    public static void main(String[] args) {
        Plan p = new PlanIphone(123,"messi@hola.or");
        System.out.println(((PlanIphone)p).getEmail());
    }
}
