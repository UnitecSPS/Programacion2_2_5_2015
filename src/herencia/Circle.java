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
public class Circle extends Shape {
    private int radius;
    
    public Circle(int gh, int gw, int r){
        super("circle","black",gh,gw);
        radius = r;
    }

    @Override
    public void draw() {
        //super.draw();
        int angle, aspectedGraphHeight, row, column, x, y, angleStep;
        char[][] circle = new char [150][150];
        //converting degree to radian by multiplying with pi/180
        angle = (int)(360 * Math.PI/180);
    
        //graphHeight is divided by scaling factor 2 for aspected ratio of characters in terminal
        //.5 is for precision
        aspectedGraphHeight = (int)(graphHeight/2.0);  


        // define graphpaper          
        for(row=0; row<=aspectedGraphHeight; row++)
        {    
            for(column=0; column<=graphWidth; column++)
            {
            circle[row][column]=' ';
            }
        }   

        //horizontal axis     
        for(column = 0; column <= graphWidth; column++)
        {
            row = aspectedGraphHeight / 2;
            circle[row][column] = '-';
        }

        //vertical axis
        for(row = 0; row <= aspectedGraphHeight; row++)
        {
             column = graphWidth / 2;
             circle[row][column] = '|';
        }

        //points of circle

        for (angle = 0;  angle <= 360; angle += 1)
        {   
           x = (int)(radius * Math.cos(angle));  
           y = (int)(radius * Math.sin(angle));

         row = (aspectedGraphHeight/2 - y/2);  
         // y is divided by scaling factor 2 for aspected ratio of characters in terminal
         column = graphWidth/2 + x;
         circle[row][column] = '.';
        }    


        //print circle
        for(row = 0; row<=aspectedGraphHeight; row++)
            {
                 for(column = 0; column<=graphWidth; column++)
                 System.out.print(circle[row][column]);
                 System.out.println(" ");
            }     
    }
}
