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
public class Listas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Validate exp = new Validate();
        System.out.println(exp.checkParanthesisBalanced("{[(5+5)}]"));
        System.out.println(exp.checkParanthesisBalanced("{2[1-(5+5)/5]*4}"));

        ConvertBase data = new ConvertBase();
        System.out.println(data.toBinary(101));
        
        ConvertBase data2 = new ConvertBase();
        System.out.println(data2.toOctal(101));
//
//        ArrayQueue miCola = new ArrayQueue(5);
//        try {
//            System.out.println(miCola.add("Hola"));
//            miCola.add(66);
//            miCola.add(77);
//            miCola.add(88);
//            miCola.add(99);
//            miCola.remove();
//            miCola.remove();
//            miCola.remove();
//            miCola.remove();
//            miCola.remove();
//            miCola.add(101);
//            miCola.add(102);
//            miCola.add(103);
//            miCola.remove();
//            miCola.add(104);
//            miCola.add(105);
//            miCola.add(106);
//            miCola.add(107);
//
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//
//        System.out.println("");
//
//        LinkedStack<Integer> duracell = new LinkedStack<>();
//        duracell.push(99);
//        duracell.push(88);
//        duracell.push(77);
//        duracell.push(66);
//        duracell.push(55);
//
//        System.out.println("El dato eliminado fue:" + duracell.pop());
//        System.out.println("El dato eliminado fue:" + duracell.pop());
//        System.out.println("El dato eliminado fue:" + duracell.pop());
//        System.out.println("El dato eliminado fue:" + duracell.pop());
//        System.out.println("El dato eliminado fue:" + duracell.pop());
//        System.out.println("El dato eliminado fue:" + duracell.pop());
//        System.out.println("El dato eliminado fue:" + duracell.pop());
//        System.out.println("El dato eliminado fue:" + duracell.pop());
//        System.out.println("El dato eliminado fue:" + duracell.pop());
//
//        System.out.println("");
//
//        ArrayStack varta = new ArrayStack(5);
//        varta.push(77);
//        varta.push(88);
//        varta.push(99);
//        varta.push(101);
//        varta.push(101);
//        varta.push(999);
//        varta.push(888);
//        varta.push(777);
//        varta.push(666);
//        varta.push(555);
//        varta.pop();
//        varta.pop();
//        varta.pop();
//        varta.pop();
//        varta.pop();
//        varta.pop();
//        varta.pop();
//        varta.pop();
        //       System.out.println(varta.pop());
        System.out.println("");
//        Stack<Integer> varta = new Stack<>();
//        varta.push(99);
//        varta.push(88);
//        varta.push(77);
//        varta.push(66);
//        varta.push(55);

        //  System.out.println("Siguiente dato a salir: " + varta.search(9878));

    }

}
