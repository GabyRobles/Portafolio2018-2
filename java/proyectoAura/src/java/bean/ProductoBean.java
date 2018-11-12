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
import model.Producto;


public class ProductoBean {
    //declarar la Api para manejar la persistencia de JPA
    EntityManagerFactory factory = Persistence.createEntityManagerFactory("ProyectoAuraPU");
    EntityManager em = factory.createEntityManager();
    //declarar la lista de Producto
    private List<Producto> lista;
    
    //constructor con la generación de la lista
    public ProductoBean(){
        try {
            lista = findAll();//búsqueda de todas las productos
        } catch (SQLException | NullPointerException ex) {
            //acción en caso de error
            System.out.println("Error: "+ex.getMessage());
        }
    }
    
    /*
    * Métodos de getter and setter para la lista
    */
    public List<Producto> getLista() {
        return lista;
    }
    public void setLista(List<Producto> lista) {
        this.lista = lista;
    }
    
    /*
    * Método de busqueda unica por nombre
    */
    public Producto findByNombre(String nombre)throws SQLException, NullPointerException{
        return (Producto) em.createNamedQuery("Producto.findByNombre").setParameter("nombre", nombre).getSingleResult();
    }
    
    /*
    * Método de busqueda de todos los elementos de la base de datos
    */
    public List<Producto> findAll()throws SQLException, NullPointerException{
        return em.createNamedQuery("Producto.findAll").getResultList();
    }
    
    
}
