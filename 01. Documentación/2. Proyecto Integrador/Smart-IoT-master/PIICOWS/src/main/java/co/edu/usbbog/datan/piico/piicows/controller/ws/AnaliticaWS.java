/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.datan.piico.piicows.controller.ws;

import co.edu.usbbog.datan.piico.piicows.controller.persistence.ActuadorFacade;
import co.edu.usbbog.datan.piico.piicows.controller.persistence.ReportesFacade;
import co.edu.usbbog.datan.piico.piicows.controller.persistence.RolFacade;
import co.edu.usbbog.datan.piico.piicows.controller.persistence.UsuarioFacade;
import co.edu.usbbog.datan.piico.piicows.controller.persistence.SensorFacade;
import co.edu.usbbog.datan.piico.piicows.model.Actuador;
import co.edu.usbbog.datan.piico.piicows.model.Reportes;
import co.edu.usbbog.datan.piico.piicows.model.Rol;
import co.edu.usbbog.datan.piico.piicows.model.Sensor;
import co.edu.usbbog.datan.piico.piicows.model.Usuario;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.jws.WebParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import com.google.gson.Gson;

/**
 * REST Web Service
 *
 * @author 305
 */
@Path("analiticaws")
public class AnaliticaWS {

    @Context
    private UriInfo context;
    
    @EJB
    ActuadorFacade actuadorFacade;
    @EJB
    SensorFacade sensorFacade;
    @EJB
    UsuarioFacade usuarioFacade;
    @EJB
    RolFacade rolFacade;
    @EJB
    ReportesFacade reportesFacade;

    //Actuador
    
    /**
     * Metodo para insertar un nuevo actuador
     * @param actuador
     * @param id identificador del actuador
     * @return Datos del nuevo actuador
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/insertarActuador")
    public String insertarActuador(@WebParam(name = "actuador") String actuador) {
        Actuador a = new Gson().fromJson(actuador, Actuador.class);
        actuadorFacade.create(a);
        a=actuadorFacade.find(a.getId());
        System.out.println("Hola");
        return new Gson().toJson(a);    
    }
    
    /**
     * Metodo para editar actuador
     * @param id identificador del actuador
     * @return Datos modificados del actuador
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/modificarActuador")
    public String modificarActuador(@WebParam(name = "id") String id) {
        Actuador a = new Gson().fromJson(id, Actuador.class);
        actuadorFacade.edit(a);
        return new Gson().toJson(a);
    }
    
    /**
     * Metodo para eliminar actuador
     * @param id identificador del actuador
     * @return Si el actuador se elimina devuelve "Actuador eliminado", de lo contrario "No existe el actuador"
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/eliminarActuador")
    public String eliminarActuador(@WebParam(name = "id") String id) {
        
        try{
        Actuador a = new Gson().fromJson(id, Actuador.class);
        actuadorFacade.remove(a);
        return "{\"mensaje\": \"Actuador eliminado\"}";
        } catch (EJBException e) {
            return "{\"error\": \"No existe el actuador\"}";
        }
    }
    
    /**
     * Metodo para mostrar todos los actuadores existentes
     * @return Actuadores existentes
     */
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/buscarTodosLosActuadores")
    public String buscarTodosLosActuadores() {
        List<Actuador> usuarios = actuadorFacade.findAll();
        String salida = "[";
        for (Actuador a : usuarios) {
            salida += new Gson().toJson(a)+",";
        }
        salida=quitarComa(salida);
        salida += "]";
        return salida;
    }
    
    /**
     * Metodo para buscar actuador
     * @param id identificador del actuador
     * @return Datos del actuador
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/buscarActuador")
    public String buscarActuador(@WebParam(name = "id") String id) {
        Actuador a = new Gson().fromJson(id, Actuador.class);
        a=actuadorFacade.find(a.getId());
        return new Gson().toJson(a);
    }
    
     /**
     * Metodo para contar todos los actuadores existentes
     * @return Numero deActuadores existentes
     */
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/contarTodosLosActuadores")
    public String contarTodosLosActuadores() {
        return "El numero de actuadores ecistentes es: "+actuadorFacade.count();
    }
    
    //Sensor
    
