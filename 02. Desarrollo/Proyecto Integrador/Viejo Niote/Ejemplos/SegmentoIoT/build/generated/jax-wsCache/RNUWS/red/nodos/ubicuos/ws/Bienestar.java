
package red.nodos.ubicuos.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Bienestar complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Bienestar">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idBienestar" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="alimentacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="energia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="salud" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fisico" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ocio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Bienestar", propOrder = {
    "idBienestar",
    "alimentacion",
    "energia",
    "salud",
    "fisico",
    "ocio"
})
public class Bienestar {

    protected int idBienestar;
    protected String alimentacion;
    protected String energia;
    protected String salud;
    protected String fisico;
    protected String ocio;

    /**
     * Obtiene el valor de la propiedad idBienestar.
     * 
     */
    public int getIdBienestar() {
        return idBienestar;
    }

    /**
     * Define el valor de la propiedad idBienestar.
     * 
     */
    public void setIdBienestar(int value) {
        this.idBienestar = value;
    }

    /**
     * Obtiene el valor de la propiedad alimentacion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAlimentacion() {
        return alimentacion;
    }

    /**
     * Define el valor de la propiedad alimentacion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAlimentacion(String value) {
        this.alimentacion = value;
    }

    /**
     * Obtiene el valor de la propiedad energia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEnergia() {
        return energia;
    }

    /**
     * Define el valor de la propiedad energia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEnergia(String value) {
        this.energia = value;
    }

    /**
     * Obtiene el valor de la propiedad salud.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSalud() {
        return salud;
    }

    /**
     * Define el valor de la propiedad salud.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSalud(String value) {
        this.salud = value;
    }

    /**
     * Obtiene el valor de la propiedad fisico.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFisico() {
        return fisico;
    }

    /**
     * Define el valor de la propiedad fisico.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFisico(String value) {
        this.fisico = value;
    }

    /**
     * Obtiene el valor de la propiedad ocio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOcio() {
        return ocio;
    }

    /**
     * Define el valor de la propiedad ocio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOcio(String value) {
        this.ocio = value;
    }

}
