/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.io.IOException;

/**
 *
 * @author Aula
 */
public class ChismeLikeABoss implements Chismeable {

    @Override
    public String chismeDelDia() {
        return "Lourdes fue por agua y nunca volvio..que paso por ella? vos sabes?";
    }

    @Override
    public void addComment(int id, String comment) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void printCommentsFromAPost(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void close() throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
