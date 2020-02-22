/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casopractico;

/**
 *
 * @author Sebastian
 */
public class CircularDoublyLinkedList<T> {
     Video<T> head;

    public CircularDoublyLinkedList() {
        head = null;
    }

    public void add(T name) {
        Video<T> newVideo = new Video<>(name);
        if (isEmpty()) {
            head = newVideo;
            newVideo.setNextVideo(newVideo);
            newVideo.setPreviousVideo(newVideo);
        } else {
            newVideo.setPreviousVideo(head.getPreviousVideo());
            newVideo.setNextVideo(head);
            head.setPreviousVideo(newVideo);
            head = newVideo;
            head.getPreviousVideo().setNextVideo(head);

        }
    }

    public void addLast(T name) {
        Video<T> newVideo = new Video<>(name);
        if (isEmpty()) {
            head = newVideo;
            newVideo.setNextVideo(newVideo);
            newVideo.setPreviousVideo(newVideo);
        } else {
            newVideo.setPreviousVideo(head.getPreviousVideo());
            newVideo.setNextVideo(head);
            head.getPreviousVideo().setNextVideo(newVideo);
            head.setPreviousVideo(newVideo);
            //head=newNode;
            //¿Se puede refactorizar?
        }
    }

    public void delete() throws Exception {
        if (isEmpty()) {
            throw new Exception("No existen datos por borrar...");
        } else if (head == head.getPreviousVideo()) {
            head = null;
        } else {
            head.getNextVideo().setPreviousVideo(head.getPreviousVideo());
            head.getPreviousVideo().setNextVideo(head.getNextVideo());
            head = head.getNextVideo();
        }
    }

    public void deleteLast() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean isEmpty() {
        return head == null;
    }

    public String showData() {
        String data = "";
        Video<T> current = this.head;
        do {
            data = data + current.getName() + " ";
            current = current.getNextVideo();
        } while (current != head);
        return data;
    }
    
    public boolean checkData(T name) {
        /*
            Se recorre la lista y se encuentra un nodo con su mismo dato, retorna verdadero
        */
        Video<T> current = this.head;
        do{
            if(current.getName().equals(name)){
                return true;
            }
            current = current.getNextVideo();
        }while(current != this.head);
        return false;
    }
}
