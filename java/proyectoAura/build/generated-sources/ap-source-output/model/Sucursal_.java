package model;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Empresa;
import model.Oferta;
import model.Stock;
import model.Valoracion;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-26T16:54:02")
@StaticMetamodel(Sucursal.class)
public class Sucursal_ { 

    public static volatile SingularAttribute<Sucursal, BigDecimal> idSucursal;
    public static volatile ListAttribute<Sucursal, Stock> stockList;
    public static volatile SingularAttribute<Sucursal, String> direccion;
    public static volatile ListAttribute<Sucursal, Oferta> ofertaList;
    public static volatile SingularAttribute<Sucursal, Empresa> idEmpresa;
    public static volatile ListAttribute<Sucursal, Valoracion> valoracionList;
    public static volatile SingularAttribute<Sucursal, String> nombre;

}