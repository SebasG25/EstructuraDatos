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
public class LinkedStack<E> implements IStack<E> {

    private Node<E> top, tail, root;
    private int sizeStack;

    public LinkedStack() {
        top = null;
        tail = null;
        root = new Node<>((E) "raiz");
        sizeStack = 0;
    }

    @Override
    public boolean empty() {
        return top == null && tail == null;
    }

    @Override
    public E peek() {

        return (empty()) ? null : top.getData();

//        if(empty()){
//            return null;
//        }else{
//            return top.getData();
//        }
    }

    @Override
    public E pop() {
        if (empty()) {
            return null;
        } else {
            E dataTemp = top.getData();
            top = (top.getNextNode() == null) ? null : top.getNextNode();
//            if (top.getNextNode()==null){
//                top=null;
//            }else{
//                top = top.getNextNode();
//            }

            sizeStack--;
            return dataTemp;
        }
    }

    public E pop1() {
//        if (topDeletedCount == 0) {
//            return null;
//        } else {
//            E dataTemp = top.getData();
//            top = top.getNextNode();
//            topDeletedCount--;
//            sizeStack--;
//            return dataTemp;
//        }
        if (top == null) {
            return null;
        } else {
            E dataTemp = top.getData();
            top = (top.getNextNode() == root) ? null : top.getNextNode();
            sizeStack--;
            return dataTemp;
        }
    }

    public E pop2() {
//        if (tailDeletedCount == 0) {
//            return null;
//        } else {
//            E dataTemp = tail.getData();
//            tail = tail.getNextNode();
//            tailDeletedCount--;
//            sizeStack--;
//            return dataTemp;
//        }
        if (tail == null) {
            return null;
        } else {
            E dataTemp = tail.getData();
            tail = (tail.getNextNode() == root) ? null : tail.getNextNode();
            sizeStack--;
            return dataTemp;
        }
    }

    @Override
    public E push(E item) {
        sizeStack++;
        top = new Node<E>(item, top);
        return item;
    }

    public E push1(E item) {
//        if (empty()) {
//            top = new Node<E>(item, tail);
//        } else if (topDeletedCount == 0) {
//            Node<E> current = tail;
//            int contNodos = 1;
//            while (contNodos != tailDeletedCount) {
//                current = tail.getNextNode();
//                contNodos++;
//            }
//            top = new Node<E>(item, current);
//            current.setNextNode(top);
//        } else {
//            top = new Node<E>(item, top);
//        }
//        topDeletedCount++;
        if (top == null) {
            top = new Node<E>(item, root);
        } else {
            top = new Node<E>(item, top);
        }
        sizeStack++;
        return item;
    }

    public E push2(E item) {
//        if (empty()) {
//            tail = new Node<E>(item, top);
//        } else if (tailDeletedCount == 0) {
//            tail = new Node<E>(item);
//            Node<E> current = top;
//            int contNodos = 1;
//            while (contNodos != topDeletedCount) {
//                current = top.getNextNode();
//                contNodos++;
//            }
//            tail = new Node<E>(item, current);
//            current.setNextNode(tail);
//        } else {
//            tail = new Node<E>(item, tail);
//        }
//        tailDeletedCount++;
        if (tail == null) {
            tail = new Node<E>(item, root);
        } else {
            tail = new Node<E>(item, tail);
        }
        sizeStack++;
        return item;
    }

    @Override
    public int search(E o) {
        Node<E> current = this.top;
        int posicion = 1;
        while (current != null) {
            if (this.top.getData().equals(o)) {
                return posicion;
            } else if (current.getData().equals(o)) {
                return posicion;
            } else {
                current = current.getNextNode();
                posicion++;
            }
        }
        return -1;
    }

    public Node<E> getTop() {
        return this.top;
    }

}
