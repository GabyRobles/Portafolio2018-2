package model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Categoria;
import model.Consumidor;
import model.Oferta;
import model.Sucursal;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-22T16:21:45")
@StaticMetamodel(Valoracion.class)
public class Valoracion_ { 

    public static volatile SingularAttribute<Valoracion, BigDecimal> idValoracion;
    public static volatile SingularAttribute<Valoracion, Sucursal> idSucursal;
    public static volatile SingularAttribute<Valoracion, Date> fecha;
    public static volatile SingularAttribute<Valoracion, BigInteger> valoracion;
    public static volatile SingularAttribute<Valoracion, Oferta> idOferta;
    public static volatile SingularAttribute<Valoracion, String> comentario;
    public static volatile SingularAttribute<Valoracion, Categoria> idCategoria;
    public static volatile SingularAttribute<Valoracion, Consumidor> idConsumidor;

}