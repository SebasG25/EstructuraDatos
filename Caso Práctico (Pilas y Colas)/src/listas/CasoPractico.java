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
 * @author s208e19
 */
public class CasoPractico {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayStack arregloPilas = new ArrayStack(8);
        
        System.out.println(arregloPilas.push1(2));
        System.out.println(arregloPilas.push1(3));
        System.out.println(arregloPilas.push1(2));
        System.out.println(arregloPilas.push1(3));
        System.out.println(arregloPilas.push1(4));
        System.out.println(arregloPilas.push1(5));
        System.out.println(arregloPilas.push2(4));
        System.out.println(arregloPilas.push2(8));
        System.out.println(arregloPilas.push1(8));
        
        System.out.println(arregloPilas.isFull());
        
    }
}
