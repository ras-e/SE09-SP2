package domain.user;

import java.util.HashMap;

public class IdAndPasswords {

    HashMap<String, String> Prodloginfo = new HashMap<String,String>();

    public IdAndPasswords() {
        Prodloginfo.put("SomeUserName1", "SomePassword1");
        Prodloginfo.put("SomeUserName2", "SomePassword2");
        Prodloginfo.put("SomeUserName3", "SomePassword3");
        Prodloginfo.put("SomeUserName3", "SomePassword3");
    }

    public HashMap<String, String> getProdloginfo() {
        return Prodloginfo;
    }


}
