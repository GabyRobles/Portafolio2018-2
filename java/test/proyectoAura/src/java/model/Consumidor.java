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
@Table(name = "CONSUMIDOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Consumidor.findAll", query = "SELECT c FROM Consumidor c")
    , @NamedQuery(name = "Consumidor.findByIdConsumidor", query = "SELECT c FROM Consumidor c WHERE c.idConsumidor = :idConsumidor")
    , @NamedQuery(name = "Consumidor.findByNombre", query = "SELECT c FROM Consumidor c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "Consumidor.findByApellidos", query = "SELECT c FROM Consumidor c WHERE c.apellidos = :apellidos")
    , @NamedQuery(name = "Consumidor.findByRut", query = "SELECT c FROM Consumidor c WHERE c.rut = :rut")
    , @NamedQuery(name = "Consumidor.findByFechaNac", query = "SELECT c FROM Consumidor c WHERE c.fechaNac = :fechaNac")
    , @NamedQuery(name = "Consumidor.findByCorreo", query = "SELECT c FROM Consumidor c WHERE c.correo = :correo")
    , @NamedQuery(name = "Consumidor.findByContrasena", query = "SELECT c FROM Consumidor c WHERE c.contrasena = :contrasena")
    , @NamedQuery(name = "Consumidor.findByPuntaje", query = "SELECT c FROM Consumidor c WHERE c.puntaje = :puntaje")
    , @NamedQuery(name = "Consumidor.findByTelefono", query = "SELECT c FROM Consumidor c WHERE c.telefono = :telefono")
    , @NamedQuery(name = "Consumidor.findByEnvOferta", query = "SELECT c FROM Consumidor c WHERE c.envOferta = :envOferta")})
public class Consumidor implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_CONSUMIDOR")
    private BigDecimal idConsumidor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "APELLIDOS")
    private String apellidos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "RUT")
    private String rut;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_NAC")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaNac;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "CORREO")
    private String correo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "CONTRASENA")
    private String contrasena;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PUNTAJE")
    private Integer puntaje;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "TELEFONO")
    private String telefono;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ENV_OFERTA")
    private Character envOferta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idConsumidor")
    private List<Valoracion> valoracionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idConsumidor")
    private List<Cupon> cuponList;

    public Consumidor() {
    }

    public Consumidor(BigDecimal idConsumidor) {
        this.idConsumidor = idConsumidor;
    }

    public Consumidor(BigDecimal idConsumidor, String nombre, String apellidos, String rut, Date fechaNac, String correo, String contrasena, Integer puntaje, String telefono, Character envOferta) {
        this.idConsumidor = idConsumidor;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.rut = rut;
        this.fechaNac = fechaNac;
        this.correo = correo;
        this.contrasena = contrasena;
        this.puntaje = puntaje;
        this.telefono = telefono;
        this.envOferta = envOferta;
    }

    public BigDecimal getIdConsumidor() {
        return idConsumidor;
    }

    public void setIdConsumidor(BigDecimal idConsumidor) {
        this.idConsumidor = idConsumidor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(Integer puntaje) {
        this.puntaje = puntaje;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Character getEnvOferta() {
        return envOferta;
    }

    public void setEnvOferta(Character envOferta) {
        this.envOferta = envOferta;
    }

    @XmlTransient
    public List<Valoracion> getValoracionList() {
        return valoracionList;
    }

    public void setValoracionList(List<Valoracion> valoracionList) {
        this.valoracionList = valoracionList;
    }

    @XmlTransient
    public List<Cupon> getCuponList() {
        return cuponList;
    }

    public void setCuponList(List<Cupon> cuponList) {
        this.cuponList = cuponList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idConsumidor != null ? idConsumidor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Consumidor)) {
            return false;
        }
        Consumidor other = (Consumidor) object;
        if ((this.idConsumidor == null && other.idConsumidor != null) || (this.idConsumidor != null && !this.idConsumidor.equals(other.idConsumidor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Consumidor[ idConsumidor=" + idConsumidor + " ]";
    }
    
}
