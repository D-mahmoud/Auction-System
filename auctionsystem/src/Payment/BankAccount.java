package Payment;

public class BankAccount {

    protected int accountbalance;

    

    public BankAccount() {
        accountbalance = 1000;
    }
    public int getAccountbalance() {
        return accountbalance;
    }

    public synchronized void deposit(int i, int value) throws InterruptedException {

        int newbalance = accountbalance + value;
        Thread.sleep(20);

        accountbalance = newbalance;

    }

    public synchronized void withdraw(int i, int amount) throws InsufficientFundsException, InterruptedException {
        if (amount <= accountbalance) {
            accountbalance -= amount;
            Thread.sleep(20);
        } else {
            double needs = amount - accountbalance;
            throw new InsufficientFundsException(needs);
        }
    }
}
