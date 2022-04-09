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
@Table(name = "service_attribute")
@NamedQueries({
    @NamedQuery(name = "ServiceAttribute.findAll", query = "SELECT s FROM ServiceAttribute s")})
public class ServiceAttribute implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_service_attribute")
    private Integer idServiceAttribute;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Size(max = 255)
    @Column(name = "value")
    private String value;
    @JoinColumn(name = "attribute_type_id", referencedColumnName = "attribute_type_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private AttributeType attributeType;
    @JoinColumn(name = "id_catalog", referencedColumnName = "id_catalog")
    @ManyToOne(fetch = FetchType.EAGER)
    private Service service;

    public ServiceAttribute() {
    }

    public ServiceAttribute(Integer idServiceAttribute) {
        this.idServiceAttribute = idServiceAttribute;
    }

    public Integer getIdServiceAttribute() {
        return idServiceAttribute;
    }

    public void setIdServiceAttribute(Integer idServiceAttribute) {
        this.idServiceAttribute = idServiceAttribute;
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

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idServiceAttribute != null ? idServiceAttribute.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ServiceAttribute)) {
            return false;
        }
        ServiceAttribute other = (ServiceAttribute) object;
        if ((this.idServiceAttribute == null && other.idServiceAttribute != null) || (this.idServiceAttribute != null && !this.idServiceAttribute.equals(other.idServiceAttribute))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.javeriana.middlewaresn.entities.ServiceAttribute[ idServiceAttribute=" + idServiceAttribute + " ]";
    }
    
}
