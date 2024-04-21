package Main;

import java.sql.*;
import javax.swing.ImageIcon;
import otherForms.*;

public class InventorySystem {
    
    public static ImageIcon image = new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\First-Year-Projects\\Inventory-System\\src\\main\\java\\resources\\logoSmall.png");

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

}
