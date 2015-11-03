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
public class Square extends Rectangle {

    public Square(int gh, int gw) {
        super(gh/2, gw/2);
    }

    @Override
    public void draw() {
        System.out.println("----Square----");
        super.draw(); 
        System.out.println("--------------");
    }
    
    
    
}
