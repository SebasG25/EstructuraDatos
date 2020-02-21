/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listas;

import java.util.HashSet;

/**
 *
 * @author s208e19
 */
public class SinglyLinkedList<T extends Comparable> implements Ilist<T> {

    private Node<T> head;
    private int totalNodes = 0;
    private int x;

    public SinglyLinkedList() {
        this.head = null;
    }

    @Override
    public void add(T data) {
        //crear el nuevo nodo
        //el siguiente del nuevo nodo = cabeza
        //actualizar cabeza = nuevo nodo
        //contar nodo
        Node<T> newNode = new Node<>(data);
        newNode.setNextNode(this.head);
        this.head = newNode;
        totalNodes++;
        
    }
    
    

    @Override
    public void addOrdered(T data) {
        /*
        Crear un nodo para el nuevo dato.
        Si la lista esta vacía, o el valor del primer elemento de la lista 
        es mayor que el nuevo, insertar el nuevo nodo en la primera posición 
        de la lista y modificar la cabecera respectivamente.
        
         */

        Node<T> newNode = new Node<>(data);
        if (isEmpty() || data.compareTo(this.head.getData()) == -1) {
            newNode.setNextNode(this.head);
            this.head = newNode;
            totalNodes++;
        } else {
            /* 
            Si no se cumple el caso anterior, buscar el lugar adecuado 
            para la inserción: recorrer la lista conservando el nodo actual. 
            Inicializar nodo actual con el valor de primera posición, 
            y avanzar mientras el siguiente nodo no sea nulo y el dato 
            que contiene la siguiente posición sea menor o igual que 
            el dato a insertar.

             */
            Node<T> current = this.head;//
            while (current.getNextNode() != null
                    && data.compareTo(current.getNextNode().getData()) == 1) {
                current = current.getNextNode();
            }
            /*
            Con esto se señala al nodo adecuado, 
            a continuación insertar el nuevo nodo a continuación de él.
            */

            newNode.setNextNode(current.getNextNode());
            totalNodes++;
            current.setNextNode(newNode);

        }

    }

    @Override
    public boolean isEmpty() {
        /*
        * Si la cabeza es null, la lista está vacía
        */
        return this.head == null;
    }

    @Override
    public String showData() {
        /*
        Se inicializa un String para poder concatenar los datos y 
        el nodo actual como la cabeza para recorrer los nodos de la lista
        */
        String data = "";
        Node<T> current = this.head;
        while (current != null) {
            /*
            Concatena los datos de los nodos a la variable String
            */
            data = data + current.getData() + " ";
            current = current.getNextNode();
        }
        return data;
    }

    @Override
    public void addLast(T data) {
        /*
        Se verifica si está vacío para poder agregar el dato y contarlo
        */
        if (isEmpty()) {
            add(data);
            totalNodes++;
        } else {
            /*
            Si no está vacía la lista, se inicializa el nuevo nodo con el dato a ingresar
            y un nodo actual como la cabeza para recorrer la lista
            */
            Node<T> newNode = new Node<>(data);
            Node<T> current = this.head;
            /*
            Recorre la lista hasta que esté en el último nodo para poder agregar el nuevo nodo
            como último nodo y lo cuenta
            */
            while (current.getNextNode() != null) {
                current = current.getNextNode();
            }
            current.setNextNode(newNode);
            totalNodes++;
        }

    }

    @Override
    public void delete() throws Exception {
        /*
        Se verifica si la lista no está vacía para poder borrar el primer dato
        */
        if (isEmpty()) {
            throw new Exception("No existen datos por borrar");
        } else {
            /*
            Se le asigna a la cabeza el siguiente nodo y se descuenta un nodo
            */
            this.head = head.getNextNode();
            totalNodes--;
        }
    }

