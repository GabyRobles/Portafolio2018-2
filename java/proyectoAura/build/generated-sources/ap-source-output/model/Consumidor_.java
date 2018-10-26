package model;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Cupon;
import model.Valoracion;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-26T16:54:02")
@StaticMetamodel(Consumidor.class)
public class Consumidor_ { 

    public static volatile SingularAttribute<Consumidor, String> apellidos;
    public static volatile SingularAttribute<Consumidor, String> rut;
    public static volatile SingularAttribute<Consumidor, Date> fechaNac;
    public static volatile SingularAttribute<Consumidor, Character> envOferta;
    public static volatile SingularAttribute<Consumidor, Integer> puntaje;
    public static volatile SingularAttribute<Consumidor, String> correo;
    public static volatile SingularAttribute<Consumidor, String> contrasena;
    public static volatile SingularAttribute<Consumidor, String> telefono;
    public static volatile ListAttribute<Consumidor, Valoracion> valoracionList;
    public static volatile SingularAttribute<Consumidor, String> nombre;
    public static volatile ListAttribute<Consumidor, Cupon> cuponList;
    public static volatile SingularAttribute<Consumidor, BigDecimal> idConsumidor;

}