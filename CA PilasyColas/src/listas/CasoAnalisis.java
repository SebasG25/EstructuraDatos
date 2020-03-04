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
public class CasoAnalisis {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayStack arregloPilas = new ArrayStack(8);
        ArrayStack arregloPilas2 = new ArrayStack(2);
        arregloPilas2.push1(2);
        arregloPilas2.push1(4);

        System.out.println("\033[31mPush 1:");
        System.out.println(arregloPilas.push1(2));
        System.out.println(arregloPilas.push1(3));
        System.out.println(arregloPilas.push1(2));
        System.out.println(arregloPilas.push1(3));
        System.out.println(arregloPilas.push1(4));
        System.out.println("");
        System.out.println("\033[31mPush 2:");
        System.out.println(arregloPilas.push2(5));
        System.out.println(arregloPilas.push2(4));
        System.out.println(arregloPilas.push2(8));
        System.out.println(arregloPilas.push2(8));

        System.out.println("");

        System.out.println("\033[31mPop 1:");
        System.out.println(arregloPilas.pop1());
        System.out.println(arregloPilas.pop1());
        System.out.println(arregloPilas.pop1());
        System.out.println("\033[31mPop 2:");
        System.out.println(arregloPilas.pop2());
        System.out.println(arregloPilas.pop2());
        System.out.println(arregloPilas.pop2());
        System.out.println(arregloPilas.pop2());
        System.out.println(arregloPilas.pop2());
        System.out.println(arregloPilas.pop2());

        System.out.println("");

        System.out.println("\033[31mArreglo 1 lleno: \033[30m" + arregloPilas.isFull());
        System.out.println("\033[31mArreglo 2 lleno: \033[30m" + arregloPilas2.isFull());

        System.out.println("");

        System.out.println("\033[31mBONUS: \033[30mDOS PILAS ENLAZADAS");
        System.out.println("");

        LinkedStack pilaEnlazada = new LinkedStack();

        System.out.println("\033[31mPush 1:");
        System.out.println(pilaEnlazada.push1(2));
        System.out.println(pilaEnlazada.push1(3));
        System.out.println(pilaEnlazada.push1(1));

        System.out.println("");

        System.out.println("\033[31mPush 2:");
        System.out.println(pilaEnlazada.push2(6));
        System.out.println(pilaEnlazada.push2(2));
        System.out.println(pilaEnlazada.push2(9));

        System.out.println("");

        System.out.println("\033[31mPop 1:");
        System.out.println(pilaEnlazada.pop1());
        System.out.println(pilaEnlazada.pop1());
        System.out.println(pilaEnlazada.pop1());
        System.out.println(pilaEnlazada.pop1());

        System.out.println("");

        System.out.println("\033[31mPop 2:");
        System.out.println(pilaEnlazada.pop2());
        System.out.println(pilaEnlazada.pop2());

        System.out.println("");

    }
}
