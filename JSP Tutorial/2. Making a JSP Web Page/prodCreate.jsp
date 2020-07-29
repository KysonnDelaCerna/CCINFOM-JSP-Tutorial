<%-- 
    Document   : prodCreate
    Created on : Jul 11, 2020, 5:33:27 PM
    Author     : Chi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Calendar, WintermelonPackage.*, java.sql.Date"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Creating a Product...</title>
    </head>
    <body>
        <%
            Calendar calendar = Calendar.getInstance();
            Product product = new Product();
            product.productID = Integer.parseInt(request.getParameter("productID"));
            product.name = request.getParameter("productName");
            product.quantity = Integer.parseInt(request.getParameter("productQuantity"));
            product.dateCreated = Date.valueOf(calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH)+1) + "-" + calendar.get(Calendar.DATE));
            product.createProduct();
            response.sendRedirect("productCreate.html");
        %>
    </body>
</html>
