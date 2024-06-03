package service;

import exceptions.InvalidLoginException;
import exceptions.NoUserFoundException;
import exceptions.UserAlreadyExistsException;
import model.Address;
import model.user.User;
import model.user.UserType;

public interface AuthService {
    boolean login(String username, String password)
            throws NoUserFoundException, InvalidLoginException;

    void signUp(String username, String password, Address address, UserType userType)
            throws UserAlreadyExistsException;

    void resetPassword(User user, String newPassword)
            throws NoUserFoundException;
}
