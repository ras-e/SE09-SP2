package domain.user;

public class UserManager {

    public static void addCompanys(String name, String cvr) {
        Companys company = new Companys(name, cvr);
    }
}
