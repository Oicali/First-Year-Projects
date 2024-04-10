/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Main;

import java.awt.Color;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.plaf.metal.MetalButtonUI;

/**
 *
 * @author jairus
 */
public class logIn extends javax.swing.JFrame {

    ImageIcon image = new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\First-Year-Projects\\Inventory-System\\src\\main\\java\\resources\\logoSmall.png");
    public static boolean isAdmin = false;

    public logIn() {
        initComponents();
        setIconImage(image.getImage());
        passField.setEchoChar('•');
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        userIcon = new javax.swing.JLabel();
        forgotUser = new javax.swing.JButton();
        forgotPass = new javax.swing.JButton();
        License = new javax.swing.JButton();
        logInErrorMessage = new javax.swing.JLabel();
        passField = new settings.PasswordField();
        usernameField = new settings.TextField();
        selectRole = new settings.Combobox();
        logInBtn = new settings.RoundedButtons();
        showPass = new settings.JCheckBoxCustom();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Log In");
        setMinimumSize(new java.awt.Dimension(1080, 750));
        setPreferredSize(new java.awt.Dimension(1080, 750));
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel2.setBackground(new java.awt.Color(15, 106, 191));
        jPanel2.setLayout(null);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 40)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Log In to your Account");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(50, 150, 550, 110);

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\First-Year-Projects\\Inventory-System\\src\\main\\java\\resources\\logInBg.png")); // NOI18N
        jPanel2.add(jLabel3);
        jLabel3.setBounds(0, -10, 670, 770);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(420, 0, 670, 750);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        userIcon.setIcon(new javax.swing.ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\First-Year-Projects\\Inventory-System\\src\\main\\java\\resources\\logInUser.png")); // NOI18N
        jPanel1.add(userIcon);
        userIcon.setBounds(150, 110, 120, 120);

        forgotUser.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        forgotUser.setForeground(new java.awt.Color(153, 153, 153));
        forgotUser.setText("Forgot Username?");
        forgotUser.setBorderPainted(false);
        forgotUser.setContentAreaFilled(false);
        forgotUser.setFocusPainted(false);
        jPanel1.add(forgotUser);
        forgotUser.setBounds(250, 330, 140, 26);

        forgotPass.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        forgotPass.setForeground(new java.awt.Color(153, 153, 153));
        forgotPass.setText("Forgot Password?");
        forgotPass.setBorderPainted(false);
        forgotPass.setContentAreaFilled(false);
        forgotPass.setFocusPainted(false);
        jPanel1.add(forgotPass);
        forgotPass.setBounds(250, 420, 140, 26);

        License.setFont(new java.awt.Font("SansSerif", 2, 11)); // NOI18N
        License.setForeground(new java.awt.Color(153, 153, 153));
        License.setText("@Mark-It! 2024");
        License.setBorderPainted(false);
        License.setContentAreaFilled(false);
        License.setFocusPainted(false);
        License.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jPanel1.add(License);
        License.setBounds(120, 720, 170, 25);

        logInErrorMessage.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        logInErrorMessage.setForeground(new java.awt.Color(255, 51, 51));
        logInErrorMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logInErrorMessage.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(logInErrorMessage);
        logInErrorMessage.setBounds(100, 570, 210, 15);

        passField.setSelectionColor(new java.awt.Color(204, 204, 204));
        passField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                passFieldMousePressed(evt);
            }
        });
        jPanel1.add(passField);
        passField.setBounds(40, 360, 330, 49);

        usernameField.setSelectionColor(new java.awt.Color(204, 204, 204));
        usernameField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                usernameFieldMousePressed(evt);
            }
        });
        jPanel1.add(usernameField);
        usernameField.setBounds(40, 270, 330, 49);

        selectRole.setMaximumRowCount(3);
        selectRole.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Administrator", "Supervisor", "Employee" }));
        selectRole.setSelectedIndex(2);
        selectRole.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        selectRole.setLabelText("Logging in as");
        selectRole.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                selectRoleMousePressed(evt);
            }
        });
        jPanel1.add(selectRole);
        selectRole.setBounds(40, 470, 330, 49);

        logInBtn.setText("Log In");
        logInBtn.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        logInBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logInBtnActionPerformed(evt);
            }
        });
        jPanel1.add(logInBtn);
        logInBtn.setBounds(130, 650, 160, 40);

        showPass.setForeground(new java.awt.Color(153, 153, 153));
        showPass.setText("Show Password");
        showPass.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        showPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showPassActionPerformed(evt);
            }
        });
        jPanel1.add(showPass);
        showPass.setBounds(40, 423, 118, 23);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, -40, 420, 790);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void logInBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logInBtnActionPerformed
        String username = usernameField.getText();
        String password = passField.getText();
        String selectedRole = (String) selectRole.getSelectedItem();

        Connection con = InventorySystem.getDbCon();

        int accountCheck = 0;
        try {

            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM users WHERE userName = '" + username + "' AND userRole = '" + selectedRole + "' AND status = 'Active'");

            while (rs.next()) {
                accountCheck = 1;
                String storedPassword = rs.getString("password"); // Get the stored password from the database

                if (password.equals(storedPassword)) {
                    setVisible(false);
                    new Home(selectedRole).setVisible(true);
                } else {
                    logInErrorMessage.setText("Invalid Password!");
                }
            }

            // Close the ResultSet
            rs.close();
            s.close();

            if (accountCheck == 0) {
                logInErrorMessage.setText("Account not found!");
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Print the exception details for debugging
            JOptionPane.showMessageDialog(null, "An error occurred. Please try again later.", "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                // Close the Connection
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }


    }//GEN-LAST:event_logInBtnActionPerformed

    private void usernameFieldMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usernameFieldMousePressed
        logInErrorMessage.setText("");
    }//GEN-LAST:event_usernameFieldMousePressed

    private void passFieldMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passFieldMousePressed
        logInErrorMessage.setText("");
    }//GEN-LAST:event_passFieldMousePressed

    private void selectRoleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectRoleMousePressed
        logInErrorMessage.setText("");
    }//GEN-LAST:event_selectRoleMousePressed

    private void showPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showPassActionPerformed
        if (showPass.isSelected()) {
            passField.setEchoChar((char) 0);
        } else {
            passField.setEchoChar('•');
        }
        logInErrorMessage.setText("");
    }//GEN-LAST:event_showPassActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                new logIn().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton License;
    private javax.swing.JButton forgotPass;
    private javax.swing.JButton forgotUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private settings.RoundedButtons logInBtn;
    private javax.swing.JLabel logInErrorMessage;
    private settings.PasswordField passField;
    private settings.Combobox selectRole;
    private settings.JCheckBoxCustom showPass;
    private javax.swing.JLabel userIcon;
    private settings.TextField usernameField;
    // End of variables declaration//GEN-END:variables
}
