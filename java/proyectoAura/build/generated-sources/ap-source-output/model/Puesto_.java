package model;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Trabajador;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-22T16:21:45")
@StaticMetamodel(Puesto.class)
public class Puesto_ { 

    public static volatile SingularAttribute<Puesto, String> puesto;
    public static volatile SingularAttribute<Puesto, BigDecimal> idPuesto;
    public static volatile ListAttribute<Puesto, Trabajador> trabajadorList;

}