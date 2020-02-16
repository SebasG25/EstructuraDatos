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
public class DoublyLinkedList<T> {
    private Student<T> head;
    private Student<T>tail;

    public DoublyLinkedList() {
        head = tail = null;
    }
    
    public void add(Student<T> student){
        if (isEmpty()) {
            head = tail = new Student(student);
        } else {
            head = new Student(student);
            head.getNextStudent().setPreviousStudent(head);        }
    }
    
    public void addStudent(String id, String studentName, String neighborhood, double finalGrade)
    {
        if(isEmpty())
        {
            head = tail = new Student(id, studentName, neighborhood, finalGrade);
        }else{
            if(finalGrade >= 3.0){
                head = new Student(id, studentName, neighborhood, finalGrade, null, head);
                head.getNextStudent().setPreviousStudent(head);
            }else if(finalGrade < 3.0){
                tail = new Student(id, studentName, neighborhood, finalGrade, tail, null);
                tail.getPreviousStudent().setNextStudent(tail);
            }
        }
    }
    
    public String showStudent()
    {
        String data = "";
        Student<T> current = this.head;
        while (current != null) {
            data += "Cédula: " + current.getId() + "\nNombre: " + current.getStudentName() 
                    + "\nBarrio: " + current.getNeighborhood() + "\nNota final: " + current.getFinalGrade() 
                    + "\n\n";
            current = current.getNextStudent();
        }
        return data;
    }
    
    public String searchStudent(String id) throws Exception{
        String data = "\033[31mEstudiante buscado: \n";
        
        if(isEmpty()){
            throw new Exception("La lista está vacía");
            
        }else{
            Student<T> current = this.head;
            while (current != null) 
            {
                if(current.getId().equals(id))
                {
                    data += "Cédula: " + current.getId() + "\nNombre: " + current.getStudentName() 
                    + "\nBarrio: " + current.getNeighborhood() + "\nNota final: " + current.getFinalGrade() 
                    + "\n\n";
                    return data;
                }
                current = current.getNextStudent();
            }
            throw new Exception("El estudiante no se encuentra en la lista");
        }
    }
    
    public String showStudentsNeighborhood(String neighborhood) throws Exception
    {
        String data = "\033[31mEstudiante(s) de barrio buscado: \n";
        
        if(isEmpty()){
            throw new Exception("\033[31mERROR: \033[30mLa lista está vacía");
            
        }else{
            Student<T> current = this.head;
            while (current != null) 
            {
                if(current.getNeighborhood().equalsIgnoreCase(neighborhood))
                {
                    data += "Nombre: " + current.getStudentName() +"\n";
                }
                current = current.getNextStudent();
            }
            
            if(data != "\033[31mEstudiante(s) de barrio buscado: \n")
            {
                return data;
            }
            throw new Exception("\033[31mERROR: \033[30mNo existe el barrio ingresado");
        }
    }
    
    public DoublyLinkedList<T> newDoubleApprovedList(DoublyLinkedList list) throws Exception
    {
        if(isEmpty()){
            throw new Exception("La lista está vacía");
        }else{
            Student<T> current = head;
            DoublyLinkedList<T> approvedStudentList = new DoublyLinkedList<>();
            while(current != null)
            {
                if(current.getFinalGrade() >= 3.0){
                    approvedStudentList.add(current.getId(), current.getStudentName(), 
                            current.getNeighborhood(), current.getFinalGrade());
                }
                current.getNextStudent();
            }
            return approvedStudentList;
        }
    }
    
    public void newDoubleList(DoublyLinkedList list) throws Exception
    {
        if(isEmpty()){
            throw new Exception("ERROR: La lista está vacía");
        }else{
            Student<T> current = list.head;
            DoublyLinkedList<T> aprobados = new DoublyLinkedList<>();
            DoublyLinkedList<T> reprobados = new DoublyLinkedList<>();
            while(current != null){
                if(current.getFinalGrade() < 3){
                    reprobados.addStudent(current.getId(), current.getStudentName(), current.getNeighborhood(), current.getFinalGrade());
                }else if(current.getFinalGrade() >= 3){
                    aprobados.add(current);
                }
                current = current.getNextStudent();
            }
            System.out.println(reprobados.showStudent());
            System.out.println(aprobados.showStudent());
        }
    }
    
    public boolean isEmpty()
    {
        return head == null;
    }
}
