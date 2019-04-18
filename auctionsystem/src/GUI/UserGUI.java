package GUI;

import Dashboard.BuyerDashboard;
import GUI.SellerGUI;
import GUI.BuyerGUI;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import Users.User;
import javax.swing.*;

public class UserGUI extends JFrame {

    JButton sell, buy;
    SellerGUI sellerGUI = new SellerGUI();
    BuyerGUI buyerGUI = new BuyerGUI();
    BuyerDashboard bb = new BuyerDashboard();
    String path = ("/Users/tr/Desktop/test.bin");
    Scanner in = new Scanner(System.in);
    HashMap<String, String> users;

    public UserGUI() {
        setSize(600, 700);
        setTitle("Sell or Buy");
        sell = new JButton("I want to Sell");
        buy = new JButton("I want to Buy");
        

        Container cp = getContentPane();
        cp.setLayout(null);

        JLabel label = new JLabel("Please Choose From The Following:");
        label.setBounds(50, 50, 300, 30);
        sell.setBounds(150, 100, 300, 30);
        buy.setBounds(150, 200, 300, 30);
         
        cp.add(label);
        cp.add(sell);
        cp.add(buy);
        

        sell.addActionListener(new Watcher());
        buy.addActionListener(new Watcher());

    }

    private class Watcher implements ActionListener {

        public void actionPerformed(ActionEvent a) {

            Object buttonPressed = a.getSource();
            if (buttonPressed.equals(sell)) {
                sellerGUI.setVisible(true);
                setVisible(false);

            } else if (buttonPressed.equals(buy)) {
                buyerGUI.setVisible(true);
                setVisible(false);

            }
           

        }
    }
}
