/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package herencia.tg2;

/**
 *
 * @author mac
 */
public abstract class Plan {
    protected int num;
    protected String name;

    public Plan(int num, String name) {
        this.num = num;
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public String getName() {
        return name;
    }
    
    public void print(){
        System.out.println(num+"-"+name);
    }
    
    public abstract double pago(int cmins, int cmsgs);
}
