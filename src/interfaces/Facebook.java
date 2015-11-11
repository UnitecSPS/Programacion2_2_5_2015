/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.ArrayList;

/**
 *
 * @author Aula
 */
public class Facebook extends SocialNetwork implements Commentable {
    private ArrayList<Comment> comments;
    
    public Facebook(String username) {
        super(username);
        comments = new ArrayList<>();
    }

    @Override
    public void addComment(int id, String comment) {
        System.out.println("Facebook Comment Engine...");
        comments.add(new Comment(id, comment));
    }

    @Override
    public void printCommentsFromAPost(int id) {
        for(Comment co : comments){
            if(co.idPost == id)
                System.out.println("-"+co);
        }
    }
    
}
