/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Payment;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dalia
 */
public class WithdrawThread extends Thread {

    BankAccount account;
    public int amount;

    public WithdrawThread(BankAccount b, int ammount) {
        this.account = b;
        this.amount = ammount;
    }

    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                this.account.withdraw(i, amount);

                sleep(10);
            }
        } catch (InterruptedException ex) {
            System.out.println(ex);
        } catch (InsufficientFundsException ex) {
            System.out.println(ex);
        }
    }

}
