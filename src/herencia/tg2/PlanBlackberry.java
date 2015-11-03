/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package herencia.tg2;

import java.util.ArrayList;

/**
 *
 * @author mac
 */
public class PlanBlackberry extends Plan {
    private String pin;
    private ArrayList<String> bbm;

    public PlanBlackberry(int num, String name, String p) {
        super(num, name);
        pin = p;
        bbm = new ArrayList<>();
    }

    public String getPin() {
        return pin;
    }

    public void addPin(String pin){
        if(!bbm.contains(pin))
            bbm.add(pin);
    }

    @Override
    public double pago(int cmins, int cmsgs) {
        double pago = 40;
        if(cmins > 200)
            pago += (cmins-200)*0.8;
        if(cmsgs > 300)
            pago += (cmsgs-300)*0.2;
        return pago;
    }
    
    @Override
    public void print() {
        super.print(); 
        System.out.println(pin);
    }
}
