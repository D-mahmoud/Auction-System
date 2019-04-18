/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Users.User;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.*;

/**
 *
 * @author Dalia
 */
public class TransactionGUI extends JFrame {

    JLabel balancelabel;
    JLabel balance;
    User user = new User();

    public TransactionGUI() {
        
        balancelabel = new JLabel("Please notice that you bank balance is:");
        balance = new JLabel(String.valueOf(user.account.getAccountbalance()));

        
        setSize(600, 700);
        setTitle("Transaction");
        
        Container cp = getContentPane();

        cp.setLayout(null);
        cp.add(balancelabel);
        cp.add(balance);
        
        balancelabel.setBounds(20, 300, 120, 30);
        balance.setBounds(150,300,120,30);

    }

}
