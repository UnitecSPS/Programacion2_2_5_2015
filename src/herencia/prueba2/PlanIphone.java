/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herencia.prueba2;

/**
 *
 * @author Aula
 */
public class PlanIphone extends Plan {
    private String itunesEmail;
    
    public PlanIphone(int n,String e){
        super(n,80);
        itunesEmail = e;
    }
    
    public String getEmail(){
        return itunesEmail;
    }
    
    @Override
    public String toString(){
        return super.toString()+itunesEmail;
    }
}
