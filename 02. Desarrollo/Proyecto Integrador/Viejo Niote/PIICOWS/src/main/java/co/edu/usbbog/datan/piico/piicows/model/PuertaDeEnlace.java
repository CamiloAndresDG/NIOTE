/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.datan.piico.piicows.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 305
 */
@Entity
@Table(name = "puerta_de_enlace", catalog = "ingusbbo_piico", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PuertaDeEnlace.findAll", query = "SELECT p FROM PuertaDeEnlace p")
    , @NamedQuery(name = "PuertaDeEnlace.findById", query = "SELECT p FROM PuertaDeEnlace p WHERE p.id = :id")
    , @NamedQuery(name = "PuertaDeEnlace.findByDescripcion", query = "SELECT p FROM PuertaDeEnlace p WHERE p.descripcion = :descripcion")
    , @NamedQuery(name = "PuertaDeEnlace.findByEstado", query = "SELECT p FROM PuertaDeEnlace p WHERE p.estado = :estado")
    , @NamedQuery(name = "PuertaDeEnlace.findByDireccionLogica", query = "SELECT p FROM PuertaDeEnlace p WHERE p.direccionLogica = :direccionLogica")
    , @NamedQuery(name = "PuertaDeEnlace.findByPuertoDeServicio", query = "SELECT p FROM PuertaDeEnlace p WHERE p.puertoDeServicio = :puertoDeServicio")
    , @NamedQuery(name = "PuertaDeEnlace.findByProtComunExt", query = "SELECT p FROM PuertaDeEnlace p WHERE p.protComunExt = :protComunExt")})
public class PuertaDeEnlace implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(nullable = false, length = 45)
    private String id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(nullable = false, length = 80)
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private short estado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "direccion_logica", nullable = false, length = 60)
    private String direccionLogica;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "puerto_de_servicio", nullable = false, length = 10)
    private String puertoDeServicio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "prot_comun_ext", nullable = false, length = 45)
    private String protComunExt;
    @JoinTable(name = "puerta_enlace_red", joinColumns = {
        @JoinColumn(name = "puerta_de_enlace", referencedColumnName = "id", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "red", referencedColumnName = "id", nullable = false)})
    @ManyToMany
    private List<Red> redList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "puertaDeEnlace")
    private List<Auth> authList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "puertaDeEnlace")
    private List<Mensajes> mensajesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "puertaDeEnlace")
    private List<Nodo> nodoList;

    public PuertaDeEnlace() {
    }

    public PuertaDeEnlace(String id) {
        this.id = id;
    }

    public PuertaDeEnlace(String id, String descripcion, short estado, String direccionLogica, String puertoDeServicio, String protComunExt) {
        this.id = id;
        this.descripcion = descripcion;
        this.estado = estado;
        this.direccionLogica = direccionLogica;
        this.puertoDeServicio = puertoDeServicio;
        this.protComunExt = protComunExt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public short getEstado() {
        return estado;
    }

    public void setEstado(short estado) {
        this.estado = estado;
    }

    public String getDireccionLogica() {
        return direccionLogica;
    }

    public void setDireccionLogica(String direccionLogica) {
        this.direccionLogica = direccionLogica;
    }

    public String getPuertoDeServicio() {
        return puertoDeServicio;
    }

    public void setPuertoDeServicio(String puertoDeServicio) {
        this.puertoDeServicio = puertoDeServicio;
    }

    public String getProtComunExt() {
        return protComunExt;
    }

    public void setProtComunExt(String protComunExt) {
        this.protComunExt = protComunExt;
    }

    @XmlTransient
    public List<Red> getRedList() {
        return redList;
    }

    public void setRedList(List<Red> redList) {
        this.redList = redList;
    }

    @XmlTransient
    public List<Auth> getAuthList() {
        return authList;
    }

    public void setAuthList(List<Auth> authList) {
        this.authList = authList;
    }

    @XmlTransient
    public List<Mensajes> getMensajesList() {
        return mensajesList;
    }

    public void setMensajesList(List<Mensajes> mensajesList) {
        this.mensajesList = mensajesList;
    }

    @XmlTransient
    public List<Nodo> getNodoList() {
        return nodoList;
    }

    public void setNodoList(List<Nodo> nodoList) {
        this.nodoList = nodoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PuertaDeEnlace)) {
            return false;
        }
        PuertaDeEnlace other = (PuertaDeEnlace) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.usbbog.datan.piico.piicows.model.PuertaDeEnlace[ id=" + id + " ]";
    }
    
}
