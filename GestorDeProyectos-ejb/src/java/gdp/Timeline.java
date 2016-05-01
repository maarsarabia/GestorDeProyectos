/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gdp;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
 * @author sistema
 */
@Entity
@Table(name = "TIMELINE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Timeline.findAll", query = "SELECT t FROM Timeline t"),
    @NamedQuery(name = "Timeline.findByIdtimeline", query = "SELECT t FROM Timeline t WHERE t.idtimeline = :idtimeline"),
    @NamedQuery(name = "Timeline.findByTexto", query = "SELECT t FROM Timeline t WHERE t.texto = :texto")})
public class Timeline implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDTIMELINE")
    private BigDecimal idtimeline;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "TEXTO")
    private String texto;
    @JoinColumn(name = "PROYECTO_IDPROYECTO", referencedColumnName = "IDPROYECTO")
    @ManyToOne
    private Proyecto proyectoIdproyecto;

    public Timeline() {
    }

    public Timeline(BigDecimal idtimeline) {
        this.idtimeline = idtimeline;
    }

    public Timeline(BigDecimal idtimeline, String texto) {
        this.idtimeline = idtimeline;
        this.texto = texto;
    }

    public BigDecimal getIdtimeline() {
        return idtimeline;
    }

    public void setIdtimeline(BigDecimal idtimeline) {
        this.idtimeline = idtimeline;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Proyecto getProyectoIdproyecto() {
        return proyectoIdproyecto;
    }

    public void setProyectoIdproyecto(Proyecto proyectoIdproyecto) {
        this.proyectoIdproyecto = proyectoIdproyecto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtimeline != null ? idtimeline.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Timeline)) {
            return false;
        }
        Timeline other = (Timeline) object;
        if ((this.idtimeline == null && other.idtimeline != null) || (this.idtimeline != null && !this.idtimeline.equals(other.idtimeline))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gdp.Timeline[ idtimeline=" + idtimeline + " ]";
    }
    
}
