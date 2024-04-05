/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import settings.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class transactBank extends frames {
    
    // Global variables 
    static JPanel transactBankPnl = new JPanel();
    static sounds sfx = new sounds();
    static JLabel transactBankVolume = new JLabel();
    public static String bankName = "null";
    
     // Generate and redesign the transaction2 frame for supported banks
    transactBank(){
        super();
        
        transactBankPnl.setSize(1244, 700);
        transactBankPnl.setBackground(Color.BLACK);
        transactBankPnl.setLayout(null);
        this.add(transactBankPnl);
        
        JLabel lbl1 = new JLabel("Select Supported Banks");
        lbl1.setFont(new Font("Source Sans Pro", Font.ITALIC + Font.BOLD, 30));
        lbl1.setHorizontalAlignment(JLabel.CENTER);
        lbl1.setForeground(new Color(255, 222, 89));
        lbl1.setBounds(520, 40, 400, 40);
        transactBankPnl.add(lbl1);
        
        JLabel cancelBtn = new JLabel();
        cancelBtn.setIcon(new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\First-Year-Projects\\FinalProject_ATM\\src\\main\\java\\resources\\cancelButton.png"));
        cancelBtn.setBounds(15, 35, 55, 55);
        transactBankPnl.add(cancelBtn);
        
        JLabel UBBtn = new JLabel();
        UBBtn.setIcon(
                new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\First-Year-Projects\\FinalProject_ATM\\src\\main\\java\\resources\\UBButton.png"));
        UBBtn.setBounds(535, 145,365, 70);
        transactBankPnl.add(UBBtn);
        
        JLabel BPIBtn = new JLabel();
        BPIBtn.setIcon(
                new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\First-Year-Projects\\FinalProject_ATM\\src\\main\\java\\resources\\BPIButton.png"));
        BPIBtn.setBounds(535, 265,365, 70);
        transactBankPnl.add(BPIBtn);
        
        JLabel BDOBtn = new JLabel();
        BDOBtn.setIcon(
                new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\First-Year-Projects\\FinalProject_ATM\\src\\main\\java\\resources\\BDOButton.png"));
        BDOBtn.setBounds(535, 385,365, 70);
        transactBankPnl.add(BDOBtn);
        
        final JButton backBtn = new roundButton("Back", new Color(48,47,178), new Color(32,31,171),  new Color(58,57,188), new Color(42,41,181));
        backBtn.setBounds(670, 500, 125, 50);
        backBtn.setFont(new Font("Source Sans Pro", Font.ITALIC + Font.BOLD, 25));
        backBtn.setForeground(Color.WHITE);
        transactBankPnl.add(backBtn);
        
        addVolumeEffects(transactBankPnl);
        
        JLabel transactBankBG = new JLabel();
        transactBankBG.setIcon(
                new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\First-Year-Projects\\FinalProject_ATM\\src\\main\\java\\resources\\transaction2BG.png"));
        transactBankBG.setBounds(0, -15, 1050, 700);
        transactBankPnl.add(transactBankBG);
        
        /* Buttons functions start here... */
        
        // For cancel button to return to log in frame
        cancelBtn.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // No action needed for mouseClicked
            }

            @Override
            public void mousePressed(MouseEvent e) {
                // No action needed for mousePressed
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                sfx.playWarning();

                cancelBtn.setIcon(new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\First-Year-Projects\\FinalProject_ATM\\src\\main\\java\\resources\\cancelButton.png"));
                int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to cancel transaction?", "Cancel Transaction", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {

                    // Update volume icon
                    if(sounds.isUnmute){
                        logIn.logInVolume.setIcon(
                            new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\First-Year-Projects\\FinalProject_ATM\\src\\main\\java\\resources\\unmute.png"));
                    
                    } else {
                        logIn.logInVolume.setIcon(
                            new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\First-Year-Projects\\FinalProject_ATM\\src\\main\\java\\resources\\mute.png"));
                    }
                    
                    bankName = "";
                    transaction.transactBankFrame.dispose();
                    FinalProject_ATM.logInFrame.show();
                    
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                cancelBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                cancelBtn.setIcon(new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\First-Year-Projects\\FinalProject_ATM\\src\\main\\java\\resources\\cancelButton2.png"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                cancelBtn.setCursor(Cursor.getDefaultCursor());
                cancelBtn.setIcon(new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\First-Year-Projects\\FinalProject_ATM\\src\\main\\java\\resources\\cancelButton.png"));
            }
        });
        
        // For UB button and go to typeAmount2 frame
        UBBtn.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // No action needed for mouseClicked
            }

            @Override
            public void mousePressed(MouseEvent e) {
                // No action needed for mousePressed
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                sfx.playClick();
                
                // Set transaction
                bankName = "UB";
                
                UBBtn.setIcon(
                new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\First-Year-Projects\\FinalProject_ATM\\src\\main\\java\\resources\\UBButton.png"));
                
                // Update volume icon
                    if(sounds.isUnmute){
                        typeAccount.typeAccountVolume.setIcon(
                            new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\First-Year-Projects\\FinalProject_ATM\\src\\main\\java\\resources\\unmute.png"));
                    
                    } else {
                        typeAccount.typeAccountVolume.setIcon(
                            new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\First-Year-Projects\\FinalProject_ATM\\src\\main\\java\\resources\\mute.png"));
                    }

                dispose();
                transaction.typeAccountFrame.show();
                   
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                UBBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                UBBtn.setIcon(
                new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\First-Year-Projects\\FinalProject_ATM\\src\\main\\java\\resources\\UBButton2.png"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
               UBBtn.setCursor(Cursor.getDefaultCursor());
               UBBtn.setIcon(
                new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\First-Year-Projects\\FinalProject_ATM\\src\\main\\java\\resources\\UBButton.png"));
            }
        });
        
        // For BPI button and go to typeAmount2 frame
        BPIBtn.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // No action needed for mouseClicked
            }

            @Override
            public void mousePressed(MouseEvent e) {
                // No action needed for mousePressed
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                sfx.playClick();
                
                // Set transaction
                bankName = "BPI";
                
                BPIBtn.setIcon(
                new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\First-Year-Projects\\FinalProject_ATM\\src\\main\\java\\resources\\BPIButton.png"));
                
                // Update volume icon
                    if(sounds.isUnmute){
                        typeAccount.typeAccountVolume.setIcon(
                            new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\First-Year-Projects\\FinalProject_ATM\\src\\main\\java\\resources\\unmute.png"));
                    
                    } else {
                        typeAccount.typeAccountVolume.setIcon(
                            new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\First-Year-Projects\\FinalProject_ATM\\src\\main\\java\\resources\\mute.png"));
                    }

                dispose();
                transaction.typeAccountFrame.show();
                   
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                BPIBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                BPIBtn.setIcon(
                new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\First-Year-Projects\\FinalProject_ATM\\src\\main\\java\\resources\\BPIButton2.png"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
               BPIBtn.setCursor(Cursor.getDefaultCursor());
               BPIBtn.setIcon(
                new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\First-Year-Projects\\FinalProject_ATM\\src\\main\\java\\resources\\BPIButton.png"));
            }
        });
        
        // For BDO button and go to typeAmount2 frame
        BDOBtn.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // No action needed for mouseClicked
            }

            @Override
            public void mousePressed(MouseEvent e) {
                // No action needed for mousePressed
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                sfx.playClick();
                
                // Set transaction
                bankName = "BDO";
                
                BDOBtn.setIcon(
                new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\First-Year-Projects\\FinalProject_ATM\\src\\main\\java\\resources\\BDOButton.png"));
                
                // Update volume icon
                    if(sounds.isUnmute){
                        typeAccount.typeAccountVolume.setIcon(
                            new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\First-Year-Projects\\FinalProject_ATM\\src\\main\\java\\resources\\unmute.png"));
                    
                    } else {
                        typeAccount.typeAccountVolume.setIcon(
                            new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\First-Year-Projects\\FinalProject_ATM\\src\\main\\java\\resources\\mute.png"));
                    }

                dispose();
                transaction.typeAccountFrame.show();
                   
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                BDOBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                BDOBtn.setIcon(
                new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\First-Year-Projects\\FinalProject_ATM\\src\\main\\java\\resources\\BDOButton2.png"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
               BDOBtn.setCursor(Cursor.getDefaultCursor());
               BDOBtn.setIcon(
                new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\First-Year-Projects\\FinalProject_ATM\\src\\main\\java\\resources\\BDOButton.png"));
            }
        });
        
        
        // For back button to return to transaction frame
        backBtn.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // No action needed for mouseClicked
            }

            @Override
            public void mousePressed(MouseEvent e) {
                // No action needed for mousePressed
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                sfx.playClick();

                // Update volume icon
                    if(sounds.isUnmute){
                        transaction.transactionVolume.setIcon(
                            new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\First-Year-Projects\\FinalProject_ATM\\src\\main\\java\\resources\\unmute.png"));
                    
                    } else {
                        transaction.transactionVolume.setIcon(
                            new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\First-Year-Projects\\FinalProject_ATM\\src\\main\\java\\resources\\mute.png"));
                    }
                
                dispose();
                logIn.transactionFrame.show();
                
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                backBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
               backBtn.setCursor(Cursor.getDefaultCursor());
            }
        });
        
    }
    
    // Add mute features
    private static void addVolumeEffects(JPanel panel) {
        transactBankVolume.setIcon(
                new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\First-Year-Projects\\FinalProject_ATM\\src\\main\\java\\resources\\unmute.png"));
        transactBankVolume.setBounds(980, 620, 40, 40);
        panel.add(transactBankVolume);

        transactBankVolume.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // No action needed for mouseClicked
            }

            @Override
            public void mousePressed(MouseEvent e) {
                // No action needed for mousePressed
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (sounds.isUnmute) {
                    transactBankVolume.setIcon(
                            new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\First-Year-Projects\\FinalProject_ATM\\src\\main\\java\\resources\\mute.png"));

                    sounds.isUnmute = false;
                } else {
                    transactBankVolume.setIcon(
                            new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\First-Year-Projects\\FinalProject_ATM\\src\\main\\java\\resources\\unmute.png"));
                    sounds.isUnmute = true;
                    sfx.playWarning();
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                transactBankVolume.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                transactBankVolume.setCursor(Cursor.getDefaultCursor());
            }
        });
    }
    
}