    /**
     * Metodo para insertar un nuevo sensor
     * @param id identificador del sensor
     * @return Datos del nuevo sensor
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/insertarSensor")
    public String insertarSensor(@WebParam(name = "sensor") String sensor) {
        Sensor s = new Gson().fromJson(sensor, Sensor.class);
        sensorFacade.create(s);
        return new Gson().toJson(s);    
    }
    
    /**
     * Metodo para editar sensor
     * @param id identificador del sensor
     * @return Datos modificados del sensor
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/modificarSensor")
    public String modificarSensor(@WebParam(name = "id") String id) {
        Sensor s = new Gson().fromJson(id, Sensor.class);
        sensorFacade.edit(s);
        return new Gson().toJson(s);
    }
    
    /**
     * Metodo para eliminar sensor
     * @param id identificador del sensor
     * @return Si el sensor se elimina devuelve "Sensor eliminado", de lo contrario "No existe el sensor"
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/eliminarSensor")
    public String eliminarSensor(@WebParam(name = "id") String id) {
        
        try{
        Sensor s = new Gson().fromJson(id, Sensor.class);
        sensorFacade.remove(s);
        return "{\"mensaje\": \"Sensor eliminado\"}";
        } catch (EJBException e) {
            return "{\"error\": \"No existe el sensor\"}";
        }
    }
    
    /**
     * Metodo para mostrar todos los sensores existentes
     * @return Sensores existentes
     */
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/buscarTodosLosSensores")
    public String buscarTodosLosSensores() {
        List<Sensor> sensores = sensorFacade.findAll();
        String salida = "[";
        for (Sensor s : sensores) {
            salida += new Gson().toJson(s)+",";
        }
        salida=quitarComa(salida);
        salida += "]";
        return salida;
    }
    
    /**
     * Metodo para buscar sensor
     * @param id identificador del sensor
     * @return Datos del sensor
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/buscarSensor")
    public String buscarSensor(@WebParam(name = "id") String id) {
        Sensor s = new Gson().fromJson(id, Sensor.class);
        s=sensorFacade.find(s.getId());
        return new Gson().toJson(s);
    }
    
     /**
     * Metodo para contar todos los sensores existentes
     * @return Numero de Sensores existentes
     */
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/contarTodosLosSensores")
    public String contarTodosLosSensores() {
        return "El numero de sensores existentes es: "+sensorFacade.count();
    }
    
    //Usuario  
    
    /**
     * Metodo para insertar un nuevo Usuario  
     * @param usuario
     * @param userName identificador del Usuario  
     * @return Datos del nuevo Usuario  
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/insertarUsuario")
    public String insertarUsuario  (@WebParam(name = "usuario") String usuario) {
        try{
            Usuario u = new Gson().fromJson(usuario, Usuario.class);
            usuarioFacade.create(u);
            u = usuarioFacade.find(u.getUsername());
            return new Gson().toJson(u);
        } catch (Exception e) {
            return "{\"respuesta\":\"error al innsertar usuario\"}";
        }

    }
    
    /**
     * Metodo para editar Usuario  
     * @param userName identificador del Usuario  
     * @return Datos modificados del Usuario  
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/modificarUsuario  ")
    public String modificarUsuario  (@WebParam(name = "usuario") String usuario) {
        Usuario   a = new Gson().fromJson(usuario, Usuario.class);
        usuarioFacade.edit(a);
        return new Gson().toJson(a);
    }
    
    /**
     * Metodo para eliminar Usuario  
     * @param userName identificador del Usuario  
     * @return Si el Usuario   se elimina devuelve "Usuario   eliminado", de lo contrario "No existe el Usuario  "
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/eliminarUsuario")
    public String eliminarUsuario (@WebParam(name = "userName") String userName) {
        
        try{
        Usuario   a = new Gson().fromJson(userName, Usuario.class);
        usuarioFacade.remove(a);
        return "{\"mensaje\": \"Usuario   eliminado\"}";
        } catch (EJBException e) {
            return "{\"error\": \"No existe el Usuario  \"}";
        }
    }
    
    /**
     * Metodo para mostrar todos los Usuario  es existentes
     * @return usuarios existentes
     */
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/buscarTodosLosUsuarios")
    public String buscarTodosLosUsuarios() {
        List<Usuario> usuarios = usuarioFacade.findAll();
        String salida = "[";
        for (Usuario   a : usuarios) {
            salida += new Gson().toJson(a)+",";
        }
        salida=quitarComa(salida);
        salida += "]";
        return salida;
    }
    
    /**
     * Metodo para buscar Usuario  
     * @param userName identificador del Usuario  
     * @return Datos del Usuario  
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/buscarUsuario")
    public String buscarUsuario  (@WebParam(name = "userName") String userName) {
        Usuario   a = new Gson().fromJson(userName, Usuario.class);
        a=usuarioFacade.find(a.getUsername());
        return new Gson().toJson(a);
    }
    
     /**
     * Metodo para contar todos los Usuarios existentes
     * @return Numero deUsuarios existentes
     */
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/contarTodosLosUsuarios")
    public String contarTodosLosUsuarios() {
        return "El numero de Usuario  es ecistentes es: "+usuarioFacade.count();
    }
    
    //Rol  
    
