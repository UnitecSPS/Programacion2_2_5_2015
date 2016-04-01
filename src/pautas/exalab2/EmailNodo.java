/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pautas.exalab2;


public class EmailNodo {
    public long pos;
    public String emisor;
    public String asunto;
    public boolean leido;
    public EmailNodo next;

    public EmailNodo(long pos, String emisor, String asunto, boolean leido) {
        this.pos = pos;
        this.emisor = emisor;
        this.asunto = asunto;
        this.leido = leido;
        next=null;
    }
    
}
