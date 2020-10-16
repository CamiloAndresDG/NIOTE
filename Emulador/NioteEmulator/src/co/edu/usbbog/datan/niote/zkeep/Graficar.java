/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.datan.niote.zkeep;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
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

    /**
     * Method to create the circles
     *
     * @param circle
     * @param x
     * @param y
     * @param key
     */
    public static void createCircle(Graphics circle, int x, int y, String key) {
        ((Graphics2D) circle).setColor(Color.LIGHT_GRAY); // Node color
        ((Graphics2D) circle).setStroke(new BasicStroke(3));// Node thickness   
        ((Graphics2D) circle).setColor(Color.BLACK); // Node outline color
        ((Graphics2D) circle).fillOval(x, y, 15, 15);// Node padding
        ((Graphics2D) circle).drawOval(x, y, 15, 15); // Outline location
        ((Graphics2D) circle).setColor(Color.BLUE);// Operation color Dijkstra
        Font fuente = new Font("Comic Sans", Font.BOLD, 16);
        circle.setFont(fuente); // Default font
        ((Graphics2D) circle).drawString(key, x, y); // Draw the location
    }

    /**
     * Method to create the circles of the sensors
     *
     * @param circle
     * @param x
     * @param y
     * @param key
     */
    public static void createCircleSensor(Graphics circle, int x, int y, String key) {
        ((Graphics2D) circle).setColor(Color.LIGHT_GRAY); // Node color
        ((Graphics2D) circle).setStroke(new BasicStroke(3)); // Node thickness  
        ((Graphics2D) circle).setColor(Color.LIGHT_GRAY); // Node outline color
        ((Graphics2D) circle).fillOval(x, y, 15, 15);// Node padding
        ((Graphics2D) circle).drawOval(x, y, 15, 15); // Outline location
        ((Graphics2D) circle).setColor(Color.BLUE);// Operation color Dijkstra
        Font fuente = new Font("Comic Sans", Font.BOLD, 16);
        circle.setFont(fuente); // Default font
        ((Graphics2D) circle).drawString(key, x, y); // Draw the location
    }

    /**
     * Method for creating the actuator circles
     *
     * @param circle
     * @param x
     * @param y
     * @param key
     */
    public static void createCircleActuator(Graphics circle, int x, int y, String key) {
        ((Graphics2D) circle).setColor(Color.BLACK); // Node color
        ((Graphics2D) circle).setStroke(new BasicStroke(3));// Node thickness   
        ((Graphics2D) circle).setColor(Color.BLACK); // Node outline color
        ((Graphics2D) circle).fillOval(x, y, 15, 15);// Node padding
        ((Graphics2D) circle).drawOval(x, y, 15, 15); // Outline location
        ((Graphics2D) circle).setColor(Color.BLUE);// Operation color Dijkstra
        Font fuente = new Font("Comic Sans", Font.BOLD, 16);
        circle.setFont(fuente); // Default font
        ((Graphics2D) circle).drawString(key, x, y); // Draw the location
    }

    /**
     * Method to create the gateways circles
     *
     * @param circle
     * @param x
     * @param y
     * @param key
     */
    public static void createCircleGateway(Graphics circle, int x, int y, String key) {
        ((Graphics2D) circle).setColor(Color.RED); // Node color
        ((Graphics2D) circle).setStroke(new BasicStroke(3));// Node thickness   
        ((Graphics2D) circle).setColor(Color.RED); // Node outline color
        ((Graphics2D) circle).fillOval(x, y, 15, 15);// Node padding
        ((Graphics2D) circle).drawOval(x, y, 15, 15); // Outline location
        ((Graphics2D) circle).setColor(Color.BLUE);// Operation color Dijkstra
        Font fuente = new Font("Comic Sans", Font.BOLD, 16);
        circle.setFont(fuente); // Default font
        ((Graphics2D) circle).drawString(key, x, y); // Draw the location
    }

    /**
     * Method to create the lines connecting all sensors, actuators and gateways
     *
     * @param lines
     * @param x
     * @param y
     * @param x1
     * @param y1
     */
    public static void createLine(Graphics lines, int x, int y, int x1, int y1) {
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
        Font fuente = new Font("Comic Sans", Font.BOLD, 14); // Define variables together with import
        lines.setFont(fuente); // Set the source

    }

    /**
     * FALTA DOCUMENTAR
     *
     * @param road
     * @param x
     * @param y
     * @param x1
     * @param y2
     * @param colors
     */
    public static void createArista(Graphics road, int x, int y, int x1, int y2, Color colors) {
        ((Graphics2D) road).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        BasicStroke stroke = new BasicStroke(2);
        ((Graphics2D) road).setStroke(stroke);
        road.setColor(colors);
        road.drawLine(x + 10, y + 10, x1 + 10, y2 + 10);
    }

    /**
     * Method to change color to selected node
     *
     * @param selectedNode
     * @param x
     * @param y
     * @param key2
     * @param color
     */
    public static void selectNode(Graphics selectedNode, int x, int y, String key2, Color color) {
        ((Graphics2D) selectedNode).setColor(color); // Color to be put on when selected
        ((Graphics2D) selectedNode).setStroke(new BasicStroke(2)); // Node thickness     
        ((Graphics2D) selectedNode).fillOval(x, y, 15, 15); //   Color the node to find a path
        ((Graphics2D) selectedNode).setColor(Color.BLACK); // Color of the selected node outline
        ((Graphics2D) selectedNode).drawOval(x, y, 15, 15); // Redraws it in the same location
    }
}