    /**
     * Metodo para insertar un nuevo Rol  
     * @param id identificador del Rol  
     * @return Datos del nuevo Rol  
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/insertarRol")
    public String insertarRol  (@WebParam(name = "id") String id) {
        Rol   a = new Gson().fromJson(id, Rol.class);
        rolFacade.create(a);
        return new Gson().toJson(a);    
    }
    
    /**
     * Metodo para editar Rol  
     * @param id identificador del Rol  
     * @return Datos modificados del Rol  
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/modificarRol  ")
    public String modificarRol  (@WebParam(name = "id") String id) {
        Rol   a = new Gson().fromJson(id, Rol.class);
        rolFacade.edit(a);
        return new Gson().toJson(a);
    }
    
    /**
     * Metodo para eliminar Rol  
     * @param id identificador del Rol  
     * @return Si el Rol   se elimina devuelve "Rol   eliminado", de lo contrario "No existe el Rol  "
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/eliminarRol")
    public String eliminarRol (@WebParam(name = "id") String id) {
        
        try{
        Rol   a = new Gson().fromJson(id, Rol.class);
        rolFacade.remove(a);
        return "{\"mensaje\": \"Rol   eliminado\"}";
        } catch (EJBException e) {
            return "{\"error\": \"No existe el Rol  \"}";
        }
    }
    
    /**
     * Metodo para mostrar todos los Roles existentes
     * @return Rols existentes
     */
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/buscarTodosLosRoles")
    public String buscarTodosLosRoles() {
        List<Rol> Rols = rolFacade.findAll();
        String salida = "[";
        for (Rol   a : Rols) {
            salida += new Gson().toJson(a)+",";
        }
        salida=quitarComa(salida);
        salida += "]";
        return salida;
    }
    
    /**
     * Metodo para buscar Rol  
     * @param nombre identificador del Rol  
     * @return Datos del Rol  
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/buscarRol ")
    public String buscarRol  (@WebParam(name = "nombre") String nombre) {
        Rol   a = new Gson().fromJson(nombre, Rol.class);
        a=rolFacade.find(a.getNombre());
        return new Gson().toJson(a);
    }
    
     /**
     * Metodo para contar todos los Roles existentes
     * @return Numero deRol  es existentes
     */
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/contarTodosLosRoles")
    public String contarTodosLosRoles() {
        return "El numero de Rol  es ecistentes es: "+rolFacade.count();
    }
    
    
//Reportes
    
    /**
     * Metodo para insertar un nuevo Reporte
     * @param id identificador del Reporte
     * @return Datos del nuevo Reporte
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/insertarReporte")
    public String insertarReporte(@WebParam(name = "id") String id) {
        Reportes a = new Gson().fromJson(id, Reportes.class);
        reportesFacade.create(a);
        return new Gson().toJson(a);    
    }
    
    /**
     * Metodo para editar Reporte
     * @param id identificador del Reporte
     * @return Datos modificados del Reporte
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/modificarReporte")
    public String modificarReporte(@WebParam(name = "id") String id) {
        Reportes a = new Gson().fromJson(id, Reportes.class);
        reportesFacade.edit(a);
        return new Gson().toJson(a);
    }
    
    /**
     * Metodo para eliminar Reporte
     * @param id identificador del Reporte
     * @return Si el Reporte se elimina devuelve "Reporte eliminado", de lo contrario "No existe el Reporte"
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/eliminarReporte")
    public String eliminarReportes(@WebParam(name = "id") String id) {
        
        try{
        Reportes a = new Gson().fromJson(id, Reportes.class);
        reportesFacade.remove(a);
        return "{\"mensaje\": \"Reporte eliminado\"}";
        } catch (EJBException e) {
            return "{\"error\": \"No existe el Reporte\"}";
        }
    }
    
    /**
     * Metodo para mostrar todos los Reportees existentes
     * @return Reportes existentes
     */
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/buscarTodosLosReportes")
    public String buscarTodosLosReportes() {
        List<Reportes> Reportes = reportesFacade.findAll();
        String salida = "[";
        for (Reportes a : Reportes) {
            salida += new Gson().toJson(a)+",";
        }
        salida=quitarComa(salida);
        salida += "]";
        return salida;
    }
    
    /**
     * Metodo para buscar Reporte
     * @param id identificador del Reporte
     * @return Datos del Reporte
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/buscarReportes")
    public String buscarReporte(@WebParam(name = "id") String id) {
        Reportes a = new Gson().fromJson(id, Reportes.class);
        a=reportesFacade.find(a.getId());
        return new Gson().toJson(a);
    }
    
     /**
     * Metodo para contar todos los Reportees existentes
     * @return Numero deReportees existentes
     */
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/contarTodosLosReportes")
    public String contarTodosLosReportes() {
        return "El numero de Reportees ecistentes es: "+reportesFacade.count();
    }

    
    @POST  
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        
        return "{valor:\"HOLA\"}";
    }

    /**
     * PUT method for updating or creating an instance of FrontWS
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
    
    public String quitarComa(String str) {
        if (str != null && str.length() > 0 && str.charAt(str.length() - 1) == ',') {
            str = str.substring(0, str.length() - 1);
        }
        return str;
    }
}
