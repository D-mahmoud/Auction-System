package Users;

import java.io.*;
import java.util.ArrayList;
import Items.Item;
import AuctionSystem.iFile;
import static Users.User.UsersHashMap;
import java.util.HashMap;
import java.util.Map;

public class Admin implements iFile {

    private String username;
    private String pw;
    public static HashMap<String, String> AdminsHashMap = new HashMap<>();
    private String adminfile = "/Users/tr/Desktop/items.bin";

    public void setUsername(String username) {
        this.username = username;
    }
    
    public void setPw(String pw) {
        this.pw = pw;
    }

    public void adduser() {
        AdminsHashMap.put(username, pw);
    }

    public boolean createfile() throws IOException {
        File file = new File(adminfile);
        return file.createNewFile();
    }

    @Override
    public boolean save() {
        try {
            ObjectOutputStream fileOutputStream = new ObjectOutputStream(new FileOutputStream(adminfile));
            fileOutputStream.writeObject(AdminsHashMap);
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
            ObjectInputStream fileInputStream = new ObjectInputStream(new FileInputStream(adminfile));
            AdminsHashMap = (HashMap<String, String>) fileInputStream.readObject();

            return true;
        } catch (FileNotFoundException ex) {
            return false;
        } catch (IOException ex) {
            return false;
        } catch (ClassNotFoundException ex) {
            return false;
        }

    }

    public boolean Login(String username, String password) throws FileNotFoundException, IOException, ClassNotFoundException {

        ObjectInputStream fileInputStream = new ObjectInputStream(new FileInputStream(adminfile));
        AdminsHashMap = (HashMap<String, String>) fileInputStream.readObject();

        for (Map.Entry<String, String> entry : AdminsHashMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (key.equals(username) && password.equals(value)) {
                return true;
            }
        }
        return false;
    }

}
