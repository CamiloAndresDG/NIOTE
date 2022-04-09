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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "service_node")
@NamedQueries({
    @NamedQuery(name = "ServiceNode.findAll", query = "SELECT s FROM ServiceNode s")})
public class ServiceNode implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_service_node")
    private Integer idServiceNode;
    @Size(max = 255)
    @Column(name = "id_node")
    private String idNode;
    @Size(max = 255)
    @Column(name = "ip")
    private String ip;
    @Size(max = 255)
    @Column(name = "id_swsn")
    private String idSwsn;
    @Column(name = "service_node_state")
    private Integer serviceNodeState;
    @OneToMany(mappedBy = "serviceNode", fetch = FetchType.EAGER)
    private List<ServiceNodeAttribute> serviceNodeAttributeList;
    @OneToMany(mappedBy = "serviceNode", fetch = FetchType.EAGER)
    private List<ServiceNodeValue> serviceNodeValueList;
    @JoinColumn(name = "node_type_id", referencedColumnName = "node_type_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private NodeType nodeType;
    @JoinColumn(name = "protocol_type_id", referencedColumnName = "protocol_type_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private ProtocolType protocolType;
    @JoinColumn(name = "id_catalog", referencedColumnName = "id_catalog")
    @ManyToOne(fetch = FetchType.EAGER)
    private Service service;
    @JoinColumn(name = "service_type_id", referencedColumnName = "sevice_type_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private ServiceType serviceType;

    public ServiceNode() {
    }

    public ServiceNode(Integer idServiceNode) {
        this.idServiceNode = idServiceNode;
    }

    public Integer getIdServiceNode() {
        return idServiceNode;
    }

    public void setIdServiceNode(Integer idServiceNode) {
        this.idServiceNode = idServiceNode;
    }

    public String getIdNode() {
        return idNode;
    }

    public void setIdNode(String idNode) {
        this.idNode = idNode;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getIdSwsn() {
        return idSwsn;
    }

    public void setIdSwsn(String idSwsn) {
        this.idSwsn = idSwsn;
    }

    public Integer getServiceNodeState() {
        return serviceNodeState;
    }

    public void setServiceNodeState(Integer serviceNodeState) {
        this.serviceNodeState = serviceNodeState;
    }

    public List<ServiceNodeAttribute> getServiceNodeAttributeList() {
        return serviceNodeAttributeList;
    }

    public void setServiceNodeAttributeList(List<ServiceNodeAttribute> serviceNodeAttributeList) {
        this.serviceNodeAttributeList = serviceNodeAttributeList;
    }

    public List<ServiceNodeValue> getServiceNodeValueList() {
        return serviceNodeValueList;
    }

    public void setServiceNodeValueList(List<ServiceNodeValue> serviceNodeValueList) {
        this.serviceNodeValueList = serviceNodeValueList;
    }

    public NodeType getNodeType() {
        return nodeType;
    }

    public void setNodeType(NodeType nodeType) {
        this.nodeType = nodeType;
    }

    public ProtocolType getProtocolType() {
        return protocolType;
    }

    public void setProtocolType(ProtocolType protocolType) {
        this.protocolType = protocolType;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idServiceNode != null ? idServiceNode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ServiceNode)) {
            return false;
        }
        ServiceNode other = (ServiceNode) object;
        if ((this.idServiceNode == null && other.idServiceNode != null) || (this.idServiceNode != null && !this.idServiceNode.equals(other.idServiceNode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.javeriana.middlewaresn.entities.ServiceNode[ idServiceNode=" + idServiceNode + " ]";
    }
    
}
