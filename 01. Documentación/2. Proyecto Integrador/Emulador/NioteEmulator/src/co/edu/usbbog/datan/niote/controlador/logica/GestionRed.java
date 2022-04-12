/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.datan.niote.controlador.logica;

import co.edu.usbbog.datan.niote.controlador.persistencia.ArchivoDeConfiguracionDeRed;
import co.edu.usbbog.datan.niote.modelo.Actuador;
import co.edu.usbbog.datan.niote.modelo.Nodo;
import co.edu.usbbog.datan.niote.modelo.PuertaDeEnlace;
import co.edu.usbbog.datan.niote.modelo.Red;
import co.edu.usbbog.datan.niote.modelo.Sensor;
import java.io.Serializable;

/**
 * Clase para crear y configurar una red y sus componentes
 *
 * @author Andrés Sánchez, Juan Ochoa, Sebastian Villanueva.
 */
public class GestionRed implements Serializable {

    /**
     * Variable de tipo Red para guardar la red
     */
    private Red red;

    /**
     * Variable que llama a la clase ArchivoDeConfiguracionDeRed
     */
    private ArchivoDeConfiguracionDeRed archivoDeConfiguracionDeRed;

    //relaciones
    /**
     * Variable que llama a la clase GestionPuertasDeEnlace
     */
    private GestionPuertasDeEnlace gestionPuertasDeEnlace;
    /**
     * Variable que llama a la clase GestionNodos
     */
    private GestionNodos gestionNodos;
    /**
     * Variable que llama a la clase GestionActuadores
     */
    private GestionActuadores gestionActuadores;
    /**
     * Variable que llama a la clase GestionSensores
     */
    private GestionSensores gestionSensores;

    /**
     * Método constructor para crear una nueva red
     *
     * @param id de la red
     * @param nombre de la red
     * @param descripcion de la red
     */
    public GestionRed(String id, String nombre, String descripcion) {
        this.red = new Red(id, nombre, descripcion);
        this.archivoDeConfiguracionDeRed = new ArchivoDeConfiguracionDeRed();
        this.gestionPuertasDeEnlace = new GestionPuertasDeEnlace();
        this.gestionNodos = new GestionNodos();
        this.gestionActuadores = new GestionActuadores();
        this.gestionSensores = new GestionSensores();
    }

    /**
     * Método constructor para abrir una red guardad en un archivo
     *
     * @param ruta en la que se encuentra el archivo
     * @param nombreArchivo nombre del archivo
     */
    public GestionRed(String ruta, String nombreArchivo) {
        this.archivoDeConfiguracionDeRed = new ArchivoDeConfiguracionDeRed(ruta, nombreArchivo);
        this.gestionPuertasDeEnlace = this.archivoDeConfiguracionDeRed.cargarPuertasDeEnlace();
        this.gestionNodos = this.archivoDeConfiguracionDeRed.cargarNodos();
        this.gestionActuadores = this.archivoDeConfiguracionDeRed.cargarActuadores();
        this.gestionSensores = this.archivoDeConfiguracionDeRed.cargarSensores();
        this.red = this.archivoDeConfiguracionDeRed.cargarRed();
    }

    /**
     * Método para obtener los valores dentro de la variable red
     *
     * @return devuelve la variable red
     */
    public Red getRed() {
        return red;
    }

    /**
     * Método para almacenar información dentro de la variable red
     *
     * @param red variable de tipo Red
     */
    public void setRed(Red red) {
        this.red = red;
    }

    /**
     * Método para obtener la información dentro de la variable gestionNodos
     *
     * @return devuelve la variable gestionNodos
     */
    public GestionNodos getGestionNodo() {
        return gestionNodos;
    }

    /**
     * Método para obtener la información dentro de la variable
     * gestionActuadores
     *
     * @return devuelve la variable gestionActuadores
     */
    public GestionActuadores getGestionActuadores() {
        return gestionActuadores;
    }

