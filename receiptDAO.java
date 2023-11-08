/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataaccessobject;

import javax.swing.JOptionPane;
import java.sql.ResultSet;
import model.Receipt;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.SQLException;

/**
 *
 * @author RHADJEL
 */
public class receiptDAO {

    public static String getId() {
        String query = "SELECT MAX(id) FROM receipt_info";
        try (PreparedStatement statement = ConnectionProvider.getConn().prepareStatement(query)) {
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                int id = rs.getInt(1);
                return String.valueOf(id + 1);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Failed to get receipt ID: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return "1";
    }

    public static void save(Receipt receipt) {
        String query = "INSERT INTO receipt_info (id, name, mobile_number, email, date, total, createdBy) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = ConnectionProvider.getConn().prepareStatement(query)) {

            statement.setInt(1, receipt.getId());
            statement.setString(2, receipt.getName());
            statement.setString(3, receipt.getMobileNumber());
            statement.setString(4, receipt.getEmail());
            statement.setString(5, receipt.getDate());
            statement.setString(6, receipt.getTotal());
            statement.setString(7, receipt.getCreatedBy());

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Order Placed Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public static ArrayList<Receipt> getAllRecordsByDate(String date, boolean orderByDesc) {
        ArrayList<Receipt> arrayList = new ArrayList<>();
        String query = "SELECT * FROM receipt_info WHERE date LIKE ?" + (orderByDesc ? " ORDER BY id DESC" : "");
        try (PreparedStatement statement = ConnectionProvider.getConn().prepareStatement(query)) {
            statement.setString(1, "%" + date + "%");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {

                Receipt receipt = new Receipt();
                receipt.setId(rs.getInt("id"));
                receipt.setName(rs.getString("name"));
                receipt.setMobileNumber(rs.getString("mobile_number"));
                receipt.setEmail(rs.getString("email"));
                receipt.setDate(rs.getString("date"));
                receipt.setTotal(rs.getString("total"));
                receipt.setCreatedBy(rs.getString("createdBy"));
                arrayList.add(receipt);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error retrieving receipts: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return arrayList;
    }

    public static ArrayList<Receipt> getAllRecordsByDesc(String date, boolean orderByDesc) {
        ArrayList<Receipt> arrayList = new ArrayList<>();
        String query = "SELECT * FROM receipt_info WHERE date LIKE ?";

        if (orderByDesc) {
            query += " ORDER BY id DESC";
        }

        try (PreparedStatement statement = ConnectionProvider.getConn().prepareStatement(query)) {
            statement.setString(1, "%" + date + "%");
            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    Receipt receipt = new Receipt();
                    receipt.setId(rs.getInt("id"));
                    receipt.setName(rs.getString("name"));
                    receipt.setMobileNumber(rs.getString("mobile_number"));
                    receipt.setEmail(rs.getString("email"));
                    receipt.setDate(rs.getString("date"));
                    receipt.setTotal(rs.getString("total"));
                    receipt.setCreatedBy(rs.getString("createdBy"));
                    arrayList.add(receipt);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, date);
        }
        return arrayList;
    }

}
