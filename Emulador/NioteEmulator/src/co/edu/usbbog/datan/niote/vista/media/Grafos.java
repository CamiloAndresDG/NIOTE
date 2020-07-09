/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.datan.niote.vista.media;

/**
 *
 * @author Camilo
 */
public class Grafos {

    private int adjacentMatrix[][] = new int[30][30]; // Adjacent matrix
    private int matrixCoefficient[][] = new int[30][30]; // Weight store for nodes

    private int coorX[] = new int[30]; // X coordinate
    private int coorY[] = new int[30]; // Y coordinate
    private int idNodo[] = new int[30]; // Will store the node indicator
    private int enGrafo[];

    // Adjacency matrix management
    public Grafos() {

    }

    public int getCoordinateX(int i) {
        return coorX[i];
    }

    public int getCoordinateY(int i) {
        return coorY[i];
    }

    public int getName(int i) {
        return idNodo[i];
    }

    public int getEnGrafo(int i) {
        return enGrafo[i];
    }

    public int getMatrixCoefficient(int i, int j) {
        return matrixCoefficient[i][j];
    }

    public int getAdjacentMatrix(int i, int j) {
        return adjacentMatrix[i][j];
    }

    public void setCoordinateX(int i, int coordenadaX) {
        this.coorX[i] = coordenadaX;
    }

    public void setCoordinateY(int i, int coordenadaY) {
        this.coorY[i] = coordenadaY;
    }

    public void setName(int i, int nombre) {
        this.idNodo[i] = nombre;
    }

    public void setEnGrafo(int i, int posicionGrafo) {
        this.enGrafo[i] = posicionGrafo;
    }

    public void createTree(int i) {
        enGrafo = new int[i];
    }
}
