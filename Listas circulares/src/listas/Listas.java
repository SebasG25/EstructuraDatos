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

        CircularSinglyLinkedList<Integer> miLista = new CircularSinglyLinkedList<>();  
        CircularSinglyLinkedList<Integer> miLista2 = new CircularSinglyLinkedList<>();  
        CircularSinglyLinkedList<Integer> miLista3 = new CircularSinglyLinkedList<>();  
        
        miLista.add(11);
        miLista.add(22);
        miLista.add(33);
        miLista.add(44);
        miLista.add(55);
        
        miLista2.add(66);
        miLista2.add(77);
        
        miLista3.addOrdered(1);
        miLista3.addOrdered(2);
        miLista3.addOrdered(3);
        miLista3.addOrdered(4);
        miLista3.addOrdered(99);
        
        System.out.println("Métodos \033[31mLISTAS CIRCULARES SIMPLES");
        
        System.out.println("\033[31mTercera lista ordenada:\033[30m " + miLista3.showData());
        
        System.out.println("\033[31mPrimer lista: \033[30m" + miLista.showData());
        try {
            System.out.println("\033[31mPrimer lista desde un dato: \033[30m" + miLista.showData(33));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        try {
            System.out.println("\033[31mPrimer lista unida con la segunda lista: \033[30m" + miLista.joinList(miLista2).showData());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        System.out.println("\n");
        
        System.out.println("Métodos \033[31mLISTAS CIRCULARES DOBLES");
        
        CircularDoublyLinkedList<Integer> miListaDoble = new CircularDoublyLinkedList<>();
        CircularDoublyLinkedList<Integer> miListaDoble2 = new CircularDoublyLinkedList<>();
        
        miListaDoble2.addOrdered(11);
        miListaDoble2.addOrdered(44);
        miListaDoble2.addOrdered(22);
        miListaDoble2.addOrdered(55);
        miListaDoble2.addOrdered(33);
        
        System.out.println("\033[31mMi segunda lista doble ordenada: \033[30m" + miListaDoble2.showData());
        
        miListaDoble.add(11);
        miListaDoble.add(22);
        miListaDoble.add(33);
        miListaDoble.add(44);
        miListaDoble.add(55);
        
        System.out.println("\033[31mPrimer lista doble: \033[30m" + miListaDoble.showData());
        
        try {
            System.out.println("\033[31mMi lista separada: \033[30m" + miListaDoble.splitList(33).showData());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
