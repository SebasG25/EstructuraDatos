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

        SinglyLinkedList<Integer> miLista = new SinglyLinkedList<>();  
        SinglyLinkedList<Integer> miLista2 = new SinglyLinkedList<>(); 
        SinglyLinkedList<Integer> miLista3 = new SinglyLinkedList<>(); 
        SinglyLinkedList<Integer> miLista4 = new SinglyLinkedList<>(); 
        SinglyLinkedList<Integer> miLista5 = new SinglyLinkedList<>();
        miLista.add(11);
        miLista.add(22);
        miLista.add(33);
        
        miLista3.add(1);
        miLista3.add(22);
        miLista3.add(33);
        miLista3.add(44);
        
        miLista4.add(45);
        miLista4.add(11);
        miLista4.add(22);
        miLista4.add(33);
        
        
        miLista5.add(11);
        miLista5.add(22);
        miLista5.add(33);
        miLista5.add(45);
        miLista5.add(55);
        // 1
        System.out.println(miLista.showData());    
        
        // 2
        System.out.println("El total de datos es: " + miLista.getTotalNodes());
        
        // 3
        try{
            miLista.showMajorData();
        }catch (Exception ex){
            Logger.getLogger(Listas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // 4
        try{
            miLista.showMinorData();
        }catch (Exception ex){
            Logger.getLogger(Listas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // 5
        try{
            System.out.println("El promedio es: " + miLista.averageData());
        }catch (Exception ex){
            Logger.getLogger(Listas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // 6
        System.out.println(miLista.checkData(1));
        System.out.println(miLista.checkData(11));
        System.out.println(miLista.checkData(33));
        
        // 7
        try{
            miLista.addLastNoRepeated(44);
            miLista.addLastNoRepeated(1);
            miLista.addLastNoRepeated(2);
            miLista.addLastNoRepeated(33);
            
        }catch(Exception ex){
            Logger.getLogger(Listas.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(miLista.showData());  
        
        // 8
        try{
            miLista2.addDescendently(33);
            miLista2.addDescendently(55);
            miLista2.addDescendently(1);
            miLista2.addDescendently(33);
            miLista2.addDescendently(11);
            miLista2.addDescendently(55);
        }catch(Exception ex){
            Logger.getLogger(Listas.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(miLista2.showData());  
        

        // 9
        try{
            miLista.deleteNode(11);
            miLista.deleteNode(44);
            miLista.deleteNode(1);
        }catch(Exception ex){
            Logger.getLogger(Listas.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(miLista.showData()); 
        
        // 10
        try{
            miLista.addNodeAfter(22, 11);
            miLista.addNodeAfter(11, 44);
            miLista.addNodeAfter(9, 25);
        }catch(Exception ex){
            Logger.getLogger(Listas.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(miLista.showData());
        
        // 11
        try{
            miLista.modifyData(44, 43);
            miLista.modifyData(43, 45);
            miLista.modifyData(14, 15);
        }catch(Exception ex){
            Logger.getLogger(Listas.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(miLista.showData());
        
        // 12
        System.out.println(miLista.verifyLength(miLista5));
        System.out.println(miLista.verifyLength(miLista3));
        
        // 13
        System.out.println(miLista.verifyEqualLists(miLista5));
        System.out.println(miLista.verifyEqualLists(miLista3));
        System.out.println(miLista.verifyEqualLists(miLista4));
    }
}
