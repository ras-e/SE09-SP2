package domain.Facade;

import Persistence.PersistenceHandler;
import domain.user.Account;

public class AccountFacade {

    public static Account login(String username, String password) {
        return PersistenceHandler.getInstance().getAccountobj(username, password);
    }



}
