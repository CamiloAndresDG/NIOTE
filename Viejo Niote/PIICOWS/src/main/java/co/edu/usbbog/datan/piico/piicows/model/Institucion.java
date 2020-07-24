/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.datan.piico.piicows.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(catalog = "ingusbbo_piico", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Institucion.findAll", query = "SELECT i FROM Institucion i")
    , @NamedQuery(name = "Institucion.findById", query = "SELECT i FROM Institucion i WHERE i.id = :id")
    , @NamedQuery(name = "Institucion.findByNombre", query = "SELECT i FROM Institucion i WHERE i.nombre = :nombre")
    , @NamedQuery(name = "Institucion.findByCiudad", query = "SELECT i FROM Institucion i WHERE i.ciudad = :ciudad")
    , @NamedQuery(name = "Institucion.findByArea", query = "SELECT i FROM Institucion i WHERE i.area = :area")})
public class Institucion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(nullable = false, length = 45)
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(nullable = false, length = 45)
    private String ciudad;
    @Size(max = 45)
    @Column(length = 45)
    private String area;
    @JoinTable(name = "proyecto_institucion", joinColumns = {
        @JoinColumn(name = "institucion", referencedColumnName = "id", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "proyecto", referencedColumnName = "id", nullable = false)})
    @ManyToMany
    private List<Proyecto> proyectoList;

    public Institucion() {
    }

    public Institucion(Integer id) {
        this.id = id;
    }

    public Institucion(Integer id, String nombre, String ciudad) {
        this.id = id;
        this.nombre = nombre;
        this.ciudad = ciudad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @XmlTransient
    public List<Proyecto> getProyectoList() {
        return proyectoList;
    }

    public void setProyectoList(List<Proyecto> proyectoList) {
        this.proyectoList = proyectoList;
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
        if (!(object instanceof Institucion)) {
            return false;
        }
        Institucion other = (Institucion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.usbbog.datan.piico.piicows.model.Institucion[ id=" + id + " ]";
    }
    
}
