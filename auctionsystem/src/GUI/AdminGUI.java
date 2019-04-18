/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import javax.swing.*;

/**
 *
 * @author Dalia
 */
public class AdminGUI extends JFrame {

    private JButton buttons = new JButton();
    JButton loginbutton;
    UserGUI usergui = new UserGUI();

    AdminLoginGUI login = new AdminLoginGUI();
    static HashMap<String, String> users;

    public AdminGUI() {

        setSize(600, 700);
        setTitle("Admin");

        loginbutton = new JButton("Login");

        Container cp = getContentPane();

        cp.setLayout(null);

        loginbutton.setBounds(150, 200, 300, 30);

        cp.add(loginbutton);
        
        loginbutton.addActionListener(new Watcher());

            }

    private class Watcher implements ActionListener {

        public void actionPerformed(ActionEvent a) {
            Object buttonPressed = a.getSource();
            
            
            if (buttonPressed.equals(loginbutton)) {
                login.setVisible(true);
                 setVisible(false);

            }
        }

    }
}
