/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.datan.niote.vista.media;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import static java.awt.Font.MONOSPACED;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

/**
 *
 * @author Camilo, Juan, Nicolas
 */
public class Graficar {

    Color color;

    public Graficar() {

    }

    public static void crearCirculo(Graphics circle, int x, int y, String key) {
        ((Graphics2D) circle).setColor(Color.LIGHT_GRAY); // Color de los nodos
        ((Graphics2D) circle).setStroke(new BasicStroke(3));//Grosor del nodo   
        ((Graphics2D) circle).setColor(Color.BLACK); //Color del contorno del nodo
        ((Graphics2D) circle).fillOval(x, y, 15, 15);// Relleno del nodo
        ((Graphics2D) circle).drawOval(x, y, 15, 15); //Ubicación del contorno
        ((Graphics2D) circle).setColor(Color.BLUE);//Color de la operacion dijkstra
        Font fuente = new Font("Comic Sans", Font.BOLD, 16);
        circle.setFont(fuente); // default font
        ((Graphics2D) circle).drawString(key, x, y); // Dibuja la ubicación 
    }

    public static void crearCirculoSensor(Graphics circle, int x, int y, String key) {
        ((Graphics2D) circle).setColor(Color.LIGHT_GRAY); // Color de los nodos
        ((Graphics2D) circle).setStroke(new BasicStroke(3));//Grosor del nodo   
        ((Graphics2D) circle).setColor(Color.LIGHT_GRAY); //Color del contorno del nodo
        ((Graphics2D) circle).fillOval(x, y, 15, 15);// Relleno del nodo
        ((Graphics2D) circle).drawOval(x, y, 15, 15); //Ubicación del contorno
        ((Graphics2D) circle).setColor(Color.BLUE);//Color de la operacion dijkstra
        Font fuente = new Font("Comic Sans", Font.BOLD, 16);
        circle.setFont(fuente); // default font
        ((Graphics2D) circle).drawString(key, x, y); // Dibuja la ubicación 
    }

    public static void crearCirculoActuador(Graphics circle, int x, int y, String key) {
        ((Graphics2D) circle).setColor(Color.BLACK); // Color de los nodos
        ((Graphics2D) circle).setStroke(new BasicStroke(3));//Grosor del nodo   
        ((Graphics2D) circle).setColor(Color.BLACK); //Color del contorno del nodo
        ((Graphics2D) circle).fillOval(x, y, 15, 15);// Relleno del nodo
        ((Graphics2D) circle).drawOval(x, y, 15, 15); //Ubicación del contorno
        ((Graphics2D) circle).setColor(Color.BLUE);//Color de la operacion dijkstra
        Font fuente = new Font("Comic Sans", Font.BOLD, 16);
        circle.setFont(fuente); // default font
        ((Graphics2D) circle).drawString(key, x, y); // Dibuja la ubicación 
    }

    public static void crearCirculoGateway(Graphics circle, int x, int y, String key) {
        ((Graphics2D) circle).setColor(Color.RED); // Color de los nodos
        ((Graphics2D) circle).setStroke(new BasicStroke(3));//Grosor del nodo   
        ((Graphics2D) circle).setColor(Color.RED); //Color del contorno del nodo
        ((Graphics2D) circle).fillOval(x, y, 15, 15);// Relleno del nodo
        ((Graphics2D) circle).drawOval(x, y, 15, 15); //Ubicación del contorno
        ((Graphics2D) circle).setColor(Color.BLUE);//Color de la operacion dijkstra
        Font fuente = new Font("Comic Sans", Font.BOLD, 16);
        circle.setFont(fuente); // default font
        ((Graphics2D) circle).drawString(key, x, y); // Dibuja la ubicación 
    }

    public static void crearLinea(Graphics lines, int x, int y, int x1, int y1) {
        int temX = 0;
        int temY = 0;
        ((Graphics2D) lines).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        BasicStroke stroke = new BasicStroke(2);
        ((Graphics2D) lines).setStroke(stroke);
        ((Graphics2D) lines).drawLine(x + 10, y + 10, x1 + 10, y1 + 10);
        if (x <= x1) {
            temX = ((x1 - x) / 2) + x;
        }
        if (x > x1) {
            temX = ((x - x1) / 2) + x1;
        }
        if (y < y1) {
            temY = ((y1 - y) / 2) + y;
        }
        if (y >= y1) {
            temY = ((y - y1) / 2) + y1;
        }
        Font fuente = new Font("Comic Sans", Font.BOLD, 14); // definir variables junto con la importacion
        lines.setFont(fuente);// establece la fuente

    }

    public static void crearArista(Graphics road, int x, int y, int x1, int y2, Color colors) {
        ((Graphics2D) road).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        BasicStroke stroke = new BasicStroke(2);
        ((Graphics2D) road).setStroke(stroke);
        road.setColor(colors);
        road.drawLine(x + 10, y + 10, x1 + 10, y2 + 10);
    }

    public static void seleccionarNodo(Graphics nodoSele, int x, int y, String key2, Color c) {
        ((Graphics2D) nodoSele).setColor(c); // Color que se pondra cuando se selecciona
        ((Graphics2D) nodoSele).setStroke(new BasicStroke(2)); //   Grosor del nodo       
        ((Graphics2D) nodoSele).fillOval(x, y, 15, 15);//   Colorea el nodo para encontrar camino
        ((Graphics2D) nodoSele).setColor(Color.BLACK);// Color del contorno del nodo seleccionado
        ((Graphics2D) nodoSele).drawOval(x, y, 15, 15);// Lo vuelve a dibujar en la misma ubicacion

    }
}
