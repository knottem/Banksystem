public class UserFactory {
    public static User getUser(UserType userType) {
        switch (userType) {
            case CONSUMER:
                return new Customer();
            case ADMIN:
                return new Admin();
            default:
                return null;
        }
    }
}