    @Override
    public void deleteLast() throws Exception {
        /*
        Se verifica si la lista no está vacía para borrar el último
        */
        if (isEmpty()) {
            throw new Exception("No existen datos por borrar");
        } else {
            /*
            Se inicializa un nodo actual como la cabeza para recorrer la lista
            */
            Node<T> current = this.head;
            /*
            Se recorre la lista hasta que el siguiente del último nodo sea nulo,
            cuando sea nulo al nodo anterior se le asigna como nodo siguiente un valor nulo
            */
            while (current.getNextNode().getNextNode() != null) {
                current = current.getNextNode();
            }
            current.setNextNode(null);
            totalNodes--;
        }

    }

    /**
     * @return the totalNodes
     */
    public int getTotalNodes() {
        return totalNodes;
    }
    
    @Override
    public void showMajorData() throws Exception
    {
        /*
        Se verifica si la lista no está vacía
        */
        if(isEmpty())
        {
            throw new Exception("No existen datos para poder verificar el dato mayor");
        }else
        {
            /*
            Se inicializa el dato mayor como el dato de la cabeza porque es el primer dato
            para luego poder comparar los siguientes datos, además, se inicializa un nodo actual como
            la cabeza para recorrer la lista
            */
            T mayor = this.head.getData();
            Node<T> current = this.head;
            while(current != null)
            {
                /*
                Si el dato mayor es menor que el dato del nodo actual, se le asigna al dato mayor el dato
                del nodo actual
                */
                if(mayor.compareTo(current.getData()) == -1)
                {
                    mayor = current.getData();
                }
                current = current.getNextNode();
            }
            System.out.println("El dato mayor es: " + mayor);
        }
    }
    
    @Override
    public void showMinorData() throws Exception
    {
        /*
        Se verifica si la lista no está vacía
        */
        if(isEmpty())
        {
            throw new Exception("No existen datos para poder verificar el dato menor");
        }else
        {
            /*
            Se inicializa el dato menor como el dato de la cabeza porque es el primer dato
            para luego poder comparar los siguientes datos, además, se inicializa un nodo actual como
            la cabeza para recorrer la lista
            */
            T menor = this.head.getData();
            Node<T> current = this.head;
            while(current != null)
            {
                /*
                Si el dato menor es mayor que el dato del nodo actual, se le asigna al dato menor el dato
                del nodo actual
                */
                if(menor.compareTo(current.getData()) == 1)
                {
                    menor = current.getData();
                }
                current = current.getNextNode();
            }
            System.out.println("El dato menor es: " + menor);
        }
    }
    
    @Override
    public double averageData() throws Exception
    {   /*
        Se inicializa un acumulador en 0 y se verifica si la lista no está vacía
        */
        double acum = 0;
        
        if(isEmpty())
        {
            throw new Exception("No existen datos para calcular el promedio");
        }
        else
        {
            /*
            Se inicializa el nodo actual como la cabeza y se recorre 
            la lista hasta que el nodo actual sea nulo
            */
            Node<T> current = this.head;
            
            while(current != null)
            {
                /*
                Se van sumando los datos de los nodos de la lista
                */
                acum += (Integer)current.getData();
                current = current.getNextNode();
            }
        }
        /*
        Retorna el promedio
        */
       return acum/getTotalNodes(); 
    }
    
    @Override
    public boolean checkData(T data)
    {
       boolean repeated = false;
       /*
       Se inicializa un nodo actual como la cabeza y se recorre la lista hasta que el nodo actual sea nulo
       */
       Node<T> current = this.head; 
          
          while(current != null)
          {
              /*
              Si el dato del nodo actual es el dato buscado, retorne verdadero  y sino,
              siga recorriendo la lista
              */
              if(current.getData() == data)
              {
                  repeated = true;
              }
              current = current.getNextNode();
          }
       return repeated;
    }
    
