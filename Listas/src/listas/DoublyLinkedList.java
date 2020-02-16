/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listas;

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
        boolean isRepeated = false;
        DoubleNode<T> current = this.head;
        while(current != null){
            if(current.getData().equals(data)){
                isRepeated = true;
                return isRepeated;
            }
            current = current.getNextNode();
        }
        return isRepeated;
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
        if(isEmpty()){
            throw new Exception("ERROR: No hay nodos disponibles para borrar");
        }else if(!checkData(data)){
            throw new Exception("ERROR: No se encuentra el dato a borrar en la lista");
        }else{
            DoubleNode<T> current = this.head;
            while(current != null){
                if(current.getData().equals(data)){
                    current.getPreviousNode().setNextNode(current.getNextNode());
                    current.getNextNode().setPreviousNode(current.getPreviousNode());
                }
                current = current.getNextNode();
            }
        }
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
