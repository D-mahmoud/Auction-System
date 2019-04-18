package AuctionSystem;

import GUI.Goodbye;
import GUI.WelcomeGUI;
import Users.Admin;
import Users.User;
import java.io.IOException;
import java.util.*;
import javax.swing.*;

public class JavaApplication1 {

    public static void main(String[] args) throws IOException {

        Goodbye b= new Goodbye();
        Thread t= new Thread(b);
        t.start();
        WelcomeGUI f = new WelcomeGUI();
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Audio Sound = new Audio();
        Sound.music();
        
    }
}
