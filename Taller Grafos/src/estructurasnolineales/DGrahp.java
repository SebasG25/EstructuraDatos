/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructurasnolineales;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 *
 * @author samaniw
 */
public class DGrahp {

    private HashMap<String, LinkedList<Node>> aList;

    public DGrahp() {
        aList = new HashMap<>();
    }

    public void addNode(String data) {
        aList.putIfAbsent(data, new LinkedList<Node>());
    }

    private String getDataList(String key) {
        LinkedList<Node> data;
        data = aList.get(key);
        String d = "";
        for (Node n : data) {
            d += n.getNode();
        }
        return d;
    }

    public void showAList() {
        for (String node : aList.keySet()) {
            System.out.println(node + ": " + getDataList(node));
        }
    }

    public void addEdge(String source, String destination, int weight) {
        aList.get(source).add(new Node(destination, weight));
    }

    public LinkedList<Node> getNeighbors(String current) {
        return aList.get(current);
    }

    public HashMap<String, Node> Dijkstra(String current) {
        /*
        Crear un mapa de recorrido, considerando vértice de destino, peso total y vértice de origen donde el peso desde el origen es cero, los demás son infinitos(desconocidos).	
         */
        HashMap<String, Node> map = new HashMap<>();
        Node data;
        for (String node : aList.keySet()) {
            if (node.equals(current)) {
                data = new Node(null, 0);
            } else {
                data = new Node(null, Integer.MAX_VALUE);
            }
            map.putIfAbsent(node, data);
        }

        /*
        Crear una cola priorizada donde se almacenan vértices a donde llegar y su respectivo peso.
         */
        PriorityQueue<Node> pq = new PriorityQueue<>();
        /*
        Definir un punto de referencia (vértice actual y peso actual: cero) 
        y agregarlo a la cola priorizada. 	
         */
        int currentWeight = 0, tourWeight;
        pq.add(new Node(current, currentWeight));
        /*
        Generar un arreglo de vértices visitados.						
         */
        LinkedList<String> visited = new LinkedList<>();

        while (!pq.isEmpty()) {
            /*
            Sacar un vértice de la cola priorizada(el que tega menor peso 
            y que parasará a ser el nodo actual), su peso será el peso actual.						
             */
            Node temp = pq.poll();
            current = temp.getNode();
            currentWeight = temp.getWeight();

            /*
            Para el vértive actual, obtener todos sus vecinos 
            y calcular el peso del recorrido(peso actual + peso arco) 
            para agregarlos a la cola priorizada si no han sido visitados.
             */
            for (Node neighbor : getNeighbors(current)) {
                if (!visited.contains(neighbor.getNode())) {
                    tourWeight = currentWeight + neighbor.getWeight();
                    pq.add(new Node(neighbor.getNode(), tourWeight));
                }
            }

            /*
            Actualizar el mapa de recorrido, esto es agregar el peso 
            y el origen correspondiente(vértice sacado previamente) 
            si es menor al valor actual del mapa.
             */
            for (Node n : pq) {
                if (n.getWeight() < map.get(n.getNode()).getWeight()) {
                    map.put(n.getNode(), new Node(current, n.getWeight()));
                }
            }
            
            /*
            Agregar si ya no lo está, el vértice sacado de la cola 
            al arreglo de visitados
            */
            if(!visited.contains(current)){
                visited.add(current);
            }

        }

        return map;
    }
    
    public String doTour(HashMap<String, LinkedList<Node>> adList){
        String tour = "";
        LinkedList<String> visited = new LinkedList<>();
        for(String node : adList.keySet()){
            for(Node n:getNeighbors(node)){
                if(!visited.contains(n)){
                    tour+= n.getNode() + " ";
                    visited.add(node);
                }
            }
        }
        return tour;
    }
    
    public HashMap<String, LinkedList<Node>> getAList(){
        return this.aList;
    }
}
