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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author nico_
 */
@Entity
@Table(name = "STOCK")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stock.findAll", query = "SELECT s FROM Stock s")
    , @NamedQuery(name = "Stock.findByIdStock", query = "SELECT s FROM Stock s WHERE s.idStock = :idStock")
    , @NamedQuery(name = "Stock.findByCantMin", query = "SELECT s FROM Stock s WHERE s.cantMin = :cantMin")
    , @NamedQuery(name = "Stock.findByCantMax", query = "SELECT s FROM Stock s WHERE s.cantMax = :cantMax")
    , @NamedQuery(name = "Stock.findByEstado", query = "SELECT s FROM Stock s WHERE s.estado = :estado")})
public class Stock implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_STOCK")
    private BigDecimal idStock;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CANT_MIN")
    private BigInteger cantMin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CANT_MAX")
    private BigInteger cantMax;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ESTADO")
    private String estado;
    @JoinColumn(name = "ID_PRODUCTO", referencedColumnName = "ID_PRODUCTO")
    @ManyToOne(optional = false)
    private Producto idProducto;
    @JoinColumn(name = "ID_SUCURSAL", referencedColumnName = "ID_SUCURSAL")
    @ManyToOne(optional = false)
    private Sucursal idSucursal;

    public Stock() {
    }

    public Stock(BigDecimal idStock) {
        this.idStock = idStock;
    }

    public Stock(BigDecimal idStock, BigInteger cantMin, BigInteger cantMax, String estado) {
        this.idStock = idStock;
        this.cantMin = cantMin;
        this.cantMax = cantMax;
        this.estado = estado;
    }

    public BigDecimal getIdStock() {
        return idStock;
    }

    public void setIdStock(BigDecimal idStock) {
        this.idStock = idStock;
    }

    public BigInteger getCantMin() {
        return cantMin;
    }

    public void setCantMin(BigInteger cantMin) {
        this.cantMin = cantMin;
    }

    public BigInteger getCantMax() {
        return cantMax;
    }

    public void setCantMax(BigInteger cantMax) {
        this.cantMax = cantMax;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
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
        hash += (idStock != null ? idStock.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stock)) {
            return false;
        }
        Stock other = (Stock) object;
        if ((this.idStock == null && other.idStock != null) || (this.idStock != null && !this.idStock.equals(other.idStock))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Stock[ idStock=" + idStock + " ]";
    }
    
}
