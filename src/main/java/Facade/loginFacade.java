package Facade;

import domain.user.IdAndPasswords;
import org.presentation.LoginController;


public class loginFacade {


    IdAndPasswords idAndPasswords = new IdAndPasswords();

    LoginController loginPage = new LoginController(idAndPasswords.getProdloginfo());

    public static boolean tryLogin(String username, String password) {

        return (idAndPasswords.getProdloginfo().containsKey(username) && idAndPasswords.getProdloginfo().get(username).equals(password));
    }
}