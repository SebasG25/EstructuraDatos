/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listas;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sebastián Guzmán
 */
public class Listas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        DoublyLinkedList<Integer> miLista = new DoublyLinkedList<>();  
        miLista.add(11);
        miLista.add(22);
        miLista.add(33);
        miLista.add(44);
        miLista.add(55);
        miLista.add(66);
        miLista.add(99);
        
        
        System.out.println(miLista.showData());
        System.out.println(miLista.checkData(66));
        try{
            miLista.deleteNode(99);
            
        }catch(Exception ex){
            ex.getMessage();
        }
        System.out.println(miLista.showData());
        
    }
}
