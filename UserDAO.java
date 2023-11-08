/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataaccessobject;

/**
 *
 * @author RHADJEL
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.User;

public class UserDAO {

    public static boolean save(User user) {
        String query = "INSERT INTO signup (name, email, mobile_number, password, confirm_password, status) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConnectionProvider.getConn(); PreparedStatement preparedStatement = conn.prepareStatement(query)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getMobileNumber());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getConfirmPassword());
            preparedStatement.setString(6, user.getStatus());

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                conn.close();
                return true;
            } else {
                conn.close();
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    public static User login(String email, String password) {
        User user = null;

        try (Connection conn = ConnectionProvider.getConn()) {
            String query = "SELECT * FROM signup WHERE email = ? AND password = ?";
            try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
                preparedStatement.setString(1, email);
                preparedStatement.setString(2, password);

                ResultSet rs = preparedStatement.executeQuery();
                if (rs.next()) {  
                    user = new User();
                    user.setStatus(rs.getString("status"));
                    user.setName(rs.getString("name"));
                    user.setEmail(email);
                    user.setMobileNumber(rs.getString("mobile_number"));
                    user.setPassword(password);
                    return user;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return null;
    }

    public static User getEmail(String email) {
        User user = null;
        try (Connection conn = ConnectionProvider.getConn(); PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM signup WHERE email = ?")) {
            preparedStatement.setString(1, email);

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                user = new User();
                user.setEmail(rs.getString("email"));
            }

            rs.close();
            preparedStatement.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public static boolean verifyOldPassword(String email, String oldPassword) {
        try (Connection conn = ConnectionProvider.getConn(); PreparedStatement preparedStatement = conn.prepareStatement("SELECT email FROM signup WHERE email = ? AND password = ?")) {
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, oldPassword);

            ResultSet rs = preparedStatement.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void updatePassword(String email, String newPassword) {
        try (Connection conn = ConnectionProvider.getConn(); PreparedStatement preparedStatement = conn.prepareStatement("UPDATE signup SET password = ?, confirm_password = ? WHERE email = ?")) {
            preparedStatement.setString(1, newPassword);
            preparedStatement.setString(2, newPassword);
            preparedStatement.setString(3, email);

            int rowsUpdated = preparedStatement.executeUpdate();

            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "Password updated successfully!");
            } else {
                JOptionPane.showMessageDialog(null, "Email not found or password not updated", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error updating password: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void changePassword(String email, String oldPassword, String newPassword) {
        try (Connection conn = ConnectionProvider.getConn(); PreparedStatement preparedStatement = conn.prepareStatement("UPDATE signup SET password = ? WHERE email = ? AND password = ?")) {

            preparedStatement.setString(1, newPassword);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, oldPassword);

            int rowsUpdated = preparedStatement.executeUpdate();

            if (rowsUpdated > 0) {
                PreparedStatement updateConfirmPassword = conn.prepareStatement("UPDATE signup SET confirm_password = ? WHERE email = ?");
                updateConfirmPassword.setString(1, newPassword);
                updateConfirmPassword.setString(2, email);

                int confirmRowsUpdated = updateConfirmPassword.executeUpdate();

                if (confirmRowsUpdated > 0) {
                    JOptionPane.showMessageDialog(null, "Password updated successfully");
                } else {
                    JOptionPane.showMessageDialog(null, "Error updating confirm password", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Incorrect email or old password", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error updating password: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
