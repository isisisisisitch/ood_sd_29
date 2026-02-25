package ca.bytetube.ood._10_moviebooking;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class UserRegister {
    private Map<String, User> users;

    public UserRegister() {
        this.users = new HashMap<>();
    }

    public User registerUser(String username, String email, String phoneNumber, String password) {
        validateUserInfo(username, email, phoneNumber);

        // create new user
        String userId = generateUserId();
        User user = new User(userId, username, email, phoneNumber);
        users.put(userId, user);

        return user;
    }

    public User getUserById(String userId) {
        User user = users.get(userId);
        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }
        return user;
    }


    private void validateUserInfo(String username, String email, String phoneNumber) {
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be empty");
        }

        if (!isValidEmail(email)) {
            throw new IllegalArgumentException("Invalid email format");
        }

        if (!isValidPhoneNumber(phoneNumber)) {
            throw new IllegalArgumentException("Invalid phone number format");
        }
    }

    private boolean isValidEmail(String email) {
        return email != null && email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }

    private boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber != null && phoneNumber.matches("^\\d{10}$");
    }

    private String generateUserId() {
        return UUID.randomUUID().toString();
    }
}
