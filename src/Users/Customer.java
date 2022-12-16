package Users;

public class Customer extends User{
    double balance;

    public Customer() {
    }

    public Customer(String name, String password, double balance) {
        super(name, password);
        this.balance = balance;
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
    public void transferToAccount (double amount, int fromAccount, int toAccount) {

    }
    public void createNewAccount() {

    }

}
