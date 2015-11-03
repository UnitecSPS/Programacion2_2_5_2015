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
        s = new Square(10, 10);
        s.draw();
        //Funciones On-Demand
        s = new Shape("Line","Black",3,10){
            public void printline(){
                for(int x=0;x<this.graphWidth;x++){
                    System.out.print("-");
                }
            }
            @Override
            public void draw(){
                for(int x=0;x<this.graphHeight;x++){
                    this.printline();
                    System.out.println("");
                }
            }
        };
        s.draw();
        
        s = new Shape("Waka","Black",3,10) {

            @Override
            public void draw() {
                for(int x=0;x<5;x++)
                    System.out.println("^");
            }
        };
        s.draw();
    }
}
