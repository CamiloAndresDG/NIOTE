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
    @NamedQuery(name = "Sensor.findAll", query = "SELECT s FROM Sensor s")
    , @NamedQuery(name = "Sensor.findById", query = "SELECT s FROM Sensor s WHERE s.id = :id")
    , @NamedQuery(name = "Sensor.findByDescripcion", query = "SELECT s FROM Sensor s WHERE s.descripcion = :descripcion")
    , @NamedQuery(name = "Sensor.findByEstado", query = "SELECT s FROM Sensor s WHERE s.estado = :estado")
    , @NamedQuery(name = "Sensor.findByTipo", query = "SELECT s FROM Sensor s WHERE s.tipo = :tipo")
    , @NamedQuery(name = "Sensor.findByMagnitud", query = "SELECT s FROM Sensor s WHERE s.magnitud = :magnitud")
    , @NamedQuery(name = "Sensor.findByFrecuencia", query = "SELECT s FROM Sensor s WHERE s.frecuencia = :frecuencia")})
public class Sensor implements Serializable {

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
    @Size(min = 1, max = 80)
    @Column(nullable = false, length = 80)
    private String tipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(nullable = false, length = 50)
    private String magnitud;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int frecuencia;
    @OneToMany(mappedBy = "sensor")
    private List<Actuador> actuadorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sensor")
    private List<Dato> datoList;
    @JoinColumn(name = "nodo", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Nodo nodo;

    public Sensor() {
    }

    public Sensor(String id) {
        this.id = id;
    }

    public Sensor(String id, String descripcion, short estado, String tipo, String magnitud, int frecuencia) {
        this.id = id;
        this.descripcion = descripcion;
        this.estado = estado;
        this.tipo = tipo;
        this.magnitud = magnitud;
        this.frecuencia = frecuencia;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMagnitud() {
        return magnitud;
    }

    public void setMagnitud(String magnitud) {
        this.magnitud = magnitud;
    }

    public int getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(int frecuencia) {
        this.frecuencia = frecuencia;
    }

    @XmlTransient
    public List<Actuador> getActuadorList() {
        return actuadorList;
    }

    public void setActuadorList(List<Actuador> actuadorList) {
        this.actuadorList = actuadorList;
    }

    @XmlTransient
    public List<Dato> getDatoList() {
        return datoList;
    }

    public void setDatoList(List<Dato> datoList) {
        this.datoList = datoList;
    }

    public Nodo getNodo() {
        return nodo;
    }

    public void setNodo(Nodo nodo) {
        this.nodo = nodo;
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
        if (!(object instanceof Sensor)) {
            return false;
        }
        Sensor other = (Sensor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.usbbog.datan.piico.piicows.model.Sensor[ id=" + id + " ]";
    }
    
}
