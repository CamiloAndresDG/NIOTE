/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.middlewaresn.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Oscar
 */
@Entity
@Table(name = "attribute_type")
@NamedQueries({
    @NamedQuery(name = "AttributeType.findAll", query = "SELECT a FROM AttributeType a")})
public class AttributeType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "attribute_type_id")
    private Integer attributeTypeId;
    @Size(max = 500)
    @Column(name = "description")
    private String description;
    @OneToMany(mappedBy = "attributeType", fetch = FetchType.EAGER)
    private List<ServiceNodeAttribute> serviceNodeAttributeList;
    @OneToMany(mappedBy = "attributeType", fetch = FetchType.EAGER)
    private List<ServiceAttribute> serviceAttributeList;

    public AttributeType() {
    }

    public AttributeType(Integer attributeTypeId) {
        this.attributeTypeId = attributeTypeId;
    }

    public Integer getAttributeTypeId() {
        return attributeTypeId;
    }

    public void setAttributeTypeId(Integer attributeTypeId) {
        this.attributeTypeId = attributeTypeId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ServiceNodeAttribute> getServiceNodeAttributeList() {
        return serviceNodeAttributeList;
    }

    public void setServiceNodeAttributeList(List<ServiceNodeAttribute> serviceNodeAttributeList) {
        this.serviceNodeAttributeList = serviceNodeAttributeList;
    }

    public List<ServiceAttribute> getServiceAttributeList() {
        return serviceAttributeList;
    }

    public void setServiceAttributeList(List<ServiceAttribute> serviceAttributeList) {
        this.serviceAttributeList = serviceAttributeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (attributeTypeId != null ? attributeTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AttributeType)) {
            return false;
        }
        AttributeType other = (AttributeType) object;
        if ((this.attributeTypeId == null && other.attributeTypeId != null) || (this.attributeTypeId != null && !this.attributeTypeId.equals(other.attributeTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.javeriana.middlewaresn.entities.AttributeType[ attributeTypeId=" + attributeTypeId + " ]";
    }
    
}
