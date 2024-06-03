package model;

import model.user.User;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Vault {
    private static Vault INSTANCE;

    private final HashMap<String, String> credentials;

    private Vault() {
        credentials = new HashMap<>();
    }

    public static Vault getInstance() {
        if (null == INSTANCE) {
            INSTANCE = new Vault();
        }

        return INSTANCE;
    }

    public void store(User user, String newPassword) {
        boolean isSamePassword = newPassword == null || newPassword.equals(user.getPassword());
        credentials.put(
                user.getUsername(),
                isSamePassword ?
                        user.getPassword() :
                        newPassword
        );
    }

    public Map<String, String> getCredentials() {
        return Collections.unmodifiableMap(credentials);
    }
}
