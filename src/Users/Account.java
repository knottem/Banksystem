package Users;

public class Account {

    private String name;
    private int id;
    private double balance;

    public Account() {
    }

    public Account(String name, int id, double balance) {
        this.name = name;
        this.id = id;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
