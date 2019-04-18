package Items;

import AuctionSystem.Audio;
import GUI.Goodbye;
import GUI.PaymentGUI;
import GUI.TransactionGUI;
import Payment.BankAccount;
import Payment.DepositThread;
import Payment.WithdrawThread;
import Users.User;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Bid extends JFrame {

    Item item;
    JButton bidbyrate, bidbyprice, buynow, pay;
    JLabel itemname, name, itemprice, price, rate, bankbalance, balance, finalbuy;
    JTextField addprice;

    public Bid(int index, Item biditem, User user) {
        item = new Item();
        name = new JLabel("Item Name:");
        itemname = new JLabel(biditem.getName());
        price = new JLabel("Item Price:");
        itemprice = new JLabel(String.valueOf(biditem.getPrice()));

        bidbyrate = new JButton("Bid by rate.");
        bidbyprice = new JButton("Bid by price.");
        pay = new JButton("Pay");
        buynow = new JButton("Buy now");
        rate = new JLabel("Bid rate: 100$");

        addprice = new JTextField();
        name.setBounds(20, 100, 120, 30);
        price.setBounds(20, 200, 120, 30);
        addprice.setBounds(20, 500, 120, 30);

        itemname.setBounds(150, 100, 120, 30);
        itemprice.setBounds(150, 200, 120, 30);
        bidbyrate.setBounds(150, 550, 120, 30);
        bidbyprice.setBounds(150, 500, 120, 30);
        pay.setBounds(300, 550, 120, 30);

        rate.setBounds(20, 550, 120, 30);

        Container cp = getContentPane();
        setTitle("Bid");
        setSize(600, 700);
        setLayout(null);
        add(bidbyrate);
        add(addprice);
        add(bidbyprice);
        add(rate);
        add(name);
        add(price);
        add(itemname);
        add(itemprice);
        add(pay);

        bidbyrate.addActionListener(new Watcher());
        bidbyprice.addActionListener(new Watcher());
        pay.addActionListener(new Watcher());

    }

    public class keylisten implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {
            char key = (char) e.getKeyChar();
            if (!Character.isDigit(key)) {
                e.consume();
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }
    }

    private class Watcher implements ActionListener {

        public void actionPerformed(ActionEvent a) {
            Object buttonpressed = a.getSource();
            PaymentGUI gui = new PaymentGUI();
            if (buttonpressed == bidbyrate) {
                int x = Integer.parseInt(itemprice.getText());
                x += 100;
                itemprice.setText(String.valueOf(x));
                Audio S1 = new Audio();
                S1.music1();

            } else if (buttonpressed == bidbyprice) {
                int x = Integer.parseInt(itemprice.getText());
                x += Integer.parseInt(addprice.getText());
                itemprice.setText(String.valueOf(x));
                addprice.setText("");
                Audio S2 = new Audio();
                S2.music1();

            } else if (buttonpressed == pay) {
                BankAccount bank = new BankAccount();
                item.price = Integer.parseInt(itemprice.getText());
                WithdrawThread withdraw = new WithdrawThread(bank, item.getPrice());
                Thread t1 = new Thread(withdraw);
                t1.start();
                setVisible(false);
                dispose();
                JOptionPane.showMessageDialog(null, "Amount paid:" + withdraw.amount);
                Audio S3 = new Audio();
                S3.music1();
                Goodbye g1 = new Goodbye();
                 Thread t= new Thread(g1);
                t.start();
                g1.setVisible(true);
            }
        }
    }
}
