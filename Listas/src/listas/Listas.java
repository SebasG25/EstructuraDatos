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
        DoublyLinkedList<Integer> miLista2 = new DoublyLinkedList<>();  
        
        miLista.add(99);
        System.out.println(miLista.showData());
        try{
            miLista.addDescendently(22);
            miLista.addDescendently(11);
            miLista.addDescendently(33);
            miLista.addDescendently(100);
            miLista.addDescendently(55);
            miLista.addDescendently(200);
            System.out.println(miLista.showData());
            miLista.addDescendently(99);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
        miLista2.add(11);
        miLista2.add(22);
        miLista2.add(33);
        miLista2.add(44);
        miLista2.add(55);
        miLista2.add(66);
        miLista2.add(99);
        System.out.println(miLista2.checkData(66));
        System.out.println(miLista2.checkData(90));
        
        System.out.println("ANTES DE BORRAR: " + miLista2.showData());
        
        try{
            miLista2.deleteNode(99);
            miLista2.deleteNode(11);
            miLista2.deleteNode(66);
            miLista2.deleteNode(99);
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        System.out.println("DESPUÉS DE BORRAR: " + miLista2.showData());
        try{
            miLista2.addNodeAfter(11, 100);
            miLista2.addNodeAfter(55, 109);
            miLista2.addNodeAfter(99, 100);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        System.out.println(miLista2.showData());
        
    }
}
