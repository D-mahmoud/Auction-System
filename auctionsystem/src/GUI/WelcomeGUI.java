/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package GUI;

import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author akram
 */
public class WelcomeGUI extends JFrame {

    private JButton buttons1 = new JButton();
    JButton a, c;
    JLabel d = new JLabel();
    JLabel b = new JLabel();
    int pos = 200;

    public WelcomeGUI() {

        setSize(600, 700);
        setTitle("Auction System");

        a = new JButton("Admin");
        c = new JButton("Customer");

        Container cp = getContentPane();
        ImageIcon imgpath = new ImageIcon("/Users/tr/Desktop/Auction/dollar.gif");
        d = new JLabel("", imgpath, JLabel.CENTER);
        d.setBounds(100, 100, 100, 100);

        cp.setLayout(null);
        

        cp.add(d);

        cp.setLayout(null);
        JLabel label = new JLabel("Please Choose From The Following:");
        label.setBounds(50, 50, 300, 30);
        a.setBounds(150, 100, 300, 30);
        c.setBounds(150, 200, 300, 30);
        cp.add(label);
        cp.add(a);
        cp.add(c);

        a.addActionListener(new WelcomeGUI.Watcher1());
        c.addActionListener(new WelcomeGUI.Watcher1());

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        d.setBounds(100, 250, 400, 400);
        add(d);
    }

    public void run() {
        while (true) {
            pos = pos - 10;
            repaint();
            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                Logger.getLogger(WelcomeGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private class Watcher1 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent b) {
            WelcomeFrame f = new WelcomeFrame();
            AdminGUI admin = new AdminGUI();

            Object buttonPressed = b.getSource();
            if (buttonPressed.equals(a)) {
                admin.setVisible(true);
                setVisible(false);

            } else if (buttonPressed.equals(c)) {
                f.setVisible(true);
                setVisible(false);

            }

        }

    }
}
