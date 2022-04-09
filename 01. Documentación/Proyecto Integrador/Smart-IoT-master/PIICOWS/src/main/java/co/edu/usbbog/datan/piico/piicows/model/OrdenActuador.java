/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.datan.piico.piicows.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 305
 */
@Entity
@Table(name = "orden_actuador", catalog = "ingusbbo_piico", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrdenActuador.findAll", query = "SELECT o FROM OrdenActuador o")
    , @NamedQuery(name = "OrdenActuador.findByOrdenId", query = "SELECT o FROM OrdenActuador o WHERE o.ordenActuadorPK.ordenId = :ordenId")
    , @NamedQuery(name = "OrdenActuador.findByActuadorId", query = "SELECT o FROM OrdenActuador o WHERE o.ordenActuadorPK.actuadorId = :actuadorId")
    , @NamedQuery(name = "OrdenActuador.findByFecha", query = "SELECT o FROM OrdenActuador o WHERE o.fecha = :fecha")
    , @NamedQuery(name = "OrdenActuador.findByConfirmacion", query = "SELECT o FROM OrdenActuador o WHERE o.confirmacion = :confirmacion")})
public class OrdenActuador implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OrdenActuadorPK ordenActuadorPK;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private short confirmacion;
    @JoinColumn(name = "actuador_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Actuador actuador;
    @JoinColumn(name = "orden_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Orden orden;

    public OrdenActuador() {
    }

    public OrdenActuador(OrdenActuadorPK ordenActuadorPK) {
        this.ordenActuadorPK = ordenActuadorPK;
    }

    public OrdenActuador(OrdenActuadorPK ordenActuadorPK, Date fecha, short confirmacion) {
        this.ordenActuadorPK = ordenActuadorPK;
        this.fecha = fecha;
        this.confirmacion = confirmacion;
    }

    public OrdenActuador(String ordenId, String actuadorId) {
        this.ordenActuadorPK = new OrdenActuadorPK(ordenId, actuadorId);
    }

    public OrdenActuadorPK getOrdenActuadorPK() {
        return ordenActuadorPK;
    }

    public void setOrdenActuadorPK(OrdenActuadorPK ordenActuadorPK) {
        this.ordenActuadorPK = ordenActuadorPK;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public short getConfirmacion() {
        return confirmacion;
    }

    public void setConfirmacion(short confirmacion) {
        this.confirmacion = confirmacion;
    }

    public Actuador getActuador() {
        return actuador;
    }

    public void setActuador(Actuador actuador) {
        this.actuador = actuador;
    }

    public Orden getOrden() {
        return orden;
    }

    public void setOrden(Orden orden) {
        this.orden = orden;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ordenActuadorPK != null ? ordenActuadorPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdenActuador)) {
            return false;
        }
        OrdenActuador other = (OrdenActuador) object;
        if ((this.ordenActuadorPK == null && other.ordenActuadorPK != null) || (this.ordenActuadorPK != null && !this.ordenActuadorPK.equals(other.ordenActuadorPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.usbbog.datan.piico.piicows.model.OrdenActuador[ ordenActuadorPK=" + ordenActuadorPK + " ]";
    }
    
}
