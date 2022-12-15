import java.io.*;
import java.util.ArrayList;

public class Database {

    ArrayList<Customer> customers;
    ArrayList<Admin> admins;

    public Database() {
        this.customers = new ArrayList<>();
        this.admins = new ArrayList<>();
        addCustomersToDatabase();
    }

    public void addCustomersToDatabase() {
        File customersFile = new File("src/customers.txt");
        try (BufferedReader reader = new BufferedReader(new FileReader(customersFile))){
            String firstLine;
            while((firstLine = reader.readLine())!= null){
                String[] array = firstLine.split("/");
                String name = array[0];
                String password = array[1];
                double balance = Double.parseDouble(array[2]);
                customers.add(new Customer(name, password, balance));
            }
            System.out.println(customers.get(0).getName());

        } catch (FileNotFoundException e) {
            System.out.println("file not found");
            e.printStackTrace();
        }
        catch (Exception e) {
            System.out.println("error");
            e.printStackTrace();
        }
    }
    public void addAdminsToDatabase() {
        File adminsFile = new File("src/admins.txt");
    }


}