    /**
     * Método para obtener la información dentro de la variable gestionSensores
     *
     * @return devuelve la variable gestionSensores
     */
    public GestionSensores getGestionSensores() {
        return gestionSensores;
    }

    /**
     * Método para obtener la información dentro de la variable
     * gestionPuertasDeEnlace
     *
     * @return devuelve la variable gestionPuertasDeEnlace
     */
    public GestionPuertasDeEnlace getGestionPuertaDeEnlace() {
        return gestionPuertasDeEnlace;
    }

    /**
     * Método para ver Todos los objetos que contiene la red
     *
     * @return devuelve una variable de tipo String con todos los componentes de
     * la red
     */
    public String verRed() {
        String salida = "Las puertas de enlace de la red " + getRed().getNombre() + "son:\n";
        pe:
        for (PuertaDeEnlace puertaDeEnlace : getRed().getPuertasDeEnlace()) {
            salida += puertaDeEnlace.toString() + "\\>\n";
            if (!puertaDeEnlace.getNodos().isEmpty()) {
                salida += "Nodos:\n";
            }
            n:
            for (Nodo nodo : puertaDeEnlace.getNodos()) {
                salida += "\t" + nodo.toString() + ":\n";
                if (!nodo.getActuadores().isEmpty()) {
                    salida += "\tActuadores:\n";
                }
                a:
                for (Actuador actuador : nodo.getActuadores()) {
                    salida += "\t\t" + actuador.toString() + ":\n";
                }
                if (!nodo.getActuadores().isEmpty()) {
                    salida += "\tSensores:\n";
                }
                s:
                for (Sensor sensor : nodo.getSensores()) {
                    salida += "\t\t" + sensor.toString() + ":\n";
                }
            }
        }
        return salida;
    }

    /**
     * Método para agregar una puerta de enlace a la red
     *
     * @param idPuertaDeEnlace id de la puerta de enlace que se va a agregar
     * @return devuelve true=se agregó o false=no se agrego
     */
    public boolean agregarPuertaDeEnlaceALaRed(String idPuertaDeEnlace) {
        PuertaDeEnlace puertaDeEnlace = getGestionPuertaDeEnlace().buscarPuertaDeEnlacePorID(idPuertaDeEnlace);
        if (puertaDeEnlace != null) {
            getGestionPuertaDeEnlace().eliminarPuertaDeEnlacePorID(idPuertaDeEnlace);
            PuertaDeEnlace puertaDeEnlaceEnLaRed = buscarPuertaDeEnlaceDeLaRedPorID(puertaDeEnlace.getId());
            if (puertaDeEnlaceEnLaRed != null) {
                return true;
            } else {
                getRed().getPuertasDeEnlace().add(puertaDeEnlace);
                return true;
            }
        } else {
            return false;
        }
    }

    /**
     * Método para ver las puertas de enlace de la red
     *
     * @return devuelve una variable de tipo String que contiene las puertas de
     * enlace
     */
    public String verPuertasDeEnlaceDeLaRed() {
        String salida = "la red " + getRed().getNombre() + "tiene:\n";
        for (PuertaDeEnlace puertaDeEnlace : getRed().getPuertasDeEnlace()) {
            salida += puertaDeEnlace.toString() + "\n";
        }
        return salida;
    }

    /**
     * Método para buscar una puerta de enlace dentro de la red
     *
     * @param idPuertaDeEnlace id de la puerta de enlace que se va a buscar
     * @return devuelve la puerta de enlace si existe el id, de lo contrario
     * devuelve null
     */
    public PuertaDeEnlace buscarPuertaDeEnlaceDeLaRedPorID(String idPuertaDeEnlace) {
        for (PuertaDeEnlace puertaDeEnlace : getRed().getPuertasDeEnlace()) {
            if (puertaDeEnlace.getId().equals(idPuertaDeEnlace)) {
                return puertaDeEnlace;
            }
        }
        return null;
    }

