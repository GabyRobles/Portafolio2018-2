package model;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Empresa;
import model.Oferta;
import model.Puesto;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-11-06T19:20:44")
@StaticMetamodel(Trabajador.class)
public class Trabajador_ { 

    public static volatile SingularAttribute<Trabajador, String> correo;
    public static volatile SingularAttribute<Trabajador, Puesto> idPuesto;
    public static volatile ListAttribute<Trabajador, Oferta> ofertaList;
    public static volatile SingularAttribute<Trabajador, BigDecimal> idTrabajador;
    public static volatile SingularAttribute<Trabajador, String> contrasena;
    public static volatile SingularAttribute<Trabajador, Empresa> idEmpresa;
    public static volatile SingularAttribute<Trabajador, String> nombre;

}