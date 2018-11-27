/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.math.BigDecimal;
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

public class CategoriaBean {

    //declarar la Api para manejar la persistencia de JPA
    EntityManagerFactory factory = Persistence.createEntityManagerFactory("ProyectoAuraPU");
    EntityManager em = factory.createEntityManager();
    //declarar la lista de categorias
    private List<Categoria> lista;

    //constructor con la generación de la lista
    public CategoriaBean() {
        try {
            lista = findAll();//búsqueda de todas las categorias
        } catch (SQLException | NullPointerException ex) {
            //acción en caso de error
            System.out.println("Error: " + ex.getMessage());
        }
    }

    /*
    * Métodos de busqueda unica
     */
    public Categoria findByNombre(String nombre) throws SQLException, NullPointerException {
        return (Categoria) em.createNamedQuery("Categoria.findByNombre").setParameter("nombre", nombre).getSingleResult();
    }
    
     /*
    * Métodos de busqueda unica
     */
    public Categoria findById(int idCat) throws SQLException, NullPointerException {
        return (Categoria) em.createNamedQuery("Categoria.findByIdCategoria").setParameter("idCategoria", idCat).getSingleResult();
    }

    /*
    * Método de busqueda de todos los elementos de la base de datos
     */
    public List<Categoria> findAll() throws SQLException, NullPointerException {
        return em.createNamedQuery("Categoria.findAll").getResultList();
    }

    public List<Categoria> getCategoriasMasValoradas(Consumidor consumer) {
        //Declarar el arreglo de salida
        ArrayList<Categoria> fetch = new ArrayList<>();
        try {
            //Declarar y llamar al procedimiento almacenado de "CATEGORIAS_VALORADAS"
            StoredProcedureQuery storedProcedureQuery = em.createStoredProcedureQuery("ADMAURA.CATEGORIAS_VALORADAS");
            storedProcedureQuery.registerStoredProcedureParameter("idcon", BigDecimal.class, ParameterMode.IN);
            storedProcedureQuery.registerStoredProcedureParameter("registros", void.class, ParameterMode.REF_CURSOR);
            // ingresar el id del consumidor como paramentro
            storedProcedureQuery.setParameter("idcon", consumer.getIdConsumidor());
            // obtener la lista resultante del procedimiento
            List rs = storedProcedureQuery.getResultList();
            //recorer la lista resultante de principio a fin
            for (int i = 0; i < rs.size(); ++i) {
                Object row[] = (Object[]) rs.get(i);//asignar como objeto cada fila de la lista
                String nCat = (String) row[2];//obtener el id de la categoria y parseo a String
                fetch.add(this.findByNombre(nCat));//Buscar y Agregar la categoria a la lista final
            }
            
        } catch (NullPointerException | SQLException e) {
            //acciones en caso de error
            System.out.println("Error en categorias mas valoradas");
            System.out.println(e.getMessage());
        }

        return fetch;
    }

}
