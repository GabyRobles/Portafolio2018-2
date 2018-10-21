/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author nico_
 */
@Entity
@Table(name = "VALORACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Valoracion.findAll", query = "SELECT v FROM Valoracion v")
    , @NamedQuery(name = "Valoracion.findByIdValoracion", query = "SELECT v FROM Valoracion v WHERE v.idValoracion = :idValoracion")
    , @NamedQuery(name = "Valoracion.findByValoracion", query = "SELECT v FROM Valoracion v WHERE v.valoracion = :valoracion")
    , @NamedQuery(name = "Valoracion.findByFecha", query = "SELECT v FROM Valoracion v WHERE v.fecha = :fecha")
    , @NamedQuery(name = "Valoracion.findByComentario", query = "SELECT v FROM Valoracion v WHERE v.comentario = :comentario")})
public class Valoracion implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_VALORACION")
    private BigDecimal idValoracion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VALORACION")
    private BigInteger valoracion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "COMENTARIO")
    private String comentario;
    @JoinColumn(name = "ID_CATEGORIA", referencedColumnName = "ID_CATEGORIA")
    @ManyToOne(optional = false)
    private Categoria idCategoria;
    @JoinColumn(name = "ID_CONSUMIDOR", referencedColumnName = "ID_CONSUMIDOR")
    @ManyToOne(optional = false)
    private Consumidor idConsumidor;
    @JoinColumn(name = "ID_OFERTA", referencedColumnName = "ID_OFERTA")
    @ManyToOne(optional = false)
    private Oferta idOferta;
    @JoinColumn(name = "ID_SUCURSAL", referencedColumnName = "ID_SUCURSAL")
    @ManyToOne(optional = false)
    private Sucursal idSucursal;

    public Valoracion() {
    }

    public Valoracion(BigDecimal idValoracion) {
        this.idValoracion = idValoracion;
    }

    public Valoracion(BigDecimal idValoracion, BigInteger valoracion, Date fecha, String comentario) {
        this.idValoracion = idValoracion;
        this.valoracion = valoracion;
        this.fecha = fecha;
        this.comentario = comentario;
    }

    public BigDecimal getIdValoracion() {
        return idValoracion;
    }

    public void setIdValoracion(BigDecimal idValoracion) {
        this.idValoracion = idValoracion;
    }

    public BigInteger getValoracion() {
        return valoracion;
    }

    public void setValoracion(BigInteger valoracion) {
        this.valoracion = valoracion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Categoria getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Categoria idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Consumidor getIdConsumidor() {
        return idConsumidor;
    }

    public void setIdConsumidor(Consumidor idConsumidor) {
        this.idConsumidor = idConsumidor;
    }

    public Oferta getIdOferta() {
        return idOferta;
    }

    public void setIdOferta(Oferta idOferta) {
        this.idOferta = idOferta;
    }

    public Sucursal getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(Sucursal idSucursal) {
        this.idSucursal = idSucursal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idValoracion != null ? idValoracion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Valoracion)) {
            return false;
        }
        Valoracion other = (Valoracion) object;
        if ((this.idValoracion == null && other.idValoracion != null) || (this.idValoracion != null && !this.idValoracion.equals(other.idValoracion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Valoracion[ idValoracion=" + idValoracion + " ]";
    }
    
}
