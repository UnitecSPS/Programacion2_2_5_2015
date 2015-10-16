/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intro;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Aula
 */
public class ColeccionDinamica {
    public static void main(String[] args) {
        //String coleccion[] = new String[10];
        ArrayList<String> coleccion = new ArrayList<>();
        //coleccion[0] = "hola";
        //coleccion[1] = "mundo";
        //coleccion[2] = "masiso";
        coleccion.add("hola");
        coleccion.add("mundo");
        coleccion.add("masiso");
        //imprimir----------------
        for(String cad : coleccion)
            System.out.println("-"+cad);
        /*
        for(int p=0; p < coleccion.length; p++){
            sop( coleccion[p] );
        }
        */
        coleccion.add(1, "SOS");
        //coleccion[2] = "Chuco";
        coleccion.set(2, "Chuco");
        System.out.println("---");
        for(int p=0; p < coleccion.size(); p++){
            System.out.println("-"+coleccion.get(p));
        }
        //Esto da IndexOutOfBoundException
        //System.out.println(coleccion.get(5));
        
        //Especiales----
        if(coleccion.contains("Chuco"))
            System.out.println("Si encontre Chuco");
        
        coleccion.remove("Chuco");
        coleccion.remove(0);
        System.out.println("Removi Chuco??");
        for(int p=0; p < coleccion.size(); p++){
            System.out.println("-"+coleccion.get(p));
        }
        coleccion.clear();
        System.out.println("Size: " + coleccion.size());
    }
}
