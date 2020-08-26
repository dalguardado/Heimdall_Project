<%-- 
    Document   : datoscompras.jsp
    Created on : Aug 26, 2020, 9:31:15 AM
    Author     : Diego Lopez
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="obj.vistas.ComprasObj"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
   <title>Compras </title>
   <style>
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}
</style>
  </head>
  
  <%
        List<ComprasObj> CList = 
                (List<ComprasObj>)request.getSession().getAttribute("compras");
    %>
    
  <body> 
        
      <h1><center>Órdenes realizadas</center></h1>
      
      <table>
            
          <tr>
                        <th>ID</th>
                        <th>Medicamento</th>
                        <th>Precio</th>
                        <th>Cantidad</th>
                        <th>Documento</th>
                        
                    </tr>
          <%
              if(CList!=null)
              {
                  Iterator<ComprasObj> ite = CList.iterator();
                  ComprasObj CTemp;
                    
                  while(ite.hasNext())
                  {
                     
                      CTemp = ite.next();
          %>
                <tr>
       
                  <td>  
                  <p><%= CTemp.getID() %></p>
                  </td>
                   <td>  
                  <p><%= CTemp.getMedicamento() %></p>
                  </td>
                  <td>  
                  <p><%= CTemp.getPrecio() %></p>
                  </td>
                   
                  <td>  
                  <p><%= CTemp.getCantidad() %></p>
                  </td>
                  
                  <td>  
                  <p><%= CTemp.getiDDocumento() %></p>
                  </td>
                  
                 
                  
                  
          <%
                    }
              }
          %>
          
        </table>

  </body>
</html>
