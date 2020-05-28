/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.datan.niote.vista.media;

/**
 *
 * @author Camilo, Juan, Nicolas
 */
public class Grafos {

    private int matrizAdyacente[][] = new int[30][30]; // Matriz adyacente

    private int coorX[] = new int[30]; // Coordenada en X 
    private int coorY[] = new int[30]; // Coordenada en Y 
    private int idNodo[] = new int[30]; // Almacenara el indicador del nodo
    private int enGrafo[];

    // gestion matriz adyacencia
    public Grafos() {

    }

    public int getCoordenadaX(int i) {
        return coorX[i];
    }

    public int getCoordenadaY(int i) {
        return coorY[i];
    }

    public int getNombre(int i) {
        return idNodo[i];
    }

    public int getEnGrafo(int i) {
        return enGrafo[i];
    }

    public int getMatrizCoeficiente(int i, int j) {
        return matrizCoeficiente[i][j];
    }

    public int getMatrizAdyacencia(int i, int j) {
        return matrizAdyacente[i][j];
    }

    public void setCoordenadaX(int i, int coordenadaX) {
        this.coorX[i] = coordenadaX;
    }

    public void setCoordenadaY(int i, int coordenadaY) {
        this.coorY[i] = coordenadaY;
    }

    public void setNombre(int i, int nombre) {
        this.idNodo[i] = nombre;
    }

    public void setEnGrafo(int i, int posicionGrafo) {
        this.enGrafo[i] = posicionGrafo;
    }

    public void crearArbol(int i) {
        enGrafo = new int[i];
    }

    private int matrizCoeficiente[][] = new int[30][30]; // Almacenador de los pesos para los nodos

}
