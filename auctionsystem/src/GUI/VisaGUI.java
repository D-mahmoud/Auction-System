/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Payment.Visa;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.*;
import Items.Item;
import javax.swing.*;


public class VisaGUI extends JFrame {

    JTextArea tx3;
    JTextArea tx;
    JTextArea tx2;
    private JButton[] buttons = new JButton[15];
    Visa x;
    Item item = new Item();

    public VisaGUI(String title) throws HeadlessException {
        setSize(600, 700);
        setTitle(title);
        tx = new JTextArea(1, 7);
        tx2 = new JTextArea(1, 7);
        tx3 = new JTextArea(1, 7);
        buttons[1] = new JButton("Back");
        buttons[1].addActionListener(new Watcher());
        buttons[1].addActionListener(e -> this.dispose());
        JLabel l = new JLabel("Enter PIN: ");
        tx.setText("");
        String t = tx.getText();
        JLabel l1 = new JLabel("Enter Expiry Date: ");
        tx2.setText("");
        String t2 = tx2.getText();
        JLabel l2 = new JLabel("Enter CVV: ");
        tx3.setText("");
        String t3 = tx3.getText();
        buttons[9] = new JButton("Buy");
        buttons[9].addActionListener(new Watcher());
        setLayout(null);
        l.setBounds(20, 50, 150, 30);
        tx.setBounds(150, 50, 150, 30);
        l1.setBounds(20, 100, 150, 30);
        tx2.setBounds(150, 100, 150, 30);
        l2.setBounds(20, 150, 150, 30);
        tx3.setBounds(150, 150, 150, 30);
        buttons[9].setBounds(80, 250, 100, 30);
        buttons[1].setBounds(220, 250, 100, 30);
        
        add(l);
        add(tx);
        add(l1);
        add(tx2);
        add(l2);
        add(tx3);
        add(buttons[9]);
        add(buttons[1]);
        
    }

    private class Watcher implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Object buttonPressed = e.getSource();
            PaymentGUI p = new PaymentGUI();
            if (buttonPressed.equals(buttons[9])) {
                x = new Visa(Integer.parseInt(tx.getText()), Integer.parseInt(tx2.getText()), tx3.getText());
               

                x.printcvv();
               
            }
            if (buttonPressed.equals(buttons[1])) {
                p.setVisible(true);
            }

        }

    }
}
