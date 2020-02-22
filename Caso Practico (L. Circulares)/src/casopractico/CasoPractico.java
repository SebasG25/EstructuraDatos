/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casopractico;
import java.util.Scanner;
import java.awt.BorderLayout;

/**
 *
 * @author Sebastián Guzmán
 */
public class CasoPractico {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner entrada = new Scanner(System.in);
        int opcion;
        System.out.println("Lista de reproducción de video");
            System.out.println("1. Agregar video");
            System.out.println("2. Eliminar");
            System.out.println("3. Actualizar");
            System.out.println("4. Ver lista");
            System.out.println("5. Reproducción automática");
            System.out.println("6. Salir");
        do{
            
            System.out.print("Ingrese una opcion de 1 a 6: ");
            opcion = entrada.nextInt();
        }while(opcion == 6);
    }
    
}
