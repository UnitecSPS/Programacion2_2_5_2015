/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos.serializar;

import java.io.Serializable;

/**
 *
 * @author Aula
 */
public class Tipo implements Serializable {
    public String name;

    public Tipo(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
    
    
}
