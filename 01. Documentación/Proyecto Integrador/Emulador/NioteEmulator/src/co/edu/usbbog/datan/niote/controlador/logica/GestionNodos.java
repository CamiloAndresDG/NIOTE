/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.datan.niote.controlador.logica;

import co.edu.usbbog.datan.niote.modelo.Nodo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase para crear, eliminar, buscar y ver nodos
 *
 * @author Andrés Sánchez, Juan Ochoa, Sebastian Villanueva.
 */
public class GestionNodos implements Serializable {

    /**
     * Lista para almacenar cada nodo que se cree
     */
    private List<Nodo> nodos;

    /**
     * Constructor para la lista de nodos
     *
     * @param nodos variable que contiene la lista
     */
    public GestionNodos(List<Nodo> nodos) {
        this.nodos = nodos;
    }

    /**
     * Constructor de la clase
     */
    public GestionNodos() {
        this.nodos = new ArrayList<>();
    }

    /**
     * Obtener los valores de la lista
     *
     * @return valores de la lista
     */
    public List<Nodo> getNodos() {
        return nodos;
    }

    /**
     * Poner nuevos valores en la lista
     *
     * @param nodos variable que contiene la lista
     */
    public void setNodos(List<Nodo> nodos) {
        this.nodos = nodos;
    }

    /**
     * Método para ver todos los nodos existentes
     *
     * @return Todos los nodos
     */
    public String verNodos() {
        String salida = "";
        for (Nodo nodo : nodos) {
            salida += salida + nodo.toString() + "\n";
        }
        return salida;
    }

    /**
     * Método para ver un nodo especifico según su id
     *
     * @param id campo unico con el que se identifica cada nodo
     * @return Especificaciones del nodo segun el id
     */
    public String verNodoPorID(String id) {
        String salida = "";
        if (existeNodoPorID(id)) {
            for (Nodo nodo : nodos) {
                if (nodo.getId().equals(id)) {
                    salida = nodo.toString() + "\n";
                }
            }
        } else {
            salida = "El nodo con ID " + id + " no existe";
        }
        return salida;
    }

    /**
     * Método para crear un nuevo nodo
     *
     * @param id campo unico de cada nodo
     * @param descripcion descripcion del nodo
     * @param estado activo o inactivo
     * @param protocoloComunicacion protocolo a traves del que se va a comunicar
     * @return retorna si el nodo se agrego o ya existe
     */
    public String crearNodo(String id, String descripcion, boolean estado, String protocoloComunicacion) {
        if (existeNodoPorID(id)) {
            return "El nodo ya existe";
        } else {
            Nodo nodo = new Nodo(id, descripcion, estado, protocoloComunicacion);
            nodos.add(nodo);
            return "El nodo con ID " + id + " se agrego";
        }

    }

    /**
     * Método para verificar si existe el id
     *
     * @param id campo único con el que se identifica cada nodo
     * @return true = si existe, false = no existe
     */
    public boolean existeNodoPorID(String id) {
        return nodos.stream().anyMatch((nodo) -> (nodo.getId().equals(id)));
    }

    /**
     * Método para buscar un nodo
     *
     * @param id campo único con el que se identifica cada nodo
     * @return El nodo que se busco
     */
    public Nodo buscarNodoPorID(String id) {
        for (Nodo nodo : nodos) {
            if (nodo.getId().equals(id)) {
                return nodo;
            }
        }
        return null;
    }

    /**
     * Método para modificar las especificaciones de un nodo
     *
     * @param id campo único de cada nodo
     * @param descripcion descripción del nodo
     * @param protocoloComunicacion protocolo a través del que se va a comunicar
     * @return Se modifico o no se modifico
     */
    public String modificarNodoPorID(String id, String descripcion, String protocoloComunicacion) {
        if (existeNodoPorID(id)) {
            Nodo nodo = buscarNodoPorID(id);
            nodo.setDescripcion(descripcion);
            nodo.setProtocoloComunicacion(protocoloComunicacion);
            return "El nodo se modificó";
        } else {
            return "El nodo con ID " + id + " no existe";
        }
    }

    /**
     * Método para eliminar un nodo
     *
     * @param id campo único con el que se identifica cada nodo
     * @return se eliminó o no se elimino
     */
    public String eliminarNodoPorID(String id) {
        if (existeNodoPorID(id)) {
            Nodo nodo = buscarNodoPorID(id);
            nodos.remove(nodo);
            return "El nodo se elimino";
        } else {
            return "El nodo con ID " + id + " no existe";
        }

    }
    
}
