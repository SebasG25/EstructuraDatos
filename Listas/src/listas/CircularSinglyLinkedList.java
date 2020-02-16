/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listas;

/**
 *
 * @author s103e28
 */
public class CircularSinglyLinkedList<T> implements Ilist<T> {

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete() throws Exception {
         if (isEmpty()) {
            throw new Exception("No existen datos por borrar...");
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
