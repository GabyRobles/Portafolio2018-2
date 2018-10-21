/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.ConsumidorBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nico_
 */
public class ConsumidorServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ConsumidorServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ConsumidorServlet at " + request.getContextPath() + "</h1>");
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
        String action = request.getRequestURI();
        System.out.println(action);
        action = utilidad.Formato.obtenerAction(action);
        
        switch (action){
            case "Registro": 
                Registrar(request, response);
                break;
                
            default: System.out.println("problema de accion"+ action); 
                break;
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
    private void Registrar(HttpServletRequest request, HttpServletResponse response){
        ConsumidorBean consumidor = new ConsumidorBean();
        try {
            String nombre = request.getParameter("fname");
            String apellido = request.getParameter("lname") ;
            String rut = request.getParameter("rut");
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            Date fechaNac = formatter.parse(request.getParameter("nac"));
            String telefono = request.getParameter("fono");
            String correo = request.getParameter("mail");
            String contrasena = request.getParameter("psw") ;
            Integer puntaje =  0;
            Character envio = 'S' ;
            if (request.getParameter("chkCorreos")== ""){
                envio = 'N';
            }
            
            
            consumidor.create(nombre, apellido, rut, fechaNac, correo, contrasena, puntaje, telefono, envio);
            request.getRequestDispatcher("/Consumidor/Home.jsp").forward(request, response);
        } catch(IOException | SQLException | ParseException | ServletException ex){
        
            System.out.println("No se puede crear el usuario: "+ex.getMessage());
            
        }
        
       
        
    }

}
