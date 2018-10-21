/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author nico_
 */
@Entity
@Table(name = "CUPON")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cupon.findAll", query = "SELECT c FROM Cupon c")
    , @NamedQuery(name = "Cupon.findByIdCupon", query = "SELECT c FROM Cupon c WHERE c.idCupon = :idCupon")
    , @NamedQuery(name = "Cupon.findByDescuento", query = "SELECT c FROM Cupon c WHERE c.descuento = :descuento")
    , @NamedQuery(name = "Cupon.findByTope", query = "SELECT c FROM Cupon c WHERE c.tope = :tope")})
public class Cupon implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_CUPON")
    private BigDecimal idCupon;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DESCUENTO")
    private BigInteger descuento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TOPE")
    private BigInteger tope;
    @JoinColumn(name = "ID_CATEGORIA", referencedColumnName = "ID_CATEGORIA")
    @ManyToOne(optional = false)
    private Categoria idCategoria;
    @JoinColumn(name = "ID_CONSUMIDOR", referencedColumnName = "ID_CONSUMIDOR")
    @ManyToOne(optional = false)
    private Consumidor idConsumidor;

    public Cupon() {
    }

    public Cupon(BigDecimal idCupon) {
        this.idCupon = idCupon;
    }

    public Cupon(BigDecimal idCupon, BigInteger descuento, BigInteger tope) {
        this.idCupon = idCupon;
        this.descuento = descuento;
        this.tope = tope;
    }

    public BigDecimal getIdCupon() {
        return idCupon;
    }

    public void setIdCupon(BigDecimal idCupon) {
        this.idCupon = idCupon;
    }

    public BigInteger getDescuento() {
        return descuento;
    }

    public void setDescuento(BigInteger descuento) {
        this.descuento = descuento;
    }

    public BigInteger getTope() {
        return tope;
    }

    public void setTope(BigInteger tope) {
        this.tope = tope;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCupon != null ? idCupon.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cupon)) {
            return false;
        }
        Cupon other = (Cupon) object;
        if ((this.idCupon == null && other.idCupon != null) || (this.idCupon != null && !this.idCupon.equals(other.idCupon))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Cupon[ idCupon=" + idCupon + " ]";
    }
    
}
