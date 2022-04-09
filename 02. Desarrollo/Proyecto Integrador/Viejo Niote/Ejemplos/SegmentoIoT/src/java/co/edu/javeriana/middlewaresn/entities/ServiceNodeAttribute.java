/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.middlewaresn.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Oscar
 */
@Entity
@Table(name = "service_node_attribute")
@NamedQueries({
    @NamedQuery(name = "ServiceNodeAttribute.findAll", query = "SELECT s FROM ServiceNodeAttribute s")})
public class ServiceNodeAttribute implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_service_node_attribute")
    private Integer idServiceNodeAttribute;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Size(max = 255)
    @Column(name = "value")
    private String value;
    @JoinColumn(name = "attribute_type_id", referencedColumnName = "attribute_type_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private AttributeType attributeType;
    @JoinColumn(name = "id_service_node", referencedColumnName = "id_service_node")
    @ManyToOne(fetch = FetchType.EAGER)
    private ServiceNode serviceNode;

    public ServiceNodeAttribute() {
    }

    public ServiceNodeAttribute(Integer idServiceNodeAttribute) {
        this.idServiceNodeAttribute = idServiceNodeAttribute;
    }

    public Integer getIdServiceNodeAttribute() {
        return idServiceNodeAttribute;
    }

    public void setIdServiceNodeAttribute(Integer idServiceNodeAttribute) {
        this.idServiceNodeAttribute = idServiceNodeAttribute;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public AttributeType getAttributeType() {
        return attributeType;
    }

    public void setAttributeType(AttributeType attributeType) {
        this.attributeType = attributeType;
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
        hash += (idServiceNodeAttribute != null ? idServiceNodeAttribute.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ServiceNodeAttribute)) {
            return false;
        }
        ServiceNodeAttribute other = (ServiceNodeAttribute) object;
        if ((this.idServiceNodeAttribute == null && other.idServiceNodeAttribute != null) || (this.idServiceNodeAttribute != null && !this.idServiceNodeAttribute.equals(other.idServiceNodeAttribute))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.javeriana.middlewaresn.entities.ServiceNodeAttribute[ idServiceNodeAttribute=" + idServiceNodeAttribute + " ]";
    }
    
}