    @Override
    public void addLastNoRepeated(T data) throws Exception {
        /*
        Si la lista está vacía se le agrega el nodo y se cuenta un nodo al total de nodos
        */
        if (isEmpty()) {
            add(data);
            totalNodes++;
        } else {
            /*
            Si la lista no está vacía, se asigna un nuevo nodo con el dato a ingresar y un nodo actual
            como la cabeza, se recorre la lista hasta que el siguiente del nodo actual sea nulo
            */
            Node<T> newNode = new Node<>(data);
            Node<T> current = this.head;
            
            while (current.getNextNode() != null)
            {
                /*
                Se verifica que el dato no esté repetido para pasar al siguiente nodo
                */
                if(!checkData(data))
                    current = current.getNextNode();
                else
                    throw new Exception("El dato está repetido");
            }
            /*
            Cuando el nodo siguiente del nodo actual sea nulo, al nodo actual se le asigna el nuevo nodo
            y se suma un nodo al total de nodos
            */
            current.setNextNode(newNode);
            totalNodes++;
        }
    }
    
    @Override
    public void addDescendently(T data) throws Exception
    {
        /*
        Se verifica primero si el dato no se encuentra en la lista
        */
        if(checkData(data)){
            throw new Exception("El nodo ya está en la lista");
        }
        /*
        Crear un nodo para el nuevo dato.
        Si la lista esta vacía, o el valor del primer elemento de la lista 
        es menor que el nuevo, insertar el nuevo nodo en la primera posición 
        de la lista y modificar la cabecera respectivamente.
        
        */
        Node<T> newNode = new Node<>(data);
        if (isEmpty() || data.compareTo(this.head.getData()) == 1) {
            newNode.setNextNode(this.head);
            this.head = newNode;
            totalNodes++;
        } else {
            /* 
            Si no se cumple el caso anterior, buscar el lugar adecuado 
            para la inserción: recorrer la lista conservando el nodo actual. 
            Inicializar nodo actual con el valor de primera posición, 
            y avanzar mientras el siguiente nodo no sea nulo y el dato 
            que contiene la siguiente posición sea mayor o igual que 
            el dato a insertar.

             */
            Node<T> current = this.head;//
            while (current.getNextNode() != null
                    && data.compareTo(current.getNextNode().getData()) == -1) {
                    current = current.getNextNode();
            }
            /*
            Con esto se señala al nodo adecuado, 
            a continuación insertar el nuevo nodo a continuación de él.
            */

            newNode.setNextNode(current.getNextNode());
            totalNodes++;
            current.setNextNode(newNode);

        }
    }
    
    @Override
    public void deleteNode(T data) throws Exception
    {
        /*
        Se verifica si la lista esta vacía o si no se encuentra el dato
        */
        if(isEmpty() || !checkData(data))
        {
           throw new Exception("No se encontró el nodo"); 
        }
        else 
        {
            /*
            Se asigna un nodo actual como la cabeza de la lista y se recorre hasta que el nodo actual
            sea nulo
            */
           Node<T> current = this.head;
           
           while(current != null)
           {
               /*
               Si la cabeza es la que se va a eliminar y hay otro dato que le sigue a la cabeza,
               el siguiente dato del nodo actual será la cabeza, sino, la cabeza se eliminará y 
               se le asigna un valor nulo
               */
               if(current == head && current.getData() == data){
                   if(current.getNextNode() != null){
                       this.head = current.getNextNode();
                   }else{
                       this.head = null;
                   }
               }
               /*
               Si es otro dato diferente de la cabeza que se va a eliminar, se verifica si el nodo siguiente
               del nodo actual no es nulo y si el nodo siguiente tiene el dato buscado. Se inicializa 
               un nodo con el nodo que se va a borrar; se verifica si el nodo siguiente al nodo que 
               se va a borrar no es nulo para asignarle al siguiente del nodo actual el nodo siguiente 
               del nodo que se va a borrar. Si el nodo siguiente del nodo que se va a borrar es nulo, 
               al nodo actual se le asigna un valor nulo
               */
               else if(current.getNextNode() != null && current.getNextNode().getData() == data)
               {
                   Node<T> previousNode = current.getNextNode();
                   if(previousNode.getNextNode() != null){
                       current.setNextNode(previousNode.getNextNode());
                   }else{
                       current.setNextNode(null);
                   }
                   /*
                   Se resta un nodo al total de nodos por el nodo que se borró
                   */
                   totalNodes--;
               }
               current = current.getNextNode();
           }
        }
    }
    
