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
        //obtener la acción de la petición
        String action = request.getParameter("action");
        //disciminación de la acción
        switch (action) {
            case "Crear"://direccionamiento en caso de crear
                showCrear(request, response);
                break;
            case "Listar"://direccionaminto a la lista de ofertas
                //Instanciar el Bean
                OfertaBean ofertas = new OfertaBean();
                //obtener y asignar la lista de ofertas 
                request.setAttribute("ofertas", ofertas.getLista());
                //direccionamiento a la página de listas
                request.getRequestDispatcher("Trabajador/Encargado/Ofertas.jsp").forward(request, response);
                break;
            case "Editar"://direccionamiento a la página de editar ofertas
                showEditar(request, response);
                break;
            case "Eliminar"://llamar a la acción de eliminar ofertas
                eliminarOferta(request, response);
                break;
            default://accion a realizar en caso de petición inválida
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
        //obtener la acción de la petición
        String action = request.getRequestURI();
        action = utilidad.Formato.obtenerAction(action);
        //disccriminación de la acción a realizar
        switch (action) {
            case "Crear"://llamar a la acción de Crear oferta
                crearOferta(request, response);
                break;
            case "Editar"://llamar a la acción de Editar oferta
                editarOferta(request, response);
            default://accion a realizar en caso de petición inválida
                System.out.println("Acción no encontrada");
                break;
        }
    }

    /**
     * Breve descripción del servlet.
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }
    
    /*
    * Método para direccionar a la creacion de oferta
    */
    private void showCrear(HttpServletRequest request, HttpServletResponse response) {
        try {//instanciar el Bean de sucursales
            SucursalBean sucursales = new SucursalBean();
            //instanciar al usuario de la sesion
            Trabajador user = (Trabajador)request.getSession().getAttribute("usuario");
            //obtener el id de la empresa
            Integer idEmpresa = Integer.valueOf(user.getIdEmpresa().getIdEmpresa().toString());
            //obtener y asignar la lista de sucursales
            request.setAttribute("sucursales", sucursales.findByEmpresa(idEmpresa));
            //direccionamiento a la página de creación
            request.getRequestDispatcher("Trabajador/Encargado/DetalleOferta.jsp").forward(request, response);
        } catch (IOException | NullPointerException | NumberFormatException | SQLException | ServletException e) {
            System.out.println("Error no se pudo obtener la Lista de sucursales: " + e.getMessage());
        }
    }
    
     /*
    * Método para crear la oferta
    */
    private void crearOferta(HttpServletRequest request, HttpServletResponse response) {
        try {//instanciar el Bean de la oferta
            OfertaBean oferta = new OfertaBean();
            //asignar el formato de las fechas
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            //obtener los datos del formulario de creación de ofertas
            String nombre = request.getParameter("nombreOferta");
            Integer idProducto = Integer.valueOf(request.getParameter("idProducto"));//Parseo de String a Integer
            Integer idCat = Integer.valueOf(request.getParameter("idCat"));//Parseo de String a Integer
            String tipoOferta = request.getParameter("tipo");
            String imagen = request.getParameter("imagenURL");
            Integer precio = Integer.valueOf(request.getParameter("precio"));//Parseo de String a Integer
            Integer idEncargado = Integer.valueOf(request.getParameter("idEncargado"));//Parseo de String a Integer
            Integer idSucur = Integer.valueOf(request.getParameter("cbSucurcales"));//Parseo de String a Integer
            Date fechaIni = formatter.parse(request.getParameter("fechaIni"));//Parseo de String a Date
            Date fechaTerm = formatter.parse(request.getParameter("fechaTerm"));//Parseo de String a Date
            //crear la Oferta dentro de la base de datos
            oferta.create(nombre, tipoOferta, imagen, precio, fechaIni, fechaTerm, idEncargado, idSucur, idProducto, idCat);
            //direccionamiento a la página de ofertas
            response.sendRedirect("/Trabajador/Encargado/Ofertas.jsp");
        } catch (IOException | NumberFormatException | SQLException | ParseException e) {
            System.out.println("Error al crear la oferta" + e.getLocalizedMessage());
        }
    }

    private void showEditar(HttpServletRequest request, HttpServletResponse response) {
        try {OfertaBean bean = new OfertaBean();
            //obtener el id de la oferta a editar
            Integer idOferta = Integer.valueOf(request.getParameter("idOferta"));//Parseo de String a Integer
            //asignar la oferta a editar
            Oferta oferta = bean.findById(idOferta);
            request.setAttribute("oferta", oferta);
            //direcionamiento a la pagina de edición
            request.getRequestDispatcher("Trabajador/Encargado/DetalleOferta.jsp").forward(request, response);
        } catch (IOException | NullPointerException | NumberFormatException | SQLException | ServletException e) {
            System.out.println("Error al redirccionar: " + e.getMessage());
        }

    }

    private void editarOferta(HttpServletRequest request, HttpServletResponse response) {
        try {//instanciar el Bean de oferta
            OfertaBean oferta = new OfertaBean();
            //asignar el formato de las fechas
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            //obtener los datos del formulario de edición de ofertas
            Integer idOferta = Integer.valueOf(request.getParameter("id"));//Parseo de String a Integer
            String nombre = request.getParameter("nombreOferta");
            Integer idProducto = Integer.valueOf(request.getParameter("idProducto"));//Parseo de String a Integer
            Integer idCat = Integer.valueOf(request.getParameter("idCat"));//Parseo de String a Integer
            String tipoOferta = request.getParameter("tipo");
            String imagen = request.getParameter("imagenURL");
            Integer precio = Integer.valueOf(request.getParameter("precio"));//Parseo de String a Integer
            Integer idEncargado = Integer.valueOf(request.getParameter("idEncargado"));//Parseo de String a Integer
            Integer idSucur = Integer.valueOf(request.getParameter("cbSucurcales"));//Parseo de String a Integer
            Date fechaIni = formatter.parse(request.getParameter("fechaIni"));//Parseo de String a Date
            Date fechaTerm = formatter.parse(request.getParameter("fechaTerm"));//Parseo de String a Date
            //editar la oferta en la base de datos
            oferta.update(idOferta, nombre, tipoOferta, imagen, precio, fechaIni, fechaTerm, idEncargado, idSucur, idProducto, idCat);
            //direccionamiento a la lista de ofertas
            response.sendRedirect("/Trabajador/Encargado/Ofertas.jsp");
        } catch (IOException | NumberFormatException | SQLException | ParseException e) {
            System.out.println("Error al editar: " + e.getLocalizedMessage());
        }
    }

    private void eliminarOferta(HttpServletRequest request, HttpServletResponse response) {
        try {//Instanciar el Bean de oferta    
            OfertaBean oferta = new OfertaBean();
            //obtener el id de la oferta a eliminar
            Integer idOferta = Integer.valueOf(request.getParameter("idOferta"));
            //Eliminar la oferta de la base de datos
            oferta.delete(idOferta);
            //direccionamiento a la lista de ofertas
            response.sendRedirect("/Trabajador/Encargado/Ofertas.jsp");
        } catch (IOException | NumberFormatException | SQLException e) {
            System.out.println("Error no se pudo eliminar: " + e.getLocalizedMessage());
        }
    }

}
