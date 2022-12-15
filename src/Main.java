import Client.Window;

public class Main {
    public static void main(String[] args) {
        Window window = new Window();
        window.setupLogin();
        User user1 = UserFactory.getUser(UserType.CUSTOMER);
    }
}
