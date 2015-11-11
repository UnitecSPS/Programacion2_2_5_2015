/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.Calendar;

/**
 *
 * @author Aula
 */
public class Comment {
    public int idPost;
    public String body;
    public Calendar date;

    public Comment(int idPost, String body) {
        this.idPost = idPost;
        this.body = body;
        date = Calendar.getInstance();
    }
    
    @Override
    public String toString(){
        return body+" - "+date.getTime();
    }
}
