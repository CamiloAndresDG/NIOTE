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
 * Clase que contiene las variables que integran un Sensor
 *
 * @author Andrés Sánchez, Juan Ochoa, Sebastian Villanueva.
 */
public class Sensor implements Serializable {

    /**
     * variable irrepetible con la que se identificara el sensor
     */
    private String id;
    /**
     * Descripción del sensor
     */
    private String descripcion;
    /**
     * Estado del Sensor
     */
    private boolean estado;
    /**
     * Tipo de Sensor
     */
    private String tipo;
    /**
     * Magnitud del dato que genera
     */
    private String magnitud;
    /**
     * Frecuencia de generacion de datos del Sensor
     */
    private int frecuencia;
    /**
     * Lista de datos generados por el sensor
     */
    private List<Dato> datosGenerados;

    /**
     * Método constructor para inicializar las variables
     *
     * @param id
     * @param descripcion
     * @param estado
     * @param tipo
     */
    public Sensor(String id, String descripcion, boolean estado, String tipo, String magnitud, int frecuencia) {
        this.id = id;
        this.descripcion = descripcion;
        this.estado = estado;
        this.tipo = tipo;
        this.magnitud = magnitud;
        this.frecuencia = frecuencia;
        this.datosGenerados = new ArrayList<Dato>();
    }

    /**
     * Método para obtener el id del sensor
     *
     * @return devuelve la variable id
     */
    public String getId() {
        return id;
    }

    /**
     * Método para insertar id al sensor
     *
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Método para obtener la descripción del sensor
     *
     * @return devuelve la variable descripción
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Método para insertar descripción al sensor
     *
     * @param descripcion
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Método para obtener el estado del sensor
     *
     * @return devuelve la variable estado
     */
    public boolean isEstado() {
        return estado;
    }

    /**
     * Método para insertar estado al sensor
     *
     * @param estado
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    /**
     * Método para obtener el tipo de sensor
     *
     * @return devuelve la variable tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Método para insertar el tipo de sensor
     *
     * @param tipo
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Método para obtener el magnitud del dato que genera
     *
     * @return devuelve la variable magnitud
     */
    public String getMagnitud() {
        return magnitud;
    }

    /**
     * Método para insertar el magnitud del dato que genera
     *
     * @param magnitud
     */
    public void setMagnitud(String magnitud) {
        this.magnitud = magnitud;
    }

    /**
     *
     * @param frecuencia
     */
    public void setFrecuencia(int frecuencia) {
        this.frecuencia = frecuencia;
    }

    /**
     *
     * @return
     */
    public int getFrecuencia() {
        return frecuencia;
    }

    /**
     * Método para obtener los datos generados por el sensor
     *
     * @return devuelve la lista datosGenerados
     */
    public List<Dato> getDatosGenerados() {
        return datosGenerados;
    }

    /**
     * Método para insertar los datos generados por el sensor
     *
     * @param datosGenerados
     */
    public void setDatosGenerados(List<Dato> datosGenerados) {
        this.datosGenerados = datosGenerados;
    }

    /**
     * Método para contener en un String las variables
     *
     * @return devuelve cadena de caracteres con las variables
     */
    @Override
    public String toString() {
        return "Sensor{" + "id=" + id + ", descripcion=" + descripcion + ", estado=" + estado + ", tipo=" + tipo + ", magnitud=" + magnitud + ", frecuencia=" + frecuencia + '}';
    }

}
