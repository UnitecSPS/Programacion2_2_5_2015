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
public class SocialNetwork {
    protected String username;
    protected ArrayList<String> posts;

    public SocialNetwork(String username) {
        this.username = username;
        posts = new ArrayList<>();
    }
    
    public void feed(){
        for(String post : posts)
            System.out.println(post);
    }
}
