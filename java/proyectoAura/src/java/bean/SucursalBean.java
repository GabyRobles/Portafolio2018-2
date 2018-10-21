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
import model.Empresa;
import model.Sucursal;

/**
 *
 * @author BR0KK
 */
public class SucursalBean {
    EntityManagerFactory factory = Persistence.createEntityManagerFactory("ProyectoAuraPU");
    EntityManager em = factory.createEntityManager();
    
    public List<Sucursal> findByEmpresa(Integer idEmpresa)throws SQLException, NullPointerException{
        Empresa empresa = (Empresa)em.createNamedQuery("Empresa.findByIdEmpresa").setParameter("idEmpresa", idEmpresa).getSingleResult();
        return em.createNamedQuery("Sucursal.findByIdEmpresa").setParameter("idEmpresa", empresa).getResultList();
    }
    
    
}
