/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package errores.prueba3;

/**
 *
 * @author Aula
 */
public class InvalidValueException extends RuntimeException {
    public InvalidValueException(int v){
        super("Numero "+v+" no es permitido.");
    }
}
