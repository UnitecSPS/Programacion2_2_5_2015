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
public class Tigo {
    ArrayList<Plan> planes = new ArrayList<>();
    
    public void addPlan(int numtel,String nombre,  String extra, String tipo){
        if(!busqueda(numtel, extra, tipo)){
            if(tipo.equalsIgnoreCase("IPHONE"))
                planes.add(new PlanIphone(numtel, nombre, extra));
            else if(tipo.equalsIgnoreCase("BLACKBERRY"))
                planes.add(new PlanBlackberry(numtel, nombre, extra));
            else
                planes.add(new Plan(numtel,nombre){
                    @Override
                    public double pago(int mins, int msgs){
                        return mins*1.2+msgs*0.5;
                    }
                });
        }
    }
    
    public boolean busqueda(int numtel, String datoExtra, String tipo){
        for(Plan p : planes){
            if(p.getNum() == numtel)
                return true;
            if(tipo.equalsIgnoreCase("IPHONE") && 
                    p instanceof PlanIphone ){
                if(((PlanIphone)p).getEmail().equals(datoExtra))
                    return true;
            } 
            else if (tipo.equalsIgnoreCase("BLACKBERRY") &&
                    p instanceof PlanBlackberry){
                
                if(((PlanBlackberry)p).getPin().equals(datoExtra))
                    return true;
            }
        }
        return false;
    }
    
    public double pagoPlan(int numTel, int mins,int msgs){
        for(Plan p : planes){
            if(p.getNum() == numTel)
                return p.pago(mins, msgs);
        }
        return 0;
    }
   
    public void addAmigo(int numTel, String pin){
        for(Plan p : planes){
            if(p.getNum() == numTel){
                if(p instanceof PlanBlackberry)
                    ((PlanBlackberry)p).addPin(pin);
                break;
            }
        }
    }
    
    public void list(){
        int iphones=0, bbs=0;
        for(Plan p : planes){
            p.print();
            if(p instanceof PlanIphone)
                iphones++;
            else if(p instanceof PlanBlackberry)
                bbs++;
        }
        System.out.println(iphones+"-"+bbs);
    }
    
}
