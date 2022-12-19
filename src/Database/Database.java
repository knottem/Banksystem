package Database;

import Users.*;

import java.io.*;
import java.util.ArrayList;

//Använder singleton
public class Database {
    private static Database instance;
    ArrayList<Customer> customers;
    ArrayList<Admin> admins;

    private Database() {
        this.customers = new ArrayList<>();
        this.admins = new ArrayList<>();
        addCustomersToDatabase();
        addAdminsToDatabase();
    }

    //Databasen skapas om den inte redan finns, annars returneras den som redan finns
    public static Database getDatabase() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    //läser från customers.txt och skapar en kund och lägger till i listan
    public void addCustomersToDatabase() {
        File customersFile = new File("resources/customers.txt");
        try (BufferedReader reader = new BufferedReader(new FileReader(customersFile))){
            String line;
            while((line = reader.readLine())!= null){
                String[] array = line.split("/");
                String name = array[0];
                String password = array[1];
                ArrayList<Account> account = new ArrayList<>();
                for (int i = 2; i < array.length; i+=2) {
                    Account temp = new Account();
                    temp.setId(Integer.parseInt(array[i]));
                    temp.setBalance(Double.parseDouble(array[i+1]));
                    account.add(temp);
                }
                customers.add((Customer) UserFactory.getUser(UserType.CUSTOMER,name, password, account));
            }
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
            e.printStackTrace();
        }
        catch (Exception e) {
            System.out.println("error");
            e.printStackTrace();
        }
    }

    //läser från admin.txt och skapar en admin och lägger till i listan
    public void addAdminsToDatabase() {
        File adminsFile = new File("resources/admins.txt");
        try (BufferedReader reader = new BufferedReader(new FileReader(adminsFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] array = line.split("/");
                String name = array[0];
                String password = array[1];
                //admin har 0 som accounts, ska försöka ändra detta
                ArrayList<Account> account2 = new ArrayList<>();
                admins.add((Admin) UserFactory.getUser(UserType.ADMIN,name, password, account2));
            }
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("error");
            e.printStackTrace();
        }

    }
    public void updateCustomerTextFile(){
        try(PrintWriter out = new PrintWriter(("resources/customers.txt"))) {
            for (Customer element : customers){
                out.print(element.getName() + "/");
                out.print(element.getPassword() + "/");

                for (int i = 0; i < element.getAccount().size(); i++) {
                    ArrayList <Account> accountArrayList = element.getAccount();
                    Account temp = accountArrayList.get(i);
                    out.print(temp.getId()+ "/");
                    if (i < element.getAccount().size()-1) {
                        out.print(temp.getBalance() + "/");
                    }else {
                        out.print(temp.getBalance() + "\n");
                    }

                }

            }
            out.close();
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
            e.printStackTrace();
        } catch (Exception e){
            System.out.println("error");
            e.printStackTrace();
        }
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public ArrayList<Admin> getAdmins() {
        return admins;
    }
}
