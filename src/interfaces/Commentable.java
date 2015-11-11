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
public interface Commentable {
    //por default: public static final
    double VERSION=1.2;
    ArrayList<String> arreys = new ArrayList<>();
    //por default: public abstract
    void addComment(int id, String comment);
    void printCommentsFromAPost(int id);
}
