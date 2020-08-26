<%-- 
    Document   : datosproductos.jsp
    Created on : Aug 26, 2020, 11:28:52 AM
    Author     : Diego Lopez
--%>

<%@page import="obj.vistas.ProductosObj"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="obj.vistas.ComprasObj"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
   <title>Productos </title>
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
        List<ProductosObj> PList = 
                (List<ProductosObj>)request.getSession().getAttribute("productos");
    %>
    
  <body> 
        
      <h1><center>Productos Disponibles</center></h1>
        <center>
        <form method="get" action="productosacomprar.jsp">
        <button class="button">COMPRAR YA</button>
        <br><br>
        </form>
      </center>
      <table>
            
          <tr>
                        <th>ID</th>
                        <th>Medicamento</th>
                        <th>Stock</th>
                        <th>Presentacion</th>
                        <th>Categoria</th>
                        <th>Receta</th>
                        <th>Sucursal</th>
                         <th>Precio</th>
                        
                    </tr>
          <%
              if(PList!=null)
              {
                  Iterator<ProductosObj> ite = PList.iterator();
                  ProductosObj CTemp;
                    
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
                  <p><%= CTemp.getStock() %></p>
                  </td>
                   
                  <td>  
                  <p><%= CTemp.getPresentacion() %></p>
                  </td>
                  
                  <td>  
                  <p><%= CTemp.getCategoria() %></p>
                  </td>
                  
                  <td>  
                  <p><%= CTemp.getReceta() %></p>
                  </td>
                  
                  <td>  
                  <p><%= CTemp.getSucursal() %></p>
                  </td>
                  
                  <td>  
                  <p><%= CTemp.getPrecio() %></p>
                  </td>
                  
                 
                                
          <%
                    }
              }
          %>
          
        </table>
          
        

  </body>
</html>