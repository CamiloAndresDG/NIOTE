
package red.nodos.ubicuos.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para AgregarEventos complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="AgregarEventos">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tipoAccion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="valor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tipoNodo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idObjeto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="objeto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="contenido" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fecha" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="visto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="publicado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AgregarEventos", propOrder = {
    "tipoAccion",
    "valor",
    "tipoNodo",
    "idObjeto",
    "objeto",
    "contenido",
    "fecha",
    "visto",
    "publicado"
})
public class AgregarEventos {

    protected String tipoAccion;
    protected String valor;
    protected String tipoNodo;
    protected String idObjeto;
    protected String objeto;
    protected String contenido;
    protected String fecha;
    protected String visto;
    protected String publicado;

    /**
     * Obtiene el valor de la propiedad tipoAccion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoAccion() {
        return tipoAccion;
    }

    /**
     * Define el valor de la propiedad tipoAccion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoAccion(String value) {
        this.tipoAccion = value;
    }

    /**
     * Obtiene el valor de la propiedad valor.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValor() {
        return valor;
    }

    /**
     * Define el valor de la propiedad valor.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValor(String value) {
        this.valor = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoNodo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoNodo() {
        return tipoNodo;
    }

    /**
     * Define el valor de la propiedad tipoNodo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoNodo(String value) {
        this.tipoNodo = value;
    }

    /**
     * Obtiene el valor de la propiedad idObjeto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdObjeto() {
        return idObjeto;
    }

    /**
     * Define el valor de la propiedad idObjeto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdObjeto(String value) {
        this.idObjeto = value;
    }

    /**
     * Obtiene el valor de la propiedad objeto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObjeto() {
        return objeto;
    }

    /**
     * Define el valor de la propiedad objeto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObjeto(String value) {
        this.objeto = value;
    }

    /**
     * Obtiene el valor de la propiedad contenido.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContenido() {
        return contenido;
    }

    /**
     * Define el valor de la propiedad contenido.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContenido(String value) {
        this.contenido = value;
    }

    /**
     * Obtiene el valor de la propiedad fecha.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * Define el valor de la propiedad fecha.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFecha(String value) {
        this.fecha = value;
    }

    /**
     * Obtiene el valor de la propiedad visto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVisto() {
        return visto;
    }

    /**
     * Define el valor de la propiedad visto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVisto(String value) {
        this.visto = value;
    }

    /**
     * Obtiene el valor de la propiedad publicado.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPublicado() {
        return publicado;
    }

    /**
     * Define el valor de la propiedad publicado.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPublicado(String value) {
        this.publicado = value;
    }

}
