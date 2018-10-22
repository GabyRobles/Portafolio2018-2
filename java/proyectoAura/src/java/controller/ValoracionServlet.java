/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Consumidor;

/**
 *
 * @author solita
 */
@WebServlet(name = "ValoracionServlet", urlPatterns = {"/ValoracionOferta"})
public class ValoracionServlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ValoracionServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ValoracionServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
      //INSERTAR_VALORACION" (val in number,fch in date,comm in VARCHAR2,idof in number,idcons in number,idct in number,idsuc in number)

        try{
        
            Integer valoracion =Integer.parseInt(request.getParameter("valoracion"));
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            Date fecha = formatter.parse(request.getParameter("fch"));
            String comentario = request.getParameter("com");
            Integer idoferta=Integer.parseInt(request.getParameter("idoferta"));
            Integer idconsumidor = Integer.valueOf(((Consumidor)request.getSession().getAttribute("usuario")).getIdConsumidor().toString());
            Integer idcate = Integer.parseInt(request.getParameter("idcategoria"));
            Integer idsuc =Integer.parseInt(request.getParameter("idsuc"));

            
        }catch(ParseException ex){
            
        System.out.println("No se puede crear la Valoracion "+ex.getMessage());
        
    }
    }

    

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
