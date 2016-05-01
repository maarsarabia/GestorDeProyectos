/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dgp.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
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
 * @author sistema
 */
@Entity
@Table(name = "PROYECTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proyecto.findAll", query = "SELECT p FROM Proyecto p"),
    @NamedQuery(name = "Proyecto.findByNombre", query = "SELECT p FROM Proyecto p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Proyecto.findByIdproyecto", query = "SELECT p FROM Proyecto p WHERE p.idproyecto = :idproyecto")})
public class Proyecto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMBRE")
    private String nombre;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDPROYECTO")
    private BigDecimal idproyecto;
    @JoinTable(name = "RELATION_2", joinColumns = {
        @JoinColumn(name = "PROYECTO_IDPROYECTO", referencedColumnName = "IDPROYECTO")}, inverseJoinColumns = {
        @JoinColumn(name = "USUARIO_IDUSUARIO", referencedColumnName = "IDUSUARIO")})
    @ManyToMany
    private Collection<Usuario> usuarioCollection;
    @OneToMany(mappedBy = "proyectoIdproyecto")
    private Collection<Tarea> tareaCollection;
    @OneToMany(mappedBy = "proyectoIdproyecto")
    private Collection<Timeline> timelineCollection;

    public Proyecto() {
    }

    public Proyecto(BigDecimal idproyecto) {
        this.idproyecto = idproyecto;
    }

    public Proyecto(BigDecimal idproyecto, String nombre) {
        this.idproyecto = idproyecto;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getIdproyecto() {
        return idproyecto;
    }

    public void setIdproyecto(BigDecimal idproyecto) {
        this.idproyecto = idproyecto;
    }

    @XmlTransient
    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }

    @XmlTransient
    public Collection<Tarea> getTareaCollection() {
        return tareaCollection;
    }

    public void setTareaCollection(Collection<Tarea> tareaCollection) {
        this.tareaCollection = tareaCollection;
    }

    @XmlTransient
    public Collection<Timeline> getTimelineCollection() {
        return timelineCollection;
    }

    public void setTimelineCollection(Collection<Timeline> timelineCollection) {
        this.timelineCollection = timelineCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idproyecto != null ? idproyecto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proyecto)) {
            return false;
        }
        Proyecto other = (Proyecto) object;
        if ((this.idproyecto == null && other.idproyecto != null) || (this.idproyecto != null && !this.idproyecto.equals(other.idproyecto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gdp.Proyecto[ idproyecto=" + idproyecto + " ]";
    }
    
}
