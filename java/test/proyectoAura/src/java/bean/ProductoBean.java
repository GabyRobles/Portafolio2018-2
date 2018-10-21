/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Producto;

/**
 *
 * @author nico_
 */
public class ProductoBean {
    EntityManagerFactory factory = Persistence.createEntityManagerFactory("ProyectoAuraPU");
    EntityManager em = factory.createEntityManager();
    
    public Producto findByNombre(String nombre){
        return (Producto) em.createNamedQuery("Producto.findByNombre").setParameter("nombre", nombre).getSingleResult();
    }
    
    public List<Producto> findAll(){
        return em.createNamedQuery("Producto.findAll").getResultList();
    }
    
    
}
