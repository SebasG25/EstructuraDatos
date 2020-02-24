/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listas;

/**
 *
 * @author s208e19
 */
public interface Ilist<T> {

    /*
    *Agregar un dato al inicio
    *@param el dato
     */
    public void add(T data);

    /*
    *Agregar un dato al final
    *@param el dato
    */
    public void addLast(T data);

    /*
    *Agregar un dato ordenado de menor a mayor
    *@param el dato
     */
    public void addOrdered(T data) throws Exception;

    /*
    *Borrar un dato al inicio
    */
    public void delete() throws Exception;

    /*
    *Borrar un dato al final
    */
    public void deleteLast() throws Exception;

    /*
    *Verificar si la lisa esta vacia
    *@return verdadero si esta vacia
     */
    public boolean isEmpty();

    /*
    *Mostrar todos los datos de la lista
    *@return String con todos los datos
     */
    public String showData();
    
    /*
    *Mostrar el mayor dato de la lista
    */
    public void showMajorData() throws Exception;
    
    /*
    *Mostrar el menor dato de la lista
    */
    public void showMinorData() throws Exception;
    
    /*
    *Mostrar el promedio de la lista
    *@return double con el promedio
    */
    public double averageData() throws Exception;
    
    /*
    *Verificar si ya existe un dato
    *@param el dato
    *@return verdadero si el dato ya está en la lista
    */
    public boolean checkData(T data);
    
    /*
    *Agregar datos sin que se puedan repetir
    *@param el dato
    */
    public void addLastNoRepeated(T data) throws Exception;
    
    /*
    *Agregar descendientemente los datos a una lista
    *@param el dato
    */
    public void addDescendently(T data) throws Exception;
    
    /*
    *Buscar un nodo con el dato ingresado y borrarlo
    *@param el dato
    */
    public void deleteNode(T data) throws Exception;
    
    /*
    *Agregar un dato despues de un dato en específico
    *@param el dato, dato a ingresar
    */
    public void addNodeAfter(T data, T newData) throws Exception;
    
    /*
    *Modificar un dato
    *@param dato a modificar, el dato
    */
    public void modifyData(T previousData, T data) throws Exception;
    
    /*
    *Verificar si dos listas tienen el mismo tamaño
    *@return verdadero si las listas tienen el mismo tamaño
    */
    public boolean verifyLength(SinglyLinkedList list);
    
    /*
    *Verificar si dos listas tienen el mismo tamaño y elementos
    *@return verdadero si las listas son iguales 
    */
    public boolean verifyEqualLists(SinglyLinkedList list);
}
