/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package red.nodos.ubicuos;

import java.util.Date;

/**
 *
 * @author Andres Sanchez
 */

public class ServiciosSensor {
    public static void enviarEvetosTemperatura(String topico, String mensaje) {
        String[] mensajes = separarMensaje(mensaje);
        
        String contenido = mensajes[0].trim();
        String valor = mensajes[1].trim();
        
        String visto="NO";
        String publicado="NO"; 
         //System.out.println("SENSOR"+ valor+ "Nodo TCP:Socket 192.168.0.108:1234"+ "1"+ "TmpDS18B20DeviceType"+ contenido+ new Date().toLocaleString()+ visto+ publicado);
       
        try {
            agregarEventos("Sensor", valor, "Nodo MQTT:"+topico, "1", "TmpDS18B20DeviceType", contenido, new Date().toLocaleString(), visto, publicado);
            //System.out.println("SENSOR"+ valor+ "Nodo TCP:Socket 192.168.0.108:1234"+ "1"+ "TmpDS18B20DeviceType"+ contenido+ new Date().toLocaleString()+ visto+ publicado);
        } catch (javax.xml.ws.WebServiceException e) {
            System.out.println("Error al publicar informacion " + e.getMessage());
        }       
    }
    
    public void enviarEvetosTelevisor(String mensaje, Boolean estado) {
        
        String contenido = mensaje;
        String valor = estado.toString();
        
        String visto="NO";
        String publicado="NO";        
        try {
            agregarEventos("Actuador", valor, "Nodo TCP:Socket 192.168.0.108:1234", "1", "GPIO_05:LED", contenido, new Date().toLocaleString(), visto, publicado);
            //System.out.println("SENSOR"+ valor+ "Nodo TCP:Socket 192.168.0.108:1234"+ "1"+ "TmpDS18B20DeviceType"+ contenido+ new Date().toLocaleString()+ visto+ publicado);
        } catch (javax.xml.ws.WebServiceException e) {
            System.out.println("Error al publicar informacion " + e.getMessage());
        }       
    }
    
    public static String[] separarMensaje(String mensaje){
        return mensaje.split(":");
    }    

    private static void agregarEventos(java.lang.String tipoAccion, java.lang.String valor, java.lang.String tipoNodo, java.lang.String idObjeto, java.lang.String objeto, java.lang.String contenido, java.lang.String fecha, java.lang.String visto, java.lang.String publicado) {
        red.nodos.ubicuos.ws.RNUWS_Service service = new red.nodos.ubicuos.ws.RNUWS_Service();
        red.nodos.ubicuos.ws.RNUWS port = service.getRNUWSPort();
        port.agregarEventos(tipoAccion, valor, tipoNodo, idObjeto, objeto, contenido, fecha, visto, publicado);
    }
    
}
