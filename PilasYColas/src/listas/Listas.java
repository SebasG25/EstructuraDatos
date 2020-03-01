/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listas;

import java.awt.BorderLayout;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Stack;

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
        
        Validate exp = new Validate();
        
        System.out.println("\033[031mBalanceado: \033[030m" + exp.checkParanthesisBalanced("{[(5+5)}]"));
        System.out.println("\033[031mBalanceado: \033[030m" + exp.checkParanthesisBalanced("{2[1-(5+5)/5]*4}"));
        System.out.println("");
        
        ConvertBase data = new ConvertBase();
        try {
            System.out.println(data.toBase("16", 13290000));
            System.out.println(data.toBase("8", 2002));
            System.out.println(data.toBase("3", 150));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        LinkedQueue<Object> cola = new LinkedQueue<>();
        System.out.println("");
        System.out.println("\033[031madd: \033[030m" + cola.add(1));
        System.out.println("\033[031madd: \033[030m" + cola.add(2));
        System.out.println("\033[031moffer: \033[030m" + cola.offer(3));
        System.out.println("\033[031moffer: \033[030m" + cola.offer(4));
        System.out.println("");
        
        try {
            System.out.println("\033[031mremove: \033[030m" + cola.remove());
            System.out.println("\033[031mremove: \033[030m" + cola.remove());
            System.out.println("\033[031mremove: \033[030m" + cola.remove());
            System.out.println("\033[031mremove: \033[030m" + cola.remove());
            System.out.println("\033[031mremove: \033[030m" + cola.remove());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        cola.add(1);
        cola.add(2);
        cola.add(3);
        cola.add(4);
        
        System.out.println("");
        System.out.println("\033[031mpoll: \033[030m" + cola.poll());
        System.out.println("\033[031mpoll: \033[030m" + cola.poll());
        System.out.println("\033[031mpoll: \033[030m" + cola.poll());
        System.out.println("\033[031mpoll: \033[030m" + cola.poll());
        System.out.println("\033[031mpoll: \033[030m" + cola.poll());
        System.out.println("");
        
        cola.add(1);
        cola.add(2);
        cola.add(3);
        cola.add(4);
        
        try {
            System.out.println("\033[031melement: \033[030m" + cola.element());
            cola.remove();
            cola.remove();
            cola.remove();
            cola.remove();
            System.out.println("\033[031melement: \033[030m" + cola.element());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        System.out.println("");
        cola.add(1);
        cola.add(2);
        System.out.println("\033[031mpeek: \033[030m" + cola.peek());
        try {
            cola.remove();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("\033[031mpeek: \033[030m" + cola.peek());
        try {
            cola.remove();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("\033[031mpeek: \033[030m" + cola.peek());
    }
}
