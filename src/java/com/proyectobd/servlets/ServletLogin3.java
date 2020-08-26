/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyectobd.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import Logic.Farmacia.LogicUser;
import Logic.Farmacia.UserObj;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import obj.vistas.ComprasObj;
import obj.vistas.ProductosObj;
/**
 *
 * @author Diego Lopez
 */
@WebServlet(name = "ServletLogin3", urlPatterns = {"/ServletLogin3"})
public class ServletLogin3 extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
            LogicUser CLogic = new LogicUser("jdbc:mysql://localhost/heimdall2?"
                + "user=root&password=12345&"
                + "autoReconnect=true&useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true");
            String strFormId = request.getParameter("formid");
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            if(strFormId.equals("1")){
                String Nombre = request.getParameter("nombre");
                String Apellido = request.getParameter("apellido");
                String DUI = request.getParameter("dui");
                String Correo = request.getParameter("correo");
                String Direccion = request.getParameter("direccion");
                String Telefono =request.getParameter("telefono");
                String NumeroRF =   request.getParameter("numero");
                String Usuario = request.getParameter("usuario");
                String Password = request.getParameter("password");
            
                boolean hasFailed = 
                    CLogic.insertUser(Nombre, Apellido, DUI, Correo, Direccion, Telefono, NumeroRF, Usuario, Password);
            
                 request.getRequestDispatcher("iniciarsesion.html")
                   .forward(request, response);
            }
            if(strFormId.equals("2")){
                String strUser = request.getParameter("name");
                String strPassword = request.getParameter("password");
                UserObj CLoginUser = CLogic.getUser(strUser, strPassword);
                
                if(CLoginUser!=null)
            {
                
                List<ComprasObj> CList = CLogic.getCompras();
                List<ProductosObj> PList = CLogic.getProductos();
          
                request.getSession().setAttribute("logged_user", CLoginUser);
                request.getSession().setAttribute("compras", CList);
                request.getSession().setAttribute("productos", PList);

                request.getRequestDispatcher("clienteusuario.html")
                       .forward(request, response);
                        
            }
            
            else
            {
                String strMessage = "Su usuario o su contraseña son incorrectos, vuelva a intentarlo.";
                request.getSession().setAttribute("message", strMessage);
               
                request.getRequestDispatcher("errorMessage.jsp")
                       .forward(request, response);
            }
                
        
            }
            
            if(strFormId.equals("3")){ 
                String Sucursal = request.getParameter("sucursal");
                if(Sucursal.equals("sucursal1")) 
                {
                request.getRequestDispatcher("datosproductos.jsp")
                       .forward(request, response);
                } 
                else if (Sucursal.equals("sucursal2")) 
                {
                request.getRequestDispatcher("datosproductos2.jsp")
                       .forward(request, response);
                } 
               
            }
            
            
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ServletLogin3.class.getName()).log(Level.SEVERE, null, ex);
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ServletLogin3.class.getName()).log(Level.SEVERE, null, ex);
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

}
