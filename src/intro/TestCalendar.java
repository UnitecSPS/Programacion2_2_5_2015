/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intro;

import java.util.Calendar;
import java.util.Locale;

/**
 *
 * @author Aula
 */
public class TestCalendar {
    public static void main(String[] args) {
        Calendar now = Calendar.getInstance();
        //imprimir la fecha
        System.out.println(now.getTime());
        //imprimir los milisegundos
        System.out.println(now.getTimeInMillis());
        //el primer milisegundo!
        Calendar old = Calendar.getInstance();
        old.setTimeInMillis(1);
        //imprimir la fecha
        System.out.println(old.getTime());
        //configurarlo con una fecha especifica
        old.set(1982, Calendar.AUGUST, 10);
        System.out.println(old.getTime());
        
        //comparaciones
        if(now.getTimeInMillis() >= old.getTimeInMillis())
            System.out.println("Now paso despues que old");
        if(now.after(old))
            System.out.println("Now paso despues que old");
        if(old.before(now))
            System.out.println("Old paso antes que Now");
        System.out.println(now.compareTo(old));
        System.out.println(old.compareTo(now));
        System.out.println(now.compareTo(now));
        
        //saber datos individuales
        System.out.println("Año: "+ old.get(Calendar.YEAR));
        System.out.println("Semana: "+old.get(Calendar.WEEK_OF_YEAR));
        System.out.println("Dia en el año: "+old.get(Calendar.DAY_OF_YEAR));
        System.out.println("Mes: "+old.get(Calendar.MONTH));
        
        //adicionar o restar valores
        old.add(Calendar.YEAR, 10);
        System.out.println(old.getTime());
        old.add(Calendar.MONTH, 6);
        System.out.println(old.getTime());
        old.add(Calendar.DATE, -10);
        System.out.println(old.getTime());
        
        Calendar test = Calendar.getInstance();
        test.add(Calendar.YEAR, -30);
        if(old.before(test))
            System.out.println("Old paso hace mas de 10 años");
        
        //nombres
        String mes = old.getDisplayName(Calendar.MONTH, Calendar.LONG, 
                Locale.FRENCH);
        String dia = old.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, 
                Locale.forLanguageTag("es"));
        System.out.println(mes+" "+dia);
    }
}
