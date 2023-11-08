/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataaccessobject;
import java.util.ArrayList;
import model.Category;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
/**
 *
 * @author RHADJEL
 */
public class CategoryDao {
    public static void save(Category category) {
        String query = "INSERT INTO category (name) VALUES (?)";
        DatabaseOperations.setDataOrDelete(query, "Category added Successfully!", category.getName());
    }

    public static ArrayList<Category> getAllRecords() {
        ArrayList<Category> arrayList = new ArrayList<>();
        String query = "SELECT * FROM category";
        try (Connection conn = ConnectionProvider.getConn();
             PreparedStatement statement = conn.prepareStatement(query);
             ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {
                Category category = new Category();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                arrayList.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public static void delete(int id) {
        String query = "DELETE FROM category WHERE ID = ?";
        DatabaseOperations.setDataOrDelete(query, "Category deleted Successfully!", Integer.toString(id));
    }   
}
