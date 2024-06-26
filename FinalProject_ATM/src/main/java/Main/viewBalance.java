/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import settings.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class viewBalance extends frames {

    // Global variables 
    static JPanel viewBalancePnl = new JPanel();
    static sounds sfx = new sounds();
    static JLabel viewBalanceVolume = new JLabel();
    static JLabel lbl2 = new JLabel();
    static JLabel lbl7 = new JLabel();
    public static String str1 = account.user.getUID().substring(0, 8);
    public static String str2 = account.user.getUID().substring(8);

    // Replace each character with "*"
    public static String maskedStr1 = String.join("", Collections.nCopies(str1.length(), "*"));

    public static String censoredUID = maskedStr1 + str2;

    // Generate and redesign the balance frame
    viewBalance() {
        super();

        viewBalancePnl.setSize(1244, 700);
        viewBalancePnl.setBackground(Color.BLACK);
        viewBalancePnl.setLayout(null);
        this.add(viewBalancePnl);

        JLabel lbl1 = new JLabel("Check your balance");
        lbl1.setFont(new Font("Source Sans Pro", Font.ITALIC + Font.BOLD, 30));
        lbl1.setHorizontalAlignment(JLabel.CENTER);
        lbl1.setForeground(new Color(255, 222, 89));
        lbl1.setBounds(515, 40, 400, 40);
        viewBalancePnl.add(lbl1);

        // Displays accountType
        lbl2.setFont(new Font("Source Sans Pro", Font.BOLD, 28));
        lbl2.setHorizontalAlignment(JLabel.CENTER);
        lbl2.setForeground(Color.WHITE);
        lbl2.setBounds(608, 175, 115, 40);
        viewBalancePnl.add(lbl2);

        JLabel lbl3 = new JLabel("Account");
        lbl3.setFont(new Font("Source Sans Pro", Font.BOLD, 28));
        lbl3.setHorizontalAlignment(JLabel.CENTER);
        lbl3.setForeground(Color.WHITE);
        lbl3.setBounds(723, 175, 115, 40);
        viewBalancePnl.add(lbl3);

        JLabel lbl4 = new JLabel(account.user.getName());
        lbl4.setFont(new Font("Source Sans Pro", Font.PLAIN, 25));
        lbl4.setHorizontalAlignment(JLabel.LEFT);
        lbl4.setForeground(Color.BLACK);
        lbl4.setBounds(580, 263, 340, 40);
        viewBalancePnl.add(lbl4);

        // Displays UID
        JLabel lbl5 = new JLabel(censoredUID);
        lbl5.setFont(new Font("Source Sans Pro", Font.PLAIN, 15));
        lbl5.setHorizontalAlignment(JLabel.LEFT);
        lbl5.setForeground(Color.BLACK);
        lbl5.setBounds(580, 294, 340, 40);
        viewBalancePnl.add(lbl5);

        JLabel lbl6 = new JLabel("Available Balance");
        lbl6.setFont(new Font("Source Sans Pro", Font.PLAIN, 23));
        lbl6.setHorizontalAlignment(JLabel.RIGHT);
        lbl6.setForeground(Color.BLACK);
        lbl6.setBounds(585, 345, 340, 40);
        viewBalancePnl.add(lbl6);

        // Displays current or savings balance amount
        lbl7.setFont(new Font("Source Sans Pro", Font.BOLD, 35));
        lbl7.setHorizontalAlignment(JLabel.RIGHT);
        lbl7.setForeground(Color.BLACK);
        lbl7.setBounds(560, 385, 365, 40);
        viewBalancePnl.add(lbl7);

        JLabel lbl8 = new JLabel("PHP");
        lbl8.setFont(new Font("Source Sans Pro", Font.BOLD, 15));
        lbl8.setHorizontalAlignment(JLabel.LEFT);
        lbl8.setForeground(Color.BLACK);
        lbl8.setBounds(520, 380, 40, 40);
        viewBalancePnl.add(lbl8);

        JLabel cancelBtn = new JLabel();
        cancelBtn.setIcon(new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\First-Year-Projects\\FinalProject_ATM\\src\\main\\java\\resources\\cancelButton.png"));
        cancelBtn.setBounds(15, 35, 55, 55);
        viewBalancePnl.add(cancelBtn);

        addVolumeEffects(viewBalancePnl);

        final JButton printBtn = new roundButton("Print", new Color(5, 38, 59), new Color(5, 38, 59), new Color(15, 48, 69), new Color(15, 48, 69));
        printBtn.setBounds(515, 488, 125, 50);
        printBtn.setFont(new Font("Source Sans Pro", Font.ITALIC + Font.BOLD, 25));
        printBtn.setForeground(Color.WHITE);
        viewBalancePnl.add(printBtn);

        final JButton backBtn = new roundButton("Back", new Color(48, 47, 178), new Color(32, 31, 171), new Color(58, 57, 188), new Color(42, 41, 181));
        backBtn.setBounds(800, 488, 125, 50);
        backBtn.setFont(new Font("Source Sans Pro", Font.ITALIC + Font.BOLD, 25));
        backBtn.setForeground(Color.WHITE);
        viewBalancePnl.add(backBtn);

        JLabel viewBalanceBG = new JLabel();
        viewBalanceBG.setIcon(
                new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\First-Year-Projects\\FinalProject_ATM\\src\\main\\java\\resources\\viewBalanceBG.png"));
        viewBalanceBG.setBounds(0, -15, 1050, 700);
        viewBalancePnl.add(viewBalanceBG);

        /* Buttons functions starts here... */
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
                    if (sounds.isUnmute) {
                        logIn.logInVolume.setIcon(
                                new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\First-Year-Projects\\FinalProject_ATM\\src\\main\\java\\resources\\unmute.png"));
                    } else {
                        logIn.logInVolume.setIcon(
                                new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\First-Year-Projects\\FinalProject_ATM\\src\\main\\java\\resources\\mute.png"));
                    }

                    dispose();
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

        // For back button to return to typeAccount frame
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
                if (sounds.isUnmute) {
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
                backBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                backBtn.setCursor(Cursor.getDefaultCursor());
            }
        });

        // For back button to return to typeAccount frame
        printBtn.addMouseListener(new MouseListener() {
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

                int choice = JOptionPane.showConfirmDialog(null, "Do you want a copy of your balance?\nClick yes to continue and return to\nlog in page.", "Print a copy", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    LocalDateTime now = LocalDateTime.now();
                    String date = dtf.format(now);

                    typeAccount.viewBalanceFrame.dispose();
                    typeAmount.process.show();
                    SwingUtilities.invokeLater(() -> {
                        typeAmount.process.fill(new Runnable() {
                            public void run() {
                                typeAmount.process.dispose();

                                try {
                                    printPDFReceipts.printBalance(typeAccount.accountType, date);
                                } catch (MalformedURLException ex) {
                                    Logger.getLogger(viewBalance.class.getName()).log(Level.SEVERE, null, ex);
                                } catch (IOException ex) {
                                    Logger.getLogger(viewBalance.class.getName()).log(Level.SEVERE, null, ex);
                                }

                                // Update volume Icon
                                if (sounds.isUnmute) {
                                    logIn.logInVolume.setIcon(
                                            new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\First-Year-Projects\\FinalProject_ATM\\src\\main\\java\\resources\\unmute.png"));

                                } else {
                                    logIn.logInVolume.setIcon(
                                            new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\First-Year-Projects\\FinalProject_ATM\\src\\main\\java\\resources\\mute.png"));
                                }
                                
                                FinalProject_ATM.logInFrame.show();
                            }
                        });
                    });

                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                printBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                printBtn.setCursor(Cursor.getDefaultCursor());
            }
        });
    }

    // Add mute features
    private static void addVolumeEffects(JPanel panel) {
        viewBalanceVolume.setIcon(
                new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\First-Year-Projects\\FinalProject_ATM\\src\\main\\java\\resources\\unmute.png"));
        viewBalanceVolume.setBounds(980, 620, 40, 40);
        panel.add(viewBalanceVolume);

        viewBalanceVolume.addMouseListener(new MouseListener() {
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
                    viewBalanceVolume.setIcon(
                            new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\First-Year-Projects\\FinalProject_ATM\\src\\main\\java\\resources\\mute.png"));

                    sounds.isUnmute = false;
                } else {
                    viewBalanceVolume.setIcon(
                            new ImageIcon("C:\\Users\\jairus\\Documents\\GitHub\\First-Year-Projects\\FinalProject_ATM\\src\\main\\java\\resources\\unmute.png"));
                    sounds.isUnmute = true;
                    sfx.playWarning();
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                viewBalanceVolume.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                viewBalanceVolume.setCursor(Cursor.getDefaultCursor());
            }
        });

    }

}
