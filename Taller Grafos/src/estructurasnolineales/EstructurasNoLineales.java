/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructurasnolineales;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 *
 * @author samaniw
 */
public class EstructurasNoLineales {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //prueba de Dijkstra
        Graph superTest = new Graph(4);
        superTest.addEdge(0, 1);
        superTest.addEdge(0, 2);
        superTest.addEdge(0, 3);
        superTest.addEdge(1, 0);
        superTest.addEdge(2, 0);
        superTest.addEdge(3, 0);
        System.out.println("lista de adyacencias");
        System.out.println(superTest.showAList());
        System.out.println(superTest.showAMatrix());
        System.out.println("Mapa de recorrido");
        superTest.doTour();
        System.out.println("");
        System.out.println("2. Para una matriz de adyacencias de un grafo, determinar si cada nodo tiene el mismo número de entradas y salidas.");
        boolean aMatrix[][] = new boolean[4][4];
        System.out.println("");
        System.out.println("Matriz ejemplo 1: ");
        System.out.println("");
        
        aMatrix[0][0] = false;
        aMatrix[0][1] = false;
        aMatrix[0][2] = true;
        aMatrix[0][3] = false;
        aMatrix[1][0] = true;
        aMatrix[1][1] = false;
        aMatrix[1][2] = false;
        aMatrix[1][3] = false;
        aMatrix[2][0] = false;
        aMatrix[2][1] = true;
        aMatrix[2][2] = false;
        aMatrix[2][3] = true;
        aMatrix[3][0] = false;
        aMatrix[3][1] = false;
        aMatrix[3][2] = true;
        aMatrix[3][3] = false;
        
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                System.out.print(aMatrix[j][i] + " ");
            }
            System.out.println("");
        }
        
        System.out.println("");
        System.out.println("Tienen el mismo número de entradas y salidas: " + superTest.verifyEntriesAndSallies(aMatrix));
        
        
        System.out.println("");
        System.out.println("3. Dada una cantidad de nodos y una lista de arcos, retornar los arcos faltantes para conectar todos los nodos.");

        Graph superTest2 = new Graph(4);
        superTest.addEdge(0, 1);
        superTest.addEdge(0, 2);
        superTest.addEdge(0, 3);
        superTest.addEdge(1, 0);
        superTest.addEdge(2, 0);
        superTest.addEdge(2, 1);
        superTest.addEdge(3, 0);
        superTest.addEdge(3, 1);
        superTest.addEdge(3, 3);
        superTest.EdgesMissing();
        
        
        
        
        
        
        
        
        
        
        
        /*HashMap<String, Node> map = superTest.Dijkstra("A");
        for (String node : map.keySet()) {
            System.out.println(node + map.get(node).getWeight()+map.get(node).getNode());
        }
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node("A", 9));
        pq.add(new Node("B", 3));
        pq.add(new Node("C", 5));
        System.out.println("Sacado de la cola:" + pq.poll().getNode());

        BinarySearchTree test = new BinarySearchTree(10);
        //datos de prueba que se pueden usar en https://visualgo.net/en/bst
        //10,5,3,8,20,7,18,25,23,30,21,24        
        test.Add(5);
        test.Add(3);
        test.Add(8);
        test.Add(20);
        test.Add(7);
        test.Add(18);
        test.Add(25);
        test.Add(23);
        test.Add(30);
        test.Add(21);
        test.Add(24);
        test.Delete(5);
        test.Delete(3);
        test.Delete(20);
        test.Delete(25);
        test.Delete(30);
        test.Delete(8);
        //llamar al método
        test.LevelOrder();

        System.out.println("");

        //System.out.println(pino.Search(88));
        // TODO code application logic here
        DGrahp g0 = new DGrahp();
        g0.addNode("A");
        g0.addNode("D");
        g0.addNode("B");
        g0.addNode("C");
        g0.addNode("E");
        g0.addEdge("A", "B", 1);
        g0.addEdge("A", "C", 1);
        g0.addEdge("A", "E", 3);
        g0.addEdge("C", "E", 1);

        g0.showAList();
        Graph g1 = new Graph(7);
        g1.addEdge(0, 1);
        g1.addEdge(0, 2);
        g1.addEdge(1, 3);
        g1.addEdge(2, 3);
        g1.addEdge(2, 4);
        g1.addEdge(2, 5);
        g1.addEdge(3, 6);
        g1.addEdge(4, 6);
        g1.addEdge(4, 5);

        //...
//        g1.deleteEdge(0, 1);
//        g1.deleteEdge(1, 2);
        System.out.println("Matriz de adyacencias");
        System.out.println(g1.showAMatrix());
        System.out.println("Lista de adyacencias");
        System.out.println(g1.showAList());

        System.out.println("Recorrido en profundidad");
        g1.DFS(0);
        System.out.println("");
        System.out.println("Recorrido en anchura");
        g1.BFS(0);
        System.out.println("");
        MaxHeap maxData = new MaxHeap();
        //31,51,53,28,47,22
        maxData.insert(31);
        maxData.insert(51);
        maxData.insert(53);
        maxData.insert(28);
        maxData.insert(47);
        maxData.insert(22);
        System.out.println(maxData.getDataHeap());
        maxData.ExtractMax();
        System.out.println(maxData.getDataHeap());
    */
    }

}
