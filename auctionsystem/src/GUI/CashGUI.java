/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import GUI.PaymentGUI;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Items.Item;
import javax.swing.*;

/**
 *
 * @author Dalia
 */


public class CashGUI extends JFrame {
    
     private JButton[] buttons = new JButton[15];
    Item item = new Item();
    public CashGUI(String title) throws HeadlessException {
        setSize(600,700);
        setTitle(title);
        
        buttons[0] = new JButton("Buy");
        buttons[1]=new JButton("Back");
        JTextArea tx = new JTextArea(1, 10);
        JLabel l = new JLabel("Number of tickets: ");
        tx.setText("");
        String t = tx.getText();
       
        buttons[0].setBounds(100, 200, 80, 30);
        buttons[1].setBounds(200, 200, 80, 30);
        l.setBounds(50, 80, 180, 30);
        tx.setBounds(170, 80, 140, 30);
        buttons[0].addActionListener(new Watcher());
        buttons[1].addActionListener(new Watcher());
       
        setLayout(null);
        add(l);
        add(tx);
       
        add(buttons[1]);
        add(buttons[0]);
        

    }
    private class Watcher implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            PaymentGUI p=new PaymentGUI();
            Object buttonPressed = e.getSource();
                if (buttonPressed.equals(buttons[1]))
                {
                p.setVisible(true);
                }
                else if (buttonPressed.equals(buttons[0])){
                //item.NumberOfTickets--;
                }
        }
    
    }
}

