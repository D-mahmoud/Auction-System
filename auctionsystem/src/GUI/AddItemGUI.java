package GUI;

import Users.Seller;
import Dashboard.BuyerDashboard;
import Dashboard.SellerDashboard;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import Items.Item;
import javax.swing.*;

public class AddItemGUI extends JFrame {

    String path = "/Users/tr/Desktop/items.bin";
    SellerDashboard f;

    //Show Items
    JButton SubmitButton, ResetButton;

    private JLabel NameLabel;
    private JLabel WidthLabel;
    private JLabel PriceLabel;
    private JLabel HeightLabel;
    private JLabel LengthLabel;
    private JLabel FillFields;

    private JTextField NameField;
    private JTextField WidthField;
    private JTextField LengthField;
    private JTextField PriceField;
    private JTextField HeightField;

    public JLabel Cheke;

    private JButton addButton;
    private JButton saveButton, back;
    int x_cor = 50;
    int y_cor = 50;
    int width = 300;
    int height = 30;

    public AddItemGUI() {

        setSize(600, 700);
        setTitle("Add Items");
        NameLabel = new JLabel("Name: ");
        PriceLabel = new JLabel("Price: ");
        WidthLabel = new JLabel("Width: ");
        LengthLabel = new JLabel("Length: ");
        HeightLabel = new JLabel("Height: ");
        FillFields = new JLabel("*Please fill all the fields.");
        FillFields.setVisible(false);
        NameField = new JTextField("");
        PriceField = new JTextField("");
        WidthField = new JTextField("");
        LengthField = new JTextField("");
        HeightField = new JTextField("");
        SubmitButton = new JButton("Submit");
        ResetButton = new JButton("Reset");
        back = new JButton("<");
        Container cp = getContentPane();
        cp.setLayout(null);
        FillFields.setForeground(Color.red);
        FillFields.setOpaque(true);
        NameLabel.setBounds(50, 50, 300, 30);
        NameField.setBounds(200, 50, 300, 30);

        PriceLabel.setBounds(50, 100, 300, 30);
        PriceField.setBounds(200, 100, 300, 30);

        WidthLabel.setBounds(50, 150, 300, 30);
        WidthField.setBounds(200, 150, 300, 30);

        LengthLabel.setBounds(50, 200, 300, 30);
        LengthField.setBounds(200, 200, 300, 30);

        HeightLabel.setBounds(50, 250, 300, 30);
        HeightField.setBounds(200, 250, 300, 30);
        FillFields.setBounds(50, 300, 300, 30);
        SubmitButton.setBounds(100, 400, 300, 30);
        ResetButton.setBounds(100, 450, 300, 30);
        back.setBounds(10, 10, 70, 30);

        cp.add(NameLabel);
        cp.add(NameField);
        cp.add(PriceLabel);
        cp.add(PriceField);
        cp.add(WidthLabel);
        cp.add(WidthField);
        cp.add(LengthLabel);
        cp.add(LengthField);
        cp.add(HeightLabel);
        cp.add(HeightField);
        cp.add(FillFields);
        cp.add(SubmitButton);
        cp.add(ResetButton);
        cp.add(back);
        PriceField.addKeyListener(new keylisten());
        LengthField.addKeyListener(new keylisten());
        HeightField.addKeyListener(new keylisten());
        WidthField.addKeyListener(new keylisten());
        SubmitButton.addActionListener(new Watcher());
        ResetButton.addActionListener(new Watcher());
        back.addActionListener(new Watcher());
    }

    private class Watcher implements ActionListener {

        public void actionPerformed(ActionEvent a) {
            Object buttonPressed = a.getSource();
  //          BuyerDashboard dashboard = new BuyerDashboard();
            Item item = new Item();
            if (buttonPressed.equals(SubmitButton)) {
                if (NameField.getText().equals("") || PriceField.getText().equals("") || LengthField.getText().equals("") || HeightField.getText().equals("") || WidthField.getText().equals("")) {
                    FillFields.setVisible(true);
                } else {

                    item.setName(NameField.getText());
                    item.setPrice(Integer.parseInt(PriceField.getText()));
                    item.setLength(Integer.parseInt(LengthField.getText()));
                    item.setHeight(Integer.parseInt(HeightField.getText()));
                    item.setWidth(Integer.parseInt(WidthField.getText()));
                    Seller.itemlist.add(item);
                    f = new SellerDashboard();
                    f.setVisible(true);
                    setVisible(false);
                }
            } else if (buttonPressed.equals(ResetButton)) {
                NameField.setText("");
                PriceField.setText("");
                LengthField.setText("");
                HeightField.setText("");
                WidthField.setText("");
            } else if (buttonPressed.equals(back)) {
                SellerGUI se = new SellerGUI();
                setVisible(false);
                se.setVisible(true);
            }
        }

    }

    private class keylisten implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {
            char key = (char) e.getKeyChar();
            if (!Character.isDigit(key)) {
                //JOptionPane.showMessageDialog(null, "Please enter only numeric characters.");
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
}
