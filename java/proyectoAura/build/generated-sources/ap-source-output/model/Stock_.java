package model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Producto;
import model.Sucursal;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-22T16:21:45")
@StaticMetamodel(Stock.class)
public class Stock_ { 

    public static volatile SingularAttribute<Stock, Sucursal> idSucursal;
    public static volatile SingularAttribute<Stock, BigDecimal> idStock;
    public static volatile SingularAttribute<Stock, String> estado;
    public static volatile SingularAttribute<Stock, BigInteger> cantMax;
    public static volatile SingularAttribute<Stock, Producto> idProducto;
    public static volatile SingularAttribute<Stock, BigInteger> cantMin;

}