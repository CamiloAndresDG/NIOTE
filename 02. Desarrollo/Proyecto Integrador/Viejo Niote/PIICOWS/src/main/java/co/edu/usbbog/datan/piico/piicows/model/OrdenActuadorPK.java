/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.datan.piico.piicows.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author 305
 */
@Embeddable
public class OrdenActuadorPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "orden_id", nullable = false, length = 45)
    private String ordenId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "actuador_id", nullable = false, length = 45)
    private String actuadorId;

    public OrdenActuadorPK() {
    }

    public OrdenActuadorPK(String ordenId, String actuadorId) {
        this.ordenId = ordenId;
        this.actuadorId = actuadorId;
    }

    public String getOrdenId() {
        return ordenId;
    }

    public void setOrdenId(String ordenId) {
        this.ordenId = ordenId;
    }

    public String getActuadorId() {
        return actuadorId;
    }

    public void setActuadorId(String actuadorId) {
        this.actuadorId = actuadorId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ordenId != null ? ordenId.hashCode() : 0);
        hash += (actuadorId != null ? actuadorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdenActuadorPK)) {
            return false;
        }
        OrdenActuadorPK other = (OrdenActuadorPK) object;
        if ((this.ordenId == null && other.ordenId != null) || (this.ordenId != null && !this.ordenId.equals(other.ordenId))) {
            return false;
        }
        if ((this.actuadorId == null && other.actuadorId != null) || (this.actuadorId != null && !this.actuadorId.equals(other.actuadorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.usbbog.datan.piico.piicows.model.OrdenActuadorPK[ ordenId=" + ordenId + ", actuadorId=" + actuadorId + " ]";
    }
    
}
