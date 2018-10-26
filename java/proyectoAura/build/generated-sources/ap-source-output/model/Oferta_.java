package model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Categoria;
import model.Producto;
import model.Sucursal;
import model.Trabajador;
import model.Valoracion;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-26T16:54:02")
@StaticMetamodel(Oferta.class)
public class Oferta_ { 

    public static volatile SingularAttribute<Oferta, Sucursal> idSucursal;
    public static volatile SingularAttribute<Oferta, Date> fechaTerm;
    public static volatile SingularAttribute<Oferta, Date> fechaIni;
    public static volatile SingularAttribute<Oferta, String> imagen;
    public static volatile SingularAttribute<Oferta, BigDecimal> idOferta;
    public static volatile SingularAttribute<Oferta, Trabajador> idTrabajador;
    public static volatile SingularAttribute<Oferta, Producto> idProducto;
    public static volatile SingularAttribute<Oferta, BigInteger> precioOferta;
    public static volatile ListAttribute<Oferta, Valoracion> valoracionList;
    public static volatile SingularAttribute<Oferta, Categoria> idCategoria;
    public static volatile SingularAttribute<Oferta, String> nombre;
    public static volatile SingularAttribute<Oferta, String> tipoOferta;

}