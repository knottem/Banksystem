import Client.Window;
import Users.Customer;
import Users.User;

import java.util.concurrent.CyclicBarrier;

public class Main {
    public static void main(String[] args) {
        Window window = new Window();
        window.setupLogin();
        window.setupLoginPage();
        new Database();

    }
}
