package helpers;

import java.util.Random;

public class DataHelper {
    private static final Random rnd = new Random();

    private static User user;

    public static User createRandomUser() {
        if(user == null){
            String username = "USER_" + rnd.nextInt();
            String password = "PASS_" + rnd.nextInt();
            user = new User("NAME", "LASTNAME", "ADDRESS", "CITY", "STATE", "ZIP" + rnd.nextInt(), "+123456789", "SSN" + rnd.nextInt(), username, password);
        }
        return user;
    }
}


