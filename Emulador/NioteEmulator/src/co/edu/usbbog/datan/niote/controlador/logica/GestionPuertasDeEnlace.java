/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.datan.niote.controlador.logica;

import co.edu.usbbog.datan.niote.modelo.PuertaDeEnlace;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase para crear, eliminar, buscar y ver puertas de enlace
 *
 * @author Andrés Sánchez, Juan Ochoa, Sebastian Villanueva.
 */
public class GestionPuertasDeEnlace implements Serializable {

    /**
     * Variable para guardar la lista de puertas de enlace
     */
    private List<PuertaDeEnlace> puertasDeEnlace;

    /**
     * Método para gestionar las puertas de enlace dentro de la lista
     *
     * @param puertasDeEnlace lista de puertas de enlace
     */
    public GestionPuertasDeEnlace(List<PuertaDeEnlace> puertasDeEnlace) {
        this.puertasDeEnlace = puertasDeEnlace;
    }

    /**
     * Método constructor de la clase GestionPuertasDeEnlace
     */
    public GestionPuertasDeEnlace() {
        this.puertasDeEnlace = new ArrayList<>();
    }

    /**
     * Método para obtener los valores dentro de la lista de puertas de enlace
     *
     * @return retorna la información almacenada dentro del objeto Puerta de
     * enlace
     */
    public List<PuertaDeEnlace> getPuertasDeEnlace() {
        return puertasDeEnlace;
    }

    /**
     * Método para colocar información dentro del objeto Puertas de enlace
     *
     * @param puertasDeEnlace
     */
    public void setPuertasDeEnlace(List<PuertaDeEnlace> puertasDeEnlace) {
        this.puertasDeEnlace = puertasDeEnlace;
    }

    /**
     * Método para ver todas las puertas de enlace
     *
     * @return retorna un string que me muestra la lista de puertas de enlace
     * que hay
     */
    public String verPuertasDeEnlace() {
        String salida = "";
        for (PuertaDeEnlace puertaDeEnlace : puertasDeEnlace) {
            salida += salida + puertaDeEnlace.toString() + "\n";
        }
        return salida;
    }

    /**
     * Método para ver la puerta de enlace por un id
     *
     * @param id id de la puerta de enlace que se va a consultar
     * @return retorna un string para visualizar la información de la puerta de
     * enlace que se quiere consultar
     */
    public String verPuertaDeEnlacePorID(String id) {
        String salida = "";
        if (existePuertaDeEnlacePorID(id)) {
            for (PuertaDeEnlace puertaDeEnlace : puertasDeEnlace) {
                if (puertaDeEnlace.getId().equals(id)) {
                    salida = puertaDeEnlace.toString() + "\n";
                }
            }
        } else {
            salida = "No existe la puerta de enlace";
        }
        return salida;
    }

    /**
     * Método para la creación de una puerta de enlace
     *
     * @param id identificación para la nueva puerta de enlace
     * @param descripcion información de la nueva puerta de enlace
     * @param estado si esta activa o desactivada la pueta de enlace
     * @param direccionLogica dirección ip del dispositivo
     * @param puertoDeServicio canal de comunicación de la pueta de enlace
     * @param protocoloComunicacionExterno tipo de protocolo de transferencia de
     * información
     * @return retorna un string que visualizar el objeto
     */
    public String crearPuertaDeEnlace(String id, String descripcion, boolean estado, String direccionLogica, String puertoDeServicio, String protocoloComunicacionExterno) {
        PuertaDeEnlace puertaDeEnlace = new PuertaDeEnlace(id, descripcion, estado, direccionLogica, puertoDeServicio, protocoloComunicacionExterno);
        if (existePuertaDeEnlacePorID(id)) {
            return "la puerta de enlace ya existe";
        } else {
            puertasDeEnlace.add(puertaDeEnlace);
            return "la puerta de enlace con ID: " + id + " se agregó";
        }
    }

    /**
     * Método para la eliminación de una puerta de enlace
     *
     * @param id id de la puerta de enlace que se va a eliminar
     * @return retorna un mensaje de confirmación o que no se pui
     */
    public String eliminarPuertaDeEnlacePorID(String id) {
        if (existePuertaDeEnlacePorID(id)) {
            PuertaDeEnlace puertaDeEnlace = buscarPuertaDeEnlacePorID(id);
            puertasDeEnlace.remove(puertaDeEnlace);
            return "la puerta de enlace se eliminó";
        } else {
            return "la puerta de enlace con ID: " + id + " no se eliminó";
        }
    }

    /**
     * Método para confirmar que existe una puerta de enlace
     *
     * @param id id para confirmar si esa puerta de enlace está dentro de la
     * lista de puertas de enlace
     * @return
     */
    public boolean existePuertaDeEnlacePorID(String id) {
        return puertasDeEnlace.stream().anyMatch((puertaDeEnlace) -> (puertaDeEnlace.getId().equals(id)));
    }

    /**
     * Método para buscar una puerta de enlace por su id
     *
     * @param id id de la puerta de enlace que se va a consultar
     * @return nos regresa un objeto de tipo puerta de enlace
     */
    public PuertaDeEnlace buscarPuertaDeEnlacePorID(String id) {
        for (PuertaDeEnlace puertaDeEnlace : puertasDeEnlace) {
            if (puertaDeEnlace.getId().equals(id)) {
                return puertaDeEnlace;
            }
        }
        return null;
    }

    /**
     * Método para modificar una puerta de enlace por su id
     *
     * @param id id de la puerta de enlace a modificar
     * @param descripcion nueva descripción de la puerta de enlace que se va a
     * modificar
     * @param direccionLogica nueva dirección ip de la puerta de enlace que se
     * va a modificar
     * @param puertoDeServicio nuevo puerto de servicio de la puerta de enlace
     * @param protocoloComunicacionExterno nuevo protocolo de comunicación de la
     * puerta de enlace que se va a modificar
     * @return retorna una confirmación de si existe la puerta de enlace, sino
     * confirma que si se modificó la puerta de enlace en un string
     */
    public String modificarPuertaDeEnlacePorID(String id, String descripcion, String direccionLogica, String puertoDeServicio, String protocoloComunicacionExterno) {
        if (buscarPuertaDeEnlacePorID(id) == null) {
            return "La puerta de enlace no existe";
        } else {
            PuertaDeEnlace modificarPuertaDeEnlace = buscarPuertaDeEnlacePorID(id);
            modificarPuertaDeEnlace.setDescripcion(descripcion);
            modificarPuertaDeEnlace.setDireccionLogica(direccionLogica);
            modificarPuertaDeEnlace.setPuertoDeServicio(puertoDeServicio);
            modificarPuertaDeEnlace.setPuertoDeServicio(puertoDeServicio);
            modificarPuertaDeEnlace.setProtocoloComunicacionExterno(protocoloComunicacionExterno);
            return "La puerta de enlace con ID " + id + " se ha modificado";
        }

    }
    
}
