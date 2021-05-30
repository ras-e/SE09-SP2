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
    public static User delUser(User user) {
        return PersistenceHandler.getInstance().deleteUser(user);
    }


    public static String addbusiness(String business) {
        return PersistenceHandler.getInstance().addbusiness(business);
    }

    public static String addprogramkategori(String kategori) {
        return PersistenceHandler.getInstance().addprogramkategori(kategori);
    }
    public static String addprogram(String name) {
        return PersistenceHandler.getInstance().addprogram(name);
    }

    public static void addKredittering(){}

    public static void deleKredittering(){}

    public static void getProgramObject(String name){

    }

    public static String addPerson(){
        return "";
    }

    public static String addKreditering(){
        return "";
    }
}
