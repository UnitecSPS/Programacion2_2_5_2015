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
public class Paint {
    public static void main(String[] args) {
        Shape s = new Circle(10, 10, 5);
        s.draw();
        s = new Rectangle(10, 10);
        s.draw();
    }
}
