/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package msgPopup;

import Main.InventorySystem;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.geom.RoundRectangle2D;
import java.net.URL;
import java.net.URLConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import settings.GlassPanePopup;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class forgotPasswordMsg extends javax.swing.JPanel {

    public static String Code = "", storedEmail = "";

    public forgotPasswordMsg() {
        initComponents();
        setOpaque(false);
        txt.setBackground(new Color(0, 0, 0, 0));
        txt.setOpaque(false);
        txt1.setBackground(new Color(0, 0, 0, 0));
        txt1.setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 15, 15));
        g2.dispose();
        super.paintComponent(grphcs);
    }

    // Method to generate OTP
    private static String generateOTP() {
        StringBuilder otpBuilder = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            otpBuilder.append((char) ((int) (Math.random() * 10) + '0'));
        }
        return otpBuilder.toString();
    }

    // Code for email sending
    public static void emailCode(String recipient) throws Exception {

        System.out.println("sending...");

        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        String myAccountEmail = "invsysmarkitbot@gmail.com";
        String password = "qfsb ksrp pwfw rigc";

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail, password);
            }
        });

        Message message = prepareCodeMessage(session, myAccountEmail, recipient);
        Transport.send(message);
        System.out.println("sent!");
    }

    private static Message prepareCodeMessage(Session session, String myAccountEmail, String recipient) throws MessagingException {
        String storedName = "";

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            message.setSubject("Inventory System Password Reset Verification Code");

            try {
                Statement s = InventorySystem.getDbCon().createStatement();
                ResultSet rs = s.executeQuery("SELECT * FROM users WHERE email = '" + recipient + "'");

                while (rs.next()) {
                    storedName = rs.getString("name");
                }

                // Close the ResultSet
                rs.close();
                s.close();

            } catch (SQLException e) {
                e.printStackTrace(); // Print the exception details for debugging
                JOptionPane.showMessageDialog(null, "An error occurred. Please try again later.", "Error", JOptionPane.ERROR_MESSAGE);
            } finally {
                InventorySystem.closeCon();
            }
            
            Code = generateOTP();
            System.out.println("The code is : " + Code);

            String htmlText = "<h3 style=\"color:black;\"> Reset Your Password!</h3>"
                    + "<p style=\"color:black;\">Dear Mr./Mrs. " + storedName + ", </p>"
                    + "<p style=\"color:black;\"> You have requested to reset your password. To proceed with the password reset process, please use the following verification code.</p>"
                    + "<h4 style=\"color:black;\"> Verification Code:  <b>" + Code + " </h4> </b>"
                    + "<p style=\"color:black;\"> Please enter this code on the password reset page to verify your identity and set a new password. Kindly note that the verification code is valid for 5 minutes. Please ensure that you input the code within this timeframe to avoid expiration and the need to request a new code.</p>"
                    + "<p style=\"color:black;\"> This message is generated automatically, so there's no need to reply. If you did not request this password reset or have any concerns, please contact our support team immediately.</p>"
                    + "<p style=\"color:black;\">Best regards,</p>"
                    + "<p style=\"color:black;\">Mark-It Inventory System </p>";

            message.setContent(htmlText, "text/html");
            return message;
        } catch (AddressException ex) {
            Logger.getLogger(InventorySystem.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txt = new javax.swing.JLabel();
        field = new javax.swing.JTextField();
        cancelBtn = new components.RoundedButtons();
        sendVCBtn = new components.RoundedButtons();
        txt1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(15, 106, 191));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Forgot your password?");

        txt.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        txt.setForeground(new java.awt.Color(102, 102, 102));
        txt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt.setText("Enter your registered email address and receive");

        field.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        field.setForeground(new java.awt.Color(153, 153, 153));
        field.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        field.setText("Enter Email Address");
        field.setOpaque(false);
        field.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                fieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                fieldFocusLost(evt);
            }
        });
        field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldActionPerformed(evt);
            }
        });

        cancelBtn.setBackground(new java.awt.Color(191, 50, 50));
        cancelBtn.setForeground(new java.awt.Color(255, 255, 255));
        cancelBtn.setText("Cancel");
        cancelBtn.setBorderColor(new java.awt.Color(191, 50, 50));
        cancelBtn.setBorderPainted(false);
        cancelBtn.setColor(new java.awt.Color(191, 50, 50));
        cancelBtn.setColorClick(new java.awt.Color(191, 50, 50));
        cancelBtn.setColorOver(new java.awt.Color(191, 50, 50));
        cancelBtn.setFocusPainted(false);
        cancelBtn.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        sendVCBtn.setBackground(new java.awt.Color(70, 191, 50));
        sendVCBtn.setForeground(new java.awt.Color(255, 255, 255));
        sendVCBtn.setText("Send");
        sendVCBtn.setBorderColor(new java.awt.Color(70, 191, 50));
        sendVCBtn.setBorderPainted(false);
        sendVCBtn.setColor(new java.awt.Color(70, 191, 50));
        sendVCBtn.setColorClick(new java.awt.Color(70, 191, 50));
        sendVCBtn.setColorOver(new java.awt.Color(70, 191, 50));
        sendVCBtn.setFocusPainted(false);
        sendVCBtn.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        sendVCBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendVCBtnActionPerformed(evt);
            }
        });

        txt1.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        txt1.setForeground(new java.awt.Color(102, 102, 102));
        txt1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt1.setText("a verification code to reset your password.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(sendVCBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(field, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(txt, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(txt1, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1)
                .addGap(25, 25, 25)
                .addComponent(txt)
                .addGap(3, 3, 3)
                .addComponent(txt1)
                .addGap(15, 15, 15)
                .addComponent(field, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sendVCBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void fieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fieldFocusGained
        field.setText(null);
        field.setForeground(new Color(51, 51, 51));
    }//GEN-LAST:event_fieldFocusGained

    private void fieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fieldFocusLost
        if (field.getText().isEmpty()) {
            field.setText("Enter Email Address");
            field.setForeground(new Color(153, 153, 153));
        }

    }//GEN-LAST:event_fieldFocusLost

    private void fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        GlassPanePopup.closePopupLast();
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void sendVCBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendVCBtnActionPerformed
        if (!field.getText().isEmpty() && !field.getText().trim().equalsIgnoreCase("Enter Email Address")) {
            try {
                URL url = new URL("http://www.google.com");
                URLConnection connection = url.openConnection();
                connection.connect();

                String findUsername = field.getText();

                boolean emailFound = false;
                try {
                    Statement s = InventorySystem.getDbCon().createStatement();
                    ResultSet rs = s.executeQuery("SELECT * FROM users WHERE email = '" + findUsername + "'");

                    while (rs.next()) {
                        emailFound = true;
                        storedEmail = rs.getString("email"); // Get the stored email from the database
                        System.out.println("Email found: " + storedEmail);
                    }

                    if (emailFound) {
                        try {
                            GlassPanePopup.closePopupLast();
                            emailCode(storedEmail);
                            verifyCodeMsg obj7 = new verifyCodeMsg();
                            GlassPanePopup.showPopup(obj7);
                            
                        } catch (Exception ex) {
                            Logger.getLogger(forgotUsernameMsg.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Sorry, it looks like the email you \n     entered is not registered.", "Email Not Found!", JOptionPane.ERROR_MESSAGE);
                    }

                    // Close the ResultSet
                    rs.close();
                    s.close();
                } catch (SQLException e) {
                    e.printStackTrace(); // Print the exception details for debugging
                    JOptionPane.showMessageDialog(null, "An error occurred. Please try again later.", "Error", JOptionPane.ERROR_MESSAGE);
                } finally {
                    InventorySystem.closeCon();
                }

            } catch (Exception e) {
                GlassPanePopup.closePopupLast();
                noWiFiMsg obj6 = new noWiFiMsg();
                obj6.closeBtnEvnt(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        GlassPanePopup.closePopupLast();
                    }
                });
                GlassPanePopup.showPopup(obj6);
            }

        }
    }//GEN-LAST:event_sendVCBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private components.RoundedButtons cancelBtn;
    private javax.swing.JTextField field;
    private javax.swing.JLabel jLabel1;
    private components.RoundedButtons sendVCBtn;
    private javax.swing.JLabel txt;
    private javax.swing.JLabel txt1;
    // End of variables declaration//GEN-END:variables
}
