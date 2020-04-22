/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructurasnolineales;

/**
 *
 * @author samaniw
 */
public class BinarySearchTree {

    private BinaryNode root;
    private BinaryNode father;
    private boolean position;
    private int contNodes;
    private int contLeaves;

    public BinarySearchTree() {
        root = null;
        contNodes=0;
        contLeaves=0;
    }

    public BinarySearchTree(int data) {
        root = new BinaryNode(data);
        contNodes=1;
        contLeaves = 1;
    }

    //Punto 1
    public void InOrden() {
        InOrden(root);
    }

    private void InOrden(BinaryNode currentRoot) {
        if (currentRoot != null) {
            InOrden(currentRoot.getLeft());
            System.out.print(currentRoot.getData() + " ");
            InOrden(currentRoot.getRight());
        }
    }

    //Punto 2
    
    public void PostOrden(){
        PostOrden(root);
    }
    
    private void PostOrden(BinaryNode currentRoot) {
        //(izquierda, derecha, raiz)
        //...
        if(currentRoot != null){
            PostOrden(currentRoot.getLeft());
            PostOrden(currentRoot.getRight());
            System.out.print(currentRoot.getData() + " ");
        }
    }

    //Punto 3
    public void PreOrden(){
        PreOrden(root);
    }
    
    private void PreOrden(BinaryNode currentRoot) {
        //(raiz, izquierda, derecha)
        //...
        if(currentRoot != null){
            System.out.print(currentRoot.getData() + " ");
            PreOrden(currentRoot.getLeft());
            PreOrden(currentRoot.getRight());
            
        }
    }

    //Punto 4
    public int CountNodes() {
        return getTotalNodes();
    }

    //Punto 5
    public int CountLeaves(){
        return CountLeaves(root);
    }
    
    public int CountLeaves(BinaryNode currentRoot) {
        //...
        if (currentRoot != null) {
            CountLeaves(currentRoot.getLeft());
            if(!currentRoot.isLeaf() && currentRoot.equals(root)){
                contLeaves--;
            }else if(currentRoot.isLeaf() && !currentRoot.equals(root)){
                contLeaves++;
            }
            CountLeaves(currentRoot.getRight());
        }
        return contLeaves;
    }

    public void Add(int data) {
        if (root == null) {
            contNodes++;
            root = new BinaryNode(data);
        } else //validar si el dato ya existe
        {
            if (Search(data) != null) {
                System.out.println("Dato repetido, no se puede insertar");
            } else {
                contNodes++;
                Add(data, root);
            }
        }
    }

    private void Add(int data, BinaryNode currentRoot) {
        if (data < currentRoot.getData()) {
            if (currentRoot.getLeft() == null) {
                currentRoot.setLeft(new BinaryNode(data));
            } else {
                Add(data, currentRoot.getLeft());
            }
        } else if (currentRoot.getRight() == null) {
            currentRoot.setRight(new BinaryNode(data));
        } else {
            Add(data, currentRoot.getRight());
        }
    }

    public BinaryNode Search(int data) {
        return Search(data, root);
    }

    private BinaryNode Search(int data, BinaryNode currentRoot) {
        if (currentRoot == null) {
            return null;
        }
        if (data == currentRoot.getData()) {
            return currentRoot;
        }

        father = currentRoot;

        if (data < currentRoot.getData()) {
            position = false;
            return Search(data, currentRoot.getLeft());
        } else {
            position = true;
            return Search(data, currentRoot.getRight());
        }
    }

    //Arreglar total de nodos
    //Punto 6
    public void Delete(int data) {
        if (root == null) {
            System.out.print("Árbol vacío");
        } else {
            Delete(data, root);
        }
    }

    private void Delete(int data, BinaryNode currentRoot) {

        BinaryNode node = Search(data);
        if (node.isLeaf()) {
            if (position) {
                father.setRight(null);
            } else {
                father.setLeft(null);
            }
        } else if (node.hasOneChild()) {
            if (node.isChildPosition()) {
                father.setRight(node.getRight());
            } else {
                father.setLeft(node.getLeft());
            }
        } else {
            BinaryNode minimum = getMinor(node.getRight());
            Delete(minimum.getData());
            node.setData(minimum.getData());
        }
    }

    //Punto 7
    public void LastLevel() {
        //...
        
    }

    //Punto 8
    public void LevelOrder(){
        LevelOrder(root);
    }
    
    private void LevelOrder(BinaryNode currentRoot){
        //...
        /* 
        Para mostrar los datos se recomienda usar:
            System.out.print(x.getData()+" ");
        donde x representa un nodo del árbol

        Para generar un salto de linea se recomienda usar:
            System.out.print("\n");
        
         */
        if (currentRoot != null) {
            System.out.print(currentRoot.getData() + " ");
            LevelOrder(currentRoot.getLeft());
            LevelOrder(currentRoot.getRight());
        }
    }

    public BinaryNode getMinor(BinaryNode currentRoot) {
        if (currentRoot.getLeft() == null) {
            return currentRoot;
        } else {
            return getMinor(currentRoot.getLeft());
        }
    }

    /**
     * @return the contNodos
     */
    public int getTotalNodes() {
        return contNodes;
    }

    /**
     * @param contNodos the contNodos to set
     */
    public void setContNodes(int contNodes) {
        this.contNodes = contNodes;
    }

    /**
     * @return the contLeaves
     */
    public int getContLeaves() {
        return contLeaves;
    }
}
