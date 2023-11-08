/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataaccessobject;

/**
 *
 * @author RHADJEL
 */
import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class DatabaseOperations {

    public static void setDataOrDelete(String query, String msg, String... params) {
        try (Connection conn = ConnectionProvider.getConn();
             PreparedStatement preparedStatement = conn.prepareStatement(query)) {

            for (int i = 0; i < params.length; i++) {
                preparedStatement.setString(i + 1, params[i]);
            }

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, msg);
            } else {
                JOptionPane.showMessageDialog(null, "No rows affected, operation failed");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static ResultSet getData(String query) {
        try (Connection conn = ConnectionProvider.getConn();
             PreparedStatement preparedStatement = conn.prepareStatement(query);
             ResultSet rs = preparedStatement.executeQuery()) {
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static class CustomPreparedStatement {

        private java.sql.PreparedStatement preparedStatement;
        private String query;
        private ResultSet rs;

        public CustomPreparedStatement(Connection conn, String query) {
            this.query = query;
            try {
                preparedStatement = conn.prepareStatement(query);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public ResultSet executeQuery() {
            try {
                 rs = preparedStatement.executeQuery();
                 return rs;
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        }

        public void close() {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }if (rs != null) {
                     rs.close(); 
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public void setString(int i, String categoryName) {
            try {
                preparedStatement.setString(i, categoryName);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public int executeUpdate() {
            try {
                return preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
                return 0;
            }
        }
    }

    public static void setDataOrDelete(String query, String msg, String categoryName) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;

        try {
            conn = ConnectionProvider.getConn();
            preparedStatement = conn.prepareStatement(query);

            if (categoryName != null) {
                preparedStatement.setString(1, categoryName);
            }

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, msg);
            } else {
                JOptionPane.showMessageDialog(null, "No rows affected, operation failed");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
