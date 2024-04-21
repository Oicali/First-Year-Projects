/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Main;

import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.metal.MetalButtonUI;

public class logIn extends javax.swing.JFrame {

    
    public static boolean isUserEmpty = true;
    public static boolean isPassEmpty = true;
    public static String username = "";
    public static String selectedRole = "";
    

    public logIn() {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        Shape roundedRectangle = new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20);
        setShape(roundedRectangle);
        setIconImage(InventorySystem.image.getImage());
        passField.setEchoChar('•');
        
        logInBtn.setUI(new MetalButtonUI() {
            protected Color getDisabledTextColor() {
                return new Color(15, 106, 191);
            }
        });
        
         usernameField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateLoginButton();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateLoginButton();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateLoginButton();
            }

            // Method to enable/disable the login button based on the PIN length
            private void updateLoginButton() {
                
                String usernameText = usernameField.getText().trim();
                if(usernameText.length()==0){
                    isUserEmpty = true;
                } else isUserEmpty = false;
                
                logInBtn.setEnabled(!isUserEmpty && !isPassEmpty);
            }
        });
        
        passField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateLoginButton();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateLoginButton();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateLoginButton();
            }

            // Method to enable/disable the login button based on the PIN length
            private void updateLoginButton() {
                
                String passText = passField.getText().trim();
                if(passText.length()==0){
                    isPassEmpty = true;
                } else isPassEmpty = false;
                
                logInBtn.setEnabled(!isUserEmpty && !isPassEmpty);
            }
        });
        

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new otherForms.PanelBorder();
        userIcon = new javax.swing.JLabel();
        exitBtn = new javax.swing.JButton();
        usernameField = new settings.TextField();
        forgotUser = new javax.swing.JButton();
        passField = new settings.PasswordField();
        forgotPass = new javax.swing.JButton();
        selectRole = new settings.Combobox();
        logInBtn = new settings.RoundedButtons();
        License = new javax.swing.JButton();
        showPass = new settings.JCheckBoxCustom();
        logInErrorMessage = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Log In");
        setMinimumSize(new java.awt.Dimension(1250, 750));
        setUndecorated(true);

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder1.setPreferredSize(new java.awt.Dimension(1250, 750));

        userIcon.setIcon(new javax.swing.ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\First-Year-Projects\\Inventory-System\\src\\main\\java\\resources\\logInUser.png")); // NOI18N

        exitBtn.setBackground(new java.awt.Color(255, 255, 255));
        exitBtn.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        exitBtn.setForeground(new java.awt.Color(15, 106, 191));
        exitBtn.setText("x");
        exitBtn.setBorderPainted(false);
        exitBtn.setContentAreaFilled(false);
        exitBtn.setFocusPainted(false);
        exitBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        exitBtn.setOpaque(true);
        exitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBtnActionPerformed(evt);
            }
        });

        usernameField.setSelectionColor(new java.awt.Color(204, 204, 204));
        usernameField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                usernameFieldMousePressed(evt);
            }
        });

        forgotUser.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        forgotUser.setForeground(new java.awt.Color(153, 153, 153));
        forgotUser.setText("Forgot Username?");
        forgotUser.setBorderPainted(false);
        forgotUser.setContentAreaFilled(false);
        forgotUser.setFocusPainted(false);
        forgotUser.setMaximumSize(new java.awt.Dimension(130, 26));
        forgotUser.setMinimumSize(new java.awt.Dimension(130, 26));
        forgotUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forgotUserActionPerformed(evt);
            }
        });

        passField.setSelectionColor(new java.awt.Color(204, 204, 204));
        passField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                passFieldMousePressed(evt);
            }
        });
        passField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passFieldActionPerformed(evt);
            }
        });

        forgotPass.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        forgotPass.setForeground(new java.awt.Color(153, 153, 153));
        forgotPass.setText("Forgot Password?");
        forgotPass.setBorderPainted(false);
        forgotPass.setContentAreaFilled(false);
        forgotPass.setFocusPainted(false);
        forgotPass.setPreferredSize(new java.awt.Dimension(132, 26));

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
        selectRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectRoleActionPerformed(evt);
            }
        });

        logInBtn.setForeground(new java.awt.Color(15, 106, 191));
        logInBtn.setText("Log In");
        logInBtn.setBorderColor(new java.awt.Color(15, 106, 191));
        logInBtn.setBorderPainted(false);
        logInBtn.setColorClick(new java.awt.Color(204, 204, 204));
        logInBtn.setColorOver(new java.awt.Color(204, 204, 204));
        logInBtn.setEnabled(false);
        logInBtn.setFocusPainted(false);
        logInBtn.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        logInBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logInBtnActionPerformed(evt);
            }
        });

        License.setFont(new java.awt.Font("SansSerif", 2, 11)); // NOI18N
        License.setForeground(new java.awt.Color(153, 153, 153));
        License.setText("@Mark-It! 2024");
        License.setBorderPainted(false);
        License.setContentAreaFilled(false);
        License.setFocusPainted(false);
        License.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        showPass.setForeground(new java.awt.Color(153, 153, 153));
        showPass.setText("Show Password");
        showPass.setFocusPainted(false);
        showPass.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        showPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showPassActionPerformed(evt);
            }
        });

        logInErrorMessage.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        logInErrorMessage.setForeground(new java.awt.Color(255, 51, 51));
        logInErrorMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logInErrorMessage.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jPanel1.setBackground(new java.awt.Color(15, 106, 191));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Log In to your Account");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(70, 210, 580, 80);

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\First-Year-Projects\\Inventory-System\\src\\main\\java\\resources\\logInBg.png")); // NOI18N
        jPanel1.add(jLabel2);
        jLabel2.setBounds(0, 0, 790, 750);

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logInErrorMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                                .addComponent(exitBtn)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                                .addComponent(userIcon)
                                .addGap(168, 168, 168))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                                    .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(panelBorder1Layout.createSequentialGroup()
                                            .addComponent(showPass, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(forgotPass, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(panelBorder1Layout.createSequentialGroup()
                                            .addComponent(forgotUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(8, 8, 8)))
                                    .addGap(40, 40, 40))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                                    .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(passField, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(selectRole, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(61, 61, 61)))))
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(License, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(logInBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(exitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(userIcon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(forgotUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(passField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(forgotPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(showPass, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(selectRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(logInErrorMessage)
                .addGap(47, 47, 47)
                .addComponent(logInBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(License)
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void showPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showPassActionPerformed
        if (showPass.isSelected()) {
            passField.setEchoChar((char) 0);
        } else {
            passField.setEchoChar('•');
        }
        logInErrorMessage.setText("");
    }//GEN-LAST:event_showPassActionPerformed

    private void selectRoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectRoleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_selectRoleActionPerformed

    private void selectRoleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectRoleMousePressed
        logInErrorMessage.setText("");
    }//GEN-LAST:event_selectRoleMousePressed

    private void usernameFieldMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usernameFieldMousePressed
        logInErrorMessage.setText("");
    }//GEN-LAST:event_usernameFieldMousePressed

    private void passFieldMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passFieldMousePressed
        logInErrorMessage.setText("");
    }//GEN-LAST:event_passFieldMousePressed

    private void forgotUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_forgotUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_forgotUserActionPerformed

    private void exitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBtnActionPerformed
        int choice = JOptionPane.showConfirmDialog(this, "Exit the program?", "Close Program", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_exitBtnActionPerformed

    private void passFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passFieldActionPerformed

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
                    new Main(selectedRole).setVisible(true);
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

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                new logIn().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton License;
    private javax.swing.JButton exitBtn;
    private javax.swing.JButton forgotPass;
    private javax.swing.JButton forgotUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private settings.RoundedButtons logInBtn;
    private javax.swing.JLabel logInErrorMessage;
    private otherForms.PanelBorder panelBorder1;
    private settings.PasswordField passField;
    private settings.Combobox selectRole;
    private settings.JCheckBoxCustom showPass;
    private javax.swing.JLabel userIcon;
    private settings.TextField usernameField;
    // End of variables declaration//GEN-END:variables
}
