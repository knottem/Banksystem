package Users;

import java.util.ArrayList;

public class Customer extends User{

    double balance;
    ArrayList<Account> accounts;

    public Customer() {
    }

    public Customer(String name, String password, ArrayList<Account> accounts) {
        super(name, password);
        this.accounts = accounts;
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

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(ArrayList<Account> accounts) {
        this.accounts = accounts;
    }

    public void transferToAccount (double amount, int fromAccount, int toAccount) {

    }
    public void createNewAccount() {

    }

}
