package co.edu.usbbog.datan.niote.vista;
//La clase de cursor se usa principalmente para encapsular la representación de mapa de bits del cursor del mouse.
import java.awt.Cursor;
//Contiene la altura y el ancho de un componente en número entero, así como doble precisión. El uso de la clase Dimension es que muchas funciones de Java AWT y Swing devuelven el objeto de dimensión.
import java.awt.Dimension;
//Point que representa una ubicación en el espacio de coordenadas (x, y), especificado en precisión entera.
import java.awt.Point;
//Un evento que indica que se produjo una acción del mouse en un componente.
import java.awt.event.MouseEvent;
//La clase que está interesada en procesar un evento de mouse implementa esta interfaz (y todos los métodos que contiene) o extiende la MouseAdapterclase abstracta (anulando solo los métodos de interés).
import java.awt.event.MouseListener;
//La clase que está interesada en procesar un evento de movimiento del mouse implementa esta interfaz (y todos los métodos que contiene) o extiende la MouseMotionAdapterclase abstracta (anulando solo los métodos de interés).
import java.awt.event.MouseMotionListener;
//Clase de fábrica para la venta de Borderobjetos estándar . Siempre que sea posible, esta fábrica entregará referencias a Borderinstancias compartidas .
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
/**
 * @author Juan
 */
public class Componente extends JLabel implements MouseListener, MouseMotionListener{
    
    /** Identificador de objeto */
    private String key = "";    
    /** Posicion de imagen */
    private Point posicion = new Point(0,0);
    /** Tamaño de imagen */
    private Dimension dimension = new Dimension(124,150);    
    /** variable que sirve para calcular el movimiento del objeto */
    private Point localizacionInicial;
    /** variable que sirve para calcular el movimiento del objeto */
    private Point comenzarArrastre;
    /** variable que sirve para calcular el movimiento del objeto */
    private Point offset;
    /** variables auxiliares para el desplazamiento del objeto*/
    private int nuevoEnX = 1;
    private int nuevoEnY = 1;
    
    /**
     * Constructor de clase
     */
    public Componente(String key){        
        //se inician propiedades de objeto
        this.key = key;
        //Permite mostrar el nombre del Key del objeto al pasar el mouse por encima
        this.setToolTipText( key );
        //"getPredefinedCursor" devuelve un objeto de cursor con el tipo predefinido especificado.
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));        
        this.setSize(dimension);
        this.setPreferredSize(dimension); 
        //Asigna una imagen al objeto
        this.setIcon( new ImageIcon(getClass().getResource("/iconosComponentes/" + ((int) Math.floor(Math.random()*4+1)) + ".png")) ); 
        this.setText("");
        this.setVisible( true );
        this.setLocation( posicion );
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
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {
       this.comenzarArrastre = getLocalizacionActual(e);
       this.localizacionInicial = this.getLocation();
    }

    @Override
    public void mouseReleased(MouseEvent e) {          
        nuevoEnX = (this.getLocation().x);
        nuevoEnY = (this.getLocation().y);
        this.setLocation( nuevoEnX, nuevoEnY );
    }
//Hace visible un contorno rojo al objeto por el que el mouse pasa
    @Override
    public void mouseEntered(MouseEvent e) {
        this.setBorder(BorderFactory.createLineBorder(new java.awt.Color(204, 0, 51), 1));   
    }
//Elimina el contorno rojo al objeto
    @Override
    public void mouseExited(MouseEvent e) {
        this.setBorder( null );   
    }

    @Override
    public void mouseDragged(MouseEvent e) {
      Point current = this.getLocalizacionActual(e);
      offset = new Point((int) current.getX() - (int) comenzarArrastre.getX(),(int) current.getY() - (int) comenzarArrastre.getY());
      Point new_location = new Point((int) (this.localizacionInicial.getX() + offset.getX()), (int) (this.localizacionInicial.getY() + offset.getY()));
      this.setLocation(new_location);          
    }

    @Override
    public void mouseMoved(MouseEvent e) {}
    
    
   /**
    * metodo para obtener la posicion  del frame en la pantalla
    * @param MouseEvent evt
    */
    private Point getLocalizacionActual(MouseEvent evt) {
        Point posicionMouse = evt.getPoint();
        Point ubicacionDelObjeto = this.getLocationOnScreen();
        return new Point((int) (ubicacionDelObjeto.getX() + posicionMouse.getX()),
               (int) (ubicacionDelObjeto.getY() + posicionMouse.getY()));
    }
    
}//-> fin clase
