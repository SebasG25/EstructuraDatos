/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listas;

import com.sun.org.apache.bcel.internal.generic.BREAKPOINT;

/**
 *
 * @author s103e28
 */
public class CircularSinglyLinkedList<T extends Comparable> implements Ilist<T> {

    Node<T> head;
    Node<T> tail;

    public CircularSinglyLinkedList() {
        head = tail = null;
    }

    private Node<T> addNode(T d) {
        Node<T> newNode = new Node<>(d);
        if (isEmpty()) {
            head = tail = newNode;
            newNode.setNextNode(newNode);
        } else {
            newNode.setNextNode(head);
            tail.setNextNode(newNode);
        }
        return newNode;
    }

    @Override
    public void add(T d) {
        head = addNode(d);
    }

    @Override
    public void addLast(T d) {
        tail = addNode(d);
    }

    @Override
    public void addOrdered(T d) {
/*
            Se verifica si el dato que se va a ingresar es menor que la cabeza, entonces se ingresa al principio
        */
        if (isEmpty() || d.compareTo(head.getData()) == -1) {
            add(d);
            return;
        }
        /*
            Se verifica si el dato que se va a ingresar es mayor que la cola, entonces se ingresa al final
        */
        if (d.compareTo(tail.getData()) == 1) {
            addLast(d);
            return;
        }
        /*
            Se verifica que dato es mayor que el dato que se va a ingresar para saber donde ubicarlo
        */
        Node<T> current = head.getNextNode();
        Node<T> newNode;
        
        while (current.getData().compareTo(d)==-1) {            
            Node<T> previousNode = current;
            current=current.getNextNode();
        }
        
        newNode = new Node<>(d);
        newNode.setNextNode(current);
        current.getPreviousNode().setNextNode(newNode);
        current.setPreviousNode(newNode);
    }
    
    public String showData(T data) throws Exception
    {   
        String d = "";
        if(isEmpty() || !checkData(data)){
            throw new Exception("\033[31mError: \033[30mNo se encontró el dato ingresado");
        }else{
            
            Node<T> current = this.head;
            do{
                if(current.getData().equals(data))
                {
                    do{
                        d = d + current.getData() + " ";
                        current = current.getNextNode();
                    }while(current != this.head);
                    return d;
                }
                current = current.getNextNode();
            }while (current != this.head);
        }
        return d;
    }
    
    public CircularSinglyLinkedList<T> joinList(CircularSinglyLinkedList list) throws Exception
    {
        if(list.isEmpty()){
            throw new Exception("\033[31mERROR: \033[30mLa lista no contiene datos para ser unidos");
        }else{
            Node<T> current = list.head;
            do{
                addLast(current.getData());
                current = current.getNextNode();
            }while(current != list.head);
        }
        return this;
    }

    @Override
    public void delete() throws Exception {
         if (isEmpty()) {
            throw new Exception("\033[31mERROR: \033[30mNo existen datos por borrar...");
        } else if (head == tail) {
            head = null;
        } else {
            tail.setNextNode(head.getNextNode());
            head = head.getNextNode();
        }
    }

    @Override
    public void deleteLast() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }
    

    @Override
    public String showData() {
        String data = "";
        Node<T> current = this.head;
        do{
            data = data + current.getData() + " ";
            current = current.getNextNode();
        }while (current != head);
        return data;
    }

    @Override
    public void showMajorData() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void showMinorData() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double averageData() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean checkData(T data) {
        /*
            Se recorre la lista y se encuentra un nodo con su mismo dato, retorna verdadero
        */
        Node<T> current = this.head;
        do{
            if(current.getData().equals(data)){
                return true;
            }
            current = current.getNextNode();
        }while(current != this.head);
        return false;
    }

    @Override
    public void addLastNoRepeated(T data) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addDescendently(T data) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteNode(T data) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addNodeAfter(T data, T newData) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modifyData(T previousData, T data) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean verifyLength(SinglyLinkedList list) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean verifyEqualLists(SinglyLinkedList list) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
