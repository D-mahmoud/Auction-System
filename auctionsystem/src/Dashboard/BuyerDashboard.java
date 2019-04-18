package Dashboard;

import GUI.BuyerGUI;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import Items.*;
import Payment.BankAccount;
import Users.Seller;
import Users.User;
import javax.swing.*;


public class BuyerDashboard extends JFrame {

    Bid newbid;
    Item biditem = new Item();
    User user = new User();
    Item exists = new Item();
    private JLabel NameLabel;
    private JLabel WidthLabel;
    private JLabel PriceLabel;
    private JLabel HeightLabel;
    private JLabel LengthLabel;

    private JTextField NameField;
    private JTextField WidthField;
    private JTextField LengthField;
    private JTextField PriceField;
    private JTextField HeightField;
    private JButton addButton;
    private JButton saveButton;
    private JButton back;
    public JLabel Cheke;
    int x_cor = 50;
    int y_cor = 50;
    int width = 300;
    int height = 30;
       
    public BuyerDashboard() {
        if (Seller.itemlist.size() != 0) {

            NameLabel = new JLabel("Name");
            PriceLabel = new JLabel("Price");
            LengthLabel = new JLabel("Length");
            HeightLabel = new JLabel("Height");
            WidthLabel = new JLabel("Width");
            back= new JButton("<");
            NameLabel.setBounds(x_cor, y_cor - 50, 100, 30);
            PriceLabel.setBounds(x_cor + 100, y_cor - 50, 100, 30);
            WidthLabel.setBounds(x_cor + 200, y_cor - 50, 100, 30);
            LengthLabel.setBounds(x_cor + 300, y_cor - 50, 100, 30);
            HeightLabel.setBounds(x_cor + 400, y_cor - 50, 100, 30);
            back.setBounds(10, 10, 70, 30);

            NameLabel.setForeground(Color.red);
            PriceLabel.setForeground(Color.red);
            WidthLabel.setForeground(Color.red);
            LengthLabel.setForeground(Color.red);
            HeightLabel.setForeground(Color.red);

            add(NameLabel);
            add(PriceLabel);
            add(WidthLabel);
            add(LengthLabel);
            add(HeightLabel);
            add(back);
            
            for (int i = 0; i < Seller.itemlist.size(); i++) {

                NameLabel = new JLabel(Seller.itemlist.get(i).getName());

                String price = Integer.toString(Seller.itemlist.get(i).getPrice());
                PriceLabel = new JLabel(price);
                String width = Integer.toString(Seller.itemlist.get(i).getWidth());
                WidthLabel = new JLabel(width);
                String length = Integer.toString(Seller.itemlist.get(i).getLength());
                LengthLabel = new JLabel(length);
                String height = Integer.toString(Seller.itemlist.get(i).getHeight());
                HeightLabel = new JLabel(height);

                NameLabel.setBounds(x_cor, y_cor, 100, 30);
                PriceLabel.setBounds(x_cor+100, y_cor, 100, 30);
                LengthLabel.setBounds(x_cor+200, y_cor, 100, 30);
                WidthLabel.setBounds(x_cor+300, y_cor, 100, 30);
                HeightLabel.setBounds(x_cor+400, y_cor, 100, 30);
                 back.setBounds( 50, 500, 100, 30);
                add(NameLabel);
                add(PriceLabel);
                add(WidthLabel);
                add(LengthLabel);
                add(HeightLabel);

                JButton bidbutton = new JButton("BID");
                bidbutton.setBounds(x_cor + 500, y_cor, 70, 30);
                add(bidbutton);
                bidbutton.setActionCommand("" + i);
                bidbutton.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        
                     int index = Integer.parseInt(e.getActionCommand());
                     biditem.setName(NameLabel.getText());
                     biditem.setPrice(Integer.parseInt(PriceLabel.getText()));
                     biditem .setWidth(Integer.parseInt(WidthLabel.getText()));
                     biditem.setHeight(Integer.parseInt(HeightLabel.getText()));
                     biditem.setLength(Integer.parseInt(LengthLabel.getText()));
                     newbid = new Bid(index,biditem,user);
                     
                     newbid.setVisible(true);
                    }

                });
               
                back.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        BuyerGUI buyer=new BuyerGUI();
                        buyer.setVisible(true);
                        setVisible(false);
                    }

                });
               
                y_cor += 40;

            }
            

            saveButton = new JButton("SAVE");
            saveButton.setBounds(500, 600, 80, 30);
            add(saveButton);

            saveButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Item item = new Item();
                    if (item.save()) {
                        JOptionPane.showMessageDialog(rootPane, "Saved ");
                    }
                    setVisible(true);
                }
            });

            setTitle("Items Dashboard");
            setSize(600, 700);
            setLayout(null);
            
        } else {

            Cheke = new JLabel();

            Cheke.setText("No Items yet");
            Cheke.setBounds(50, 100, 150, 300);
            add(Cheke);

            setTitle("Items Dashboard");
            setSize(650, 700);
            setLayout(null);
            

        }
    }

}

