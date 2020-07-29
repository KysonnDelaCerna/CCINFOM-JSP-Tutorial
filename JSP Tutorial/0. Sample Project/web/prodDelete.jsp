<%-- 
    Document   : prodCreate
    Created on : Jul 11, 2020, 5:33:27 PM
    Author     : Chi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="WintermelonPackage.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Deleting a Product...</title>
    </head>
    <body>
        <%
            Product product = new Product();
            product.productID = Integer.parseInt(request.getParameter("productID"));
            product.deleteProduct();
            response.sendRedirect("productDelete.html");
        %>
    </body>
</html>
