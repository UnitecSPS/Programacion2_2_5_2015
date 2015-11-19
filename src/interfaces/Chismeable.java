/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.io.Closeable;
import java.io.Serializable;

/**
 *
 * @author Aula
 */
public interface Chismeable extends Commentable,Serializable,Closeable {
    public String chismeDelDia();
}
