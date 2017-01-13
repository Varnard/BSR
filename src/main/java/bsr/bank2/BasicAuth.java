package bsr.bank2;

import java.nio.charset.Charset;
import java.util.Base64;


public class BasicAuth {

    private static final String user="Janusz";
    private static final String password="bsr";

    public static boolean authorize(String auth){
        try {
            if (!auth.substring(0, 5).equals("Basic")) return false;
            else {
                String credentials = new String(Base64.getDecoder().decode(auth.substring(6)), Charset.forName("UTF-8"));
                if ((user + ":" + password).equals(credentials)) return true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public static String getCredentials(){
        return Base64.getEncoder().encodeToString((user+":"+password).getBytes());
    }
}
