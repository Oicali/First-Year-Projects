/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Main;
import settings.progressScreen;

/**
 *
 * @author jairus
 */
public class InventorySystem {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                progressScreen loading = new progressScreen(null,true);
                loading.setVisible(true);
                
                logIn a = new logIn();
                     a.setVisible(true);
                
                
            }
        });
    }
}
