/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listas;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Sebastián Guzmán
 */
public class DoublyLinkedList<T extends Comparable> implements Ilist<T> {

    private DoubleNode<T> head;
    private DoubleNode<T> tail;

    /*
        Se inicializa una Lista Doble vacía al crearla
    */
    public DoublyLinkedList() {
        head = tail = null;
    }

    //agregar datos al inicio
    @Override
    public void add(T d) {

        if (isEmpty()) {
            head = tail = new DoubleNode<>(d);
        } else {
            head = new DoubleNode<>(d, null, head);
            head.getNextNode().setPreviousNode(head);
        }

    }
    /*
        Agregar datos al final de la lista 
    */
    @Override
    public void addLast(T d) {
        if (isEmpty()) {
            head = tail = new DoubleNode<>(d);
        } else {
            tail = new DoubleNode<>(d, tail, null);
            tail.getPreviousNode().setNextNode(tail);
        }
    }

    /*
        Agregar datos de menor a mayor
    */
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
        DoubleNode<T> current = head.getNextNode();
        DoubleNode<T> newNode;
        
        while (current.getData().compareTo(d)==-1) {            
            current=current.getNextNode();
        }
        
        newNode = new DoubleNode<>(d,current.getPreviousNode(),current);
        current.getPreviousNode().setNextNode(newNode);
        current.setPreviousNode(newNode);
    }
    
    /*
     * Borrar el primer nodo
     */
    @Override
    public void delete() throws Exception {
        if (isEmpty()) {
            throw new Exception("Lista ya esta vacía");
        } else if (head == tail) {
            head = tail = null;
        } else {
            head.getNextNode().setPreviousNode(null);
            head = head.getNextNode();
        }
    }

    /*
        Borrar el último nodo
    */
    @Override
    public void deleteLast() throws Exception {
        if (isEmpty()) {
            throw new Exception("Lista ya esta vacía");
        } else if (head == tail) {
            head = tail = null;
        } else {
            tail.getPreviousNode().setNextNode(null);
            tail = tail.getPreviousNode();
        }
    }

    /*
        Verificar si la lista está vacía
    */
    @Override
    public boolean isEmpty() {
        return head == null;
    }

    /*
        Mostrar la los datos de la lista
    */
    @Override
    public String showData() {
        String data = "";
        DoubleNode<T> current = this.head;
        while (current != null) {
            data = data + current.getData() + " ";
            current = current.getNextNode();
        }
        return data;
    }

    /*
        Mostrar los datos de la lista desde la cola hacia atrás
    */
    public String showDataReverse() {
        String data = "";
        DoubleNode<T> current = this.tail;
        while (current != null) {
            data += current.getData() + " ";
            current = current.getPreviousNode();
        }
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

    /*
        Verifica si el dato ingresado como parámetro ya existe en la lista
    */
    @Override
    public boolean checkData(T data) {
        /*
            Se recorre la lista y se encuentra un nodo con su mismo dato, retorna verdadero
        */
        DoubleNode<T> current = this.head;
        while(current != null){
            if(current.getData().equals(data)){
                return true;
            }
            current = current.getNextNode();
        }
        return false;
    }

    @Override
    public void addLastNoRepeated(T data) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /*
        Agregar datos de mayor a menor sin que se repitan datos
    */
    @Override
    public void addDescendently(T data) throws Exception {
        /*
            Se verifica si el dato que se va a ingresar ya está en la lista para retornar una excepción
        */
        if(checkData(data)){
            throw new Exception("ERROR: El dato ya está ingresado en la lista");
        }else{
            /*
                Se verifica si el dato que se va a ingresar es mayor que la cabeza, entonces se ingresa al principio
            */
            if (isEmpty() || data.compareTo(head.getData()) == 1) {
                add(data);
                return;
            }
            /*
                Se verifica si el dato que se va a ingresar es menor que la cola, entonces se ingresa al final
            */
            if (data.compareTo(tail.getData()) == -1) {
                addLast(data);
                return;
            }
        
            /*
                Se verifica que dato es menor que el dato que se va a ingresar para saber donde ubicarlo
            */
            DoubleNode<T> current = head.getNextNode();
            DoubleNode<T> newNode;
        
            while (current.getData().compareTo(data)==1) {            
                current=current.getNextNode();
            }
        
            newNode = new DoubleNode<>(data,current.getPreviousNode(),current);
            current.getPreviousNode().setNextNode(newNode);
            current.setPreviousNode(newNode);
        }
    }

    @Override
    public void deleteNode(T data) throws Exception {
        /*
            Se verifica si la lista está vacía para lanzar una excepción
        */
        if(isEmpty()){
            throw new Exception("ERROR: No existe el nodo a borrar");
            
        }else if(!checkData(data)){
            /*
                También se verifica si no se encuentra el dato para lanzar una excepción
            */
            throw new Exception("ERROR: No existe el nodo a borrar");
        }else{
            /*
                Se recorre la lista para eliminar un nodo en diferentes casos, se elimina el nodo si se encuentra y
                se asignan los nodos siguientes y los nodos anteriores después de haber eliminado el nodo
            */
            DoubleNode<T> current = this.head;
            while(current != null){
                if(current.getData().equals(data) && current == this.head){
                    if(current.getNextNode() != null){
                        this.head = current.getNextNode();
                        head.setPreviousNode(null);
                    }else{
                        this.head = null;
                    }
                }else if(current != this.tail && current.getNextNode().getData() == data){
                    if(current.getNextNode().getNextNode() != null){
                        current.setNextNode(current.getNextNode().getNextNode());
                        current.getNextNode().getNextNode().setPreviousNode(current);
                    }else{
                        current.setNextNode(null);
                    }
                }
                current = current.getNextNode();
            }
        }
    }

    @Override
    public void addNodeAfter(T data, T newData) throws Exception {
        /*
            Se verifica si el dato de referencia está en la lista, si no, se lanza una excepción
        */
        if(!checkData(data)){
            throw new Exception("No existe el nodo ingresado como referencia");
        }else{
            /*
                Se recorre la lista para buscar el nodo de referencia y a ese nodo se le asigna como nodo siguiente
                el nuevo nodo, al nuevo nodo se le asigna como nodo anterior al nodo de referencia y como nodo siguiente
                al siguiente del siguiente del nodo de referencia
            */
            DoubleNode<T> current = this.head;
            DoubleNode<T> newNode = new DoubleNode<>(newData);
            while(current != null){
                if(current.getData().equals(data)){
                    if(current.getNextNode() != null){
                        current.getNextNode().setPreviousNode(newNode);
                        newNode.setNextNode(current.getNextNode());
                        newNode.setPreviousNode(current);
                        current.setNextNode(newNode);
                    }else{
                        newNode.setNextNode(null);
                        newNode.setPreviousNode(current);
                        current.setNextNode(newNode);
                    }
                    
                }
                current = current.getNextNode();
            }
        }
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
