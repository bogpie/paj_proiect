package com.paj.electronics.service.auth;

import com.paj.electronics.domain.user.Address;
import com.paj.electronics.domain.user.User;
import com.paj.electronics.domain.user.UserType;
import com.paj.electronics.exceptions.InvalidCredentialsException;
import com.paj.electronics.exceptions.UserAlreadyExistsException;
import com.paj.electronics.exceptions.UserNotFoundException;

public interface AuthService {
    boolean login(String username, String password) throws UserNotFoundException, InvalidCredentialsException;

    void signUp(String username, String password, Address address, UserType userType) throws UserAlreadyExistsException;

    void resetPassword(User user, String newPassword) throws UserNotFoundException;
}
