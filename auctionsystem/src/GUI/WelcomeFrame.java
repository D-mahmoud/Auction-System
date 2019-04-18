package GUI;

import Chat.Server;
import GUI.WelcomeGUI;
import GUI.UserGUI;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;

public class WelcomeFrame extends JFrame {

    private JButton buttons = new JButton();
    JButton loginbutton, signupbutton, chat, statistics, back;
    UserGUI usergui = new UserGUI();
    SignUpGUI signup = new SignUpGUI();
    LoginGUI login = new LoginGUI();
    ChartGUI ch = new ChartGUI();

    public void paint(Graphics g) {
        super.paint(g);
        try {
            BufferedImage img = ImageIO.read(new File("/Users/tr/Desktop/Auction/auction.png"));
            g.drawImage(img, 200, 340, 230, 300, null);

        } catch (IOException ex) {
            System.out.println(ex);
        }

    }

    public WelcomeFrame() {

        setSize(600, 700);
        setTitle("Welcome");

        loginbutton = new JButton("Login");
        signupbutton = new JButton("Signup");
        chat = new JButton("Contact Us");
        statistics = new JButton("Statistics");

        Container cp = getContentPane();

        cp.setLayout(null);
        JLabel label = new JLabel("Welcome to our auction system:");
        back = new JButton("<");
        label.setBounds(50, 50, 300, 30);
        loginbutton.setBounds(150, 200, 300, 30);
        signupbutton.setBounds(150, 300, 300, 30);
        chat.setBounds(150, 500, 300, 30);
        statistics.setBounds(150, 600, 300, 30);
        back.setBounds(10, 10, 70, 30);
        cp.add(label);
        cp.add(loginbutton);
        cp.add(signupbutton);
        cp.add(chat);
        cp.add(statistics);
        cp.add(back);
        loginbutton.addActionListener(new Watcher());
        signupbutton.addActionListener(new Watcher());
        chat.addActionListener(new Watcher());
        statistics.addActionListener(new Watcher());
        back.addActionListener(new Watcher());

    }

    private class Watcher implements ActionListener {

        public void actionPerformed(ActionEvent a) {
            Object buttonPressed = a.getSource();
            WelcomeFrame f = new WelcomeFrame();

            if (buttonPressed.equals(loginbutton)) {
                login.setVisible(true);
                setVisible(false);

            } else if (buttonPressed.equals(signupbutton)) {
                signup.setVisible(true);
                setVisible(false);
            } else if (buttonPressed.equals(statistics)) {
                ch.setVisible(true);
                setVisible(false);

            }
            else if (buttonPressed.equals(chat))
            {
                try {
                    Server server = new Server();
                    server.setVisible(true);
                    setVisible(false);
                } catch (IOException ex) {
                    Logger.getLogger(WelcomeFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else if (buttonPressed.equals(back)) {
                WelcomeGUI welcome = new WelcomeGUI();
                welcome.setVisible(true);
                setVisible(false);

            }
        }
    }

}
