package co.edu.usbbog.datan.niote.recursos.pantallaDeEmulacion;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * @author Juan
 */
public class ComponentController {

    // Internal object counter
    private int internalObjectCounter = 0;

    // The objects will be stored in a HASH-MAP 
    private Map hashMap = new HashMap();

    // JPanel
    private JPanel container;

    /**
     * DefaultListModel
     */
    private DefaultListModel listModel;

    /**
     * Class constructor
     *
     * @param JPanel Donde se colocaran los objetos
     * @param DefaultListModel Aqui se almacenaran los key (identificadores) de
     * objetos
     */
    public ComponentController(JPanel jPanel, DefaultListModel listModel) {
        this.container = jPanel;
        this.listModel = listModel;
    }

    /**
     * Method that creates a new object
     *
     * @param name of the new object
     */
    public void nuevoComponente(String name, int id) {
        //Increases counter by +1 when adding a new object       
        this.internalObjectCounter += 1;
        //// Create a new instance of "Component and the number of the object giving it the name"
        Componente componente = new Componente(name + " " + this.internalObjectCounter, id);
        //Places the created object in a random position
        componente.setLocation(rndNum(this.container.getWidth() - componente.getWidth()), rndNum(this.container.getHeight() - componente.getHeight()));
        //Add the object in the MAP
        hashMap.put(name + this.internalObjectCounter, componente);
        //Add the key in the List
        listModel.addElement(name + " " + this.internalObjectCounter);
        //add the object in the JPanel
        this.container.add(componente);
        //Update graphics
        this.container.repaint();
    }

    /**
     * Method that changes the current image of an object to another random
     * image
     *
     * @param String Key object identifier
     */
//    public void cambiarImagen(String key, int id) {
//        Componente tmp = (Componente) hashMap.get(key);
//        tmp.setIcon(new ImageIcon(getClass().getResource("/co/edu/usbbog/datan/niote/recursos/pantallaDeEmulacion/iconos/" + id + ".png")));
//        tmp.repaint();
//    }

    /**
     * Method that changes all the images of all the objects that exist in the
     * MAP
     */
//    public void cambiarTodasLasImagenes() {
//        Iterator it = hashMap.entrySet().iterator();
//        while (it.hasNext()) {
//            Map.Entry e = (Map.Entry) it.next();
//            cambiarImagen(e.getKey().toString());
//        }
//    }

    /**
     * Returns a random integer between 0 and a number passed as a parameter
     *
     * @param int last number
     */
    public int rndNum(int value) {
        return (int) Math.floor(Math.random() * value + 1);
    }

}
