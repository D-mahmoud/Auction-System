/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Items.Item;
import Dashboard.BuyerDashboard;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

/**
 *
 * @author Dalia
 */
public class PaymentGUI extends JFrame {

    Item item = new Item();

    private JButton[] buttons = new JButton[15];
    JRadioButton Visa1, Cash1;
    JTextArea tx3;
    JTextArea tx;
    JTextArea tx2;

    public PaymentGUI() {

        setSize(600,700);
        setTitle("payement");
        buttons[0] = new JButton(" Select Payment ");
        buttons[1] = new JButton("Back");
        buttons[1].addActionListener(new Watcher());
        buttons[1].addActionListener(e -> this.dispose());
        setLayout(null);
        Visa1 = new JRadioButton("Visa");
        Cash1 = new JRadioButton("Cash");
        Watcher h = new Watcher();
        Visa1.addActionListener(h);
        Cash1.addActionListener(h);
        ButtonGroup payment = new ButtonGroup();
        payment.add(Visa1);
        payment.add(Cash1);
        setLayout(null);
        Visa1.setBounds(180, 50, 130, 30);
        Cash1.setBounds(180, 100, 130, 30);
        buttons[0].setBounds(220, 100, 130, 30);
        buttons[1].setBounds(190, 100, 100, 30);

        add(Visa1);
        add(Cash1);
        add(buttons[0]);
        add(buttons[1]);
        buttons[0].addActionListener(new PaymentGUI.Watcher());
       
    }

    class Watcher implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent a) {

            VisaGUI sp = new VisaGUI("Visa");
            CashGUI cash = new CashGUI("Enter Cash Amount");
            BuyerDashboard t = new BuyerDashboard();
            Object buttonPressed = a.getSource();
            if (Visa1.isSelected() && buttonPressed.equals(buttons[0])) {
               
                sp.setVisible(true);
                 setVisible(false);
            }

            if (Cash1.isSelected() && buttonPressed.equals(buttons[0])) {
                cash.setVisible(true);
                 setVisible(false);
            }
            if (buttonPressed.equals(buttons[1])) {
                t.setVisible(true);
                 setVisible(false);
            }

        }
    }
}
