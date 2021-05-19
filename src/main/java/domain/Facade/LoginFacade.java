package domain.Facade;

import Persistence.PersistenceHandler;
import domain.user.User;

public class LoginFacade {

    public static User login(String username, String password) {
        return PersistenceHandler.getInstance().getLoginUserObj(username, password);
    }
    public static User addUser(User user) {
        return PersistenceHandler.getInstance().addUser(user);
    }
}
