/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WintermelonPackage;
import java.sql.*;
import java.util.Calendar;
import java.util.ArrayList;
/**
 *
 * @author Chi
 */
public class Product {
    public int productID;
    public String name;
    public Date dateCreated;
    public int quantity;
    public boolean error;
    public String errorMsg;
    
    public void createProduct() {
        Connection connection;
        PreparedStatement statement;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance(); 
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/wintermelon?useSSL=false&useTimezone=true&serverTimezone=Asia/Singapore&user=root&password=p@ssword");
            statement = connection.prepareStatement("INSERT INTO product (productID, name, dateCreated, quantity) VALUES(?, ?, ?, ?)");
            statement.setInt(1, productID);
            statement.setString(2, name);
            statement.setDate(3, dateCreated);
            statement.setInt(4, quantity);
            statement.execute();
            error = false;
            statement.close();
            connection.close();
        } catch (Exception e) {
            error = true;
            e.printStackTrace();
        }
    }
    
    public void updateProduct() {
        Connection connection;
        PreparedStatement statement;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance(); 
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/wintermelon?useSSL=false&useTimezone=true&serverTimezone=Asia/Singapore&user=root&password=p@ssword");
            statement = connection.prepareStatement("UPDATE product SET quantity = ? WHERE productID = ?");
            statement.setInt(1, quantity);
            statement.setInt(2, productID);
            statement.execute();
            error = false;
            statement.close();
            connection.close();
        } catch (Exception e) {
            error = true;
            e.printStackTrace();
        }
    }
    
    public void deleteProduct() {
        Connection connection;
        PreparedStatement statement;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance(); 
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/wintermelon?useSSL=false&useTimezone=true&serverTimezone=Asia/Singapore&user=root&password=p@ssword");
            statement = connection.prepareStatement("DELETE FROM product WHERE productID = ?");
            statement.setInt(1, productID);
            statement.execute();
            error = false;
            statement.close();
            connection.close();
        } catch (Exception e) {
            error = true;
            e.printStackTrace();
        }
    }
    
    public ArrayList<Product> getProducts() {
        Connection connection;
        PreparedStatement statement;
        ResultSet rs;
        ArrayList<Product> products = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance(); 
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/wintermelon?useSSL=false&useTimezone=true&serverTimezone=Asia/Singapore&user=root&password=p@ssword");
            statement = connection.prepareStatement("SELECT * FROM product");
            rs=statement.executeQuery();
            while(rs.next()) {
                Product product = new Product();
                product.productID = rs.getInt(1);
                product.name = rs.getString(2);
                product.dateCreated = rs.getDate(3);
                product.quantity = rs.getInt(4);
                products.add(product);
            }
            error = false;
            rs.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            error = true;
            e.printStackTrace();
        }
        return products;
    }
    
    public static void main (String[] args) {
        Product product = new Product();
        product.productID = 1003;
        product.quantity = 300;
        product.dateCreated=Date.valueOf("2020-07-11");
        product.name = "Wintermelon";
        product.createProduct();
    }
}
