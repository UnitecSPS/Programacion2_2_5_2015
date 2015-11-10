/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.io.Closeable;
import java.io.IOException;
import java.io.Serializable;

/**
 *
 * @author Aula
 */
public class Chisme implements Commentable, Serializable, Closeable {
    String comments[];
    
    public Chisme(){
        comments = new String[1000];
    }
    
    @Override
    public void addComment(int id, String comment) {
        System.out.println("Mas chismes...");
        comments[id] = comment;
    }

    @Override
    public void printCommentsFromAPost(int id) {
        System.out.println(comments[id]);
    }
    
    public void print(){
        for(String co : comments)
            System.out.println("-"+co);
    }

    @Override
    public void close() {
        System.out.println("Cerrando chisme");
    }
    
}
