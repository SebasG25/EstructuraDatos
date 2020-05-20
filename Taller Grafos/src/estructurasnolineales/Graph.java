/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructurasnolineales;

import java.util.LinkedList;

/**
 *
 * @author samaniw
 */
public class Graph {

    private boolean aMatrix[][];
    private int totalNodes;
    private LinkedList<Integer> aList[];

    public Graph(int n) {
        totalNodes = n;
        aMatrix = new boolean[n][n];
        aList = new LinkedList[n];
        for (int i = 0; i < totalNodes; i++) {
            aList[i] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int source, int destination) {
        aMatrix[source][destination] = true;
        aList[source].add(destination);
    }
    
    public void addBidirectionalEdge(int source, int destination) {
        aMatrix[source][destination] = true;
        aMatrix[destination][source] = true;
        aList[source].add(destination);
        aList[destination].add(source);
    }

    public void deleteEdge(int source, int destination) {
        aMatrix[source][destination] = false;
        aList[source].remove((Object) destination);
    }
    
    public void deleteBidirectionalEdge(int source, int destination) {
        aMatrix[source][destination] = false;
        aMatrix[destination][source] = false;
        aList[source].remove((Object) destination);
        aList[destination].remove((Object) source);
    }

    public String showAMatrix() {
        String Table = "";

        for (int i = 0; i < totalNodes; i++) {
            for (int j = 0; j < totalNodes; j++) {
                //Table += aMatrix[i][j] ? 1 : 0;
                Table += aMatrix[i][j] + " ";
            }
            Table += "\n";
        }

        return Table;
    }

    public String showAList() {
        String List = "";
        for (int i = 0; i < totalNodes; i++) {
            List += i + ": ";
            for (Integer v : aList[i]) {
                List += v + " ";
            }
            List += "\n";
        }
        return List;
    }

    public void DFS(int source) {
        boolean visited[] = new boolean[totalNodes];
        DFS(source, visited);
    }

    private void DFS(int source, boolean visited[]) {
        visited[source] = true;
        System.out.print(source + " ");
        for (int v : aList[source]) {
            if (!visited[v]) {
                DFS(v, visited);
            }
        }
    }

    public void BFS(int source) {
        boolean visited[] = new boolean[totalNodes];
        LinkedList<Integer> queue = new LinkedList<>();

        visited[source] = true;
        queue.add(source);

        while (!queue.isEmpty()) {
            source = queue.poll();
            System.out.print(source + " ");
            for (int v : aList[source]) {
                if (!visited[v]) {
                    visited[v] = true;
                    queue.add(v);
                }
            }
        }
    }
    
    public void doTour(){ 
        LinkedList<Integer> visited = new LinkedList<>();
        for(int i = 0; i < aList.length; i++){
            if(!visited.contains(i)){
                visited.add(i);
            }
            for(int node : aList[i]){
                if(!visited.contains(node)){
                    System.out.print(node + " ");
                    System.out.print(i + " ");
                    
                }else{
                    visited.add(node);
                }
            }
        }
    }
    
    public int countSallies(boolean aMatrix[][], int columna){
        int salidas = 0;
        for(int i = 0; i < totalNodes; i++){
                if(aMatrix[i][columna]){
                    salidas++;
                }
            }
        return salidas;
    } 
    
    public int countEntries(boolean aMatrix[][], int fila){
        int entradas = 0;
        for(int j = 0; j < totalNodes; j++){
            if(aMatrix[fila][j]){
                entradas++;
            }
        }
        return entradas;
    }
    
    public boolean verifyEntriesAndSallies(boolean aMatrix[][]){
        for(int i = 0; i < totalNodes; i++){
            if(!(countSallies(aMatrix, i) == countEntries(aMatrix, i))){
                return false;
            }
        }
        return true;
    }
    
    public void EdgesMissing(){
        boolean auxMatrix[][] = aMatrix;
        System.out.print("Arcos faltantes: [ ");
        for (int i = 0; i < totalNodes; i++) {
            for (int j = 0; j < totalNodes; j++) {
                if(!auxMatrix[i][j] && (i!=j)){
                    System.out.print("["+ i +", "+ j +"] ");
                    auxMatrix[j][i] = true;
                }
            }
        }
        System.out.print("]");
    }

}
