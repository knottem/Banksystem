package Utility;

import Database.Database;
import Users.Customer;

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

//    public void transfer(Customer customer, ArrayList<Customer> customers){
//        boolean found = false;
//        Scanner scan = new Scanner(System.in);
//        int value = inputInt("Hur mycket vill du överföra?");
//        if(customer.getBalance() - value >= 0) {
//            int account = inputInt("Till vilket konto?");
//            for (int i = 0; i < customers.size(); i++) {
//                if (customers.get(i).getAccount() == account) {
//                    found = true;
//                    while (true) {
//                        System.out.println("Stämmer detta konto: " + account + " Svara med J för ja eller N för nej");
//                        String answer = scan.nextLine();
//                        if (answer.equalsIgnoreCase("j")) {
//                            //Måste lägga till att kolla så det inte blir minus tal efter man withdrawar
//                            customer.withdrawMoney(value);
//                            customers.get(i).depositMoney(value);
//                            break;
//                        }
//                    }
//                }
//            }
//            if(!found){
//                System.out.println("felaktigt konto");
//            }
//        } else {
//            System.out.println("Du har för lite pengar på kontot");
//        }
//
//    }

    public void deposit(Customer customer) {
        int value = inputInt("Hur mycket vill du lägga in?");
        System.out.println("Till vilket konto?");
        for (int i = 0; i <customer.getAccount().size() ; i++) {
            System.out.println(i+1 + ". Konto: " + customer.getAccount().get(i).getId() + " Balance: " + customer.getAccount().get(i).getBalance() + " kr");
        }
        int konto = inputInt("Svara med siffran som stämmer överens med Kontot") + 1;
        customer.getAccount().get(konto).depositMoney(value);
        System.out.println(value + " kr sattes in på kontot " + customer.getAccount().get(konto) + "\n");
        history.writeToFile("Deposit " + value + " kr to Account " + customer.getAccount().get(konto).getId(), customer);
        sleep(2000);
    }

    public void checkAccount(Customer customer) {
        StringBuilder accounts = new StringBuilder();
        for (int i = 0; i < customer.getAccount().size() ; i++) {
            accounts.append("Konto: " + customer.getAccount().get(i).getId() + " Balance: " + customer.getAccount().get(i).getBalance() + " kr\n");
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
        for (int i = 0; i <customer.getAccount().size() ; i++) {
            System.out.println(i+1 + ". Konto: " + customer.getAccount().get(i).getId() + " Balance: " + customer.getAccount().get(i).getBalance() + " kr");
        }
        int konto = inputInt("Svara med siffran som stämmer överens med Kontot") + 1;
        if(customer.getAccount().get(konto).getBalance() - value >= 0) {
            customer.getAccount().get(konto).withdrawMoney(value);
            System.out.println(value + " kr togs ut från kontot\n");
            history.writeToFile("Withdraw " + value + " kr from Account " + customer.getAccount().get(konto).getId(), customer);
        } else {
            System.out.println("Du har för lite pengar på kontot");
        }
        sleep(2000);
    }

    public int createRandomNumber(){
        int number;
        boolean checkIfNumberExists;
        do {
            checkIfNumberExists = false;
            number = random.nextInt(999999) + 100000;
            for (int i = 0; i < database.getCustomers().size(); i++) {
                for (int j = 0; j < database.getCustomers().get(i).getAccount().size(); j++) {
                    if (database.getCustomers().get(i).getAccount().get(j).getId() == number) {
                        checkIfNumberExists = true;
                        break;
                    }
                }
            }
        } while (checkIfNumberExists);
        return number;
    }
}
