/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package red.nodos.ubicuos;

import javax.jws.WebService;
import javax.jws.WebMethod;
import red.nodos.ubicuos.util.ControladorLed;

/**
 *
 * @author Andres Sanchez
 */
@WebService(serviceName = "ServicioActuador")
public class ServicioActuador {
    ControladorLed controladorLed;
    
    ServiciosSensor serviciosSensor;
    /**
     * Web service operation
     * @return 
     */
    @WebMethod(operationName = "PrenderLed")
    public Boolean prenderLed() {
        controladorLed = new ControladorLed();
        serviciosSensor = new ServiciosSensor();
        boolean estado= controladorLed.encender();
        serviciosSensor.enviarEvetosTelevisor("Televisor Encendido", estado);
        return estado;
    }
    
    /**
     * Web service operation
     * @return 
     */
    @WebMethod(operationName = "ApagarLed")
    public Boolean apagarLed() {        
        controladorLed = new ControladorLed();
        serviciosSensor = new ServiciosSensor();
        boolean estado= controladorLed.apagar();
        serviciosSensor.enviarEvetosTelevisor("Televisor Apagado", estado);
        return estado;
    }
}
