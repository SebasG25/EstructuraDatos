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
public class Student<T> {
    private double finalGrade;
    private String id;
    private String studentName;
    private String neighborhood;
    private Student<T> nextStudent;
    private Student<T> previousStudent;
    
    public Student(String id, String studentName, String neighborhood, double finalGrade)
    {
        setId(id);
        setStudentName(studentName);
        setNeighborhood(neighborhood);
        setFinalGrade(finalGrade);
    }
    
    public Student(String id, String studentName, String neighborhood, double finalGrade, Student previousStudent, Student nextStudent)
    {
        setId(id);
        setStudentName(studentName);
        setNeighborhood(neighborhood);
        setFinalGrade(finalGrade);
        setPreviousStudent(previousStudent);
        setNextStudent(nextStudent);
    }
    
    public Student(Student student, Student previousStudent, Student nextStudent){
        setId(student.getId());
        setStudentName(student.getStudentName());
        setNeighborhood(student.getNeighborhood());
        setFinalGrade(student.getFinalGrade());
        setPreviousStudent(previousStudent);
        setNextStudent(nextStudent);
    }

    /**
     * @return the finalGrade
     */
    public double getFinalGrade() {
        return finalGrade;
    }

    /**
     * @param finalGrade the finalGrade to set
     */
    public void setFinalGrade(double finalGrade) {
        this.finalGrade = finalGrade;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the studentName
     */
    public String getStudentName() {
        return studentName;
    }

    /**
     * @param studentName the studentName to set
     */
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    /**
     * @return the neighborhood
     */
    public String getNeighborhood() {
        return neighborhood;
    }

    /**
     * @param neighborhood the neighborhood to set
     */
    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    /**
     * @return the nextStudent
     */
    public Student<T> getNextStudent() {
        return nextStudent;
    }

    /**
     * @param nextStudent the nextStudent to set
     */
    public void setNextStudent(Student<T> nextStudent) {
        this.nextStudent = nextStudent;
    }

    /**
     * @return the previosStudent
     */
    public Student<T> getPreviousStudent() {
        return previousStudent;
    }

    /**
     * @param previousStudent the previousStudent to set
     */
    public void setPreviousStudent(Student<T> previousStudent) {
        this.previousStudent = previousStudent;
    }
}
