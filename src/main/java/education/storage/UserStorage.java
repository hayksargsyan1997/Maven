package education.storage;

import education.exception.UserNotFoundException;
import education.model.User;

import java.util.HashMap;
import java.util.Map;


public class UserStorage {
    private Map<String, User> userMap = new HashMap<>();

    public void add(User user) {
        userMap.put(user.getEmail(),user);

    }
        public User getByEmail (String email) throws UserNotFoundException {
           if (userMap.containsKey(email)){
               return userMap.get(email);
           }
            throw new UserNotFoundException("Էլ․փոստը գոյություն չունի" + email);
        }

    }
