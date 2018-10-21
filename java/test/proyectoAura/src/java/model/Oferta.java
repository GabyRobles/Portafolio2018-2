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
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author nico_
 */
@Entity
@Table(name = "OFERTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Oferta.findAll", query = "SELECT o FROM Oferta o")
    , @NamedQuery(name = "Oferta.findByIdOferta", query = "SELECT o FROM Oferta o WHERE o.idOferta = :idOferta")
    , @NamedQuery(name = "Oferta.findByNombre", query = "SELECT o FROM Oferta o WHERE o.nombre = :nombre")
    , @NamedQuery(name = "Oferta.findByTipoOferta", query = "SELECT o FROM Oferta o WHERE o.tipoOferta = :tipoOferta")
    , @NamedQuery(name = "Oferta.findByImagen", query = "SELECT o FROM Oferta o WHERE o.imagen = :imagen")
    , @NamedQuery(name = "Oferta.findByPrecioOferta", query = "SELECT o FROM Oferta o WHERE o.precioOferta = :precioOferta")
    , @NamedQuery(name = "Oferta.findByFechaIni", query = "SELECT o FROM Oferta o WHERE o.fechaIni = :fechaIni")
    , @NamedQuery(name = "Oferta.findByFechaTerm", query = "SELECT o FROM Oferta o WHERE o.fechaTerm = :fechaTerm")})
public class Oferta implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_OFERTA")
    private BigDecimal idOferta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "TIPO_OFERTA")
    private String tipoOferta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "IMAGEN")
    private String imagen;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRECIO_OFERTA")
    private BigInteger precioOferta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_INI")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIni;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_TERM")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaTerm;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOferta")
    private List<Valoracion> valoracionList;
    @JoinColumn(name = "ID_CATEGORIA", referencedColumnName = "ID_CATEGORIA")
    @ManyToOne(optional = false)
    private Categoria idCategoria;
    @JoinColumn(name = "ID_PRODUCTO", referencedColumnName = "ID_PRODUCTO")
    @ManyToOne(optional = false)
    private Producto idProducto;
    @JoinColumn(name = "ID_SUCURSAL", referencedColumnName = "ID_SUCURSAL")
    @ManyToOne(optional = false)
    private Sucursal idSucursal;
    @JoinColumn(name = "ID_TRABAJADOR", referencedColumnName = "ID_TRABAJADOR")
    @ManyToOne(optional = false)
    private Trabajador idTrabajador;

    public Oferta() {
    }

    public Oferta(BigDecimal idOferta) {
        this.idOferta = idOferta;
    }

    public Oferta(BigDecimal idOferta, String nombre, String tipoOferta, String imagen, BigInteger precioOferta, Date fechaIni, Date fechaTerm) {
        this.idOferta = idOferta;
        this.nombre = nombre;
        this.tipoOferta = tipoOferta;
        this.imagen = imagen;
        this.precioOferta = precioOferta;
        this.fechaIni = fechaIni;
        this.fechaTerm = fechaTerm;
    }

    public BigDecimal getIdOferta() {
        return idOferta;
    }

    public void setIdOferta(BigDecimal idOferta) {
        this.idOferta = idOferta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoOferta() {
        return tipoOferta;
    }

    public void setTipoOferta(String tipoOferta) {
        this.tipoOferta = tipoOferta;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public BigInteger getPrecioOferta() {
        return precioOferta;
    }

    public void setPrecioOferta(BigInteger precioOferta) {
        this.precioOferta = precioOferta;
    }

    public Date getFechaIni() {
        return fechaIni;
    }

    public void setFechaIni(Date fechaIni) {
        this.fechaIni = fechaIni;
    }

    public Date getFechaTerm() {
        return fechaTerm;
    }

    public void setFechaTerm(Date fechaTerm) {
        this.fechaTerm = fechaTerm;
    }

    @XmlTransient
    public List<Valoracion> getValoracionList() {
        return valoracionList;
    }

    public void setValoracionList(List<Valoracion> valoracionList) {
        this.valoracionList = valoracionList;
    }

    public Categoria getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Categoria idCategoria) {
        this.idCategoria = idCategoria;
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

    public Trabajador getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(Trabajador idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOferta != null ? idOferta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Oferta)) {
            return false;
        }
        Oferta other = (Oferta) object;
        if ((this.idOferta == null && other.idOferta != null) || (this.idOferta != null && !this.idOferta.equals(other.idOferta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Oferta[ idOferta=" + idOferta + " ]";
    }
    
}
