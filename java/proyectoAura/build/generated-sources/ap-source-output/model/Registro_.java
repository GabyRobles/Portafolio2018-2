package model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-22T16:21:45")
@StaticMetamodel(Registro.class)
public class Registro_ { 

    public static volatile SingularAttribute<Registro, Date> fecha;
    public static volatile SingularAttribute<Registro, BigInteger> contOferta;
    public static volatile SingularAttribute<Registro, BigInteger> contCupones;
    public static volatile SingularAttribute<Registro, BigInteger> contCorreos;
    public static volatile SingularAttribute<Registro, BigInteger> contConsumidor;
    public static volatile SingularAttribute<Registro, BigDecimal> idRegistro;

}