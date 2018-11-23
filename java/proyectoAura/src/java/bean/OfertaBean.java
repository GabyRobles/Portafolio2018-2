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
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.ParameterMode;
import javax.persistence.Persistence;
import javax.persistence.StoredProcedureQuery;
import model.Categoria;
import model.Oferta;

public class OfertaBean {
    //declarar la Api para manejar la persistencia de JPA
    EntityManagerFactory factory = Persistence.createEntityManagerFactory("ProyectoAuraPU");
    EntityManager em = factory.createEntityManager();
    //declarar la lista de Ofertas
    private List<Oferta> lista; 
    
    //constructor con la generación de la lista
    public OfertaBean(){
        try {
            lista = findAll();//búsqueda de todas las Ofertas
        } catch (NullPointerException | SQLException ex) {
            //acción en caso de error
            System.out.println("Error: "+ex.getMessage());
        }
    }
    
    /*
    * Método de busqueda unica
    */
    public Oferta findById(Integer id) throws SQLException, NullPointerException{
        return (Oferta) em.createNamedQuery("Oferta.findByIdOferta").setParameter("idOferta", id).getSingleResult();
    }
    
    /*
    * Método de busqueda unica
    */
    public Oferta findByNombre(String nombre) throws SQLException, NullPointerException{
        return (Oferta) em.createNamedQuery("Oferta.findByNombre").setParameter("nombre", nombre).getSingleResult();
    }
    
    /*
    * Método de busqueda de todos los elementos de la base de datos
    */
    public List<Oferta> findAll()throws SQLException, NullPointerException{
        return em.createNamedQuery("Oferta.findAll").getResultList();
    }
    
    /*
    * Métodos de getter and setter para la lista
    */
    public List<Oferta> getLista() {
        return lista;
    }

    public void setLista(List<Oferta> lista) {
        this.lista = lista;
    }
    
    /*
    * Método de búsqueda de todos los elementos segun categoria
    */
    public List<Oferta> findByCategoria(Categoria idCategoria) {
        return em.createNamedQuery("Oferta.findByIdCategoria").setParameter("idCategoria", idCategoria).getResultList();
    }
    
    /*
    * Método para insetar oferta en la base de datos
    */
    public void create(String nombre, String tipoOferta, String imagen, Integer precioOferta, Date fechaIni, Date fechaTerm, Integer idTrabajador, Integer idSucursal, Integer idProducto, Integer idCategoria)
    throws SQLException{
        //definir procedimiento
        StoredProcedureQuery storedProcedureQuery= em.createStoredProcedureQuery("OPERACIONES_CRUD.INSERTAR_OFERTA");
        storedProcedureQuery.registerStoredProcedureParameter("nombre", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("tpo", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("img", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("prof", Integer.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("idtr", Integer.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("idsuc", Integer.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("idproin", Integer.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("fechini", Date.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("fechater", Date.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("idcat", Integer.class, ParameterMode.IN);
    
        //Asignar valores
        storedProcedureQuery.setParameter("nombre", nombre);
        storedProcedureQuery.setParameter("tpo", tipoOferta);
        storedProcedureQuery.setParameter("img", imagen);
        storedProcedureQuery.setParameter("prof", precioOferta);
        storedProcedureQuery.setParameter("idtr", idTrabajador);
        storedProcedureQuery.setParameter("idsuc", idSucursal);
        storedProcedureQuery.setParameter("idproin", idProducto);
        storedProcedureQuery.setParameter("fechini", fechaIni);
        storedProcedureQuery.setParameter("fechater", fechaTerm);
        storedProcedureQuery.setParameter("idcat", idCategoria);
        
        //ejecutar
        storedProcedureQuery.execute();
    
    }
    
     /*
    * Método para edtiar oferta en la base de datos
    */
    public void update(Integer idOfer, String nombre, String tipoOferta, String imagen, Integer precioOferta, Date fechaIni, Date fechaTerm, Integer idTrabajador, Integer idSucursal, Integer idProducto, Integer idCategoria)
    throws SQLException{
        //definir procedimiento
        StoredProcedureQuery storedProcedureQuery= em.createStoredProcedureQuery("OPERACIONES_CRUD.ACTUALIZAR_OFERTA");
        storedProcedureQuery.registerStoredProcedureParameter("idpue", Integer.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("nombre", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("tpo", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("img", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("prof", Integer.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("idtr", Integer.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("idsuc", Integer.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("idproin", Integer.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("fechini", Date.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("fechater", Date.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("idcat", Integer.class, ParameterMode.IN);
        //asignar valores
        storedProcedureQuery.setParameter("idpue", idOfer);
        storedProcedureQuery.setParameter("nombre", nombre);
        storedProcedureQuery.setParameter("tpo", tipoOferta);
        storedProcedureQuery.setParameter("img", imagen);
        storedProcedureQuery.setParameter("prof", precioOferta);
        storedProcedureQuery.setParameter("idtr", idTrabajador);
        storedProcedureQuery.setParameter("idsuc", idSucursal);
        storedProcedureQuery.setParameter("idproin", idProducto);
        storedProcedureQuery.setParameter("fechini", fechaIni);
        storedProcedureQuery.setParameter("fechater", fechaTerm);
        storedProcedureQuery.setParameter("idcat", idCategoria);
        //ejecutar
        storedProcedureQuery.execute();
    
    }
    
    /*
    * Método para eliminar oferta en la base de datos
    */
    public void delete(Integer idOferta) throws SQLException{
        //definir procedimiento
        StoredProcedureQuery storedProcedureQuery = em.createStoredProcedureQuery("OPERACIONES_CRUD.ELIMINAR_OFERTA");
        storedProcedureQuery.registerStoredProcedureParameter("idofer", Integer.class, ParameterMode.IN);
        //asignar valores
        storedProcedureQuery.setParameter("idofer", idOferta);
        //ejecutar
        storedProcedureQuery.execute();
    }
    
    public List<Oferta> getOfertasPopulares(Categoria category){
        ArrayList fetch = new ArrayList<>();
        try {
        StoredProcedureQuery storedProcedureQuery = em.createStoredProcedureQuery("ADMAURA.OFERTAS_POPULARES");
        storedProcedureQuery.registerStoredProcedureParameter("idcat", BigDecimal.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("registros", void.class, ParameterMode.REF_CURSOR);
        storedProcedureQuery.setParameter("idcat",category.getIdCategoria());
        
        
        List rs = storedProcedureQuery.getResultList();
        
        for (int i=0; i<rs.size(); ++i ) {
            Object row[] = (Object[])rs.get(i);
            BigDecimal idOfer = (BigDecimal)row[0];
            String id = idOfer.toString();
            fetch.add(this.findById(Integer.parseInt(id)));
        }
        /*
        while(rs.next()){
            Oferta oferta = ofer.findById(Integer.parseInt(rs.getString("id_cat")));
            fetch.add(oferta);
        } */   
        } catch (SQLException e) {
            System.out.println("error en ofertas populares");
        }
   return  fetch;
   }
    
    
}
