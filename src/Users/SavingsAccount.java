package Users;

public class SavingsAccount extends Account{

    public SavingsAccount() {
    }

    public SavingsAccount(String name, int id, double balance) {
        super(name, id, balance);
    }

    //Overrideade metoder ifall vi vill ha speciella funktioner för olika konton
    @Override
    public void withdrawMoney(double amount) {
        super.withdrawMoney(amount);
    }

    @Override
    public void depositMoney(double amount) {
        super.depositMoney(amount);
    }
}
