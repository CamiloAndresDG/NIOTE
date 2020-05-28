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
 * Clase que contiene las variables que integran una Red
 *
 * @author Andrés Sánchez, Juan Ochoa, Sebastian Villanueva.
 */
public class Red implements Serializable {

    /**
     * Variable única para identificar la red
     */
    private String id;
    /**
     * Variable que contiene el nombre de la Red
     */
    private String nombre;
    /**
     * Variable que contiene la descripción de la Red
     */
    private String descripcion;
    /**
     * Lista de las puertas de enlace de la red
     */
    private List<PuertaDeEnlace> puertasDeEnlace;

    /**
     * Método constructor para inicializar las variables
     *
     * @param id
     * @param nombre
     * @param descripcion
     */
    public Red(String id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.puertasDeEnlace = new ArrayList<PuertaDeEnlace>();
    }

    /**
     * Método para obtener el id de la Red
     *
     * @return devuelve la variable id
     */
    public String getId() {
        return id;
    }

    /**
     * Método para insertar id a la Red
     *
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Método para obtener el nombre de la Red
     *
     * @return devuelve la variable nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método para insertar nombre a la Red
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método para obtener la descripción de la Red
     *
     * @return devuelve la variable descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Método para insertar descripción a la Red
     *
     * @param descripcion
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Método para obtener las Puertas de enlace de la red
     *
     * @return devuelve la lista puertasDeEnlace
     */
    public List<PuertaDeEnlace> getPuertasDeEnlace() {
        return puertasDeEnlace;
    }

    /**
     * Método para insertar puertas de enlace a la Red
     *
     * @param puertasDeEnlace
     */
    public void setPuertasDeEnlace(List<PuertaDeEnlace> puertasDeEnlace) {
        this.puertasDeEnlace = puertasDeEnlace;
    }

    /**
     * Método para contener las variables en un String
     *
     * @return devuelve cadena de caracteres con las variables
     */
    @Override
    public String toString() {
        return "Red{" + "id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + '}';
    }

}
