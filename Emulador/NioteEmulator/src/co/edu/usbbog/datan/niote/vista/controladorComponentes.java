package co.edu.usbbog.datan.niote.vista;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
/**
 * @author Juan
 */
public class controladorComponentes {

    /** COntador interno de objetos */
    private int contador_de_objetos = 0;
    /** Los objetos se almacenaran en un HASH-MAP */
    private Map hashMap = new HashMap();   
    /** JPanel */
    private JPanel contenedor;
    /** DefaultListModel */
    private DefaultListModel listModel;
    
    /** Constructor de clase 
     * @param JPanel Donde se colocaran los objetos
     * @param DefaultListModel Aqui se almacenaran los key (identificadores) de objetos
     */
    public controladorComponentes(JPanel jpanel , DefaultListModel listModel ){
        this.contenedor = jpanel;
        this.listModel = listModel;
    }
    
    /**
     * Metodo que crea un nuevo objeto
     */
    public void nuevoComponente(String nombre)
    {
        //aumenta contador en +1        
        this.contador_de_objetos +=1;
        //Crea una nueva instancia de "Componente y el numero del objeto asignandole un nombre"
        Componente componente = new Componente( nombre + " " + this.contador_de_objetos );
        //coloca al objeto creado en una posicion aleatoria
        componente.setLocation( rndNum( this.contenedor.getWidth() - componente.getWidth() )  , rndNum(this.contenedor.getHeight()-componente.getHeight() ) );        
        //agrega el objeto en el MAP
        hashMap.put("Componente " + this.contador_de_objetos, componente );        
        //agrega el KEY en el List
        listModel.addElement( nombre + " " + this.contador_de_objetos );
        //agrega el objeto en el JPanel
        this.contenedor.add(componente);
        //actualiza graficos
        this.contenedor.repaint();
    }
    
    /**
     * Metodo que cambia la imagen actual de un objeto por otra imagen aleatoria
     * @param String Key identificador de objeto
     */
    public void cambiarImagen( String key )
    {
        Componente tmp = (Componente) hashMap.get( key );
        tmp.setIcon( new ImageIcon(getClass().getResource("/org/bolivia/app/res/" + ((int) Math.floor(Math.random()*4+1))+ ".png")) ); 
        tmp.repaint();
    }
     
    /**
     * Metodo que cambia todas las imagenes de todos los objetos que existan en el MAP
     */
    public void cambiarTodasLasImagenes()
    {
        Iterator it = hashMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry e = (Map.Entry)it.next();
            cambiarImagen( e.getKey().toString() );            
        }
    }
    
    /**
     * Retorna un numero entero aleatorio entre 0 y un numero pasado como parametro
     * @param int numero entero
     */
    public int rndNum( int value ){          
        return (int) Math.floor(Math.random()*value+1);
    }
    
}//->fin de clase
