<%-- 
    Document   : productosacomprar.jsp
    Created on : Aug 26, 2020, 12:17:31 PM
    Author     : Diego Lopez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>COMPRA EN LINEA- FARMACIA SAN ROQUE</title>
    </head>
    <body>
        <<body>
        <h1>Ingresa los datos requeridos</h1>
        <br>
        
        <form id="myform" name="myform" action="ServletLogin3" method="post">
            Medicamento: <input type="number" id="id" name="id" />
            <br><br>
            
            Cantidad: <input type="number" id="cantidad" name="cantidad" />
            <br><br> 
            <impur type="hidden" name="sucursal" value="1"/>         
            <input type="submit" id="mysubmit" name="mysubmit" value="Entrar" />
        </form>
    </body>
</html>
