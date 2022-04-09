/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.middlewaresn.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Oscar
 */
@Entity
@Table(name = "service_node_value")
@NamedQueries({
    @NamedQuery(name = "ServiceNodeValue.findAll", query = "SELECT s FROM ServiceNodeValue s")})
public class ServiceNodeValue implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_service_node_value")
    private Integer idServiceNodeValue;
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Size(max = 255)
    @Column(name = "value")
    private String value;
    @JoinColumn(name = "id_service_node", referencedColumnName = "id_service_node")
    @ManyToOne(fetch = FetchType.EAGER)
    private ServiceNode serviceNode;

    public ServiceNodeValue() {
    }

    public ServiceNodeValue(Integer idServiceNodeValue) {
        this.idServiceNodeValue = idServiceNodeValue;
    }

    public Integer getIdServiceNodeValue() {
        return idServiceNodeValue;
    }

    public void setIdServiceNodeValue(Integer idServiceNodeValue) {
        this.idServiceNodeValue = idServiceNodeValue;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public ServiceNode getServiceNode() {
        return serviceNode;
    }

    public void setServiceNode(ServiceNode serviceNode) {
        this.serviceNode = serviceNode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idServiceNodeValue != null ? idServiceNodeValue.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ServiceNodeValue)) {
            return false;
        }
        ServiceNodeValue other = (ServiceNodeValue) object;
        if ((this.idServiceNodeValue == null && other.idServiceNodeValue != null) || (this.idServiceNodeValue != null && !this.idServiceNodeValue.equals(other.idServiceNodeValue))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.javeriana.middlewaresn.entities.ServiceNodeValue[ idServiceNodeValue=" + idServiceNodeValue + " ]";
    }
    
}
