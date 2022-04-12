/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package segmento.iot.nodos;

/**
 *
 * @author Andres Sanchez
 */
public class Led {

    public static void main(String[] args) {
        System.out.println("Iniciando servidor del Led\n");
        Servidor serv = new Servidor(); //Se crea el servidor
        serv.iniciarServidor();
    }
}
