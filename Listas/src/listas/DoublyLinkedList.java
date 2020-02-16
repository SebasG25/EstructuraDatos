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

    @Override
    public void addLast(T d) {
        if (isEmpty()) {
            head = tail = new DoubleNode<>(d);
        } else {
            tail = new DoubleNode<>(d, tail, null);
            tail.getPreviousNode().setNextNode(tail);
        }
    }

    @Override
    public void addOrdered(T d) {

        if (isEmpty() || d.compareTo(head.getData()) == -1) {
            add(d);
            return;
        }
        if (d.compareTo(tail.getData()) == 1) {
            addLast(d);
            return;
        }
        
        DoubleNode<T> current = head.getNextNode();
        DoubleNode<T> newNode;
        
        while (current.getData().compareTo(d)==-1) {            
            current=current.getNextNode();
        }
        
        newNode = new DoubleNode<>(d,current.getPreviousNode(),current);
        current.getPreviousNode().setNextNode(newNode);
        current.setPreviousNode(newNode);
        

    }

    @Override
    /**
     * Borrar el primer nodo
     */
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

    @Override
    public boolean isEmpty() {
        return head == null;
    }

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

    @Override
    public boolean checkData(T data) {
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

    @Override
    public void addDescendently(T data) throws Exception {
        if(checkData(data)){
            throw new Exception("ERROR: El dato ya está ingresado en la lista");
        }else{
            if (isEmpty() || data.compareTo(head.getData()) == 1) {
                add(data);
                return;
            }
            if (data.compareTo(tail.getData()) == -1) {
                addLast(data);
                return;
            }
        
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
        if(isEmpty() || !checkData(data)){
            throw new Exception("ERROR: No existe el nodo a borrar");
        }else{
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
        if(!checkData(data)){
            throw new Exception("No existe el nodo ingresado como referencia");
        }else{
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
