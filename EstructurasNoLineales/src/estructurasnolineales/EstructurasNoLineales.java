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
public class EstructurasNoLineales {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

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

        BinarySearchTree pino = new BinarySearchTree(8);
        try {
            pino.Add(3);
            pino.Add(9);
            pino.Add(2);
            pino.Add(3);
            pino.Add(7);
            pino.Add(1);
            pino.Add(4);
            System.out.print("Inorden: ");
            pino.InOrden(); 
            System.out.println("");
            System.out.print("PreOrden: ");
            pino.PreOrden();
            System.out.println("");
            System.out.print("PosOrden: ");
            pino.PostOrden();
            System.out.println("");
//            pino.Delete(3);
            System.out.println("El total de nodos es: " + pino.CountNodes());
            System.out.println("El total de hojas es: " + pino.CountLeaves());
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("");
        //System.out.println(pino.Search(88));
    }

}
