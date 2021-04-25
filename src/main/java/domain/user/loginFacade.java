package domain.user;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import org.presentation.LoginController;

public class loginFacade {

    IdAndPasswords idAndPasswords = new IdAndPasswords();

    LoginController loginPage = new LoginController(idAndPasswords.getProdloginfo());

    public boolean tryLogin(String username, String password) {

        return (idAndPasswords.getProdloginfo().containsKey(username) && idAndPasswords.getProdloginfo().get(username).equals(password));
    }

}




