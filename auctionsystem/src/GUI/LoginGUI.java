/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Users.Admin;
import Users.User;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author Dalia
 */
public class LoginGUI extends JFrame {

    JLabel usernameLabel;
    JTextField usernameField;
    JLabel usernameRequired;
    JLabel passwordLabel;
    JPasswordField passwordfield;
    JLabel passwordfRequired;
    JButton login;
    JButton submit;
    JButton back;

    public LoginGUI() {
        usernameLabel = new JLabel("Username");
        usernameField = new JTextField();
        usernameRequired = new JLabel("*Username is required");
        passwordLabel = new JLabel("Password");
        passwordfield = new JPasswordField("");
        passwordfRequired = new JLabel("*Password is required");
        submit = new JButton("SUBMIT");
        back = new JButton("<");
        Container cp = getContentPane();
        cp.setLayout(null);
        usernameLabel.setBounds(50, 50, 300, 30);
        usernameField.setBounds(200, 50, 300, 30);
        usernameRequired.setBounds(200, 100, 300, 30);
        usernameRequired.setForeground(Color.red);
        usernameRequired.setOpaque(true);
        passwordLabel.setBounds(50, 200, 300, 30);
        passwordfield.setBounds(200, 200, 300, 30);
        passwordfRequired.setBounds(200, 240, 300, 30);
        passwordfRequired.setForeground(Color.red);
        passwordfRequired.setOpaque(true);
        submit.setBounds(400, 550, 100, 30);
        back.setBounds(10, 10, 60, 40);
        passwordfRequired.setVisible(false);
        usernameRequired.setVisible(false);
        this.add(usernameLabel);
        this.add(usernameField);
        this.add(usernameRequired);
        this.add(passwordLabel);
        this.add(passwordfield);
        this.add(passwordfRequired);
        this.add(submit);
        this.add(back);
        setSize(600, 700);
        setTitle("Login Form");
        submit.addActionListener(new Watcher());
        back.addActionListener(new Watcher());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private class Watcher implements ActionListener {

        public void actionPerformed(ActionEvent a) {
            User existinguser = new User();
           
            Object buttonPressed = a.getSource();
            if (buttonPressed.equals(submit)) {
                try {
                    if (usernameField.getText().equals("")) {
                        usernameRequired.setVisible(true);
                    }
                    if (passwordfield.getText().equals("")) {
                        passwordfRequired.setVisible(true);
                    } else if (existinguser.Login(usernameField.getText(), String.valueOf(passwordfield.getText()))) {
                        JOptionPane.showMessageDialog(null, "Success.");
                        UserGUI usergui = new UserGUI();
                        usergui.setVisible(true);
                        setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(null, "Wrong username or password.");
                    }

                } catch (IOException ex) {
                    System.out.println(ex);
                } catch (ClassNotFoundException ex) {
                    System.out.println(ex);
                }
            }
              else if (buttonPressed.equals(back)) {
                    WelcomeFrame f = new WelcomeFrame();
                    f.setVisible(true);
                    setVisible(false);
                }

            

        }
    }
}
