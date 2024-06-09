package manage_coffee.models;

import java.util.ArrayList;
import java.util.List;

public class Auth {
    private List<User> userList;

    public Auth() {
        userList = new ArrayList<User>();
        userList.add(new User("admin", "123456"));
    }

    public boolean authUser(String username, String password) {
        for (User user : userList) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}
