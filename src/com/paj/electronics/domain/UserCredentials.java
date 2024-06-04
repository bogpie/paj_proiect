package com.paj.electronics.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class UserCredentials {
  private static UserCredentials INSTANCE;

  private final HashMap<String, String> credentials;

  private UserCredentials() {
    credentials = new HashMap<>();
  }

  public static UserCredentials getInstance() {
    if (null == INSTANCE) {
      INSTANCE = new UserCredentials();
    }

    return INSTANCE;
  }

  public void storeUserCredentials(User user, String newPassword) {
    credentials.put(user.getName(), null == newPassword ? user.getPassword() : newPassword);
  }

  public Map<String, String> getCredentials() {
    return Collections.unmodifiableMap(credentials);
  }
}
