/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidad;

import bean.CategoriaBean;
import bean.OfertaBean;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Categoria;
import model.Consumidor;
import model.Oferta;



public class ListaInteligente {
    
    //método por defecto para cargar las ofertas
    public static HashMap<Categoria,List<Oferta>> cargarOfertas(){
        HashMap<Categoria,List<Oferta>> mapa = new HashMap<>();
        try {
            CategoriaBean cat = new CategoriaBean();
            OfertaBean ofer = new OfertaBean();
            List<Oferta> ofertas = new ArrayList<>();
            
            for (Categoria i : cat.findAll()) {
                ofertas = new ArrayList<>();
                for (Oferta o : ofer.findByCategoria(i) ) {
                    ofertas.add(o);
                }
                mapa.put(i, ofertas);
            }

        } catch (SQLException | NullPointerException ex) {
            Logger.getLogger(ListaInteligente.class.getName()).log(Level.SEVERE, null, ex);
            mapa = null;
        }
        
         return mapa;
    }
    
    //sobrecargada agregando al consumidor
    public static HashMap<Categoria,List<Oferta>> cargarOfertas(Consumidor consumidor){
        HashMap<Categoria,List<Oferta>> mapa = new HashMap<>();
        try {
            CategoriaBean cat = new CategoriaBean();
            OfertaBean ofer = new OfertaBean();
            List<Oferta> ofertas = new ArrayList<>();
            
            for (Categoria i : cat.getCategoriasMasValoradas(consumidor)) {
                ofertas = new ArrayList<>();
                for (Oferta o : ofer.getOfertasPopulares(i) ) {
                    ofertas.add(o);
                }
                mapa.put(i, ofertas);
            }

        } catch (NullPointerException ex) {
            Logger.getLogger(ListaInteligente.class.getName()).log(Level.SEVERE, null, ex);
            mapa = null;
        }
        
         return mapa;
    }
   
}
