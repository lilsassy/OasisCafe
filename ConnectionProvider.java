/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataaccessobject;

/**
 *
 * @author RHADJEL
 */

import java.sql.*;
import javax.swing.JOptionPane;

public class ConnectionProvider {
     public static Connection getConn(){
         Connection conn = null;
        try{
            String url = "jdbc:mysql://localhost:3306/cms";
            String user = "admin";
            String password = "Ching@2223";
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url, user, password);
        }catch(SQLException |ClassNotFoundException e){
            JOptionPane.showMessageDialog(null,e);
        }
        return null;
    }

}
