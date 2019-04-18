package Dashboard;

import java.awt.Color;
import java.awt.event.*;
import java.util.*;
import GUI.AddItemGUI;
import Items.Bid;
import Items.Item;
import Users.Seller;
import Users.User;
import javax.swing.*;

public class SellerDashboard extends JFrame {

    private JLabel NameLabel;
    private JLabel WidthLabel;
    private JLabel PriceLabel;
    private JLabel HeightLabel;
    private JLabel LengthLabel;
    Item biditem = new Item();
    Bid newbid;
    User user = new User();
    private JTextField NameField;
    private JTextField WidthField;
    private JTextField LengthField;
    private JTextField PriceField;
    private JTextField HeightField;
    private JButton addButton;
    private JButton saveButton,back;
    public JLabel Empty;
    Item items = new Item();
    int x_cor = 50;
    int y_cor = 50;
    int width = 300;
    int height = 30;

    public SellerDashboard() {
        setSize(700, 850);
        setLayout(null);
        if (Seller.itemlist.size() != 0) {

            NameLabel = new JLabel("Name");
            PriceLabel = new JLabel("Price");
            LengthLabel = new JLabel("Length");
            HeightLabel = new JLabel("Height");
            WidthLabel = new JLabel("Width");
            back=new JButton("<");
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
                PriceLabel.setBounds(x_cor + 100, y_cor, 100, 30);
                LengthLabel.setBounds(x_cor + 200, y_cor, 100, 30);
                WidthLabel.setBounds(x_cor + 300, y_cor, 100, 30);
                HeightLabel.setBounds(x_cor + 400, y_cor, 100, 30);
                back.setBounds( 50, 500, 100, 30);
                add(NameLabel);
                add(PriceLabel);
                add(WidthLabel);
                add(LengthLabel);
                add(HeightLabel);

    back.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        AddItemGUI add= new AddItemGUI();
                        add.setVisible(true);
                        setVisible(false);
                    }
    
    
    
                    
                }
            );
                y_cor += 40;

            }

        } else {

            Empty = new JLabel();

            Empty.setText("there are no items, Add yours!");
            Empty.setBounds(50, 50, 150, 200);

            setTitle("Items Dashboard");
            setSize(600, 700);
            setLayout(null);
            setVisible(true);

            addButton = new JButton("Add");
            addButton.setBounds(400, 600, 80, 30);
            add(addButton);
            addButton.setVisible(true);
            addButton.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    AddItemGUI add = new AddItemGUI();
                    add.setVisible(true);
                    setVisible(false);

                }
            });

        }
    }
}
