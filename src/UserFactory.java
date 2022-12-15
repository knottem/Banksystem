public class UserFactory {
    public static User getUser(UserType userType) {
        switch (userType) {
            case CUSTOMER:
                return new Customer();
            case ADMIN:
                return new Admin();
            default:
                return null;
        }
    }
}


