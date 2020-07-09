/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.datan.niote.vista;

import co.edu.usbbog.datan.niote.vista.media.Graficar;
import co.edu.usbbog.datan.niote.vista.media.Grafos;
import java.awt.Color;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Camilo
 */
public class EmulacionJPanel extends javax.swing.JPanel {

    // Variables needed to graph IoT nodes
    private int tope = 0; // Accumulated 
    private int end; // Last Node
    private int start;
    int n = 0, nn = 0, id, id2;
    private int aristM;

    public EmulacionJPanel() {
        initComponents();
    }

    //Se inicializan los metodos
    Graficar paint = new Graficar();
    Grafos trees = new Grafos();

    Graficar graph = new Graficar();

    /**
     * Method to insert origin node
     *
     * @param origin
     * @param noexts
     * @param top1
     * @return originNode
     */
    public static int insertOrigin(String origin, String noexts, int top1) {
        int originNode = 0;
        try {
            originNode = Integer.parseInt(JOptionPane.showInputDialog("" + origin));
            if (originNode >= top1) {
                JOptionPane.showMessageDialog(null, "" + noexts + "\nPor favor ingrese un nodo existente");
                originNode = insertOrigin(origin, noexts, top1);
            }
        } catch (Exception ex) {
            originNode = insertOrigin(origin, noexts, top1);
        }
        return originNode;
    }

    /**
     * Method to design the graph of nodes because they are deleted when updated
     *
     * @param top
     * @param tree
     */
    public static void keepIt(int top, Grafos tree) {
        for (int j = 0; j < top; j++) {
            for (int k = 0; k < top; k++) {
//                if (tree.g etMatrizAdyacencia(j, k) == 1) {
                Graficar.createLine(jPanel1.getGraphics(), tree.getCoordinateX(j),
                        tree.getCoordinateY(j), tree.getCoordinateX(k),
                        tree.getCoordinateY(k));
//                }
            }
        }
        for (int j = 0; j < top; j++) {
            Graficar.createCircle(jPanel1.getGraphics(), tree.getCoordinateX(j), tree.getCoordinateY(j), String.valueOf(tree.getName(j)));
        }
    }

    /**
     * FALTA DOCUMENTAR
     *
     * @param weight
     * @return
     */
    public int setW(String weight) {// validacion de valores >40
        int pesoArista = 0;
        try {
            pesoArista = Integer.parseInt(JOptionPane.showInputDialog("" + weight));
            if (pesoArista < 1 || pesoArista > 1000) {
                JOptionPane.showMessageDialog(null, "El peso del nodo debe estar entre 1 y 1000");
                pesoArista = setW(weight);
            }
        } catch (Exception ex) {
            pesoArista = setW(weight);
        }
        return pesoArista;
    }

    /**
     * FALTA DOCUMENTAR
     *
     * @param x
     * @param y
     */
    public void selectNodoLft(int x, int y) {
        for (int j = 0; j < tope; j++) {
            if ((x + 2) > trees.getCoordinateX(j) && x < (trees.getCoordinateX(j) + 13) && (y + 2) > trees.getCoordinateY(j) && y < (trees.getCoordinateY(j) + 13)) {
                if (nn == 0) {
                    start = j;
                    keepIt(tope, trees);
                } else {
                    end = j;
                }
                nn++;
                n = 0;
                id = -1;
                Graficar.selectNode(jPanel1.getGraphics(), trees.getCoordinateX(j), trees.getCoordinateY(j), null, Color.GREEN);
                break;
            }

        }

    }

