package Utility;

import Accounts.Account;
import Accounts.AccountFactory;
import Accounts.AccountType;
import Database.Database;
import Users.Customer;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Utility {

    History history = new History();
    Random random = new Random();

    Database database = Database.getDatabase();

    public int inputInt(String text) {
        while (true) {
            Scanner scan;
            System.out.println(text);
            try {
                scan = new Scanner(System.in);
                return scan.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Förväntade mig ett nummer");
            } catch (NumberFormatException e) {
                System.out.println("Inte nummer");
            }
        }
    }

    public boolean repeatProgram(String text) {
        boolean repeat;
        do {
            System.out.println(text +" j/n");
            Scanner input = new Scanner(System.in);
            String yesNo = input.nextLine();
            repeat = true;
            switch (yesNo) {
                case "j" -> repeat = false;
                case "n" -> {
                    System.out.println("Hej då");
                    System.exit(0);
                    }
                default -> System.out.println("Svara med j för JA och n för NEJ");
            }
        } while (repeat);
        return false;
    }

    public void sleep(int number){
        try{
            Thread.sleep(number);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void transfer(Customer customer){
        boolean found = false;
        int value = inputInt("Hur mycket vill du överföra?");
        System.out.println("Från vilket konto?");
        for (int i = 0; i <customer.getAccounts().size() ; i++) {
            System.out.println(i+1 + ". Konto: " + customer.getAccounts().get(i).getId() + " Balance: " + customer.getAccounts().get(i).getBalance() + " kr");
        }
        int konto = inputInt("Svara med siffran som stämmer överens med Kontot") - 1;
        int number = inputInt("Till vilket konto?");
        if(customer.getAccounts().get(konto).getBalance() - value >= 0) {
            for (int i = 0; i < database.getCustomers().size(); i++) {
                for (int j = 0; j < database.getCustomers().get(i).getAccounts().size(); j++) {
                    if(database.getCustomers().get(i).getAccounts().get(j).getId() == number){
                        customer.getAccounts().get(konto).withdrawMoney(value);
                        database.getCustomers().get(i).getAccounts().get(j).depositMoney(value);
                        System.out.println(value + " kr fördes över till konto " + number);
                        history.writeToFile("Transfer " + value + " kr from Account " + customer.getAccounts().get(konto).getId() + " to Account " + number, customer);
                        found = true;
                        database.updateCustomerTextFile();
                        break;
                    }
                }
            }
            if(!found){
                System.out.println("Kontot finns ej.");
            }
        } else {
            System.out.println("Du har för lite pengar på kontot");
        }
    }

    public void deposit(Customer customer) {
        int value = inputInt("Hur mycket vill du lägga in?");
        System.out.println("Till vilket konto?");
        for (int i = 0; i <customer.getAccounts().size() ; i++) {
            System.out.println(i+1 + ". Konto: " + customer.getAccounts().get(i).getId() + " Balance: " + customer.getAccounts().get(i).getBalance() + " kr");
        }
        int konto = inputInt("Svara med siffran som stämmer överens med Kontot") - 1;
        customer.getAccounts().get(konto).depositMoney(value);
        System.out.println(value + " kr sattes in på kontot " + customer.getAccounts().get(konto).getId() + "\n");
        history.writeToFile("Deposit " + value + " kr to Account " + customer.getAccounts().get(konto).getId(), customer);
        sleep(2000);
        database.updateCustomerTextFile();
    }

    public void checkAccount(Customer customer) {
        StringBuilder accounts = new StringBuilder();
        for (int i = 0; i < customer.getAccounts().size() ; i++) {
            accounts.append("Konto: " + customer.getAccounts().get(i).getId() + " Balance: " + customer.getAccounts().get(i).getBalance() + " kr\n");
        }
        if(accounts.isEmpty()){
            System.out.println("\n" + customer.getName() + "\n");
        } else {
            System.out.println("\n" + customer.getName() + "\n" + accounts);
        }
        sleep(2000);
    }

    public void withdraw(Customer customer) {
        int value = inputInt("Hur mycket vill du ta ut?");
        System.out.println("Från vilket konto?");
        for (int i = 0; i <customer.getAccounts().size() ; i++) {
            System.out.println(i+1 + ". Konto: " + customer.getAccounts().get(i).getId() + " Balance: " + customer.getAccounts().get(i).getBalance() + " kr");
        }
        int konto = inputInt("Svara med siffran som stämmer överens med Kontot") - 1;
        if(customer.getAccounts().get(konto).getBalance() - value >= 0) {
            customer.getAccounts().get(konto).withdrawMoney(value);
            System.out.println(value + " kr togs ut från kontot\n");
            history.writeToFile("Withdraw " + value + " kr from Account " + customer.getAccounts().get(konto).getId(), customer);
        } else {
            System.out.println("Du har för lite pengar på kontot");
        }
        database.updateCustomerTextFile();
        sleep(2000);
    }

    public int createRandomNumber(){
        int number;
        boolean checkIfNumberExists;
        do {
            checkIfNumberExists = false;
            number = random.nextInt(999999) + 100000;
            for (int i = 0; i < database.getCustomers().size(); i++) {
                for (int j = 0; j < database.getCustomers().get(i).getAccounts().size(); j++) {
                    if (database.getCustomers().get(i).getAccounts().get(j).getId() == number) {
                        checkIfNumberExists = true;
                        break;
                    }
                }
            }
        } while (checkIfNumberExists);
        return number;
    }

    public void createNewAccount(Customer customer) {
        System.out.println("Vilkets sorts konto vill du skapa?");
        for (int i = 0; i < AccountType.values().length; i++) {
            System.out.println(i+1 + ". " + AccountType.values()[i]);
        }
        int number = inputInt("svara med rätt siffra") - 1;
        if(number <= AccountType.values().length) {
            customer.getAccounts().add(AccountFactory.getAccount(AccountType.values()[number]));
            int id = createRandomNumber();
            customer.getAccounts().get(customer.getAccounts().size()-1).setId(id);
            history.writeToFile("Created new " + AccountType.values()[number] + " with number: " + id , customer);
            database.updateCustomerTextFile();
        } else {
            System.out.println("felaktigt siffra");
        }
    }
}
