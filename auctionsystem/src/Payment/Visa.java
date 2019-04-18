/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Payment;

import javax.swing.JButton;
import javax.swing.JRadioButton;

/**
 *
 * @author Dalia
 */
public class Visa {
    private int pin, ExpiryDate;
  private String      CVV;
    public Visa(int pin, int ExpiryDate, String CVV) {
        this.pin = pin;
        this.ExpiryDate = ExpiryDate;
        this.CVV = CVV;
    }
    JRadioButton Visa1, Cash1;
    
    private JButton[] buttons = new JButton[15];
     public void setPin(int pin) {
        this.pin = pin;
    }

    public void setExpiryDate(int ExpiryDate) {
        this.ExpiryDate = ExpiryDate;
    }

    public void setCVV(String CVV) {
        this.CVV = CVV;
    }

    public int getPin() {
        return pin;
    }

    public int getExpiryDate() {
        return ExpiryDate;
    }

    public String getCVV() {
        return CVV;
    }
 public void printcvv(){
        
        System.out.println(CVV);
    }
}
