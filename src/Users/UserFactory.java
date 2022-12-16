package Users;

public class UserFactory {
    public static User getUser(UserType userType, String name, String password, double balance) {
        switch (userType) {
            case CUSTOMER:
                return new Customer(name, password, balance);
            case ADMIN:
                return new Admin(name, password);
            default:
                return null;
        }
    }


}
