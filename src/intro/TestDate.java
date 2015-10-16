/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intro;

import java.util.Date;

/**
 *
 * @author Aula
 */
public class TestDate {
    public static void main(String[] args) {
        Date d = new Date();
        System.out.println(d);
        Date d1 = new Date(1);
        System.out.println(d1);
        Date d2 = new Date(Long.MAX_VALUE);
        System.out.println(d2);
        
    }
}
