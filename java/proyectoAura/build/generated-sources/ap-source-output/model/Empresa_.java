package model;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Sucursal;
import model.Trabajador;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-11-06T19:20:44")
@StaticMetamodel(Empresa.class)
public class Empresa_ { 

    public static volatile ListAttribute<Empresa, Sucursal> sucursalList;
    public static volatile SingularAttribute<Empresa, BigDecimal> idEmpresa;
    public static volatile SingularAttribute<Empresa, String> nombre;
    public static volatile ListAttribute<Empresa, Trabajador> trabajadorList;

}