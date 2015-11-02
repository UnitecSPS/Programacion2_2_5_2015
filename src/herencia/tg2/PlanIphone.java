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
public class PlanIphone extends Plan {
    private String email;
    
    public PlanIphone(int num, String name, String e) {
        super(num, name);
        email = e;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public double pago(int cmins, int cmsgs) {
        return 22 + (cmins*0.4)+(cmsgs*0.1);
    }

    @Override
    public void print() {
        super.print(); 
        System.out.println(email);
    }
    
    
    
}
