package manage_coffee.models;

import manage_coffee.models.repositories.ManageRepository;

import java.util.ArrayList;
import java.util.List;

public class Auth {
    private List<User> userList;
    private static Auth instance;

    private Auth() {
        userList = new ArrayList<User>();
        userList.add(new User("admin", "123456"));
    }

    public synchronized static Auth getInstance() {
        if (instance == null) {
            instance = new Auth();
        }
        return instance;
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
