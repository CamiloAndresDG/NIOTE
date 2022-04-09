/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.datan.piico.piicows.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 305
 */
@Entity
@Table(catalog = "ingusbbo_piico", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nodo.findAll", query = "SELECT n FROM Nodo n")
    , @NamedQuery(name = "Nodo.findById", query = "SELECT n FROM Nodo n WHERE n.id = :id")
    , @NamedQuery(name = "Nodo.findByDescripcion", query = "SELECT n FROM Nodo n WHERE n.descripcion = :descripcion")
    , @NamedQuery(name = "Nodo.findByEstado", query = "SELECT n FROM Nodo n WHERE n.estado = :estado")
    , @NamedQuery(name = "Nodo.findByProtocoloComunicacion", query = "SELECT n FROM Nodo n WHERE n.protocoloComunicacion = :protocoloComunicacion")})
public class Nodo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(nullable = false, length = 45)
    private String id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(nullable = false, length = 80)
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private short estado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "protocolo_comunicacion", nullable = false, length = 45)
    private String protocoloComunicacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nodo")
    private List<Actuador> actuadorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nodo")
    private List<Sensor> sensorList;
    @JoinColumn(name = "puerta_de_enlace", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private PuertaDeEnlace puertaDeEnlace;

    public Nodo() {
    }

    public Nodo(String id) {
        this.id = id;
    }

    public Nodo(String id, String descripcion, short estado, String protocoloComunicacion) {
        this.id = id;
        this.descripcion = descripcion;
        this.estado = estado;
        this.protocoloComunicacion = protocoloComunicacion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public short getEstado() {
        return estado;
    }

    public void setEstado(short estado) {
        this.estado = estado;
    }

    public String getProtocoloComunicacion() {
        return protocoloComunicacion;
    }

    public void setProtocoloComunicacion(String protocoloComunicacion) {
        this.protocoloComunicacion = protocoloComunicacion;
    }

    @XmlTransient
    public List<Actuador> getActuadorList() {
        return actuadorList;
    }

    public void setActuadorList(List<Actuador> actuadorList) {
        this.actuadorList = actuadorList;
    }

    @XmlTransient
    public List<Sensor> getSensorList() {
        return sensorList;
    }

    public void setSensorList(List<Sensor> sensorList) {
        this.sensorList = sensorList;
    }

    public PuertaDeEnlace getPuertaDeEnlace() {
        return puertaDeEnlace;
    }

    public void setPuertaDeEnlace(PuertaDeEnlace puertaDeEnlace) {
        this.puertaDeEnlace = puertaDeEnlace;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nodo)) {
            return false;
        }
        Nodo other = (Nodo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.usbbog.datan.piico.piicows.model.Nodo[ id=" + id + " ]";
    }
    
}
