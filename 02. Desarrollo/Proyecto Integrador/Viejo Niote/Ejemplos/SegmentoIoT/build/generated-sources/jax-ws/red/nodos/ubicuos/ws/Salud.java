
package red.nodos.ubicuos.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Salud complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Salud">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idSalud" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="presion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="respiracion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pulso" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="temperatura" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="saturacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Salud", propOrder = {
    "idSalud",
    "presion",
    "respiracion",
    "pulso",
    "temperatura",
    "saturacion"
})
public class Salud {

    protected int idSalud;
    protected String presion;
    protected String respiracion;
    protected String pulso;
    protected String temperatura;
    protected String saturacion;

    /**
     * Obtiene el valor de la propiedad idSalud.
     * 
     */
    public int getIdSalud() {
        return idSalud;
    }

    /**
     * Define el valor de la propiedad idSalud.
     * 
     */
    public void setIdSalud(int value) {
        this.idSalud = value;
    }

    /**
     * Obtiene el valor de la propiedad presion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPresion() {
        return presion;
    }

    /**
     * Define el valor de la propiedad presion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPresion(String value) {
        this.presion = value;
    }

    /**
     * Obtiene el valor de la propiedad respiracion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRespiracion() {
        return respiracion;
    }

    /**
     * Define el valor de la propiedad respiracion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRespiracion(String value) {
        this.respiracion = value;
    }

    /**
     * Obtiene el valor de la propiedad pulso.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPulso() {
        return pulso;
    }

    /**
     * Define el valor de la propiedad pulso.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPulso(String value) {
        this.pulso = value;
    }

    /**
     * Obtiene el valor de la propiedad temperatura.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemperatura() {
        return temperatura;
    }

    /**
     * Define el valor de la propiedad temperatura.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemperatura(String value) {
        this.temperatura = value;
    }

    /**
     * Obtiene el valor de la propiedad saturacion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSaturacion() {
        return saturacion;
    }

    /**
     * Define el valor de la propiedad saturacion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSaturacion(String value) {
        this.saturacion = value;
    }

}
