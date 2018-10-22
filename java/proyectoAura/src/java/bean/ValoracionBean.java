/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;


import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.ParameterMode;
import javax.persistence.Persistence;
import javax.persistence.StoredProcedureQuery;

/**
 *
 * @author solita
 */
public class ValoracionBean {
    EntityManagerFactory factory = Persistence.createEntityManagerFactory("ProyectoAuraPU");
    EntityManager em = factory.createEntityManager();
    
        //INSERTAR_VALORACION" (val in number,fch in date,comm in VARCHAR2,idof in number,idcons in number,idct in number,idsuc in number)
    public void createValoracion(int valoracion, Date fecha,String comentario ,int idofert,int idconsumidor,int idcate,int idsucur ){
    //SE CREA UNA VARIABLE DE PROCEDIMIENTO
        StoredProcedureQuery storedProcedureQuery= em.createStoredProcedureQuery("OPERACIONES_CRUD.INSERTAR_VALORACION");
    //variable del procedimiento en la bd
        storedProcedureQuery.registerStoredProcedureParameter("val", Integer.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("fch", Date.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("comm", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("idof", Integer.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("idcons", Integer.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("idct", Integer.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("idsuc", Integer.class, ParameterMode.IN); 
    
        //ingreso de variables
         storedProcedureQuery.setParameter("val", valoracion);
         storedProcedureQuery.setParameter("fch", valoracion);
         storedProcedureQuery.setParameter("comm", valoracion);
         storedProcedureQuery.setParameter("idof", valoracion);
         storedProcedureQuery.setParameter("idcons", valoracion);
         storedProcedureQuery.setParameter("idct", valoracion);
         storedProcedureQuery.setParameter("idsuc", valoracion);
                 
                //ejecutar procedimiento
        storedProcedureQuery.execute(); 
        
    }
    
    
}
