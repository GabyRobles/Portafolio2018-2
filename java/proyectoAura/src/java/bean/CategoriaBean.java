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

public class CategoriaBean {
    //declarar la Api para manejar la persistencia de JPA
    EntityManagerFactory factory = Persistence.createEntityManagerFactory("ProyectoAuraPU");
    EntityManager em = factory.createEntityManager();
    //declarar la lista de categorias
    private List<Categoria> lista;
    
    
    //constructor con la generación de la lista
    public CategoriaBean(){
        try {
            lista = findAll();//búsqueda de todas las categorias
        } catch (SQLException | NullPointerException ex) {
            //acción en caso de error
            System.out.println("Error: "+ex.getMessage());
        }
    }
    
    /*
    * Método de busqueda unica
    */
    public Categoria findByNombre(String nombre) throws SQLException, NullPointerException{
        return (Categoria) em.createNamedQuery("Categoria.findByNombre").setParameter("nombre", nombre).getSingleResult();
    }
    
    /*
    * Método de busqueda de todos los elementos de la base de datos
    */
    public List<Categoria> findAll() throws SQLException, NullPointerException{
        return em.createNamedQuery("Categoria.findAll").getResultList();
    }
    
}
