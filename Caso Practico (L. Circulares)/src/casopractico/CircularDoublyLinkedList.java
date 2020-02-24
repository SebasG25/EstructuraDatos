/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casopractico;

import java.util.Scanner;

/**
 *
 * @author Sebastián Guzmán
 */
public class CircularDoublyLinkedList<T> {
     Video<T> head;
     private int totalVideos = 0;

    public CircularDoublyLinkedList() {
        head = null;
    }

    public void add(T name) {
        if(checkData(name)){
            System.out.println("\033[31mERROR: \033[30mEste video ya está en la lista de reproducción");
        }else{
            Video<T> newVideo = new Video<>(name);
            if (isEmpty()) {
                head = newVideo;
                newVideo.setNextVideo(newVideo);
                newVideo.setPreviousVideo(newVideo);
                totalVideos++;
            } else {
                newVideo.setPreviousVideo(head.getPreviousVideo());
                newVideo.setNextVideo(head);
                head.setPreviousVideo(newVideo);
                head = newVideo;
                head.getPreviousVideo().setNextVideo(head);
                totalVideos++;
            }
        }
    }

    public void delete() throws Exception {
        if (isEmpty()) {
            throw new Exception("\033[31mERROR: \033[30mNo existen datos por borrar...");
        } else if (head == head.getPreviousVideo()) {
            head = null;
        } else {
            head.getNextVideo().setPreviousVideo(head.getPreviousVideo());
            head.getPreviousVideo().setNextVideo(head.getNextVideo());
            head = head.getNextVideo();
        }
    }
    
    public void deleteVideo(T videoName)throws Exception{
        if (isEmpty() || !checkData(videoName)) {
            throw new Exception("\033[31mERROR: \033[30mNo se encontró el video ingresado");
        } else {
            Video<T> current = this.head;
            do{ 
                if(current.getName().toString().equalsIgnoreCase(videoName.toString())){
                    if(getTotalVideos() == 1){
                        head = null;
                        totalVideos--;
                        break;
                    }else if(head.getName().toString().equalsIgnoreCase(videoName.toString())){
                       head.getPreviousVideo().setNextVideo(head.getNextVideo());
                       head.getNextVideo().setPreviousVideo(head.getPreviousVideo()); 
                       head = head.getNextVideo();
                       totalVideos--;
                    }else if(current.getName().toString().equalsIgnoreCase(videoName.toString())){
                        current.getPreviousVideo().setNextVideo(current.getNextVideo());
                        current.getNextVideo().setPreviousVideo(current.getPreviousVideo());
                        totalVideos--;
                    }
                }
                current = current.getNextVideo();
            }while(current != this.head);
        }
    }
    
    public void updateVideo(T videoName, T newName)throws Exception{
        if (isEmpty() || !checkData(videoName)) {
            throw new Exception("\033[31mError: \033[30mNo se encontró el video ingresado");
        } else {
            Video<T> current = this.head;
            do{
                if(current.getName().toString().equalsIgnoreCase(videoName.toString())){
                    current.setName(newName);
                    System.out.println("\033[31mCanción actualizada con éxito");
                }
                current = current.getNextVideo();
            }while(current != this.head);
        }
    }
    
    public void play() throws InterruptedException{
        if(isEmpty()){
            System.out.println("\033[31mERROR: \033[30mNo hay videos en la lista para reproducir");
        }else{
            Video<T> current = this.head;
            do {
                System.out.println("\033[31m\nReproduciendo: " + "\033[30m" + current.getName() + "\n");
                Thread.sleep(2000);
                current = current.getNextVideo();
            }while (current != head);
            
            Scanner entrada = new Scanner(System.in);
            String answer = "";
            while(answer.isEmpty() || answer.equalsIgnoreCase("no") || !answer.equalsIgnoreCase("si")){
                System.out.println("¿Desea repetir la lista de reproducción? Si/No");
                answer = entrada.nextLine();
                answer = answer.trim();
                if(answer.equalsIgnoreCase("si")){
                    play();
                }else if(answer.equalsIgnoreCase("no")){
                    break;
                }
            }
        }
    }

    public void deleteLast() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean isEmpty() {
        return head == null;
    }

    public String showData() {
        String data = "\n";
        if(isEmpty()){
            data = "\033[31mNo hay videos en la lista";
        }else{
            int cont = 1;
            Video<T> current = this.head;
            do {
                data += "\033[31m" + cont + ". \033[30m" + current.getName() + "\n";
                current = current.getNextVideo();
                cont++;
            }while (current != head);
            return data;
        }
        return data;
    }
    
    public boolean checkData(T name) {
        /*
            Se recorre la lista y se encuentra un nodo con su mismo dato, retorna verdadero
        */
        if(isEmpty()){
            return false;
        }else{
            Video<T> current = this.head;
        do{ 
            if(current.getName().toString().equalsIgnoreCase(name.toString())){
                return true;
            }
            current = current.getNextVideo();
        }while(current != this.head);
        return false;
        
        }
    }

    /**
     * @return the totalVideos
     */
    public int getTotalVideos() {
        return totalVideos;
    }
}
