/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chat;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;


public class Server extends JFrame implements Runnable {

    private ServerSocket Mysocket;
    private Socket clientsocket;
    private JTextField OneMessage;
    public JLabel allMessage;
    private ArrayList<Socket> Allconnections = new ArrayList<Socket>();

    JButton sendMsg = new JButton("Send");

    public Server() throws IOException {
        setSize(new Dimension(600, 600));
        setTitle("Contact Us!");
        Mysocket = new ServerSocket(6000);
        setLayout(null);
        allMessage = new JLabel("<html>All messages here");
        OneMessage = new JTextField("Write message here");
        allMessage.setBounds(20, 20, 300, 100);
        OneMessage.setBounds(allMessage.getBounds().x, allMessage.getBounds().y + allMessage.getHeight() + 10, 150, 50);
        sendMsg.setBounds(OneMessage.getBounds().x, OneMessage.getBounds().y + OneMessage.getHeight() + 10, 150, 50);
        add(allMessage);
        add(OneMessage);
        add(sendMsg);
        sendMsg.addActionListener(new act());

    }

    public void run() {
        try {
            while (true) {
                clientsocket = Mysocket.accept();
                Allconnections.add(clientsocket);
                ConnectionThread ct = new ConnectionThread(clientsocket, allMessage);
                Thread t1 = new Thread(ct);
                t1.start();
                Thread.sleep(1000);
                System.out.println("Waiting for another client");
            }
        } catch (InterruptedException e) {
        } catch (IOException e) {
        }
    }

    private class act implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {

                if (e.getSource().equals(sendMsg)) {
                    start(OneMessage.getText());
                    allMessage.setText(allMessage.getText() + "<br>" + OneMessage.getText());
                    OneMessage.setText(null);
                }

            } catch (IOException ex) {
                System.out.println(ex);
            }
        }

    }

    public void start(String msg) throws IOException {
        for (Socket s : Allconnections) {
            OutputStream os = s.getOutputStream();
            PrintWriter pw = new PrintWriter(os, true);
            pw.println(msg);
        }
        

    }
}