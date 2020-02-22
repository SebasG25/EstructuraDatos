/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casopractico;

/**
 *
 * @author Sebastián Guzmán
 */
public class Video<T> {
    private T id;
    private T name;
    private Video<T> nextVideo;
    private Video<T> previousVideo;
    
    public Video(T name,Video pv, Video nv){
        setName(name);
        setPreviousVideo(pv);
        setNextVideo(nv);
    }
    
    public Video(T name, T id){
       setName(name);
       setId(id);
       setPreviousVideo(null);
       setNextVideo(null);
    }

    /**
     * @return the id
     */
    public T getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(T id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public T getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(T name) {
        this.name = name;
    }

    /**
     * @return the nextVideo
     */
    public Video<T> getNextVideo() {
        return nextVideo;
    }

    /**
     * @param nextVideo the nextVideo to set
     */
    public void setNextVideo(Video<T> nextVideo) {
        this.nextVideo = nextVideo;
    }

    /**
     * @return the previousVideo
     */
    public Video<T> getPreviousVideo() {
        return previousVideo;
    }

    /**
     * @param previousVideo the previousVideo to set
     */
    public void setPreviousVideo(Video<T> previousVideo) {
        this.previousVideo = previousVideo;
    }
}
