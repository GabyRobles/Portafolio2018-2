/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.sql.SQLException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import model.Trabajador;

public class TrabajadorBean {
    //declarar la Api para manejar la persistencia de JPA
    EntityManagerFactory factory = Persistence.createEntityManagerFactory("ProyectoAuraPU");
    EntityManager em = factory.createEntityManager();
    
    /*
    * Método de busqueda unica
    */
    public Trabajador findByCorreo(String correo)throws SQLException, NullPointerException, NoResultException{
        return (Trabajador)em.createNamedQuery("Trabajador.findByCorreo").setParameter("correo", correo).getSingleResult();
    }
    
    /*
    * Método para validar contraseña
    */
    public boolean validarContrasena(String Correo, String contrasena) throws SQLException, NoResultException{
        //Instanciar al cosumidor por busqueda
        Trabajador trabajador = findByCorreo(Correo);
        boolean validador = false;//declarar el retorno
        //cambiar el retorno en caso de encontrar coincidencia
        if (trabajador.getContrasena().equals(contrasena))
        {
            validador = true;
        }
        return validador;
    }
    
    /*
    * Método de para obtener el tipo de trabajador
    */
    public String recuperarTipoTrabajador(String correo) throws SQLException{
        //instanciar el trabajador entregado por la busqueda
        Trabajador trabajador = findByCorreo(correo);
        //obtener el puesto
        String puesto = trabajador.getIdPuesto().getPuesto();
        return puesto;
    }
}
