/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Categoria;

/**
 *
 * @author nico_
 */
public class CategoriaBean {
    EntityManagerFactory factory = Persistence.createEntityManagerFactory("ProyectoAuraPU");
    EntityManager em = factory.createEntityManager();
    private List<Categoria> lista;
    
    public CategoriaBean(){
        try {
            lista = findAll();
        } catch (SQLException | NullPointerException ex) {
            System.out.println("Error: "+ex.getMessage());
        }
    }
    
    public Categoria findByNombre(String nombre) throws SQLException, NullPointerException{
        return (Categoria) em.createNamedQuery("Categoria.findByNombre").setParameter("nombre", nombre).getSingleResult();
    }
    
    public List<Categoria> findAll() throws SQLException, NullPointerException{
        return em.createNamedQuery("Categoria.findAll").getResultList();
    }
    
}
