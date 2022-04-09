
package red.nodos.ubicuos.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the red.nodos.ubicuos.ws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AgregarEventos_QNAME = new QName("http://iot.servicio/", "AgregarEventos");
    private final static QName _BienestarResponse_QNAME = new QName("http://iot.servicio/", "BienestarResponse");
    private final static QName _PrenderTVResponse_QNAME = new QName("http://iot.servicio/", "PrenderTVResponse");
    private final static QName _Salud_QNAME = new QName("http://iot.servicio/", "Salud");
    private final static QName _ApagarTVResponse_QNAME = new QName("http://iot.servicio/", "ApagarTVResponse");
    private final static QName _AgregarEventosSim_QNAME = new QName("http://iot.servicio/", "AgregarEventosSim");
    private final static QName _ApagarTV_QNAME = new QName("http://iot.servicio/", "ApagarTV");
    private final static QName _SaludResponse_QNAME = new QName("http://iot.servicio/", "SaludResponse");
    private final static QName _AgregarEventosSimResponse_QNAME = new QName("http://iot.servicio/", "AgregarEventosSimResponse");
    private final static QName _PrenderTV_QNAME = new QName("http://iot.servicio/", "PrenderTV");
    private final static QName _AgregarEventosResponse_QNAME = new QName("http://iot.servicio/", "AgregarEventosResponse");
    private final static QName _Bienestar_QNAME = new QName("http://iot.servicio/", "Bienestar");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: red.nodos.ubicuos.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link PrenderTVResponse }
     * 
     */
    public PrenderTVResponse createPrenderTVResponse() {
        return new PrenderTVResponse();
    }

    /**
     * Create an instance of {@link Salud }
     * 
     */
    public Salud createSalud() {
        return new Salud();
    }

    /**
     * Create an instance of {@link BienestarResponse }
     * 
     */
    public BienestarResponse createBienestarResponse() {
        return new BienestarResponse();
    }

    /**
     * Create an instance of {@link AgregarEventos }
     * 
     */
    public AgregarEventos createAgregarEventos() {
        return new AgregarEventos();
    }

    /**
     * Create an instance of {@link Bienestar }
     * 
     */
    public Bienestar createBienestar() {
        return new Bienestar();
    }

    /**
     * Create an instance of {@link AgregarEventosResponse }
     * 
     */
    public AgregarEventosResponse createAgregarEventosResponse() {
        return new AgregarEventosResponse();
    }

    /**
     * Create an instance of {@link AgregarEventosSimResponse }
     * 
     */
    public AgregarEventosSimResponse createAgregarEventosSimResponse() {
        return new AgregarEventosSimResponse();
    }

    /**
     * Create an instance of {@link PrenderTV }
     * 
     */
    public PrenderTV createPrenderTV() {
        return new PrenderTV();
    }

    /**
     * Create an instance of {@link AgregarEventosSim }
     * 
     */
    public AgregarEventosSim createAgregarEventosSim() {
        return new AgregarEventosSim();
    }

    /**
     * Create an instance of {@link ApagarTV }
     * 
     */
    public ApagarTV createApagarTV() {
        return new ApagarTV();
    }

    /**
     * Create an instance of {@link SaludResponse }
     * 
     */
    public SaludResponse createSaludResponse() {
        return new SaludResponse();
    }

    /**
     * Create an instance of {@link ApagarTVResponse }
     * 
     */
    public ApagarTVResponse createApagarTVResponse() {
        return new ApagarTVResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AgregarEventos }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://iot.servicio/", name = "AgregarEventos")
    public JAXBElement<AgregarEventos> createAgregarEventos(AgregarEventos value) {
        return new JAXBElement<AgregarEventos>(_AgregarEventos_QNAME, AgregarEventos.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BienestarResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://iot.servicio/", name = "BienestarResponse")
    public JAXBElement<BienestarResponse> createBienestarResponse(BienestarResponse value) {
        return new JAXBElement<BienestarResponse>(_BienestarResponse_QNAME, BienestarResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PrenderTVResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://iot.servicio/", name = "PrenderTVResponse")
    public JAXBElement<PrenderTVResponse> createPrenderTVResponse(PrenderTVResponse value) {
        return new JAXBElement<PrenderTVResponse>(_PrenderTVResponse_QNAME, PrenderTVResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Salud }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://iot.servicio/", name = "Salud")
    public JAXBElement<Salud> createSalud(Salud value) {
        return new JAXBElement<Salud>(_Salud_QNAME, Salud.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ApagarTVResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://iot.servicio/", name = "ApagarTVResponse")
    public JAXBElement<ApagarTVResponse> createApagarTVResponse(ApagarTVResponse value) {
        return new JAXBElement<ApagarTVResponse>(_ApagarTVResponse_QNAME, ApagarTVResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AgregarEventosSim }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://iot.servicio/", name = "AgregarEventosSim")
    public JAXBElement<AgregarEventosSim> createAgregarEventosSim(AgregarEventosSim value) {
        return new JAXBElement<AgregarEventosSim>(_AgregarEventosSim_QNAME, AgregarEventosSim.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ApagarTV }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://iot.servicio/", name = "ApagarTV")
    public JAXBElement<ApagarTV> createApagarTV(ApagarTV value) {
        return new JAXBElement<ApagarTV>(_ApagarTV_QNAME, ApagarTV.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaludResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://iot.servicio/", name = "SaludResponse")
    public JAXBElement<SaludResponse> createSaludResponse(SaludResponse value) {
        return new JAXBElement<SaludResponse>(_SaludResponse_QNAME, SaludResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AgregarEventosSimResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://iot.servicio/", name = "AgregarEventosSimResponse")
    public JAXBElement<AgregarEventosSimResponse> createAgregarEventosSimResponse(AgregarEventosSimResponse value) {
        return new JAXBElement<AgregarEventosSimResponse>(_AgregarEventosSimResponse_QNAME, AgregarEventosSimResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PrenderTV }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://iot.servicio/", name = "PrenderTV")
    public JAXBElement<PrenderTV> createPrenderTV(PrenderTV value) {
        return new JAXBElement<PrenderTV>(_PrenderTV_QNAME, PrenderTV.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AgregarEventosResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://iot.servicio/", name = "AgregarEventosResponse")
    public JAXBElement<AgregarEventosResponse> createAgregarEventosResponse(AgregarEventosResponse value) {
        return new JAXBElement<AgregarEventosResponse>(_AgregarEventosResponse_QNAME, AgregarEventosResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Bienestar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://iot.servicio/", name = "Bienestar")
    public JAXBElement<Bienestar> createBienestar(Bienestar value) {
        return new JAXBElement<Bienestar>(_Bienestar_QNAME, Bienestar.class, null, value);
    }

}
