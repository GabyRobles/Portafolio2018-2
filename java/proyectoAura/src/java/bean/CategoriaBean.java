/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.ParameterMode;
import javax.persistence.Persistence;
import javax.persistence.StoredProcedureQuery;
import model.Categoria;
import model.Consumidor;
import model.Oferta;

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
    
    
   public List<Categoria> getCategoriasMasValoradas(Consumidor consumer){
       ArrayList<Categoria> fetch = new ArrayList<>();
       try {
        StoredProcedureQuery storedProcedureQuery = em.createStoredProcedureQuery("ADMAURA.CATEGORIAS_VALORADAS");
        storedProcedureQuery.registerStoredProcedureParameter("idcon", BigDecimal.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("registros", void.class, ParameterMode.REF_CURSOR);
        storedProcedureQuery.setParameter("idcon",consumer.getIdConsumidor());
        
        
        List rs = storedProcedureQuery.getResultList();
        
        for (int i=0; i<rs.size(); ++i ) {
            Object row[] = (Object[])rs.get(i);
            String nCat =(String) row[2];
            fetch.add(this.findByNombre(nCat));
        }
        
        /*
        while(rs.next()){
            System.out.println(rs.getString("cant_val"));
            Categoria categoria = cat.findByNombre(rs.getString("id_cat"));
            fetch.add(categoria);
        } */  
        } catch (Exception e) {
            System.out.println("Error en categorias mas valoradas");
            System.out.println(e.getMessage());
        }    
        
   return  fetch;
   }
    
}
