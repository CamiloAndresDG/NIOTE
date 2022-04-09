/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.swing.JOptionPane;

/**
 *
 * @author sevin
 */
public class Cliente {
    
    Socket socket;
    BufferedReader read;
    PrintWriter output;

    public void startClient() throws UnknownHostException, IOException{
        socket = new Socket("127.0.0.1", 9090);
        output = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
        String username = JOptionPane.showInputDialog(null, "Enter User Name:");
        output.println(username);
        String password = JOptionPane.showInputDialog(null, "Enter Password");
        output.println(password);
        output.flush();
        read = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String response = read.readLine();
        System.out.println("This is the response: " + response);
        JOptionPane.showMessageDialog(null, response);
        Servidor();
    }
    public void Servidor() throws IOException{
        socket = new Socket("127.0.0.1", 1000);
        output = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
        output.println("hola mundo");
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         Cliente client = new Cliente();
        try {
            client.startClient();
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
}
