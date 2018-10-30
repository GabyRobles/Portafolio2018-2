/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.ParameterMode;
import javax.persistence.Persistence;
import javax.persistence.StoredProcedureQuery;
import model.Categoria;
import model.Oferta;

/**
 *
 * @author nico_
 */
public class OfertaBean {
    EntityManagerFactory factory = Persistence.createEntityManagerFactory("ProyectoAuraPU");
    EntityManager em = factory.createEntityManager();
    
    private List<Oferta> lista; 
    
    public OfertaBean(){
        try {
            lista = findAll();
        } catch (NullPointerException | SQLException ex) {
        }
    }
    
    public Oferta findById(Integer id) throws SQLException, NullPointerException{
        return (Oferta) em.createNamedQuery("Oferta.findByIdOferta").setParameter("idOferta", id).getSingleResult();
    }
    
    public Oferta findByNombre(String nombre) throws SQLException, NullPointerException{
        return (Oferta) em.createNamedQuery("Oferta.findByNombre").setParameter("nombre", nombre).getSingleResult();
    }
    
    public List<Oferta> findAll()throws SQLException, NullPointerException{
        return em.createNamedQuery("Oferta.findAll").getResultList();
    }

    public List<Oferta> getLista() {
        return lista;
    }

    public void setLista(List<Oferta> lista) {
        this.lista = lista;
    }
    
    public List<Oferta> findByCategoria(Categoria idCategoria) {
        return em.createNamedQuery("Oferta.findByIdCategoria").setParameter("idCategoria", idCategoria).getResultList();
    }
    
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
    
    public void delete(Integer idOferta) throws SQLException{
        StoredProcedureQuery storedProcedureQuery = em.createStoredProcedureQuery("OPERACIONES_CRUD.ELIMINAR_OFERTA");
        storedProcedureQuery.registerStoredProcedureParameter("idofer", Integer.class, ParameterMode.IN);
        storedProcedureQuery.setParameter("idofer", idOferta);
        storedProcedureQuery.execute();
    }
}
