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
@Table(name = "service_type")
@NamedQueries({
    @NamedQuery(name = "ServiceType.findAll", query = "SELECT s FROM ServiceType s")})
public class ServiceType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "sevice_type_id")
    private Integer seviceTypeId;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @OneToMany(mappedBy = "serviceType", fetch = FetchType.EAGER)
    private List<ServiceNode> serviceNodeList;

    public ServiceType() {
    }

    public ServiceType(Integer seviceTypeId) {
        this.seviceTypeId = seviceTypeId;
    }

    public Integer getSeviceTypeId() {
        return seviceTypeId;
    }

    public void setSeviceTypeId(Integer seviceTypeId) {
        this.seviceTypeId = seviceTypeId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ServiceNode> getServiceNodeList() {
        return serviceNodeList;
    }

    public void setServiceNodeList(List<ServiceNode> serviceNodeList) {
        this.serviceNodeList = serviceNodeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (seviceTypeId != null ? seviceTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ServiceType)) {
            return false;
        }
        ServiceType other = (ServiceType) object;
        if ((this.seviceTypeId == null && other.seviceTypeId != null) || (this.seviceTypeId != null && !this.seviceTypeId.equals(other.seviceTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.javeriana.middlewaresn.entities.ServiceType[ seviceTypeId=" + seviceTypeId + " ]";
    }
    
}
