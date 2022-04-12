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
@Table(name = "protocol_type")
@NamedQueries({
    @NamedQuery(name = "ProtocolType.findAll", query = "SELECT p FROM ProtocolType p")})
public class ProtocolType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "protocol_type_id")
    private Integer protocolTypeId;
    @Size(max = 500)
    @Column(name = "description")
    private String description;
    @OneToMany(mappedBy = "protocolType", fetch = FetchType.EAGER)
    private List<ServiceNode> serviceNodeList;

    public ProtocolType() {
    }

    public ProtocolType(Integer protocolTypeId) {
        this.protocolTypeId = protocolTypeId;
    }

    public Integer getProtocolTypeId() {
        return protocolTypeId;
    }

    public void setProtocolTypeId(Integer protocolTypeId) {
        this.protocolTypeId = protocolTypeId;
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
        hash += (protocolTypeId != null ? protocolTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProtocolType)) {
            return false;
        }
        ProtocolType other = (ProtocolType) object;
        if ((this.protocolTypeId == null && other.protocolTypeId != null) || (this.protocolTypeId != null && !this.protocolTypeId.equals(other.protocolTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.javeriana.middlewaresn.entities.ProtocolType[ protocolTypeId=" + protocolTypeId + " ]";
    }
    
}
