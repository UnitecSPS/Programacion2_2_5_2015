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
public enum Ejes {
    NUM4(12), NUM6(20), NUM8(24);
    final int peaje;
    
    private Ejes(int p){
        peaje=p;
    }
}
