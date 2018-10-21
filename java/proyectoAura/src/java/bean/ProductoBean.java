/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;


import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private List<Producto> lista;
    
    public ProductoBean(){
        try {
            lista = findAll();
        } catch (SQLException | NullPointerException ex) {
            System.out.println("Error: "+ex.getMessage());;
        }
    }

    public List<Producto> getLista() {
        return lista;
    }

    public void setLista(List<Producto> lista) {
        this.lista = lista;
    }
    
    public Producto findByNombre(String nombre)throws SQLException, NullPointerException{
        return (Producto) em.createNamedQuery("Producto.findByNombre").setParameter("nombre", nombre).getSingleResult();
    }
    
    public List<Producto> findAll()throws SQLException, NullPointerException{
        return em.createNamedQuery("Producto.findAll").getResultList();
    }
    
    
}
