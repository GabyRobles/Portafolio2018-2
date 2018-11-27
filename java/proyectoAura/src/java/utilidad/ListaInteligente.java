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
        //declarar el hashmap de salida
        HashMap<Categoria,List<Oferta>> mapa = new HashMap<>();
        try {
            //instanciar los beans a utilizar
            CategoriaBean cat = new CategoriaBean();
            OfertaBean ofer = new OfertaBean();
            //declarar lista de ofertas
            List<Oferta> ofertas = new ArrayList<>();
            //recorrer las categorias existentes
            for (Categoria i : cat.findAll()) {
                ofertas = new ArrayList<>();//reiniciar la lista en cada categoria
                //agregar cada oferta segun categoria en la lista
                for (Oferta o : ofer.findByCategoria(i) ) {
                    ofertas.add(o);
                }
                //ingresar la categoria y la lista de ofertas asociadas
                mapa.put(i, ofertas);
            }

        } catch (SQLException | NullPointerException ex) {
            //acciones en caso de error
            Logger.getLogger(ListaInteligente.class.getName()).log(Level.SEVERE, null, ex);
            mapa = null;
        }
        
         return mapa;
    }
    
    //sobrecarga del metodo para cargar ofertas segun consumidor
    public static HashMap<Categoria,List<Oferta>> cargarOfertas(Consumidor consumidor){
        //método por defecto para cargar las ofertas
        HashMap<Categoria,List<Oferta>> mapa = new HashMap<>();
        try {
            //instanciar los beans a utilizar
            CategoriaBean cat = new CategoriaBean();
            OfertaBean ofer = new OfertaBean();
            //declarar lista de ofertas
            List<Oferta> ofertas = new ArrayList<>();
            //recorrer las categorias ordenadas por el comportamiento del cliente
            for (Categoria i : cat.getCategoriasMasValoradas(consumidor)) {
                ofertas = new ArrayList<>();//reiniciar la lista en cada categoria
                //agregar cada oferta ordenada segun su popularidad
                for (Oferta o : ofer.getOfertasPopulares(i) ) {
                    ofertas.add(o);
                }
                //ingresar la categoria y la lista de ofertas asociadas
                mapa.put(i, ofertas);
            }

        } catch (NullPointerException ex) {
            //acciones en caso de error
            Logger.getLogger(ListaInteligente.class.getName()).log(Level.SEVERE, null, ex);
            mapa = null;
        }
        
         return mapa;
    }
   
}
