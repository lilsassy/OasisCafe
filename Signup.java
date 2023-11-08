/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package coffeemanagement;

/**
 *
 * @author RHADJEL
 */


import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import model.User;
import dataaccessobject.UserDAO;


public class Signup extends javax.swing.JFrame {
    
    public String emailPattern = "^[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z0-9]+$";
    public String mobilePattern = "\\d{11}";
    public String model = "^[0-11]*$";
    
    /**
     * Creates new form Signup
     */
    public Signup() {
        initComponents();
    }
    
     public void validateFields() {
        boolean valid = true;

        String name = nameTF.getText();
        String email = emailTF.getText();
        String mobileNumber = mobileTF.getText();
        String password = new String(passwordTF.getPassword());
        String confirmPassword = new String(confirmTF.getPassword());

        if (name.isEmpty() || email.isEmpty() || mobileNumber.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            valid = false;
        }

        if (!email.matches(emailPattern)) {
            valid = false;
        }

        if (mobileNumber.length() != 11 || !mobileNumber.matches(mobilePattern)) {
            valid = false;
        }

        if (!password.equals(confirmPassword)) {
            valid = false;
        }

        // Enable or disable the ENTER button based on validation result
        enterBTN.setEnabled(valid);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        nameTF = new javax.swing.JTextField();
        emailTF = new javax.swing.JTextField();
        mobileTF = new javax.swing.JTextField();
        confirmTF = new javax.swing.JPasswordField();
        passwordTF = new javax.swing.JPasswordField();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        enterBTN = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Oasis Cafe");
        setBackground(new java.awt.Color(237, 231, 231));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocation(new java.awt.Point(320, 1));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe Script", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(48, 16, 16));
        jLabel1.setText("Oasis Cafe");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, 320, -1));

        jLabel2.setFont(new java.awt.Font("Segoe Print", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(48, 16, 16));
        jLabel2.setText("Sign Up");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 170, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe Print", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(48, 16, 16));
        jLabel3.setText("Name:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 269, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe Print", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(48, 16, 16));
        jLabel4.setText("Email:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 324, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe Print", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(48, 16, 16));
        jLabel5.setText("Contact Number:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 376, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe Print", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(48, 16, 16));
        jLabel6.setText("Password:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 426, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe Print", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(48, 16, 16));
        jLabel7.setText("Confirm Password:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 475, -1, -1));

        nameTF.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        nameTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTFActionPerformed(evt);
            }
        });
        nameTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nameTFKeyReleased(evt);
            }
        });
        getContentPane().add(nameTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(276, 281, 300, 27));

        emailTF.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        emailTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                emailTFKeyReleased(evt);
            }
        });
        getContentPane().add(emailTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(276, 336, 300, 27));

        mobileTF.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        mobileTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                mobileTFKeyReleased(evt);
            }
        });
        getContentPane().add(mobileTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(276, 387, 300, 29));

        confirmTF.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        confirmTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                confirmTFKeyReleased(evt);
            }
        });
        getContentPane().add(confirmTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(276, 487, 300, 27));

        passwordTF.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        passwordTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                passwordTFKeyReleased(evt);
            }
        });
        getContentPane().add(passwordTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(276, 438, 300, 27));

        jPanel3.setBackground(new java.awt.Color(196, 164, 132));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(181, 128, 25));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Login");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 450, 80, 30));

        enterBTN.setBackground(new java.awt.Color(181, 128, 25));
        enterBTN.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        enterBTN.setForeground(new java.awt.Color(255, 255, 255));
        enterBTN.setText("ENTER");
        enterBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterBTNActionPerformed(evt);
            }
        });
        jPanel3.add(enterBTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 450, -1, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 610, 570));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/coffee-aesthetic-background1.png"))); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void enterBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterBTNActionPerformed
        // TODO add your handling code here:
        String name = nameTF.getText();
        String email = emailTF.getText();
        String mobileNumber = mobileTF.getText();
        String password = new String(passwordTF.getPassword());
        String confirmPassword = new String(confirmTF.getPassword());

        if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(this, "Passwords do not match!");
            return;
        }   

        User user = new User(name, email, mobileNumber, password, confirmPassword);

        boolean saved = UserDAO.save(user);

        if (saved) {
            // Successful registration
            JOptionPane.showMessageDialog(this, "Signed up successfully.");
            nameTF.setText("");
            emailTF.setText("");
            mobileTF.setText("");
            passwordTF.setText("");
            confirmTF.setText("");

            setVisible(false);
            new Login().setVisible(true);
    } else {
        JOptionPane.showMessageDialog(this, "Error registering user", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_enterBTNActionPerformed

    private void nameTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTFActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_nameTFActionPerformed

    private void nameTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameTFKeyReleased
        // TODO add your handling code here:
        
    }//GEN-LAST:event_nameTFKeyReleased

    private void emailTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emailTFKeyReleased
        // TODO add your handling code here:
       
    }//GEN-LAST:event_emailTFKeyReleased

    private void mobileTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mobileTFKeyReleased
        // TODO add your handling code here:
        
    }//GEN-LAST:event_mobileTFKeyReleased

    private void passwordTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordTFKeyReleased
        // TODO add your handling code here:
       
    }//GEN-LAST:event_passwordTFKeyReleased

    private void confirmTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_confirmTFKeyReleased
        // TODO add your handling code here:
       
    }//GEN-LAST:event_confirmTFKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        new Login().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
         SwingUtilities.invokeLater(new Runnable() {
        
            
                    public void run() {
                new Signup().setVisible(true);
                }
            });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField confirmTF;
    private javax.swing.JTextField emailTF;
    private javax.swing.JButton enterBTN;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField mobileTF;
    private javax.swing.JTextField nameTF;
    private javax.swing.JPasswordField passwordTF;
    // End of variables declaration//GEN-END:variables
}