/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enums;

/**
 *
 * @author Aula
 */
public class Eje {
    public final int peaje, ordinal;
    public final String name;
    public static final Eje NUM4 = new Eje(12,0,"NUM4");
    public static final Eje NUM6 = new Eje(20,1,"NUM6");
    public static final Eje NUM8 = new Eje(24,2,"NUM8");
    
    public Eje(int p, int o, String n){
        peaje = p;
        ordinal = o;
        name = n;
    }
    
    public String name(){
        return name;
    }
    
    public int ordinal(){
        return ordinal;
    }
    
    @Override
    public String toString(){
        return name;
    }
    
    public static Eje valueOf(String n){
        switch(n){
            case "NUM4":
                return NUM4;
            case "NUM6":
                return NUM6;
            case "NUM8":
                return NUM8;
            default:
                throw new IllegalArgumentException(n+" No es un tipo adecuado");
        }
    }
}
