/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.datan.niote.controlador.simulador;

/**
 *
 * @author Andrés Sánchez, Juan Ochoa, Sebastian Villanueva.
 */
public class NodoHilo extends Thread{

     String name;
      
    public NodoHilo(String msg) {
    
        super(msg);
    }
    
    public void run(){
        
        for(int i=1; i>0; i++){        
            
            System.out.println("Objeto: "+this.getName()+" - "+i);
        }
    }
    
    
    
    
}
