package Client;

import Database.Database;
import Users.Customer;
import Utility.Utility;

import java.time.LocalDate;
import java.util.Scanner;

public class Client {

    LocalDate today = LocalDate.now();
    Utility utility = new Utility();
    FAQ faq = new FAQ();
    boolean repeat = false;

    Database database = Database.getDatabase();

    void Program() {

        System.out.println("\nVälkommen till Bank Systemet");
        System.out.println("Dagens Datum: " + today + "\n");

        do {
            boolean startLoop = true;
            while (startLoop) {
                int answer = utility.inputInt("""
                        Vad vill du göra?
                        1. Logga in
                        2. Skapa ny användare
                        3. FAQ
                        4. Avsluta Programmet""");
                switch (answer) {
                    case (1) -> {
                        System.out.println("\nSkriv in användarnamn:");
                        Scanner scan = new Scanner(System.in);
                        String name = scan.nextLine();
                        boolean found = false;
                        for (int i = 0; i < database.getCustomers().size() ; i++) {
                            if(name.equalsIgnoreCase(database.getCustomers().get(i).getName())){
                                System.out.println("Skriv in lösenord:");
                                String password = scan.nextLine();
                                found = true;
                                if(password.equals(database.getCustomers().get(i).getPassword())){
                                    login(database.getCustomers().get(i));
                                }
                            }
                        }
                        if(!found){
                            System.out.println("Användaren hittades inte\n");
                        }
                    }
                    case (2) -> {
                    }
                    case (3) -> {
                        faq.readingFAQ();
                        utility.sleep(1000);
                        startLoop = false;
                    }
                    case (4) -> System.exit(0);

                    default -> System.out.println("Felaktigt nummer");
                }
            }
            repeat = utility.repeatProgram("\nKör igen?");
        }while (!repeat);
    }

    private void login (Customer customer){
        boolean startLoop = true;
        do {
            int answer = utility.inputInt("Välkommen " + customer.getName() +
                    "\n1. Överföra pengar\n2. Sätta in pengar\n3. Ta ut pengar\n4. Kolla dina konton\n5. Logga ut");
                switch (answer) {
                    //case (1) -> utility.transfer(customer, database.getCustomers());
                    case (2) -> utility.deposit(customer);
                    case (3) -> utility.withdraw(customer);
                    case (4) -> utility.checkAccount(customer);
                    case (5) -> startLoop = false;
                    default -> System.out.println("Felaktigt nummer");
                }
            }while(startLoop);
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.Program();
    }
}