    /**
     * FALTA DOCUMENTAR
     *
     * @param x
     * @param y
     * @return
     */
    public boolean selectNodoRght(int x, int y) {
        for (int j = 0; j < tope; j++) {// si hay alguno selecionado 
            if ((x + 2) > trees.getCoordinateX(j) && x < (trees.getCoordinateX(j) + 13) && (y + 2) > trees.getCoordinateY(j) && y < (trees.getCoordinateY(j) + 13)) {
                if (n == 0) {
                    id = j;
                    keepIt(tope, trees);
                    Graficar.selectNode(jPanel1.getGraphics(), trees.getCoordinateX(j), trees.getCoordinateY(j), null, Color.orange);
                    n++;
                } else {
                    id2 = j;
                    n++;
                    Graficar.selectNode(jPanel1.getGraphics(), trees.getCoordinateX(j), trees.getCoordinateY(j), null, Color.orange);
                    if (id == id2) {// solo toma el primer clic
                        n = 0;
                        Graficar.createCircle(jPanel1.getGraphics(), trees.getCoordinateX(id), trees.getCoordinateY(id), String.valueOf(trees.getName(id)));
                        id = -1;
                        id2 = -1;
                    }
                }
                nn = 0;
                return true;
            }
        }
        return false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Mapa = new javax.swing.JLabel();

        setBackground(new java.awt.Color(27, 27, 27));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setMinimumSize(new java.awt.Dimension(770, 522));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel1MouseMoved(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });
        jPanel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jPanel1KeyReleased(evt);
            }
        });
        jPanel1.setLayout(null);

        Mapa.setBackground(new java.awt.Color(255, 255, 255));
        Mapa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(Mapa);
        Mapa.setBounds(10, 10, 700, 320);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1MouseMoved

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1MouseClicked


 /*
    Array of options for selection
     */
    String[] boton = {"Sensor", "Actuador", "Gateway"};

    /**
     * Click node graph event
     *
     * @param evt
     */
    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed

        int x;
        int y;
        x = evt.getX();
        y = evt.getY();
        if (evt.isMetaDown()) {
            selectNodoLft(x, y);
        } else {
            if (!selectNodoRght(x, y)) {
                if (tope < 12) {
                    //1 Sensor, 2 Actuador, 3 Gateway
                    int opcion = JOptionPane.showOptionDialog(this, "¿Que nodo IoT quiere agregar?", null, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, boton, boton[0]);

                    switch (opcion) {

                        case 0:
                            trees.setCoordinateX(tope, x);
                            trees.setCoordinateY(tope, y);
                            trees.setName(tope, tope);
                            Graficar.createCircleSensor(jPanel1.getGraphics(), trees.getCoordinateX(tope), trees.getCoordinateY(tope), String.valueOf(trees.getName(tope)));
                            tope++;
                            break;

                        case 1:
                            trees.setCoordinateX(tope, x);
                            trees.setCoordinateY(tope, y);
                            trees.setName(tope, tope);
                            Graficar.createCircleActuator(jPanel1.getGraphics(), trees.getCoordinateX(tope), trees.getCoordinateY(tope), String.valueOf(trees.getName(tope)));
                            tope++;
                            break;

                        case 2:
                            trees.setCoordinateX(tope, x);
                            trees.setCoordinateY(tope, y);
                            trees.setName(tope, tope);
                            Graficar.createCircleGateway(jPanel1.getGraphics(), trees.getCoordinateX(tope), trees.getCoordinateY(tope), String.valueOf(trees.getName(tope)));
                            tope++;
                            break;
                    }
                } else {
                    Icon imagenError = new ImageIcon(getClass().getResource("/iconos/baseline_warning_black_36dp.png"));
                    JOptionPane.showMessageDialog(this, "Solo se pueden ingresar 12 nodos", "Nodos maximos", JOptionPane.INFORMATION_MESSAGE, imagenError);
                }
            }

            // Securities income
            if (n == 2) {
                n = 0;
                Graficar.createLine(jPanel1.getGraphics(), trees.getCoordinateX(id), trees.getCoordinateY(id), trees.getCoordinateX(id2), trees.getCoordinateY(id2));
                Graficar.createCircle(jPanel1.getGraphics(), trees.getCoordinateX(id), trees.getCoordinateY(id), String.valueOf(trees.getName(id)));
                Graficar.createCircle(jPanel1.getGraphics(), trees.getCoordinateX(id2), trees.getCoordinateY(id2), String.valueOf(trees.getName(id2)));
                id = -1;
                id2 = -1;
            }
        }

    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1KeyPressed

    private void jPanel1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1KeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Mapa;
    public static javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

}
