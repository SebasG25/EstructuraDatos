/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casopractico;

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
        
        DoublyLinkedList<Student> miLista = new DoublyLinkedList<>();
        
        miLista.addStudent("1000869566", "Sebastián", "Calasanz", 3.5);
        miLista.addStudent("1000869888", "Santiago", "Villa Hermosa", 3.0);
        miLista.addStudent("1000869777", "Felipe", "Boston", 2.5);
        miLista.addStudent("1000869788", "Miguel", "Villa Hermosa", 3.1);
        miLista.addStudent("1000869777", "Michael", "Boston", 2.9);
        miLista.addStudent("1000869777", "Simón", "Belén", 1.0);
        
        System.out.println(miLista.showStudent());
        
        try{
            System.out.println(miLista.searchStudent("1000869777"));
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
        try{
            System.out.println(miLista.showStudentsNeighborhood("BoStOn"));
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
        try{
            DoublyLinkedList<Student> miListaAprobados = miLista.newDoubleApprovedList();
            System.out.println("\033[31mLista de estudiantes aprobados: \033[30m\n" + miListaAprobados.showStudent());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
        try{
            DoublyLinkedList<Student> miListaDesaprobados = miLista.newDoubleFailedList();
            System.out.println("\033[31mLista de estudiantes desaprobados: \033[30m\n" + miListaDesaprobados.showStudent());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
}
