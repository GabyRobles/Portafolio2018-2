package model;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Cupon;
import model.Oferta;
import model.Producto;
import model.Valoracion;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-26T16:54:02")
@StaticMetamodel(Categoria.class)
public class Categoria_ { 

    public static volatile ListAttribute<Categoria, Producto> productoList;
    public static volatile ListAttribute<Categoria, Oferta> ofertaList;
    public static volatile SingularAttribute<Categoria, BigDecimal> idCategoria;
    public static volatile ListAttribute<Categoria, Valoracion> valoracionList;
    public static volatile SingularAttribute<Categoria, String> nombre;
    public static volatile ListAttribute<Categoria, Cupon> cuponList;

}