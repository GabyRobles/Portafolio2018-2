package model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Categoria;
import model.Consumidor;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-26T16:54:02")
@StaticMetamodel(Cupon.class)
public class Cupon_ { 

    public static volatile SingularAttribute<Cupon, BigInteger> descuento;
    public static volatile SingularAttribute<Cupon, BigInteger> tope;
    public static volatile SingularAttribute<Cupon, BigDecimal> idCupon;
    public static volatile SingularAttribute<Cupon, Categoria> idCategoria;
    public static volatile SingularAttribute<Cupon, Consumidor> idConsumidor;

}