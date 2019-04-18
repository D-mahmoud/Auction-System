/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javax.swing.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mohamed
 */
public class Goodbye extends JFrame implements Runnable {

    JLabel a = new JLabel();
    JLabel b = new JLabel();
    int pos = 200;

    public Goodbye() {
        setSize(600, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon imgpath = new ImageIcon("/Users/tr/Desktop/Auction/Thank.gif");
        a = new JLabel("", imgpath, JLabel.CENTER);

        ImageIcon img = new ImageIcon("/Users/tr/Desktop/Auction/abc.gif");
        b = new JLabel("", img, JLabel.CENTER);

        b.setBounds(0, 0, 400, 600);

        Container cp = getContentPane();
        cp.setLayout(null);
        

        cp.add(b);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        a.setBounds(pos, 50, 377, 377);
        add(a);

    }

    @Override
    public void run() {
        while (true) {
            pos = pos - 10;
            repaint();
            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                Logger.getLogger(Goodbye.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
