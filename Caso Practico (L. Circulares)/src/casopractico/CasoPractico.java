/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casopractico;
import java.util.Scanner;
import java.awt.BorderLayout;
import java.util.InputMismatchException;


/**
 *
 * @author Sebastián Guzmán
 */
public class CasoPractico {

    
    /**
     * @param args the command line arguments
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        CircularDoublyLinkedList<Video> listaCircular = new CircularDoublyLinkedList<>();
        System.out.println("\033[31mLista de reproducción de video");
        Scanner entrada = new Scanner(System.in);
        String opcion;
        do{
            System.out.println();
            System.out.println("\033[31m1. \033[30mAgregar video");
            System.out.println("\033[31m2. \033[30mEliminar");
            System.out.println("\033[31m3. \033[30mActualizar");
            System.out.println("\033[31m4. \033[30mVer lista");
            System.out.println("\033[31m5. \033[30mReproducción automática");
            System.out.println("\033[31m6. \033[30mSalir");  
            System.out.print("Ingrese una opcion de 1 a 6: ");
            
            opcion = entrada.nextLine();
            if(opcion.equals("")){
                System.out.println("\033[31mERROR: \033[30mPor favor ingresa una opción");
            }else if(opcion.equals("1")){
                addVideo(listaCircular);
            }else if (opcion.equals("2")){
                deleteVideo(listaCircular);
            }else if(opcion.equals("3")){
                try{
                    updateVideo(listaCircular);
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }
            }else if(opcion.equals("4")){
                showList(listaCircular);
            }else if(opcion.equals("5")){
                playSongs(listaCircular);
            }else{
                System.out.println("\033[31mERROR: \033[30mPor favor ingresa una opción válida");
            }
        }while(!opcion.equals("6"));
                
    }
    
    public static void addVideo(CircularDoublyLinkedList lista){
        Scanner entrada = new Scanner(System.in);
        String videoName = "";
         while(videoName.isEmpty()){
            System.out.print("Ingrese nombre del video: ");
            videoName = entrada.nextLine();
            videoName = videoName.trim();
        }
        lista.add(videoName);
        System.out.println();
    }
    
    public static void deleteVideo(CircularDoublyLinkedList lista){
        Scanner entrada = new Scanner(System.in);
        System.out.print("Ingrese nombre del video a borrar: ");
        String videoName = entrada.nextLine();
        try {
            lista.deleteVideo(videoName);
            System.out.println("\033[31mVideo eliminado con éxito");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void updateVideo(CircularDoublyLinkedList lista) throws Exception{
        Scanner entrada = new Scanner(System.in);
        
        String videoName = "";
        while(videoName.isEmpty()){
            System.out.print("Ingrese nombre del video a actualizar: ");
            videoName = entrada.nextLine();
            videoName = videoName.trim();
        }
        
        if(lista.checkData(videoName)){
            String newName = "";
            while(newName.isEmpty()){
                System.out.print("Ingrese nombre del nuevo video: ");
                newName = entrada.nextLine();
                newName = newName.trim();
            }
            
            try {
                lista.updateVideo(videoName, newName);
            } catch (Exception e) {
                System.out.println("\033[31mERROR: \033[30m" + e.getMessage());
            }
        }else{
            System.out.println("\033[31mERROR: \033[30mNo se encuentra el video ingresado");
        }
        
    }
    
    public static void playSongs(CircularDoublyLinkedList lista) throws InterruptedException{
        lista.play();
    }
    
    public static void showList(CircularDoublyLinkedList lista){
        if(!lista.isEmpty()){
           System.out.println("\033[31m\nLista de reproducción con un total de " + lista.getTotalVideos() + " videos: \033[30m" + lista.showData()); 
        }else{
            System.out.println("\033[31mLa lista está vacía");
        }
            
    }
}
    
