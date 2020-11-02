
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.datan.niote.vista.media.controladores.projectstree;

import co.edu.usbbog.datan.niote.controlador.logica.GestionRed;

/**
 * Estructura de una lista enlazada
 *
 * @author 204
 */
public class Nodo {

    //Que es lista: es una secuencia de elementos dispuestos en cierto orden
    //Cada elemento tiene un  prosesor y sucesor
    /*/
    //Presesor (el anterior). El que conecta el apuntador
    //Sucesor (el siguiente).
    //El primer nodo de la lista se llama: la cabeza EN LOS NODOS SE GUARDAN LOS ELEMENTOS
    //Hacia donde se apunta se llama apuntador
    
    EsVacia (Saber si esta vacia)
    Insertar (Principio de la lista)
    Resto= toda la lista - cabeza
    /*/
    //Variable para poder guardar de Cualquier documento
    GestionRed valor; //Cualquier tipo //Se hace cuadrito
    Nodo siguiente; //Apunta, flecha //Se hace flechita //Se guarda cualquier tipo de dato
    Nodo anterior;

    //Constructor
    public Nodo(GestionRed obj) {
        this.valor = obj;
        this.siguiente = null; //Termine
    }

    //Manera como se apunta a otro nodo
    public void enlazarSiguiente(Nodo n) {
        siguiente = n;
    }

    //Manera como se apunta a otro nodo
    public void enlazarAnterior(Nodo n) {
        anterior = n;
    }

    //Obtener o conocer el siguiente nodo
    public Nodo obtenerSiguiente() {
        return siguiente;
    }

    //Obtener o conocer el anterior nodo
    public Nodo obtenerAnterior() {
        return anterior;
    }

    //Obtener el elemento
    public GestionRed obtenerValor() {
        return valor;
    }

    public void darValor(GestionRed obj) {
        this.valor = valor;
    }
}
