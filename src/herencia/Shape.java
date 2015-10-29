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
public abstract class Shape {
    protected String name, color;
    protected int graphHeight , graphWidth;
    protected double size;

    public Shape(String name, String color, int gh, int gw) {
        this.name = name;
        this.color = color;
        graphHeight = gh;
        graphWidth = gw;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public double getSize() {
        return size;
    }
    
    public abstract void draw();
}
