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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author nico_
 */
@Entity
@Table(name = "REGISTRO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Registro.findAll", query = "SELECT r FROM Registro r")
    , @NamedQuery(name = "Registro.findByIdRegistro", query = "SELECT r FROM Registro r WHERE r.idRegistro = :idRegistro")
    , @NamedQuery(name = "Registro.findByFecha", query = "SELECT r FROM Registro r WHERE r.fecha = :fecha")
    , @NamedQuery(name = "Registro.findByContCorreos", query = "SELECT r FROM Registro r WHERE r.contCorreos = :contCorreos")
    , @NamedQuery(name = "Registro.findByContConsumidor", query = "SELECT r FROM Registro r WHERE r.contConsumidor = :contConsumidor")
    , @NamedQuery(name = "Registro.findByContOferta", query = "SELECT r FROM Registro r WHERE r.contOferta = :contOferta")
    , @NamedQuery(name = "Registro.findByContCupones", query = "SELECT r FROM Registro r WHERE r.contCupones = :contCupones")})
public class Registro implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_REGISTRO")
    private BigDecimal idRegistro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CONT_CORREOS")
    private BigInteger contCorreos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CONT_CONSUMIDOR")
    private BigInteger contConsumidor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CONT_OFERTA")
    private BigInteger contOferta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CONT_CUPONES")
    private BigInteger contCupones;

    public Registro() {
    }

    public Registro(BigDecimal idRegistro) {
        this.idRegistro = idRegistro;
    }

    public Registro(BigDecimal idRegistro, Date fecha, BigInteger contCorreos, BigInteger contConsumidor, BigInteger contOferta, BigInteger contCupones) {
        this.idRegistro = idRegistro;
        this.fecha = fecha;
        this.contCorreos = contCorreos;
        this.contConsumidor = contConsumidor;
        this.contOferta = contOferta;
        this.contCupones = contCupones;
    }

    public BigDecimal getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(BigDecimal idRegistro) {
        this.idRegistro = idRegistro;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public BigInteger getContCorreos() {
        return contCorreos;
    }

    public void setContCorreos(BigInteger contCorreos) {
        this.contCorreos = contCorreos;
    }

    public BigInteger getContConsumidor() {
        return contConsumidor;
    }

    public void setContConsumidor(BigInteger contConsumidor) {
        this.contConsumidor = contConsumidor;
    }

    public BigInteger getContOferta() {
        return contOferta;
    }

    public void setContOferta(BigInteger contOferta) {
        this.contOferta = contOferta;
    }

    public BigInteger getContCupones() {
        return contCupones;
    }

    public void setContCupones(BigInteger contCupones) {
        this.contCupones = contCupones;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRegistro != null ? idRegistro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Registro)) {
            return false;
        }
        Registro other = (Registro) object;
        if ((this.idRegistro == null && other.idRegistro != null) || (this.idRegistro != null && !this.idRegistro.equals(other.idRegistro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Registro[ idRegistro=" + idRegistro + " ]";
    }
    
}
