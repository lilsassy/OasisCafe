/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataaccessobject;

import java.util.ArrayList;
import model.product;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;

/**
 *
 * @author RHADJEL
 */
public class productDao {

    private static final String product = "product";

    public static void save(product product) {

        String query = "INSERT INTO product (name, category, price) VALUES (?, ?, ?)";
        DatabaseOperations.setDataOrDelete(query, "Product Added Successfully!", product.getName(), product.getCategory(), product.getPrice());

    }

    public static ArrayList<product> getAllRecords() {
        ArrayList<product> arrayList = new ArrayList<>();
        String query = "SELECT * FROM product";

        try (Connection conn = ConnectionProvider.getConn(); PreparedStatement statement = conn.prepareStatement(query); ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {
                product product = new product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setCategory(rs.getString("category"));
                product.setPrice(rs.getString("price"));

                arrayList.add(product);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error retrieving products: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return arrayList;

    }

    public static void update(product product) {
        String query = "UPDATE product SET name = ?, category = ?, price = ? WHERE id = ?";
        try (Connection conn = ConnectionProvider.getConn(); PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, product.getName());
            statement.setString(2, product.getCategory());
            statement.setString(3, product.getPrice());
            statement.setInt(4, product.getId());
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Product Updated Successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error Updating product: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void delete(int id) {
        String query = "DELETE FROM " + product + " WHERE id = ?";
        try (Connection conn = ConnectionProvider.getConn(); PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Product Deleted Successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error Deleting Product: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static ArrayList<product> getAllRecordsByCategory(String category) {
        ArrayList<product> list = new ArrayList<>();
        String query = "SELECT * FROM product WHERE category = ?";

        try (Connection conn = ConnectionProvider.getConn(); PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, category);
            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    product productObj = new product();
                    productObj.setId(rs.getInt("id"));
                    productObj.setName(rs.getString("name"));
                    productObj.setCategory(rs.getString("category"));
                    productObj.setPrice(rs.getString("price"));
                    list.add(productObj);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error retrieving products by category: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return list;
    }

    public static ArrayList<product> filterproductByName(String name, String category) {
        ArrayList<product> list = new ArrayList<>();
        try {
            String query = "SELECT * FROM product WHERE name LIKE ? AND category = ?";
            ResultSet rs;

            try (Connection conn = ConnectionProvider.getConn(); PreparedStatement statement = conn.prepareStatement(query)) {
                statement.setString(1, "%" + name + "%");
                statement.setString(2, category);
                rs = statement.executeQuery();

                while (rs.next()) {
                    product productObj = new product();
                    productObj.setName(rs.getString("name"));
                    list.add(productObj);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return list;
    }

    public static product getproductByname(String name) {
        product productObj = new product();
        try {
            String query = "SELECT * FROM product WHERE name = ?";
            ResultSet rs;

            try (Connection conn = ConnectionProvider.getConn(); PreparedStatement statement = conn.prepareStatement(query)) {
                statement.setString(1, name);
                rs = statement.executeQuery();

                if (rs.next()) {

                    productObj.setName(rs.getString("name"));
                    productObj.setCategory(rs.getString("category"));
                    productObj.setPrice(rs.getString("price"));
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return productObj;
    }
}
