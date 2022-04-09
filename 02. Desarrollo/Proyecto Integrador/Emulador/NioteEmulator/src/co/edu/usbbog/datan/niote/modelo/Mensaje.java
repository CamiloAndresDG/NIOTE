/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.datan.niote.modelo;

import java.io.Serializable;
import java.util.Date;

/**
 * Clase que define las variables que integran un Mensaje generado por una
 * puerta de enlace
 *
 * @author Andrés Sánchez, Juan Ochoa, Sebastian Villanueva.
 */
public class Mensaje implements Serializable {

    /**
     * Variable única con la que se va a identificar el mensaje
     */
    private String id;
    /**
     * Variable que contiene la fecha en la que se envía el mensaje
     */
    private Date fecha;
    /**
     * Variable que contiene el tipo de mensaje accion|lectura
     */
    private String tipo;
    /**
     * Variable que contiene el mensaje en formato JSON
     */
    private String mensaje;

    /**
     * Método constructor para inicializar las variables
     *
     * @param id
     * @param fecha
     * @param tipo
     * @param mensaje
     */
    public Mensaje(String id, Date fecha, String tipo, String mensaje) {
        this.id = id;
        this.fecha = fecha;
        this.tipo = tipo;
        this.mensaje = mensaje;
    }

    /**
     * Método para obtener el id del mensaje
     *
     * @return devuelve el id del mensaje
     */
    public String getId() {
        return id;
    }

    /**
     * Método para insertar id del mensaje
     *
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Método para obtener la fecha del mensaje
     *
     * @return devuelve la variable fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * Método para insertar la fecha de un mensaje
     *
     * @param fecha
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * Método para obtener el mensaje
     *
     * @return devuelve la variable mensaje
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * Método para insertar el mensaje
     *
     * @param mensaje
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    /**
     *
     * @return
     */
    public String getTipo() {
        return tipo;
    }

    /**
     *
     * @param tipo
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Método para contener las variables del mensaje en un String
     *
     * @return devuelve una cadena de caracteres con las variables
     */
    @Override
    public String toString() {
        return "Mensaje{" + "id=" + id + ", fecha=" + fecha + ", mensaje=" + mensaje + '}';
    }

}
