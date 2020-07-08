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
 * Clase que representa las variables que integran un Actuador
 *
 * @author Andrés Sánchez, Juan Ochoa, Sebastian Villanueva.
 */
public class Actuador implements Serializable {

    /**
     * Variable irrepetible con la que se identificara el actuador
     */
    private String id;
    /**
     * Descripción del Actuador
     */
    private String descripcion;
    /**
     * Estado del Actuador
     */
    private boolean estado;
    /**
     * Tipo de actuador
     */
    private String tipo;
    /**
     * Lista de acciones que ya se realizaron
     */
    private List<Orden> accionesRealizadas;
    /**
     * Lista de acciones por realizar
     */
    private List<Orden> accionesEnCola;

    /**
     * Método constructor para dar valor a las variables del Actuador
     *
     * @param id
     * @param descripcion
     * @param estado
     * @param tipo
     */
    public Actuador(String id, String descripcion, boolean estado, String tipo) {
        this.id = id;
        this.descripcion = descripcion;
        this.estado = estado;
        this.tipo = tipo;
        this.accionesRealizadas = new ArrayList<Orden>();
        this.accionesEnCola = new ArrayList<Orden>();
    }

    Actuador() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Método para obtener el Id del actuador
     *
     * @return devuelve el id
     */
    public String getId() {
        return id;
    }

    /**
     * Método para almacenar un id a un actuador
     *
     * @param id a almacenar
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Método para obtener la descripción del actuador
     *
     * @return
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Método para almacenar la descripción del actuador
     *
     * @param descripción
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Método para obtener el Estado del actuador
     *
     * @return devuelve la variable estado
     */
    public boolean isEstado() {
        return estado;
    }

    /**
     * Método para almacenar en la variable estado
     *
     * @param estado
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    /**
     * Método para obtener el tipo de actuador
     *
     * @return devuelve la variable tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Método para almacenar en la variable tipo de actuador
     *
     * @param tipo
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Método para obtener la lista de acciones realizadas
     *
     * @return devuelve la variable accionesRealizadas
     */
    public List<Orden> getAccionesRealizadas() {
        return accionesRealizadas;
    }

    /**
     * Método para agregar valores a la lista de acciones realizadas
     *
     * @param accionesRealizadas
     */
    public void setAccionesRealizadas(List<Orden> accionesRealizadas) {
        this.accionesRealizadas = accionesRealizadas;
    }

    /**
     * Método para obtener la lista de acciones en cola
     *
     * @return devuelve accionesEnCola
     */
    public List<Orden> getAccionesEnCola() {
        return accionesEnCola;
    }

    /**
     * Método para agregar valores a la lista de acciones en cola
     *
     * @param accionesEnCola
     */
    public void setAccionesEnCola(List<Orden> accionesEnCola) {
        this.accionesEnCola = accionesEnCola;
    }

    /**
     * Método para contener los valores del actuador en un String
     *
     * @return devuelve el String con las variables del actuador
     */
    @Override
    public String toString() {
        return "Actuador{" + "id=" + id + ", descripcion=" + descripcion + ", estado=" + estado + ", tipo=" + tipo + '}';
    }

}
