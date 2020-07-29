<%-- 
    Document   : prodShow
    Created on : Jul 11, 2020, 6:15:23 PM
    Author     : Chi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="WintermelonPackage.*, java.util.ArrayList"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Showing the products..</title>
    </head>
    <body>
        <%
            Product product = new Product();
            ArrayList<Product> productList = product.getProducts();
        %>
        <h3>Showing The List of products:</h3>
        <table border="1">
            <thead>
                <th>Product ID</th>
                <th>Name</th>
                <th>Date Created</th>
                <th>Quantity</th>
            </thead>
            <%
            for (int i=0; i<productList.size(); i++) {%>
                <tr>
                    <td> <%=productList.get(i).productID%> </td>
                    <td> <%=productList.get(i).name%> </td>
                    <td> <%=productList.get(i).dateCreated%> </td>
                    <td> <%=productList.get(i).quantity%> </td> 
                </tr>
            <%}%>
        </table>
    </body>
</html>
