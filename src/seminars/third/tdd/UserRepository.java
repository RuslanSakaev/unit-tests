package seminars.third.tdd;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UserRepository {
    public List<User> data = new ArrayList<>();

    public void addUser(User user) {
        if (user.isAuthenticate) {
            data.add(user);
        }
    }

    public boolean findByName(String username) {
        for (User user : data) {
            if (user.name.equals(username)) {
                return true;
            }
        }
        return false;
    }

    public void logOutNonAdmins() {
        Iterator<User> iterator = data.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            if (!user.isAdmin()) {
                user.logOut();
                iterator.remove();
            }
        }
    }
}