/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.CategoriaBean;
import bean.ConsumidorBean;
import bean.OfertaBean;
import bean.TrabajadorBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.NoResultException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Categoria;
import model.Oferta;


public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @param msg
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response, String msg)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* Pagina de error */
            out.print("<style>");
            out.print(".error-template {padding: 40px 15px;text-align: center;}");
            out.print(".error-actions {margin-top:15px;margin-bottom:15px;}");
            out.print(".error-actions .btn { margin-right:10px; }");
            out.print("</style>");
            out.println("<link href=" + "//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" + " rel=" + "stylesheet" + " id=" + "bootstrap-css" + ">");
            out.println("<script src=" + "//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js" + "></script>");
            out.println("<script src=" + "//code.jquery.com/jquery-1.11.1.min.js" + "></script>");
            out.println("<div class=" + "container" + ">");
            out.println("<div class=" + "row" + ">");
            out.println("<div class=" + "col-md-12" + ">");
            out.println("<div class="+"error-template"+">");
            out.println("<h1>Oops!</h1>");
            out.println("<h2>500 Not Found</h2>");
            out.println("<div class="+"error-details"+">");
            out.println("usuario o contraseña incorrectos");
            out.println("</div>");
            out.println("<div class="+"error-actions"+">");
            out.println("<a href ="+"/proyectoAura/"+" class="+"btn btn-primary btn-lg"+"><span class="+"glyphicon glyphicon-home"+"></span>");
            out.println("Llevame al home </a > <a href ="+"#"+" class="+"btn btn-default btn-lg"+">"+"<span class="+"glyphicon glyphicon-envelope"+"></span > Contact Support</a>");
            out.println("</div>");
            out.println("</div>");
            out.println("</div>");
            out.println("</div>");
            out.println("</div>");

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

        //redireccionamiento segun accion enviada por metodo get
        String action = request.getParameter("action");

        switch (action) {
            case "LoginC"://direcionamiento a la pantalla de login para consumidor
                response.sendRedirect("Login.jsp");
                break;
            case "LoginT"://direcionamiento a la pantalla de login para trabajador
                response.sendRedirect("Trabajador/Login.jsp");
                break;
            case "Registro"://direcionamiento a la pantalla de registro de Cliente
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
        //obtener la accion de llamado
        String action = request.getRequestURI();
        action = utilidad.Formato.obtenerAction(action);

        //dirigir la accion a los metodos
        switch (action) {
            case "Consumidor":
                //llamada a la funcion para iniciar consumidor
                logearC(request, response);
                break;
            case "Trabajador":
                //llamada a la funcion para iniciar trabajador
                logearT(request, response);
                break;
            default:
                //en caso de accion no existente el error se muestra por consola
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
            // instanciar Beans
            ConsumidorBean consumidorBean = new ConsumidorBean();

            //obtener parametros de entrada
            String correo = request.getParameter("email");
            String contrasena = request.getParameter("psw");

            //validar contraseña con el bean
            if (consumidorBean.validarContrasena(correo, contrasena)) {
                //establecer al usuario como atributo de session
                request.getSession().setAttribute("usuario", consumidorBean.findByCorreo(correo));
                response.sendRedirect(request.getContextPath()+"/ConsumidorServlet?action=cargarOfertas");
                //request.getRequestDispatcher("/ConsumidorServlet?action=cargarOfertas").forward(request, response);
            }
        } catch (IOException | SQLException | NoResultException e) {
            processRequest(request, response, e.getMessage());
            System.out.println("Error: " + e.getLocalizedMessage());
        }
    }

    private void logearT(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // instanciar Beans
            TrabajadorBean trabajadorBean = new TrabajadorBean();

            //obtener parametros de entrada
            String correo = request.getParameter("email"); // se saca del id del jsp
            String contrasena = request.getParameter("psw");

            //Recuperar el tipo de trabajador
            String tipo = trabajadorBean.recuperarTipoTrabajador(correo);

            //validar contraseña con el bean
            if (trabajadorBean.validarContrasena(correo, contrasena)) {
                //establecer al usuario como atributo de session
                request.getSession().setAttribute("usuario", trabajadorBean.findByCorreo(correo));
                switch (tipo) {
                    case "Encargado tienda":
                        //hipervínculo hacia la pagina de Encargado
                        request.getRequestDispatcher("/Trabajador/Encargado/Home.jsp").forward(request, response);
                        break;
                    case "Gerente Agencia":
                        //hipervínculo hacia la pagina de consumidor
                        request.getRequestDispatcher("/Trabajador/Gerente/Home.jsp").forward(request, response);
                        break;
                    default:
                        //error en caso de no tener permisos, imprimir en el sistema cerra la sesion y redirigir al login
                        System.out.println("No tiene permisos para ingresar");
                        request.getSession().invalidate();
                        request.getRequestDispatcher("/").forward(request, response);
                        break;
                }

            }
        } catch (IOException | NullPointerException | SQLException | NoResultException | ServletException e) {
            processRequest(request, response, e.getMessage());
            System.out.println("Error :  " + e.getMessage());
        }

    }
}
