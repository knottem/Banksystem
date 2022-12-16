import Users.*;

import java.io.*;
import java.util.ArrayList;

public class Database {

    ArrayList<Customer> customers;
    ArrayList<Admin> admins;

    public Database() {
        this.customers = new ArrayList<>();
        this.admins = new ArrayList<>();
        addCustomersToDatabase();
        addAdminsToDatabase();
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
            System.out.println(customers.get(0).getName());
            System.out.println(customers.get(1).getPassword());
            System.out.println(customers.get(0).getBalance());


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
            System.out.println(admins.get(0).getName());
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("error");
            e.printStackTrace();
        }

    }
    }
