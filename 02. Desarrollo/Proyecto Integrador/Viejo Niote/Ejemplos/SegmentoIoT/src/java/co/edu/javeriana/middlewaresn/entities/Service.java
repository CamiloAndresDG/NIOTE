/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.middlewaresn.entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Oscar
 */
@Entity
@Table(name = "service")
@NamedQueries({
    @NamedQuery(name = "Service.findAll", query = "SELECT s FROM Service s")})
public class Service implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_catalog")
    private Integer idCatalog;
    @Column(name = "date_last_value")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateLastValue;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Size(max = 255)
    @Column(name = "id_susn")
    private String idSusn;
    @Size(max = 255)
    @Column(name = "last_value")
    private String lastValue;
    @Column(name = "service_state")
    private Integer serviceState;
    @OneToMany(mappedBy = "service", fetch = FetchType.EAGER)
    private List<ServiceAttribute> serviceAttributeList;
    @OneToMany(mappedBy = "service", fetch = FetchType.EAGER)
    private List<ServiceNode> serviceNodeList;

    public Service() {
    }

    public Service(Integer idCatalog) {
        this.idCatalog = idCatalog;
    }

    public Integer getIdCatalog() {
        return idCatalog;
    }

    public void setIdCatalog(Integer idCatalog) {
        this.idCatalog = idCatalog;
    }

    public Date getDateLastValue() {
        return dateLastValue;
    }

    public void setDateLastValue(Date dateLastValue) {
        this.dateLastValue = dateLastValue;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIdSusn() {
        return idSusn;
    }

    public void setIdSusn(String idSusn) {
        this.idSusn = idSusn;
    }

    public String getLastValue() {
        return lastValue;
    }

    public void setLastValue(String lastValue) {
        this.lastValue = lastValue;
    }

    public Integer getServiceState() {
        return serviceState;
    }

    public void setServiceState(Integer serviceState) {
        this.serviceState = serviceState;
    }

    public List<ServiceAttribute> getServiceAttributeList() {
        return serviceAttributeList;
    }

    public void setServiceAttributeList(List<ServiceAttribute> serviceAttributeList) {
        this.serviceAttributeList = serviceAttributeList;
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
        hash += (idCatalog != null ? idCatalog.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Service)) {
            return false;
        }
        Service other = (Service) object;
        if ((this.idCatalog == null && other.idCatalog != null) || (this.idCatalog != null && !this.idCatalog.equals(other.idCatalog))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.javeriana.middlewaresn.entities.Service[ idCatalog=" + idCatalog + " ]";
    }
    
}
