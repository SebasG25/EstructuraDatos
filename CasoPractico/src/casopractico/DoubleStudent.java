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
public class DoubleStudent<T> {
    private T finalGrade;
    private T id;
    private T studentName;
    private T neighborhood;
    private DoubleStudent<T> nextStudent;
    private DoubleStudent<T> previousStudent;
    
    public DoubleStudent(T d,DoubleStudent ps, DoubleStudent ns){
        setFinalGrade(d);
        setPreviousStudent(ps);
        setNextStudent(ns);
    }
    
    public DoubleStudent(T d){
       this(d,null,null) ;
    }
    
    public DoubleStudent(T id, T studentName, T neighborhood, T finalGrade)
    {
        setId(id);
        setStudentName(studentName);
        setNeighborhood(neighborhood);
        setFinalGrade(finalGrade);
    }

    /**
     * @return the finalGrade
     */
    public T getFinalGrade() {
        return finalGrade;
    }

    /**
     * @param finalGrade the finalGrade to set
     */
    public void setFinalGrade(T finalGrade) {
        this.finalGrade = finalGrade;
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
     * @return the studentName
     */
    public T getStudentName() {
        return studentName;
    }

    /**
     * @param studentName the studentName to set
     */
    public void setStudentName(T studentName) {
        this.studentName = studentName;
    }

    /**
     * @return the neighborhood
     */
    public T getNeighborhood() {
        return neighborhood;
    }

    /**
     * @param neighborhood the neighborhood to set
     */
    public void setNeighborhood(T neighborhood) {
        this.neighborhood = neighborhood;
    }

    /**
     * @return the nextStudent
     */
    public DoubleStudent<T> getNextStudent() {
        return nextStudent;
    }

    /**
     * @param nextStudent the nextStudent to set
     */
    public void setNextStudent(DoubleStudent<T> nextStudent) {
        this.nextStudent = nextStudent;
    }

    /**
     * @return the previosStudent
     */
    public DoubleStudent<T> getPreviousStudent() {
        return previousStudent;
    }

    /**
     * @param previosStudent the previosStudent to set
     */
    public void setPreviousStudent(DoubleStudent<T> previosStudent) {
        this.previousStudent = previosStudent;
    }
}
