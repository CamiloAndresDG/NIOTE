/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.datan.niote.controlador.logica;

import co.edu.usbbog.datan.niote.modelo.Sensor;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase para crear, eliminar, buscar y ver sensores
 *
 * @author Andrés Sánchez, Juan Ochoa, Sebastian Villanueva.
 */
public class GestionSensores implements Serializable {

    /**
     * Lista para almacenar cada sensor que se cree
     */
    private List<Sensor> sensores;

    /**
     * Constructor para la lista de sensores
     *
     * @param sensores variable que contiene la lista
     */
    public GestionSensores(List<Sensor> sensores) {
        this.sensores = sensores;
    }

    /**
     * Constructor de la clase
     */
    public GestionSensores() {
        this.sensores = new ArrayList<>();
    }

    /**
     * Obtener elementos de la lista
     *
     * @return elementos
     */
    public List<Sensor> getSensores() {
        return sensores;
    }

    /**
     * Poner nuevos valores en la lista
     *
     * @param sensores variable que contiene la lista
     */
    public void setSensores(List<Sensor> sensores) {
        this.sensores = sensores;
    }

    /**
     * Método para ver todos los sensores creados
     *
     * @return Todos los sensores que existen
     */
    public String verSensores() {

        String salida = "";
        for (Sensor sensore : sensores) {
            salida += salida + sensore.toString();
        }
        return salida;
    }

    /**
     * Ver sensor con un id especifico
     *
     * @param id campo único con el que se identifica el sensor
     * @return sensor que coincide con el id
     */
    public String verSensorPorID(String id) {
        String salida = "";

        if (existeSensorPorID(id)) {
            for (Sensor sensore : sensores) {
                if (sensore.getId().equals(id)) {
                    salida += salida + sensore.toString();
                }
            }
        } else {

            salida = "El nodo no existe";
        }

        return salida;
    }

    /**
     * Método para crear un nuevo sensor
     *
     * @param id campo único para identificar el sensor
     * @param descripcion descripción del sensor
     * @param estado activo o inactivo
     * @param tipo tipo de sensor
     * @param magnitud
     * @param frecuencia
     * @return se creó o ya existe
     */
    public String crearSensor(String id, String descripcion, boolean estado, String tipo, String magnitud, int frecuencia) {
        String salida = "";
        if (existeSensorPorID(id)) {
            salida = "El sensor ya existe";
        } else {
            Sensor sensor = new Sensor(id, descripcion, estado, tipo, magnitud, frecuencia);
            sensores.add(sensor);
            salida = "El sensor con id " + id + " se agregó";
        }
        return salida;
    }

    /**
     * Método para verificar si existe un sensor con id especifico
     *
     * @param id campo único con el que se identifica el sensor
     * @return true = existe, false = no existe
     */
    public boolean existeSensorPorID(String id) {

        if (sensores.stream().anyMatch((sensore) -> (sensore.getId().equals(id)))) {
            return true;
        }
        return false;
    }

    /**
     * Método para buscar un sensor con id especifico
     *
     * @param id campo único con el que se identifica el sensor
     * @return sensor que coincide con el id
     */
    public Sensor buscarSensorPorID(String id) {

        for (Sensor sensore : sensores) {
            if (sensore.getId().equals(id)) {
                return sensore;
            }
        }
        return null;
    }

    /**
     * Método para modificar las especificaciones de un sensor
     *
     * @param id campo único con que el que se identifica el sensor
     * @param descripcion descripción del sensor
     * @param tipo tipo de sensor
     * @return se modificó o no existe
     */
    public String modificarSensorPorID(String id, String descripcion, String tipo) {

        if (existeSensorPorID(id)) {
            Sensor sensor = buscarSensorPorID(id);
            sensor.setDescripcion(descripcion);
            sensor.setTipo(tipo);
            return "El sensor se modificó";
        } else {
            return "El sensor con ID " + id + " no existe";
        }
    }

    /**
     * Método para eliminar un sensor de la lista}
     *
     * @param id campo único con el que se identifica el sensor
     * @return se eliminó o no existe
     */
    public String eliminarSensorPorID(String id) {

        if (existeSensorPorID(id)) {

            Sensor sensor = buscarSensorPorID(id);
            sensores.remove(sensor);
            return "El sensor se eliminó";
        } else {
            return "El sensor con ID " + id + " no existe";
        }

    }
    
}
