/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidad;

import java.util.regex.Pattern;


public class Formato {
    public static String obtenerAction(String param){
        String[] parts = param.split(Pattern.quote("/"));//separa el texto entregado segun '/'
        return parts[3];//retorna el la ultima posicion
    }
}
