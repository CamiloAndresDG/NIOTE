/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.datan.niote.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que contiene las variables que integran una Puerta de Enlace
 *
 * @author Andrés Sánchez, Juan Ochoa, Sebastian Villanueva.
 */
public class PuertaDeEnlace implements Serializable {

    /**
     * Variable única con la que se identifica la puerta de enlace
     */
    private String id;
    /**
     * Variable que contiene la descripción de la puerta de enlace
     */
    private String descripcion;
    /**
     * Variable que contiene el estado de la puerta de enlace
     */
    private boolean estado;
    /**
     * -----------
     */
    private String direccionLogica;
    /**
     * -----------
     */
    private String puertoDeServicio;
    /**
     * ---------
     */
    private String protocoloComunicacionExterno;
    /**
     * Lista que contiene los mensajes de la puerta de enlace
     */
    private List<Mensaje> mensajes;
    /**
     * Lista que contiene los nodos que pertenecen a la puerta de enlace
     */
    private List<Nodo> nodos;

    /**
     * Método constructor para inicializar las variables
     *
     * @param id
     * @param descripcion
     * @param estado
     * @param direccionLogica
     * @param puertoDeServicio
     * @param protocoloComunicacionExterno
     */
    public PuertaDeEnlace(String id, String descripcion, boolean estado, String direccionLogica, String puertoDeServicio, String protocoloComunicacionExterno) {
        this.id = id;
        this.descripcion = descripcion;
        this.estado = estado;
        this.direccionLogica = direccionLogica;
        this.puertoDeServicio = puertoDeServicio;
        this.protocoloComunicacionExterno = protocoloComunicacionExterno;
        this.mensajes = new ArrayList<Mensaje>();
        this.nodos = new ArrayList<Nodo>();
    }

    /**
     * Método para obtener el id de la puerta de enlace
     *
     * @return devuelve la variable id
     */
    public String getId() {
        return id;
    }

    /**
     * Método para inserta id a la puerta de enlace
     *
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Método para obtener la descripción de la puerta de enlace
     *
     * @return devuelve la variable descripción
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Método para inserta descripción a la puerta de enlace
     *
     * @param descripcion
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Método para obtener el estado de la puerta de enlace
     *
     * @return devuelve la variable estado
     */
    public boolean isEstado() {
        return estado;
    }

    /**
     * Método para insertar estado a la puerta de enlace
     *
     * @param estado
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    /**
     * Método para obtener la direccion logica de la puerta de enlace
     *
     * @return devuelve la variable direccionLogica
     */
    public String getDireccionLogica() {
        return direccionLogica;
    }

    /**
     * Método para insertar dirección lógica a la puerta de enlace
     *
     * @param direccionLogica
     */
    public void setDireccionLogica(String direccionLogica) {
        this.direccionLogica = direccionLogica;
    }

    /**
     * Método para obtener puerto de servicio de la puerta de enlace
     *
     * @return
     */
    public String getPuertoDeServicio() {
        return puertoDeServicio;
    }

    /**
     * Método para insertar puerto de servicio a la puerta de enlace
     *
     * @param puertoDeServicio
     */
    public void setPuertoDeServicio(String puertoDeServicio) {
        this.puertoDeServicio = puertoDeServicio;
    }

    /**
     * Método para obtener el protocolo de comunicación de la puerta de enlace
     *
     * @return devuelve la variable protocoloComunicacion
     */
    public String getProtocoloComunicacionExterno() {
        return protocoloComunicacionExterno;
    }

    /**
     * Método para insertar protocolo de comunicación a la puerta de enlace
     *
     * @param protocoloComunicacionExterno
     */
    public void setProtocoloComunicacionExterno(String protocoloComunicacionExterno) {
        this.protocoloComunicacionExterno = protocoloComunicacionExterno;
    }

    /**
     * Método para obtener los nodos de la puerta de enlace
     *
     * @return devuelve la lista nodos
     */
    public List<Nodo> getNodos() {
        return nodos;
    }

    /**
     * Método para insertar nodos a la puerta de enlace
     *
     * @param nodos
     */
    public void setNodos(List<Nodo> nodos) {
        this.nodos = nodos;
    }

    /**
     * Método para obtener los mensajes de la puerta de enlace
     *
     * @return devuelve la lista mensajes
     */
    public List<Mensaje> getMensajes() {
        return mensajes;
    }

    /**
     * Método para insertar mensajes a la puerta de enlace
     *
     * @param mensajes
     */
    public void setMensajes(List<Mensaje> mensajes) {
        this.mensajes = mensajes;
    }

    /**
     * Método para contener las variables en un String
     *
     * @return devuelve cadena de caracteres con las variables
     */
    @Override
    public String toString() {
        return "PuertaDeEnlace{" + "id=" + id + ", descripcion=" + descripcion + ", estado=" + estado + ", direccionLogica=" + direccionLogica + ", puertoDeServicio=" + puertoDeServicio + ", protocoloComunicacionExterno=" + protocoloComunicacionExterno + '}';
    }

}
