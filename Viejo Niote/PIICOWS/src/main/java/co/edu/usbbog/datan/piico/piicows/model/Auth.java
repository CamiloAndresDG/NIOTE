/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.datan.piico.piicows.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 305
 */
@Entity
@Table(catalog = "ingusbbo_piico", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Auth.findAll", query = "SELECT a FROM Auth a")
    , @NamedQuery(name = "Auth.findById", query = "SELECT a FROM Auth a WHERE a.id = :id")
    , @NamedQuery(name = "Auth.findByUser", query = "SELECT a FROM Auth a WHERE a.user = :user")
    , @NamedQuery(name = "Auth.findByPass", query = "SELECT a FROM Auth a WHERE a.pass = :pass")
    , @NamedQuery(name = "Auth.findByTopic", query = "SELECT a FROM Auth a WHERE a.topic = :topic")})
public class Auth implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(nullable = false, length = 80)
    private String user;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 512)
    @Column(nullable = false, length = 512)
    private String pass;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(nullable = false, length = 45)
    private String topic;
    @JoinColumn(name = "puerta_de_enlace", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private PuertaDeEnlace puertaDeEnlace;

    public Auth() {
    }

    public Auth(Integer id) {
        this.id = id;
    }

    public Auth(Integer id, String user, String pass, String topic) {
        this.id = id;
        this.user = user;
        this.pass = pass;
        this.topic = topic;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public PuertaDeEnlace getPuertaDeEnlace() {
        return puertaDeEnlace;
    }

    public void setPuertaDeEnlace(PuertaDeEnlace puertaDeEnlace) {
        this.puertaDeEnlace = puertaDeEnlace;
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
        if (!(object instanceof Auth)) {
            return false;
        }
        Auth other = (Auth) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.usbbog.datan.piico.piicows.model.Auth[ id=" + id + " ]";
    }
    
}
