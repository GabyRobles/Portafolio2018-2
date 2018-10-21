/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.OfertaBean;
import bean.SucursalBean;
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
import model.Oferta;
import model.Trabajador;

/**
 *
 * @author nico_
 */
@WebServlet(name = "OfertaServlet", urlPatterns = {"/OfertaServlet"})
public class OfertaServlet extends HttpServlet {

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
            out.println("<title>Servlet OfertaServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet OfertaServlet at " + request.getContextPath() + "</h1>");
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
            case "Crear":
                showCrear(request, response);
                break;
            case "Listar":
                OfertaBean ofertas = new OfertaBean();
                request.setAttribute("ofertas", ofertas.getLista());
                request.getRequestDispatcher("Trabajador/Encargado/Ofertas.jsp").forward(request, response);
                break;
            case "Editar":
                showEditar(request, response);
                break;
            case "Eliminar":
                eliminarOferta(request, response);
                break;
            default:
                System.out.println("Acción no encontrada");
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
            case "Crear":
                crearOferta(request, response);
                break;
            case "Editar":
                editarOferta(request, response);
            default:
                System.out.println("Acción no encontrada");
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
    }
    
    private void showCrear(HttpServletRequest request, HttpServletResponse response) {
        try {
            SucursalBean sucursales = new SucursalBean();
            Trabajador user = (Trabajador)request.getSession().getAttribute("usuario");
            System.out.println("usuario = "+user.toString());
            Integer idEmpresa = Integer.valueOf(user.getIdEmpresa().getIdEmpresa().toString());
            System.out.println("idEmpresa = "+idEmpresa);
            request.setAttribute("sucursales", sucursales.findByEmpresa(idEmpresa));
            request.getRequestDispatcher("Trabajador/Encargado/DetalleOferta.jsp").forward(request, response);
        } catch (IOException | NullPointerException | NumberFormatException | SQLException | ServletException e) {
            System.out.println("Error no se pudo obtener la Lista de sucursales: " + e.getMessage());
        }
    }

    private void crearOferta(HttpServletRequest request, HttpServletResponse response) {
        try {
            OfertaBean oferta = new OfertaBean();
        
            String nombre = request.getParameter("nameOferta");
            String tipoOferta = request.getParameter("tipo");
            String imagen = request.getParameter("imagenURL");
            Integer precio = Integer.valueOf(request.getParameter("precio"));
            Integer idEncargado = Integer.valueOf(request.getParameter("idEncargado"));
            Integer idCat = Integer.valueOf(request.getParameter("idCat"));

            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            Date fechaIni = formatter.parse(request.getParameter("fechaIni"));
            Date fechaTerm = formatter.parse(request.getParameter("fechaTerm"));

            oferta.create(nombre, tipoOferta, imagen, Integer.SIZE, fechaIni, fechaTerm, Integer.MAX_VALUE, Integer.SIZE, Integer.MIN_VALUE, Integer.BYTES);
        } catch (NumberFormatException | ParseException e) {
            System.out.println("Error al crear la oferta" + e.getLocalizedMessage());
        }
    }

    private void showEditar(HttpServletRequest request, HttpServletResponse response) {
        try {
            Integer idOferta = Integer.valueOf(request.getParameter("id"));
            OfertaBean bean = new OfertaBean();
            Oferta oferta = bean.findById(idOferta);
            request.setAttribute("oferta", oferta);
            request.getRequestDispatcher("Trabajador/Encargado/DetalleOferta.jsp").forward(request, response);
        } catch (IOException | NumberFormatException | ServletException e) {
            System.out.println("Error al redirccionar: " + e.getMessage());
        }

    }

    private void editarOferta(HttpServletRequest request, HttpServletResponse response) {
        try {
            OfertaBean oferta = new OfertaBean();
        
            Integer idOferta = Integer.valueOf(request.getParameter("id"));

            String nombre = request.getParameter("nameOferta");
            String tipoOferta = request.getParameter("tipo");
            String imagen = request.getParameter("imagenURL");
            Integer precio = Integer.valueOf(request.getParameter("precio"));
            Integer idEncargado = Integer.valueOf(request.getParameter("idEncargado"));
            Integer idCat = Integer.valueOf(request.getParameter("idCat"));

            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            Date fechaIni = formatter.parse(request.getParameter("fechaIni"));
            Date fechaTerm = formatter.parse(request.getParameter("fechaTerm"));

            oferta.update(idOferta, nombre, tipoOferta, imagen, Integer.SIZE, fechaIni, fechaTerm, Integer.MAX_VALUE, Integer.SIZE, Integer.MIN_VALUE, Integer.BYTES);
        } catch (NumberFormatException | ParseException e) {
            System.out.println("Error al editar: " + e.getLocalizedMessage());
        }
    }

    private void eliminarOferta(HttpServletRequest request, HttpServletResponse response) {
        try {    
            OfertaBean oferta = new OfertaBean();
        
            Integer idOferta = Integer.valueOf(request.getParameter("id"));
            oferta.delete(idOferta);
        } catch (NumberFormatException e) {
            System.out.println("Error no se pudo eliminar: " + e.getLocalizedMessage());
        }
    }

}
