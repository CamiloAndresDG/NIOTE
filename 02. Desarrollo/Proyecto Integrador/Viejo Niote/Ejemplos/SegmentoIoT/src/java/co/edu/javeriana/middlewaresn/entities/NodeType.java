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
@Table(name = "node_type")
@NamedQueries({
    @NamedQuery(name = "NodeType.findAll", query = "SELECT n FROM NodeType n")})
public class NodeType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "node_type_id")
    private Integer nodeTypeId;
    @Size(max = 500)
    @Column(name = "description")
    private String description;
    @OneToMany(mappedBy = "nodeType", fetch = FetchType.EAGER)
    private List<ServiceNode> serviceNodeList;

    public NodeType() {
    }

    public NodeType(Integer nodeTypeId) {
        this.nodeTypeId = nodeTypeId;
    }

    public Integer getNodeTypeId() {
        return nodeTypeId;
    }

    public void setNodeTypeId(Integer nodeTypeId) {
        this.nodeTypeId = nodeTypeId;
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
        hash += (nodeTypeId != null ? nodeTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NodeType)) {
            return false;
        }
        NodeType other = (NodeType) object;
        if ((this.nodeTypeId == null && other.nodeTypeId != null) || (this.nodeTypeId != null && !this.nodeTypeId.equals(other.nodeTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.javeriana.middlewaresn.entities.NodeType[ nodeTypeId=" + nodeTypeId + " ]";
    }
    
}
