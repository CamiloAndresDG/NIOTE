package co.edu.usbbog.datan.niote.vista.media.controladores.pantallaemulacion;

// The cursor class is mainly used to encapsulate the bitmap representation of the mouse cursor
import java.awt.Cursor;

// Contains the height and width of a component as an integer, as well as double precision. The use of the Dimension class is that many Java AWT and Swing functions return the dimension object
import java.awt.Dimension;

// Point representing a location in the coordinate space (x, y), specified in integer precision
import java.awt.Point;

// An event indicating that a mouse action occurred on a component
import java.awt.event.MouseEvent;

// The class that is interested in processing a mouse event implements this interface (and all the methods it contains) or extends the abstract MouseAdapter class (overriding only the methods of interest)
import java.awt.event.MouseListener;

// The class that is interested in processing a mouse movement event implements this interface (and all the methods it contains) or extends the abstract MouseMotionAdapter class (overriding only the methods of interest)
import java.awt.event.MouseMotionListener;

// Factory class for the sale of standard BorderObjets. Whenever possible, this factory will provide references to shared Border Instances
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * @author Juan Esteban Contreras Díaz.
 * @version 1.0
 * @since July 2020.
 */
public class Componente extends JLabel implements MouseListener, MouseMotionListener {

    /**
     * Object identifier
     */
    private String key = "";
    /**
     * Image position
     */
    private Point posicion = new Point(0, 0);
    /**
     * Image size
     */
    private Dimension dimension = new Dimension(70, 70);
    /**
     * Variable used to calculate the movement of the object (initial position)
     */
    private Point localizacionInicial;
    /**
     * Variable used to calculate the movement of the object (moving)
     */
    private Point comenzarArrastre;
    /**
     * Variable used to calculate the movement of the object (final position)
     */
    private Point offset;
    /**
     * Auxiliary variables for object displacement
     */
    private int nuevoEnX = 1;
    private int nuevoEnY = 1;

    /**
     * Class constructor
     */
    public Componente(String key, String nomImagen) {
        //se inician propiedades de objeto
        this.key = key;
        //Permite mostrar el nombre del Key del objeto al pasar el mouse por encima
        this.setToolTipText(key);
        //"getPredefinedCursor" devuelve un objeto de cursor con el tipo predefinido especificado.
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        this.setSize(dimension);
        this.setPreferredSize(dimension);
        //Asigna una imagen al objeto   
        this.setIcon(new ImageIcon(getClass().getResource("/co/edu/usbbog/datan/niote/vista/media/imagenes/paletanodos/" + nomImagen + ".png")));
        this.setText("");
        this.setVisible(true);
        this.setLocation(posicion);
        //se agregan los listener para poder usar los metodos del mouse en el objeto
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.comenzarArrastre = getLocalizacionActual(e);
        this.localizacionInicial = this.getLocation();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        nuevoEnX = (this.getLocation().x);
        nuevoEnY = (this.getLocation().y);
        this.setLocation(nuevoEnX, nuevoEnY);
    }
//Hace visible un contorno rojo al objeto por el que el mouse pasa

    @Override
    public void mouseEntered(MouseEvent e) {
        this.setBorder(BorderFactory.createLineBorder(new java.awt.Color(244, 244, 244), 1));
    }
//Elimina el contorno rojo al objeto

    @Override
    public void mouseExited(MouseEvent e) {
        this.setBorder(null);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Point current = this.getLocalizacionActual(e);
        offset = new Point((int) current.getX() - (int) comenzarArrastre.getX(), (int) current.getY() - (int) comenzarArrastre.getY());
        Point new_location = new Point((int) (this.localizacionInicial.getX() + offset.getX()), (int) (this.localizacionInicial.getY() + offset.getY()));
        this.setLocation(new_location);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    /**
     * metodo para obtener la posicion del frame en la pantalla
     *
     * @param MouseEvent evt
     */
    private Point getLocalizacionActual(MouseEvent evt) {
        Point posicionMouse = evt.getPoint();
        Point ubicacionDelObjeto = this.getLocationOnScreen();
        return new Point((int) (ubicacionDelObjeto.getX() + posicionMouse.getX()),
                (int) (ubicacionDelObjeto.getY() + posicionMouse.getY()));
    }

}//-> fin clase
