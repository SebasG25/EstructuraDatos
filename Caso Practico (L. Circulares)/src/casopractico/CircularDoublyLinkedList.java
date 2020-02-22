/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casopractico;

/**
 *
 * @author Sebastian
 */
public class CircularDoublyLinkedList<T> {
     Video<T> head;

    public CircularDoublyLinkedList() {
        head = null;
    }

    public void add(T d) {
        Video<T> newNode = new Video<>(d);
        if (isEmpty()) {
            head = newNode;
            newNode.setNextNode(newNode);
            newNode.setPreviousNode(newNode);
        } else {
            newNode.setPreviousNode(head.getPreviousNode());
            newNode.setNextNode(head);
            head.setPreviousNode(newNode);
            head = newNode;
            head.getPreviousNode().setNextNode(head);

        }
    }

    public void addLast(T d) {
        DoubleNode<T> newNode = new DoubleNode<>(d);
        if (isEmpty()) {
            head = newNode;
            newNode.setNextNode(newNode);
            newNode.setPreviousNode(newNode);
        } else {
            newNode.setPreviousNode(head.getPreviousNode());
            newNode.setNextNode(head);
            head.getPreviousNode().setNextNode(newNode);
            head.setPreviousNode(newNode);
            //head=newNode;
            //¿Se puede refactorizar?
        }
    }

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
        if (d.compareTo(head.getPreviousNode().getData()) == 1) {
            addLast(d);
            return;
        }
        /*
            Se verifica que dato es menor que el dato que se va a ingresar para saber donde ubicarlo
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

    public void delete() throws Exception {
        if (isEmpty()) {
            throw new Exception("No existen datos por borrar...");
        } else if (head == head.getPreviousNode()) {
            head = null;
        } else {
            head.getNextNode().setPreviousNode(head.getPreviousNode());
            head.getPreviousNode().setNextNode(head.getNextNode());
            head = head.getNextNode();
        }
    }

    public void deleteLast() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean isEmpty() {
        return head == null;
    }

    public String showData() {
        String data = "";
        DoubleNode<T> current = this.head;
        do {
            data = data + current.getData() + " ";
            current = current.getNextNode();
        } while (current != head);
        return data;
    }
    
    public boolean checkData(T data) {
        /*
            Se recorre la lista y se encuentra un nodo con su mismo dato, retorna verdadero
        */
        DoubleNode<T> current = this.head;
        do{
            if(current.getData().equals(data)){
                return true;
            }
            current = current.getNextNode();
        }while(current != this.head);
        return false;
    }
    
    public CircularDoublyLinkedList<T> splitList(T data) throws Exception{
        if(isEmpty() || !checkData(data))
        {
            throw new Exception("\033[31mERROR: \033[30mNo se pudo encontrar el dato de referencia");
        }else{
            DoubleNode<T> current = this.head;
            do{
                
            }while(current != this.head);
            return this;
        }
    }
}
