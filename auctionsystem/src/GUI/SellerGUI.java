package GUI;

import Items.Item;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Dashboard.BuyerDashboard;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;

public class SellerGUI extends JFrame {

    JButton Add,Back;

    public SellerGUI() {

        setSize(600, 700);
        setTitle("Auction System");
        Add = new JButton("Add Item");
        Back = new JButton("<");

        Container cp = getContentPane();
        cp.setLayout(null);

        cp.add(Add);
        cp.add(Back);

        Add.setBounds(150, 150, 300, 30);
        Back.setBounds(10, 10, 70, 30);

        Back.addActionListener(new Watcher());
        Add.addActionListener(new Watcher());
    }

    private class Watcher implements ActionListener {

        public void actionPerformed(ActionEvent a) {

            Object buttonPressed = a.getSource();
            if (buttonPressed.equals(Add)) {
                AddItemGUI additem = new AddItemGUI();
                additem.setVisible(true);
                setVisible(false);
            } else if (buttonPressed.equals(Back)) {
                UserGUI user = new UserGUI();
                user.setVisible(true);
                setVisible(false);
            }

        }

    }
}
