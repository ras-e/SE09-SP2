package domain.users;

public class AccountManager {

    public static String cryptPassword(String password){
        return password;
    }

    public static void createAccount(String email, String password, String name){
    String[] names = name.split(" ");
    String firstName = "";
    String lastName = "";
        for (int i = 0; i < names.length; i++){
            if(names[i].equals(" ")){
                continue;
            }
            if(firstName.equals("")){
                firstName = names[i];
            }else{
                lastName += i == names.length-1 ? names[i] : names[i] + " ";
            }
        }
        User user = new User(email, firstName, lastName);

    }
    public static void checkLogin(String email, String password){
        System.out.println(email + " " +password);
    }
}
