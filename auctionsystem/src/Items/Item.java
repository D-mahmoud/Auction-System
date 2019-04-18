package Items;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.*;
import Users.Seller;
import AuctionSystem.iFile;
import javax.swing.*;

public class Item implements Serializable, iFile {

    String name;
    public int length, height, price, width;

    private String filePath = "/Users/tr/Desktop/items.bin";

    public Item(String name, int price, int width, int length, int height) {
        this.name = name;
        this.price = price;
        this.width = width;
        this.length = length;
        this.height = height;
    }

    public Item() {

    }

    public boolean createfile() throws IOException {
        File file = new File(filePath);
        return file.createNewFile();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean save() {

        try {

            ObjectOutputStream fileOutputStream = new ObjectOutputStream(new FileOutputStream(filePath, true));
            fileOutputStream.writeObject(Seller.itemlist);
            return true;
        } catch (FileNotFoundException ex) {
            return false;
        } catch (IOException ex) {
            return false;
        }
    }

    public boolean load() {

        try {
            ObjectInputStream fileInputStream = new ObjectInputStream(new FileInputStream(filePath));
            Seller.itemlist = (ArrayList<Item>) fileInputStream.readObject();

            return true;
        } catch (FileNotFoundException ex) {
            return false;
        } catch (IOException ex) {
            return false;
        } catch (ClassNotFoundException ex) {
            return false;
        }
    }

}
