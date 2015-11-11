/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Aula
 */
public class HCM {
    public static void main(String[] args) throws IOException {
        Facebook fb = new Facebook("gotcha");
        if(fb instanceof Commentable)
            System.out.println("FB es comentable");
        Twitter tw = new Twitter("gotcha");
        if(tw instanceof Commentable)
            System.out.println("Twiter es comentable");
        
        //-------
        Commentable f = new Chisme();
        f.addComment(0, "Wazaaap");
        f.printCommentsFromAPost(0);
        ((Chisme)f).print();
        //---
        ArrayList<Commentable> comentables = new ArrayList<>();
        comentables.add(fb);
        comentables.add(new Chisme());
        
        for(Commentable com : comentables){
            com.addComment(0, "Hola");
            if( com instanceof Closeable)
                ((Closeable)com).close();
        }
        //-------
        Closeable c = new Closeable() {

            @Override
            public void close() throws IOException {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
    }
}
