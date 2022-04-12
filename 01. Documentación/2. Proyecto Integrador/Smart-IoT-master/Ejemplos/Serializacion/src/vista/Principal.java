/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.persistencia.ArchivoPersona;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import modelo.Persona;

/**
 *
 * @author Yury Muñoz
 */
public class Principal {

    public static void main(String[] args) throws ClassNotFoundException, IOException {
        int opc;
        Scanner terminal = new Scanner(System.in);
        //Variables necesarias
        String nombre;
        String apellido;
        long documento;
        //Crea el archivo persona necesario para guardar los datos, si no existe lo crea, y da los metodos CRUD
        ArchivoPersona ap = new ArchivoPersona();
        do {
            System.out.println("0. para salir\n"
                    + "1. Para Ingresar personas\n"
                    + "2. para mostrar todas las personas\n"
                    + "3. para buscar persona por documento\n"
                    + "4. para eliminar personas por documento\n"
                    + "5. para modificar personas por documento");
            opc=terminal.nextInt();
            switch (opc){
                case 0:
                    opc=0;
                    break;
                case 1:
                    //Captura de los datos para crear una persona
                    System.out.print("Digite el nombre: ");
                    nombre = terminal.next();
                    System.out.print("Digite el apellido: ");
                    apellido = terminal.next();
                    System.out.print("Digite el documento: ");
                    documento = terminal.nextLong();
                    //Instancia de Objeto para guardar en el Archivo
                    Persona personaNueva = new Persona(nombre, apellido, documento);
                    //guardar en el archivo persona.txt
                    ap.crearPersona(personaNueva); 
                    System.out.println("Se agrego a: " + personaNueva.toString());
                    break;
                case 2:
                    //busca todos los objetos del archivo y debuelve una lista
                    ArrayList<Persona> listaPersonas = ap.buscarTodo();
                    //si la lista tiene datos se imprime
                    if(listaPersonas.isEmpty()){
                        System.out.println("No hay datos en el Archivo");
                    } else {
                        //imprime la Lista
                        System.out.println("***Lista de "+listaPersonas.size()+" Personas***");
                        listaPersonas.stream().forEach((listaPersona) -> {
                            System.out.println(listaPersona.toString());
                        });
                    }
                    break;
                case 3:
                    //Captura de los datos para la busqueda
                    System.out.print("Digite el documento: ");
                    documento = terminal.nextLong();
                    //busca un objeto por un atributo (en este caso el documento, ya que es lo unico que no se repite)
                    Persona personaBuscada = ap.buscarPorDocumento(documento);
                    //imprime si encuenta el objeto
                    if (personaBuscada != null) {
                        System.out.println("Se encontro: " + personaBuscada.toString());
                    } else {
                        System.out.println("No existe la persona");
                    }
                    break;
                case 4:
                    //Captura de los datos para la eliminacion
                    System.out.print("Digite el documento: ");
                    documento = terminal.nextLong();
                    //eliminar un objeto del archivo por un atributo (en este caso el documento, ya que es lo unico que no se repite)
                    ap.eliminarPersona(documento);
                     //buscamos todo en el archivo e imprimimos otra vez, para verificar que se elimino 
                    break;
                case 5:
                    //Captura de los datos para la modificacion
                    System.out.print("Digite el documento: ");
                    documento = terminal.nextLong();
                    //Se busca el objeto a modificar
                    Persona personaModificar = ap.buscarPorDocumento(documento);
                    //si existe se hace la modificacion
                    if (personaModificar != null) {
                        //Captura de los datos para la modificacionque se van a modificar
                        System.out.print("Digite el nombre: ");
                        nombre = terminal.next();
                        System.out.print("Digite el apellido: ");
                        apellido = terminal.next();
                        //modificamos los atributos se pueden cambiar (en este caso nunca cambiamos el documento)
                        personaModificar.setNombre(nombre);
                        personaModificar.setApellido(apellido);
                        //ahora guardamos el cambio en el archivo
                        ap.modificarPersona(personaModificar.getDocumento(), personaModificar);
                    } else {
                        System.out.println("No existe la persona");
                    }
                    //buscamos todo en el archivo e imprimimos otra vez, para verificar que se modifica     
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            } 
        } while (opc!=0);
        System.out.println("Gracias, Vuelva pronto");
    }
}
