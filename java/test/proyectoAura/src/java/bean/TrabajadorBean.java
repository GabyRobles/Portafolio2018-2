/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Trabajador;

/**
 *
 * @author nico_
 */
public class TrabajadorBean {
    EntityManagerFactory factory = Persistence.createEntityManagerFactory("ProyectoAuraPU");
    EntityManager em = factory.createEntityManager();
    
    public Trabajador findByCorreo(String correo){
        return (Trabajador)em.createNamedQuery("Trabajador.findByCorreo").setParameter("correo", correo).getSingleResult();
    }
    
    public boolean validarContrasena(String Correo, String contrasena){
        boolean validador = false;
        Trabajador trabajador = findByCorreo(Correo);
        if (trabajador.getContrasena().equals(contrasena))
        {
            validador = true;
        }
        return validador;
    }
}
