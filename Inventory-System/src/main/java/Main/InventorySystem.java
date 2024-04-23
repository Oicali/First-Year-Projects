package Main;

import java.sql.*;
import otherForms.*;
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

public class InventorySystem {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                progressScreen loading = new progressScreen(null, true);
                loading.setVisible(true);

                new logIn().show();

            }
        });
    }

    public static Connection getDbCon() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory_system", "root", "#MySQL2220");
            return con;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

    }

    public static void closeCon() {
        try {
            if (getDbCon() != null) {
                getDbCon().close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void sendMail(String recipient) throws Exception{
        System.out.print("sending...");
        Properties properties = new Properties();
        
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        
        String myAccountEmail = "invsysmarkitbot@gmail.com";
        String password = "qfsb ksrp pwfw rigc";
        
        Session session = Session.getInstance(properties, new Authenticator(){
            @Override
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(myAccountEmail, password);
            }
    });
        
        Message message = prepareMessage(session, myAccountEmail, recipient);
        Transport.send(message);
        System.out.print("sent!");
    }
    
    private static Message prepareMessage(Session session, String myAccountEmail, String recipient) throws MessagingException{
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            message.setSubject("Try sending");
            message.setText("It works!!! \n yayyyyy");
            return message;
        } catch (AddressException ex) {
            Logger.getLogger(InventorySystem.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    private static Message prepareMessage(Session session) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
