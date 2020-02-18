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
public class DoublyLinkedList<T> {
    private Student<T> head;
    private Student<T>tail;

    /*
        Se inicializa una Lista Doble vacía al crearla
    */
    public DoublyLinkedList() {
        head = tail = null;
    }
    
    /*
        Se agrega a un objeto estudiante a la lista
    */
    public void add(Student<T> student){
        /*
            Se verifica si la lista está vacía para inicializar la cabeza y la cola
            como el estudiante a ingresar. Se le da los atributos del estudiante, y
            se inicializa el siguiente estudiante y estudiante anterior como null
        */
        if (isEmpty()) {
            head = tail = new Student(student, null, null);
        } else {
            /*
                Si la lista no está vacía, se corren los estudiantes a la derecha y se
                ingresa el nuevo estudiante
            */
            head = new Student(student, null, head);
            head.getNextStudent().setPreviousStudent(head);        
        }
    }
    
    /*
    * Se agrega a un objeto estudiante a la lista en una posición dependiendo si aprobó o reprobó
    */
    public void addStudent(String id, String studentName, String neighborhood, double finalGrade)
    {
        if(isEmpty())
        {
            /*
                Se verifica si la lista está vacía para inicializar la cabeza y la cola
                como el estudiante a ingresar. Se le da los atributos del estudiante, y
                se inicializa el siguiente estudiante y estudiante anterior como null
            */
            head = tail = new Student(id, studentName, neighborhood, finalGrade, null, null);
        }else{
            /*
                Se verifica si aprobó o reprobó para saber si se agrega al inicio o al final
            */
            if(finalGrade >= 3.0){
                head = new Student(id, studentName, neighborhood, finalGrade, null, head);
                head.getNextStudent().setPreviousStudent(head);
            }else if(finalGrade < 3.0){
                tail = new Student(id, studentName, neighborhood, finalGrade, tail, null);
                tail.getPreviousStudent().setNextStudent(tail);
            }
        }
    }
    
    /*
        Mostrar la lista y los datos del estudiante
    */
    public String showStudent()
    {
        /*
            Recorre la lista para imprimir cada uno de los datos de un estudiante en la lista
        */
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
    
    /*
        Buscar un estudiante con una identificación específica ingresada por el usuario
    */
    public String searchStudent(String id) throws Exception{
        String data = "\033[31mEstudiante buscado: \n";
        
        /*
            Se verifica si la lista está vacía para lanzar una excepción
        */
        if(isEmpty()){
            throw new Exception("La lista está vacía");
            
        }else{
            /*
                Si no está vacía la lista, se inicializa un objeto estudiante actual como la cabeza de la lista y se recorre
                la lista, hasta que el objeto estudiante actual sea nulo. En cada objeto estudiante verifica si el dato de ese estudiante
                es igual al Id ingresado para retornar los datos del estudiante, sino, sigue recorriendo la lista
            */
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
            /*
                Si no encuentra el estudiante, se lanza una excepción
            */
            throw new Exception("El estudiante no se encuentra en la lista");
        }
    }
    
    /*
        Muestra los estudiantes de un barrio específico ingresado por el usuario
    */
    public String showStudentsNeighborhood(String neighborhood) throws Exception
    {
        String data = "\033[31mEstudiante(s) de barrio buscado: \n";
        /*
            Se verifica si la lista está vacía para lanzar una excepción
        */
        if(isEmpty()){
            throw new Exception("\033[31mERROR: \033[30mLa lista está vacía");
            
        }else{
            /*
                Si no está vacía la lista, se inicializa un objeto estudiante actual como la cabeza de la lista y se recorre
                la lista, hasta que el objeto estudiante actual sea nulo. En cada estudiante verifica si el dato del barrio 
                de ese objeto estudiante es igual al barrio guarda el nombre de ese estudiante y sigue recorriendo la lista, sino, 
                igualmente sigue recorriendo la lista
            */
            Student<T> current = this.head;
            while (current != null) 
            {
                if(current.getNeighborhood().equalsIgnoreCase(neighborhood))
                {
                    data += "Nombre: " + current.getStudentName() +"\n";
                }
                current = current.getNextStudent();
            }
            
            /*
                Se verifica si se encontraron estudiantes con el barrio ingresado para retornar los nombres de los estudiantes
            */
            if(data != "\033[31mEstudiante(s) de barrio buscado: \n")
            {
                return data;
            }
            /*
                Si no hay ningún estudiante con el barrio ingresado, se lanza una excepción
            */
            throw new Exception("\033[31mERROR: \033[30mNo existe el barrio ingresado");
        }
    }
    
    /*
        Se crea una nueva lista doble con los estudiantes aprobados
    */
    public DoublyLinkedList<T> newDoubleApprovedList() throws Exception
    {
        /*
            Se verifica si la lista está vacía para lanzar una excepción
        */
        if(isEmpty()){
            throw new Exception("\033[31mERROR: \033[30mLa lista está vacía");
        }else{
            /*
                Se crea un objeto estudiante actual con la cabeza de la lista con todos los estudiantes y
                se crea otra lista doble que se llama "aprobados"
            */
            Student<T> current = this.head;
            DoublyLinkedList<T> aprobados = new DoublyLinkedList<>();
            
            /*
                Se recorre la lista hasta que el objeto estudiante actual sea nulo
            */
            while(current != null){
                /*
                    Se verifica si ese estudiante aprobó la asignatura para luego agregarlo a la nueva lista
                */
                if(current.getFinalGrade() > 3){
                    aprobados.add(current);
                }
                /*
                    Si no aprobó, sigue recorriendo la lista
                */
                current = current.getNextStudent();
            }
            /*
                Retorna la lista después de haber terminado de recorrer la lista
            */
            return aprobados;
        }
    }
    
    /*
        Se crea una nueva lista doble con los estudiantes reprobados
    */
    public DoublyLinkedList<T> newDoubleFailedList() throws Exception
    {
        /*
            Se verifica si la lista está vacía para lanzar una excepción
        */
        if(isEmpty()){
            throw new Exception("\033[31mERROR: \033[30mLa lista está vacía");
        }else{
            /*
                Se crea un objeto estudiante actual con la cabeza de la lista con todos los estudiantes y
                se crea otra lista doble que se llama "reprobados"
            */
            Student<T> current = this.head;
            DoublyLinkedList<T> reprobados = new DoublyLinkedList<>();
            
            /*
                Se recorre la lista hasta que el objeto estudiante actual sea nulo
            */
            while(current != null){
                /*
                    Se verifica si ese estudiante reprobó la asignatura para luego agregarlo a la nueva lista
                */
                if(current.getFinalGrade() < 3){
                    reprobados.add(current);
                }
                /*
                    Si no aprobó, sigue recorriendo la lista
                */
                current = current.getNextStudent();
            }
            /*
                Retorna la lista después de haber terminado de recorrer la lista
            */
            return reprobados;
        }
    }
    
    public boolean isEmpty()
    {
        /*
            Se verifica si la cabeza es nula; si es cierto, entonces la lista está vacía
        */
        return this.head == null;
    }
}
