package org.example.entities;

import java.util.HashMap;
import java.util.Map;

public class UserManagerImpl implements UserManager {
    Map<Integer, User> users = new HashMap<>();

    public User getUser(Integer id) {
        User user = users.get(id);
        if(user == null) {
            users.put(id, new User(id));
        }
        return users.get(id);
    }
}
