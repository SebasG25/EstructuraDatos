/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listas;

import java.util.HashSet;
import java.util.Set;
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

        SinglyLinkedList<Integer> lista = new SinglyLinkedList<>();
        lista.add(11);
        lista.add(22);
        lista.add(33);
        lista.add(44);
        lista.add(55);
        lista.add(66);
        System.out.println("\033[31mMI LISTA SIMPLE \033[30m" + lista.showData());
        try {
            System.out.println("\033[31mMI LISTA REVERSADA SIMPLE: \033[30m" + lista.reverseList().showData());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        Node n1 = new Node(55);
        Node n2 = new Node(66);
        Node n3 = new Node(77);
        Node n4 = new Node(88);
        Node n5 = new Node(99);
        
        n1.setNextNode(n2);
        n2.setNextNode(n3);
        n3.setNextNode(n4);
        n4.setNextNode(n5);
        n5.setNextNode(n3);
        System.out.println("\033[31mHAY LOOP: \033[30m" + n1.LoopDetector(n1));
        
        
        
        
        
        CircularSinglyLinkedList<Integer> miCircular = new CircularSinglyLinkedList<>();
        miCircular.add(11);
        miCircular.add(22);
        miCircular.add(33);
        miCircular.add(44);
        miCircular.add(55);
        miCircular.add(66);
        System.out.println("\033[31mMI LISTA CIRCULAR: \033[30m" + miCircular.showData());
        
        try {
            miCircular.deleteAbove(44);
            System.out.println("\033[31mMI LISTA CIRCULAR: \033[30m" + miCircular.showData());
            miCircular.deleteAbove(56);
            System.out.println("\033[31mMI LISTA CIRCULAR: \033[30m" + miCircular.showData());
        } catch (Exception ex) {
            Logger.getLogger(Listas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
    }
    
}
