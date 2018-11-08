package model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Categoria;
import model.Oferta;
import model.Stock;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-11-06T19:20:44")
@StaticMetamodel(Producto.class)
public class Producto_ { 

    public static volatile SingularAttribute<Producto, Date> fechaVen;
    public static volatile SingularAttribute<Producto, BigInteger> precio;
    public static volatile ListAttribute<Producto, Stock> stockList;
    public static volatile SingularAttribute<Producto, Date> fechaElab;
    public static volatile ListAttribute<Producto, Oferta> ofertaList;
    public static volatile SingularAttribute<Producto, BigDecimal> idProducto;
    public static volatile SingularAttribute<Producto, Categoria> idCategoria;
    public static volatile SingularAttribute<Producto, String> nombre;

}