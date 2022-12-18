package Users;

import java.util.ArrayList;

public class UserFactory {
    public static User getUser(UserType userType, String name, String password, ArrayList<Account> account) {
        switch (userType) {
            case CUSTOMER:
                return new Customer(name, password, account);
            case ADMIN:
                return new Admin(name, password);
            default:
                return null;
        }
    }


}
