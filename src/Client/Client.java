package Client;

import utility.Utility;

import java.time.LocalDate;

public class Client {

    LocalDate today = LocalDate.now();
    Utility utility = new Utility();
    //FAQ faq = new FAQ();
    boolean repeat = false;

    void Program() {

        System.out.println("\nVälkommen till Bank Systemet");
        System.out.println("Dagens Datum: " + today + "\n");

        do {
            boolean startLoop = true;
            while (startLoop) {
                int answer = utility.inputInt("""
                        Vad vill du göra?
                        1. Logga in
                        2. Skapa Nytt Konto
                        3. FAQ
                        4. Avsluta Programmet""");
                switch (answer) {
                    case (1) -> {
                    }
                    case (2) -> {
                    }
                    case (3) -> {
                      //  faq.print();
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

    public static void main(String[] args) {
        Client client = new Client();
        client.Program();
    }
}
