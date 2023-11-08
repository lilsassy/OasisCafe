/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package coffeemanagement;

import dataaccessobject.UserDAO;
import javax.swing.JOptionPane;

/**
 *
 * @author RHADJEL
 */
public class changepassword extends javax.swing.JFrame {

    private String userEmail;

    /**
     * Creates new form changepassword
     */
    public changepassword() {
        initComponents();
    }

    public changepassword(String email) {
        initComponents();
        userEmail = email;
        updateBTN.setEnabled(false);
    }

    public void validateFields() {
        String oldPassword = oldTF.getText();
        String newPassword = newTF.getText();
        String confirmPass = confirmTF.getText();
        if (!oldPassword.isEmpty() && !newPassword.isEmpty() && !confirmPass.isEmpty() && newPassword.equals(confirmPass)) {
            updateBTN.setEnabled(true);
        } else {
            updateBTN.setEnabled(false);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        oldTF = new javax.swing.JPasswordField();
        newTF = new javax.swing.JPasswordField();
        confirmTF = new javax.swing.JPasswordField();
        updateBTN = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();

        jCheckBox1.setText("jCheckBox1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Oasis Cafe");
        setLocation(new java.awt.Point(350, 134));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe Script", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(48, 16, 16));
        jLabel1.setText("Change Password");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 44, -1, -1));

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(557, 11, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(48, 16, 16));
        jLabel2.setText("Old Password:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(91, 166, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(48, 16, 16));
        jLabel3.setText("New Password:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 215, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(48, 16, 16));
        jLabel4.setText("Confirm Password:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 273, -1, -1));

        oldTF.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        oldTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                oldTFKeyReleased(evt);
            }
        });
        getContentPane().add(oldTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 164, 253, -1));

        newTF.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        newTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                newTFKeyReleased(evt);
            }
        });
        getContentPane().add(newTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 213, 253, -1));

        confirmTF.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        confirmTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                confirmTFKeyReleased(evt);
            }
        });
        getContentPane().add(confirmTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 271, 253, -1));

        updateBTN.setBackground(new java.awt.Color(181, 128, 25));
        updateBTN.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        updateBTN.setText("Update Password");
        updateBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBTNActionPerformed(evt);
            }
        });
        getContentPane().add(updateBTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(248, 336, -1, -1));

        jPanel1.setBackground(new java.awt.Color(196, 164, 132));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 670, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        new Homepage().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void oldTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_oldTFKeyReleased
        // TODO add your handling code here:
        validateFields();
    }//GEN-LAST:event_oldTFKeyReleased

    private void newTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_newTFKeyReleased
        // TODO add your handling code here:
        validateFields();
    }//GEN-LAST:event_newTFKeyReleased

    private void confirmTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_confirmTFKeyReleased
        // TODO add your handling code here:
        validateFields();
    }//GEN-LAST:event_confirmTFKeyReleased

    private void updateBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBTNActionPerformed
        // TODO add your handling code here:
        String oldPassword = oldTF.getText();
        String newPassword = newTF.getText();

        if (UserDAO.verifyOldPassword(userEmail, oldPassword)) {
            UserDAO.updatePassword(userEmail, newPassword);
            JOptionPane.showMessageDialog(this, "Password updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            setVisible(false);
            new Homepage().setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Incorrect old password. Password not updated.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_updateBTNActionPerformed

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
            java.util.logging.Logger.getLogger(changepassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(changepassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(changepassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(changepassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new changepassword().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField confirmTF;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField newTF;
    private javax.swing.JPasswordField oldTF;
    private javax.swing.JButton updateBTN;
    // End of variables declaration//GEN-END:variables
}