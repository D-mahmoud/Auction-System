package GUI;

import Users.User;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

public class SignUpGUI extends JFrame {

    JRadioButton gender1;
    JRadioButton gender2;

    JLabel usernameLabel;
    JTextField usernameField;
    JLabel usernameRequired;
    JLabel passwordLabel;

    JLabel firstNameLabel;
    JTextField firstName;
    JLabel lastNameLabel;
    JTextField lastName;

    JTextField username;
    JPasswordField passwordField;

    JLabel emailLabel;
    JTextField emailField;

    JLabel phoneNumberLabel;
    JTextField phoneNumber;

    JTextField dateOfBirth;
    JLabel dateOfBirthLabel;

    JTextField day;
    JLabel dayLabel;
    JTextField month;
    JLabel monthLabel;
    JTextField year;
    JLabel yearLabel;
    JComboBox daycombo;
    JComboBox monthcombo;
    JComboBox yearcombo;
    JLabel genderLabel;
    JRadioButton malegender;
    JRadioButton femalegender;
    ButtonGroup gendergroup;

    JLabel positionLabel;
    JComboBox positionsBox;
    JButton submit, back;

    public SignUpGUI() {
        firstNameLabel = new JLabel("First Name");
        firstName = new JTextField();
        lastNameLabel = new JLabel("Last Name");
        lastName = new JTextField();
        usernameLabel = new JLabel("Username");
        username = new JTextField();
        passwordLabel = new JLabel("Password");
        passwordField = new JPasswordField();
        emailLabel = new JLabel("Email");
        emailField = new JTextField();
        phoneNumberLabel = new JLabel("Phone Number");
        phoneNumber = new JTextField("");
        dateOfBirthLabel = new JLabel("Date of Birth");
        daycombo = new JComboBox();
        monthcombo = new JComboBox();
        yearcombo = new JComboBox();
        back = new JButton("<");

        for (int k = 1; k <= 31; k++) {
            daycombo.addItem(k);
        }
        for (int v = 1; v <= 12; v++) {
            monthcombo.addItem(v);
        }
        for (int p = 1960; p <= 2004; p++) {
            yearcombo.addItem(p);
        }
        malegender = new JRadioButton("Male");
        femalegender = new JRadioButton("Female");
        genderLabel = new JLabel("Gender");
        gendergroup = new ButtonGroup();
        gendergroup.add(malegender);
        gendergroup.add(femalegender);
        submit = new JButton("SUBMIT");
        setLayout(null);
        firstNameLabel.setBounds(50, 50, 300, 30);
        firstName.setBounds(200, 50, 300, 30);
        lastNameLabel.setBounds(50, 100, 300, 30);
        lastName.setBounds(200, 100, 300, 30);
        usernameLabel.setBounds(50, 150, 300, 30);
        username.setBounds(200, 150, 300, 30);
        passwordLabel.setBounds(50, 200, 300, 30);
        passwordField.setBounds(200, 200, 300, 30);
        passwordField.setEchoChar('*');
        emailLabel.setBounds(50, 250, 300, 30);
        emailField.setBounds(200, 250, 300, 30);
        phoneNumberLabel.setBounds(50, 300, 300, 30);
        phoneNumber.setBounds(200, 300, 300, 30);
        dateOfBirthLabel.setBounds(50, 350, 100, 30);
        daycombo.setBounds(200, 350, 80, 30);
        monthcombo.setBounds(320, 350, 80, 30);
        yearcombo.setBounds(420, 350, 80, 30);
        genderLabel.setBounds(50, 410, 50, 30);
        malegender.setBounds(200, 400, 100, 50);
        femalegender.setBounds(340, 400, 100, 50);
        submit.setBounds(400, 550, 100, 30);
        back.setBounds(10, 10, 70, 30);
        this.add(firstNameLabel);
        this.add(firstName);
        this.add(lastNameLabel);
        this.add(lastName);
        this.add(usernameLabel);
        this.add(username);
        this.add(passwordLabel);
        this.add(passwordField);
        this.add(emailLabel);
        this.add(emailField);
        this.add(phoneNumberLabel);
        this.add(phoneNumber);
        this.add(dateOfBirthLabel);
        this.add(daycombo);
        this.add(monthcombo);
        this.add(yearcombo);
        this.add(malegender);
        this.add(femalegender);
        this.add(genderLabel);
        this.add(submit);
        this.add(back);
        phoneNumber.addKeyListener(new keylisten());
        submit.addActionListener(new Watcher());
        back.addActionListener(new Watcher());
        setSize(600, 700);
        setTitle("Registration Form");

    }

    private class Watcher implements ActionListener {

        public void actionPerformed(ActionEvent a) {

            UserGUI gui = new UserGUI();
            User user = new User();

            Object buttonPressed = a.getSource();
            if (buttonPressed.equals(submit)) {

                if (firstName.getText().equals("") || lastName.getText().equals("") || username.getText().equals("") || passwordField.getText().equals("") || emailField.getText().equals("") || phoneNumber.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill all the fields.");
                }
                if (phoneNumber.getText().length() != 11) {
                    JOptionPane.showMessageDialog(null, "Wrong phone number Length", "Alert", JOptionPane.ERROR_MESSAGE);
                }

                if (!emailField.getText().contains("@") && !emailField.getText().contains(".")) {

                    JOptionPane.showMessageDialog(null, "Wrong email format", "Alert", JOptionPane.ERROR_MESSAGE);
                } else {
                    user.setusername(username.getText());
                    user.setpassword(passwordField.getText());
                    user.adduser();
                    user.save();
                    setVisible(false);
                    JOptionPane.showMessageDialog(null, "User added succesfully");
                    gui.setVisible(true);
                    setVisible(false);
                }
            } else if (buttonPressed.equals(back)) {
                WelcomeFrame f = new WelcomeFrame();
                f.setVisible(true);
                setVisible(false);
            }
        }
    }

    private class keylisten implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {
              
              
                char key = (char) e.getKeyChar();
            if (!Character.isDigit(key) || (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) || (e.getKeyCode() == KeyEvent.VK_DELETE)) {
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
