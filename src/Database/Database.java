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
                double balance = Double.parseDouble(array[2]);
                customers.add((Customer) UserFactory.getUser(UserType.CUSTOMER,name, password, balance));
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
                double balance = Double.parseDouble(array[2]); //admin har 0 som balance, ska försöka ändra detta
                admins.add((Admin) UserFactory.getUser(UserType.ADMIN,name, password, balance));
            }
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
            e.printStackTrace();
        } catch (Exception e) {
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
