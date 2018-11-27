/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.CategoriaBean;
import bean.ConsumidorBean;
import bean.OfertaBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Consumidor;
import model.Oferta;
import utilidad.ListaInteligente;

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
        String action = request.getParameter("action");//obtener la accion de la petición
        //Discriminar la acción a realizar
        switch (action) {
            case "sumarPuntajes"://sumar los puntajes
                this.sumarPuntaje(request, response);
                break;
            case "cargarOfertas"://accion para carga las ofertas
                if (request.getSession().getAttribute("mapa") == null) {
                    Consumidor con = (Consumidor) request.getSession().getAttribute("usuario");
                    request.getSession().setAttribute("mapa", ListaInteligente.cargarOfertas(con));
                }
                //response.sendRedirect("Consumidor/Home.jsp");
                request.getRequestDispatcher("/Consumidor/Home.jsp").forward(request, response);
                break;
            case "detalle":
                showDetalle(request, response);
                break;
            case "listarPorCategoria":
                ListaPorCategoria(request, response);
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
        //obtener la accion de la petición
        String action = request.getRequestURI();
        action = utilidad.Formato.obtenerAction(action);
        //discriminar la accion a realizar
        switch (action) {
            case "Registro": //llamar al registro
                Registrar(request, response);
                break;

            default://Acción en caso de que no exista la petición
                System.out.println("problema de accion" + action);
                break;
        }
    }

    /*
        Descripción del servlet
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }

    private void Registrar(HttpServletRequest request, HttpServletResponse response) {
        //instanciar el Bean para consumidor
        ConsumidorBean consumidor = new ConsumidorBean();
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");// formato para la fecha
            //Obtener los datos del formulario de registro
            String nombre = request.getParameter("fname");
            String apellido = request.getParameter("lname");
            String rut = request.getParameter("rut");
            Date fechaNac = formatter.parse(request.getParameter("nac"));
            String telefono = request.getParameter("fono");
            String correo = request.getParameter("mail");
            String contrasena = request.getParameter("psw");
            Integer puntaje = 0;
            //asignar el parametro para envío de correos automáticos
            Character envio = 'S';
            if (request.getParameter("chkCorreos") == "") {
                envio = 'N';
            }

            //Alamacenar el consumidor en la base de datos
            consumidor.create(nombre, apellido, rut, fechaNac, correo, contrasena, puntaje, telefono, envio);
            //direccionamiento al Home del consumidor
            request.getRequestDispatcher("/Consumidor/Home.jsp").forward(request, response);
        } catch (IOException | SQLException | ParseException | ServletException ex) {
            //Mensaje de Error
            System.out.println("No se puede crear el usuario: " + ex.getMessage());

        }
    }

    private void sumarPuntaje(HttpServletRequest request, HttpServletResponse response) {// llamado al metodo sumar Puntos creado en ConsumidorBean
        ConsumidorBean consumidor = new ConsumidorBean();
        Consumidor usuario = (Consumidor) request.getSession().getAttribute("usuario");

        try {
            consumidor.sumarPuntos(usuario, 10);//El usuario recibira por defecto 10 puntos
        } catch (Exception ex) {
            System.out.println("No se puede agregar el puntaje");
        }
    }
    
    private void showDetalle(HttpServletRequest request, HttpServletResponse response) {
        OfertaBean oferta = new OfertaBean();
        try {
            int idOfer = Integer.parseInt(request.getParameter("idofer"));
            request.setAttribute("oferta", oferta.findById(idOfer));
            request.getRequestDispatcher("/Consumidor/DetalleOferta.jsp").forward(request, response);
            
        } catch (IOException | NullPointerException | NumberFormatException | SQLException | ServletException ex) {
            Logger.getLogger(OfertaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }

    private void ListaPorCategoria(HttpServletRequest request, HttpServletResponse response) {
        OfertaBean oferta = new OfertaBean();
        CategoriaBean categoria = new CategoriaBean();
        List<Oferta> listaOferta = new ArrayList<>();
        try {
            int idCat = Integer.parseInt(request.getParameter("idcat"));
            
            listaOferta = oferta.findByCategoria(categoria.findById(idCat));
            request.setAttribute("listadoPorCategoria",listaOferta);
            request.getRequestDispatcher("/Consumidor/OfertasPorCategoria.jsp").forward(request, response);
        } catch(IOException | NullPointerException | NumberFormatException | SQLException | ServletException ex){
            Logger.getLogger(OfertaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
