/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.CategoriaBean;
import bean.ConsumidorBean;
import bean.TrabajadorBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nico_
 */
public class LoginServlet extends HttpServlet {

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
            out.println("<title>Servlet LoginServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");
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
        String action = request.getParameter("action");

        switch (action) {
            case "LoginC":
                response.sendRedirect("Login.jsp");
                break;
            case "LoginT":
                response.sendRedirect("Trabajador/Login.jsp");
                break;
            case "Registro":
                response.sendRedirect("Registro.jsp");
                break;
        }
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

        switch (action) {
            case "Consumidor":
                logearC(request, response);
                break;
            case "Trabajador":
                logearT(request, response);
                break;
            default:
                System.out.println("error de accion " + action);
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

    private void logearC(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String correo = request.getParameter("email");
            String contrasena = request.getParameter("psw");
            ConsumidorBean consumidorBean = new ConsumidorBean();
            CategoriaBean categoria = new CategoriaBean();
            if (consumidorBean.validarContrasena(correo, contrasena)) {
                request.getSession().setAttribute("usuario", consumidorBean.findByCorreo(correo));
                request.setAttribute("categorias", categoria.findAll());
                request.getRequestDispatcher("/Consumidor/Home.jsp").forward(request, response);
            }
        } catch (IOException | ServletException | SQLException e) {
            System.out.println("Error no existe el usuario: " + e.getLocalizedMessage());
        }
    }

    private void logearT(HttpServletRequest request, HttpServletResponse response) {
        try {
            String correo = request.getParameter("email"); // se saca del id del jsp
            String contrasena = request.getParameter("psw");
            TrabajadorBean trabajadorBean = new TrabajadorBean();

            String tipo = trabajadorBean.recuperarTipoTrabajador(correo);

            if (trabajadorBean.validarContrasena(correo, contrasena)) {
                request.getSession().setAttribute("usuario", trabajadorBean.findByCorreo(correo));
                switch (tipo) {
                    case "Encargado tienda":
                        //hipervínculo
                        request.getRequestDispatcher("/Trabajador/Encargado/Home.jsp").forward(request, response);
                        break;

                    case "Gerente Agencia":
                        request.getRequestDispatcher("/Trabajador/Gerente/Home.jsp").forward(request, response);
                        break;
                    default:
                        System.out.println("No tiene permisos para ingresar");
                        request.getSession().setAttribute("usuario", null);
                        break;
                }
                
            }
        } catch (IOException | SQLException | ServletException ex) {
            System.out.println("Error :  " + ex.getMessage());
        }

    }
}
