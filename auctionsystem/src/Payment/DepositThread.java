/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Payment;

import static java.lang.Thread.sleep;

/**
 *
 * @author Dalia
 */
public class DepositThread extends Thread {

    BankAccount bk;
    int ammount;

    public DepositThread(BankAccount b, int ammount) {
        this.bk = b;
        this.ammount = ammount;
    }

    public void run() {
        try {
            
            for (int i = 0; i < 10; i++) {
                this.bk.deposit(i, ammount);

                sleep(10);
            }
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
    }

}
