package Users;

import Accounts.Account;

import java.util.ArrayList;

public class Customer extends User{

    ArrayList<Account> accounts;

    public Customer() {
    }

    public Customer(String name, String password, ArrayList<Account> accounts) {
        super(name, password);
        this.accounts = accounts;
    }


    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(ArrayList<Account> accounts) {
        this.accounts = accounts;
    }


}
