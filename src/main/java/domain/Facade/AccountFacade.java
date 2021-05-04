package domain.Facade;

import Persistence.PersistenceHandler;
import domain.user.Account;

public class AccountFacade {

    public Account login(String username, String password) {
        return PersistenceHandler.PersistanceHandler.getInstance().getAccount(username, password);
    }



}
