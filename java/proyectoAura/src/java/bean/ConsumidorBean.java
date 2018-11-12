/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;


import java.sql.SQLException;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.ParameterMode;
import javax.persistence.Persistence;
import javax.persistence.StoredProcedureQuery;
import model.Consumidor;

/**
 *
 * @author nico_
 */
public class ConsumidorBean {
    //declarar la Api para manejar la persistencia de JPA
    EntityManagerFactory factory = Persistence.createEntityManagerFactory("ProyectoAuraPU");
    EntityManager em = factory.createEntityManager();
    
   public void create(String nombre,String apellido,String rut,Date fechaNac,String correo,String contrasena,Integer puntaje,String telefono,Character envOferta)throws SQLException{
        //Definir procedimiento
        StoredProcedureQuery storedProcedureQuery= em.createStoredProcedureQuery("OPERACIONES_CRUD.INSERTAR_CONSUMIDOR");
        storedProcedureQuery.registerStoredProcedureParameter("nombre", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("ape", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("rut", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("fechnac", Date.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("correo", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("pass", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("pto", Integer.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("tele", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("envofe", Character.class, ParameterMode.IN);
        
        //Asignar valores
        storedProcedureQuery.setParameter("nombre", nombre);
        storedProcedureQuery.setParameter("ape", apellido);
        storedProcedureQuery.setParameter("rut", rut);
        storedProcedureQuery.setParameter("fechnac", fechaNac);
        storedProcedureQuery.setParameter("correo", correo);
        storedProcedureQuery.setParameter("pass", contrasena);
        storedProcedureQuery.setParameter("pto", puntaje);
        storedProcedureQuery.setParameter("tele", telefono);
        storedProcedureQuery.setParameter("envofe", envOferta);
        
        //ejecutar procedimiento
        storedProcedureQuery.execute();     
        
   }
   
   /*
    * Método de busqueda unica
    */
   public Consumidor findByCorreo(String Correo)throws SQLException, NullPointerException, NoResultException{
       return (Consumidor) em.createNamedQuery("Consumidor.findByCorreo").setParameter("correo", Correo).getSingleResult();
   }
   
   /*
    * Método para validar contraseña
    */
   public boolean validarContrasena(String correo, String contrasena) throws SQLException, NoResultException{
       //Instanciar al cosumidor por busqueda
       Consumidor consumidor = findByCorreo(correo);
       boolean validacion = false; //declarar el retorno
       //cambiar el retorno en caso de encontrar coincidencia
       if (consumidor.getContrasena().equals(contrasena)){
           validacion = true;
       }
       return validacion;
   }
   
   /*
    * Método de sumarPuntos
    */
   public void sumarPuntos(Consumidor consumidor, int puntos){
        //suma y envia puntaje a la entidad
        Integer puntaje = consumidor.getPuntaje();
        puntaje += puntos;
        consumidor.setPuntaje(puntaje);
   }
}
