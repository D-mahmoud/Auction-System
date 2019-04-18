package Users;

import AuctionSystem.iFile;
import Items.Item;
import Payment.BankAccount;
import java.io.*;
import java.io.Serializable;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class User extends JFrame implements Serializable , iFile {

    private String filePath = "/Users/tr/Desktop/users.bin";
    private String firstname;
    private String lastname;
    private String email;
    private String username;
    private String password;
    private String gender;
    private String position;
    private String phonenumber;
    private int age;
    public BankAccount account;
    static HashMap<String, String> UsersHashMap = new HashMap<>();

    public String getusername() {
        return username;
    }

    public void setusername(String username) {
        this.username = username;
    }

    public String getpassword() {
        return password;
    }

    public void setpassword(String password) {
        this.password = password;
    }

    public void adduser()
    {
        UsersHashMap.put(username, password);
    }
    
    
public boolean Login(String username, String password) throws FileNotFoundException, IOException, ClassNotFoundException {

        ObjectInputStream   fileInputStream = new ObjectInputStream(new FileInputStream(filePath));
            UsersHashMap= (HashMap<String,String>)fileInputStream.readObject();
            
        for (Map.Entry<String, String> entry : UsersHashMap.entrySet()) { 
            String key = entry.getKey();
            String value = entry.getValue();
            if (key.equals(username) && password.equals(value)) {
                return true;
            }
        }
        return false;
}
    
    @Override
    public boolean save() {
        try {
            ObjectOutputStream fileOutputStream = new ObjectOutputStream(new FileOutputStream(filePath,true));
            fileOutputStream.writeObject(UsersHashMap);
            return true;
        } catch (FileNotFoundException ex) {
            return false;
        } catch (IOException ex) {
            return false;
        }
    }
    
    @Override
    public boolean load() {
       
        try {
            ObjectInputStream fileInputStream = new ObjectInputStream(new FileInputStream(filePath));
            UsersHashMap = (HashMap<String, String>) fileInputStream.readObject();

            return true;
        } catch (FileNotFoundException ex) {
            return false;
        } catch (IOException ex) {
            return false;
        } catch (ClassNotFoundException ex) {
            return false;
        }  }

}
