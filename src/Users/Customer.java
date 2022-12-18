package Users;

import java.util.ArrayList;

public class Customer extends User{

    double balance;
    ArrayList<Account> account;

    public Customer() {
    }

    public Customer(String name, String password, ArrayList<Account> account) {
        super(name, password);
        this.account = account;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void withdrawMoney(double amount) {
        balance -= amount;
    }
    public void depositMoney (double amount) {
        balance += amount;
    }

    public ArrayList<Account> getAccount() {
        return account;
    }

    public void setAccount(ArrayList<Account> account) {
        this.account = account;
    }

    public void transferToAccount (double amount, int fromAccount, int toAccount) {

    }
    public void createNewAccount() {

    }

}