    /**
     * Método para remover una puerta de enlace de la red
     *
     * @param idPuertaDeEnlace id de la puerta de enlace que se va a remover
     * @return devuelve true = se eliminó o false = no se elimino
     */
    public boolean removerPuertaDeEnlaceDeLaRed(String idPuertaDeEnlace) {
        PuertaDeEnlace puertaDeEnlace = buscarPuertaDeEnlaceDeLaRedPorID(idPuertaDeEnlace);
        if (puertaDeEnlace != null) {
            for (Nodo nodo : puertaDeEnlace.getNodos()) {
                removerNodoDeLaRed(nodo.getId());
            }
            if (getRed().getPuertasDeEnlace().remove(puertaDeEnlace)) {
                getGestionPuertaDeEnlace().crearPuertaDeEnlace(puertaDeEnlace.getId(), puertaDeEnlace.getDescripcion(), false, puertaDeEnlace.getDireccionLogica(), puertaDeEnlace.getPuertoDeServicio(), puertaDeEnlace.getProtocoloComunicacionExterno());
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * Método para agregar un nodo a la red
     *
     * @param idNodo id del nodo que se va a agregar
     * @param idPuertaDeEnlace id de la puerta de enlace a la que va a
     * pertenecer
     * @return devuelve true = se agregó o false = no se agrego
     */
    public boolean agregarNodoALaRed(String idNodo, String idPuertaDeEnlace) {
        Nodo nodo = getGestionNodo().buscarNodoPorID(idNodo);
        if (nodo != null) {
            getGestionNodo().eliminarNodoPorID(idNodo);
            Nodo nodoEnRed = buscarNodoDeLaRedPorID(nodo.getId());
            if (nodoEnRed != null) {
                return true;
            } else {
                for (int i = 0; i < getRed().getPuertasDeEnlace().size(); i++) {
                    if (getRed().getPuertasDeEnlace().get(i).getId().equals(idPuertaDeEnlace)) {
                        getRed().getPuertasDeEnlace().get(i).getNodos().add(nodo);
                        return true;
                    }
                }
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * Método para ver los nodos que pertenecen a la red
     *
     * @return devuelve una variable de tipo String con los nodos de la red
     */
    public String verNodosDeLaRed() {
        String salida = "";
        pe:
        for (PuertaDeEnlace puertaDeEnlace : getRed().getPuertasDeEnlace()) {
            salida += "en: " + puertaDeEnlace.getId() + " estan:\n";
            n:
            for (Nodo nodo : puertaDeEnlace.getNodos()) {
                salida += "\t" + nodo.toString() + "\n";
            }
        }
        return salida;
    }

    /**
     * Método para buscar un nodo de la red mediante su id
     *
     * @param idNodo id del nodo a buscar
     * @return devuelve el nodo si se encontró o null si no se encontró
     */
    public Nodo buscarNodoDeLaRedPorID(String idNodo) {
        for (PuertaDeEnlace puertaDeEnlace : getRed().getPuertasDeEnlace()) {
            for (Nodo nodo : puertaDeEnlace.getNodos()) {
                if (nodo.getId().equals(idNodo)) {
                    return nodo;
                }
            }
        }
        return null;
    }

    /**
     * Método para remover nodo de la red
     *
     * @param idNodo id del nodo que se va a remover
     * @return devuelve true = se removió o false = no se removió
     */
    public boolean removerNodoDeLaRed(String idNodo) {
        Nodo nodo = buscarNodoDeLaRedPorID(idNodo);
        if (nodo != null) {
            for (Actuador actuador : nodo.getActuadores()) {
                removerActuadorDeLaRed(actuador.getId());
            }
            for (Sensor sensor : nodo.getSensores()) {
                removerSensorDeLaRed(sensor.getId());
            }
            pe:
            for (int i = 0; i < getRed().getPuertasDeEnlace().size(); i++) {
                if (getRed().getPuertasDeEnlace().get(i).getNodos().remove(nodo)) {
                    getGestionNodo().crearNodo(nodo.getId(), nodo.getDescripcion(), false, nodo.getProtocoloComunicacion());
                    return true;
                }
            }
            return false;
        } else {
            return false;
        }
    }

    /**
     * Método para agregar sensor a la red
     *
     * @param idSensor id del sensor que se va a agregar
     * @param idNodo id del nodo al que va a pertenecer
     * @return devuelve true = se agregó o false = no se agrego
     */
    public boolean agregarSensorALaRed(String idSensor, String idNodo) {
        Sensor sensor = getGestionSensores().buscarSensorPorID(idSensor);
        if (sensor != null) {
            getGestionSensores().eliminarSensorPorID(idSensor);
            Sensor sensorEnLaRed = buscarSensorDeLaRedPorID(sensor.getId());
            if (sensorEnLaRed != null) {
                return true;
            } else {
                for (int i = 0; i < getRed().getPuertasDeEnlace().size(); i++) {
                    for (int j = 0; j < getRed().getPuertasDeEnlace().get(i).getNodos().size(); j++) {
                        if (getRed().getPuertasDeEnlace().get(i).getNodos().get(j).getId().equals(idNodo)) {
                            getRed().getPuertasDeEnlace().get(i).getNodos().get(j).getSensores().add(sensor);
                            return true;
                        }
                    }
                }
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * Método para ver los sensores de la red
     *
     * @return devuelve variable de tipo String con los sensores de la red
     */
    public String verSensoresDeLaRed() {
        String salida = "";
        pe:
        for (PuertaDeEnlace puertaDeEnlace : getRed().getPuertasDeEnlace()) {
            salida += "en: " + puertaDeEnlace.getId() + " estan:\n";
            n:
            for (Nodo nodo : puertaDeEnlace.getNodos()) {
                salida += "\ten: " + nodo.getId() + " estan:\n";
                s:
                for (Sensor sensor : nodo.getSensores()) {
                    salida += "\t\t" + sensor.toString() + "\n";
                }
            }
        }
        return salida;
    }

    /**
     * Método para buscar un sensor mediante su id
     *
     * @param idSensor id del sensor que se va a buscar
     * @return devuelve el sensor si se encontró, de lo contrario devuelve null
     */
    public Sensor buscarSensorDeLaRedPorID(String idSensor) {
        for (PuertaDeEnlace puertaDeEnlace : getRed().getPuertasDeEnlace()) {
            for (Nodo nodo : puertaDeEnlace.getNodos()) {
                for (Sensor sensor : nodo.getSensores()) {
                    if (sensor.getId().equals(idSensor)) {
                        return sensor;
                    }
                }
            }
        }
        return null;
    }

    /**
     * Método para remover un sensor de la red
     *
     * @param idSensor id del sensor que se va a remover
     * @return devuelve true = se removió o false = no se removió
     */
    public boolean removerSensorDeLaRed(String idSensor) {
        Sensor sensor = buscarSensorDeLaRedPorID(idSensor);
        if (sensor != null) {
            pe:
            for (int i = 0; i < getRed().getPuertasDeEnlace().size(); i++) {
                n:
                for (int j = 0; j < getRed().getPuertasDeEnlace().get(i).getNodos().size(); j++) {
                    if (getRed().getPuertasDeEnlace().get(i).getNodos().get(j).getSensores().remove(sensor)) {
                        getGestionSensores().crearSensor(sensor.getId(), sensor.getDescripcion(), false, sensor.getTipo(), sensor.getMagnitud(), sensor.getFrecuencia());
                        return true;
                    }
                }
            }
            return false;
        } else {
            return false;
        }
    }

    /**
     * Método para agregar un actuador en la red
     *
     * @param idActuador id del actuador que se va a agregar
     * @param idNodo id del nodo al que va a pertenecer
     * @return devuelve true = se agregó o false = no se agrego
     */
    public boolean agregarActuadorALaRed(String idActuador, String idNodo) {
        Actuador actuador = getGestionActuadores().buscarActuadorPorID(idActuador);
        if (actuador != null) {
            getGestionActuadores().eliminarActuadorPorID(idActuador);
            Actuador actuadorEnLaRed = buscarActuadorDeLaRedPorID(actuador.getId());
            if (actuadorEnLaRed != null) {
                return true;
            } else {
                for (int i = 0; i < getRed().getPuertasDeEnlace().size(); i++) {
                    for (int j = 0; j < getRed().getPuertasDeEnlace().get(i).getNodos().size(); j++) {
                        if (getRed().getPuertasDeEnlace().get(i).getNodos().get(j).getId().equals(idNodo)) {
                            getRed().getPuertasDeEnlace().get(i).getNodos().get(j).getActuadores().add(actuador);
                            return true;
                        }
                    }
                }
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * Método para ver los Actuadores de la red
     *
     * @return variable de tipo String que contiene los actuadores
     */
    public String verActuadorDeLaRed() {
        String salida = "";
        pe:
        for (PuertaDeEnlace puertaDeEnlace : getRed().getPuertasDeEnlace()) {
            salida += "en: " + puertaDeEnlace.getId() + " estan:\n";
            n:
            for (Nodo nodo : puertaDeEnlace.getNodos()) {
                salida += "\ten: " + nodo.getId() + " estan:\n";
                a:
                for (Actuador actuador : nodo.getActuadores()) {
                    salida += "\t\t" + actuador.toString() + "\n";
                }
            }
        }
        return salida;
    }

    /**
     * Método para buscar actuador de la red por id
     *
     * @param idActuador id del actuador que se va a buscar
     * @return devuelve el actuador si se encontró, de lo contrario devuelve
     * null
     */
    public Actuador buscarActuadorDeLaRedPorID(String idActuador) {
        for (PuertaDeEnlace puertaDeEnlace : getRed().getPuertasDeEnlace()) {
            for (Nodo nodo : puertaDeEnlace.getNodos()) {
                for (Actuador actuador : nodo.getActuadores()) {
                    if (actuador.getId().equals(idActuador)) {
                        return actuador;
                    }
                }
            }
        }
        return null;
    }

    /**
     * Método para Remover Actuador de la red
     *
     * @param idActuador id del actuador que se va a remover
     * @return devuelve true = se removió o false = no se removió
     */
    public boolean removerActuadorDeLaRed(String idActuador) {
        Actuador actuador = buscarActuadorDeLaRedPorID(idActuador);
        if (actuador != null) {
            pe:
            for (int i = 0; i < getRed().getPuertasDeEnlace().size(); i++) {
                n:
                for (int j = 0; j < getRed().getPuertasDeEnlace().get(i).getNodos().size(); j++) {
                    if (getRed().getPuertasDeEnlace().get(i).getNodos().get(j).getActuadores().remove(actuador)) {
                        getGestionActuadores().crearActuador(actuador.getId(), actuador.getDescripcion(), false, actuador.getTipo());
                        return true;
                    }
                }
            }
            return false;
        } else {
            return false;
        }
    }

    /**
     * Método para guardar la red como archivo
     *
     * @param ruta en la que se quiere guardar el archivo
     * @param nombreArchivo nombre del archivo que se va a crear
     * @return devuelve true = se guardó o false = no se guardo
     */
    public boolean guardarRed(String ruta, String nombreArchivo) {
        archivoDeConfiguracionDeRed = new ArchivoDeConfiguracionDeRed(ruta, nombreArchivo, this);
        if (archivoDeConfiguracionDeRed != null) {
            return true;
        } else {
            return false;
        }
    }
    
}
