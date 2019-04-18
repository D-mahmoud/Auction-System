package Users;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import Items.Item;
import javax.swing.*;

public class Seller extends User  {

    Item item = new Item();
    public static ArrayList<Item> itemlist = new ArrayList<Item>(20);
    
    public void additem() 
    {
        itemlist.add(item);
    }
    public void deleteitem(Item i) 
    {
       itemlist.remove(i);
    }
    
    public Seller() 
    {
    }
}
