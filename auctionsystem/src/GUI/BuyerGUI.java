package GUI;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Items.Item;
import Dashboard.BuyerDashboard;
import javax.swing.JButton;
import javax.swing.JFrame;

public class BuyerGUI extends JFrame {

    JButton i,back;
    BuyerDashboard item = new BuyerDashboard();

    public BuyerGUI() {

        setSize(600, 700);
        setTitle("Auction System");
        i = new JButton("View Items");
        back=new JButton("<");
        Container cp = getContentPane();
        cp.setLayout(null);
        i.setBounds(150, 100, 300, 30);
        back.setBounds(10, 10, 70, 30);
        cp.add(i);
        cp.add(back);
        i.addActionListener(new Watcher());
        back.addActionListener(new Watcher());
    }

    private class Watcher implements ActionListener {

        public void actionPerformed(ActionEvent a) {

            Object buttonPressed = a.getSource();
            if (buttonPressed.equals(i)) {
                item.setVisible(true);
                setVisible(false);

            }
           else if (buttonPressed.equals(back)) {
               UserGUI user=new UserGUI();
                user.setVisible(true);
                setVisible(false);

            }

        }

    }
}