    @Override
    public void addNodeAfter(T data, T newData) throws Exception 
    {
        /*
        Se verifica si la lista esta vacía o si no se encuentra el dato
        */
        if(isEmpty() || !checkData(data))
        {
           throw new Exception("No se encontró el nodo"); 
        }else{
            /*
            Se inicializa un nuevo nodo con el nuevo dato y otro nodo como la cabeza. Se recorre la
            lista para encontrar el nodo que contenga el dato buscado, hasta que el nodo actual sea nulo
            */
           Node<T> newNode = new Node<>(newData);
           Node<T> current = this.head;
           while(current != null)
           {
               if(current.getData() == data)
               {
                   /*
                   Si el nodo siguiente del nodo actual no es nulo es porque hay un nodo con un dato
                   en la siguiente posición, por lo que se guarda ese nodo para asignarselo como nodo siguiente
                   al nuevo nodo, y al actual se le asigna el nodo siguiente como el nuevo nodo
                   */
                   if(current.getNextNode() != null){
                       Node<T> previousNode = current.getNextNode();
                       current.setNextNode(newNode);
                       newNode.setNextNode(previousNode);
                   }else{
                       /*
                       Si el nodo siguiente del nodo actual es nulo, se le asigna al nodo siguiente
                       del nodo actual el nuevo nodo, y al nuevo nodo se le asigna null al nodo siguiente
                       porque el nuevo nodo estará de último en la lista
                       */
                       current.setNextNode(newNode);
                       newNode.setNextNode(null);
                   }
                   /*
                   Se suma un nodo más al total de nodos cuando se agregue el nuevo nodo
                   */
                   totalNodes++;
               }
               current = current.getNextNode();
           }
        }
    }
    
    @Override
    public void modifyData(T previousData, T data) throws Exception 
    {  
        /*
        Se verifica si la lista esta vacía o si no se encuentra el dato
        */
        if(isEmpty() || !checkData(previousData))
        {
           throw new Exception("No se encontró el nodo"); 
        }else{
            /*
            Se inicializa un nodo como la cabeza y se recorre la lista. Si se encuentra
            el nodo con el dato buscado, se cambia el dato anterior del nodo por el dato nuevo
            */
            Node<T> current = this.head;
            while(current != null){
                if(current.getData() == previousData)
                {
                    current.setData(data);
                }
                current = current.getNextNode();  
                
            }
        }
    }
    
    @Override
    public boolean verifyLength(SinglyLinkedList list)
    {
        /*
        Se verifica el total de nodos de una lista y se compara con la cantidad total
        de nodos de la lista ingresada como parámetro. Si son iguales se retorna verdadero,
        de lo contrario, retorna falso
        */
        return getTotalNodes() == list.getTotalNodes();
    }
    
    @Override
    public boolean verifyEqualLists(SinglyLinkedList list)
    {
        /*
        Se verifica primero si se tiene la misma cantidad de nodos
        */
        if(!verifyLength(list)){
            return false;
        }else{
            /*
            Se inicializan dos nodos como la cabeza de una lista y la cabeza de la otra lista 
            y un contador, se recorren las dos listas al mismo tiempo hasta que las dos cabezan sean null
            */
            int cont = 0;
            Node<T> current = this.head;
            Node<T> currentCompared = list.head;
            while(current != null && currentCompared != null)
            {
                /*
                Si un dato es igual al dato de la otra lista, cuéntelo, además, las dos listas pasan al siguiente
                nodo
                */
                if(current.getData()== currentCompared.getData())
                {
                    cont++;
                }
                /*
                Si no son iguales los datos de las listas igualmente pase al siguiente nodo en ambas listas
                */
                current = current.getNextNode();
                currentCompared = currentCompared.getNextNode();
            }
            /*
            Si la cantidad de nodos totales es igual al contador retorna verdadero, sino, retorna falso
            */            
            return cont == getTotalNodes();
        }
    }
}
