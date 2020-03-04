/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listas;

/**
 *
 * @author s208e19
 */
public class Node<T> {

    private T data;
    private Node<T> nextNode;
    private static int totalNodes = 0;

    public Node(T d) {
        this.data = d;
        nextNode = null;
        totalNodes++;
    }

    /**
     * @return the data
     */
    public T getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * @return the nextNode
     */
    public Node getNextNode() {
        return nextNode;
    }

    /**
     * @param nextNode the nextNode to set
     */
    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }
    
    public boolean LoopDetector(Node head) {
        boolean loop = false;
        int cont = 1;
        Node<T> current = head;
        while (current != null) {
            current = current.getNextNode();
            cont++;
            if (cont > getTotalNodes()) {
                loop = true;
                return loop;
            }
        }
        return loop;
    }

    /**
     * @return the totalNodes
     */
    public int getTotalNodes() {
        return totalNodes;
    }
    

}
