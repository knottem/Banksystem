package Users;

public class Customer extends User{
    double balance;

    public Customer() {
    }

    public Customer(String name, String password, double balance) {
        super(name, password);
        this.balance = balance;
    }

    public void withdrawMoney(double amount) {

    }
    public void depositMoney (double amount) {

    }
    public void transferToAccount (double amount, int fromAccount, int toAccount) {

    }
    public void createNewAccount() {

    }

}
