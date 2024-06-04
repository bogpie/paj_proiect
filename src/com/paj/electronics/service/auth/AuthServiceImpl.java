package com.paj.electronics.service.auth;

import com.paj.electronics.domain.*;
import com.paj.electronics.domain.user.*;
import com.paj.electronics.exceptions.InvalidCredentialsException;
import com.paj.electronics.exceptions.UserAlreadyExistsException;
import com.paj.electronics.exceptions.UserNotFoundException;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class AuthServiceImpl implements AuthService {
    private UserCredentials userCredentials;
    private Shop shop;

    @Override
    public boolean login(String username, String password) throws UserNotFoundException, InvalidCredentialsException {
        Optional<String> currentUserCredentials = Optional.ofNullable(userCredentials.getCredentials().get(username));
        String currentUserPassword = currentUserCredentials.orElseThrow(() -> new UserNotFoundException("User not found"));

        if (!password.equals(currentUserPassword)) {
            throw new InvalidCredentialsException("Invalid credentials");
        }

        return true;
    }

    @Override
    public void signUp(String username, String password, Address address, UserType userType) throws UserAlreadyExistsException {
        if (userCredentials.getCredentials().get(username) != null) {
            throw new UserAlreadyExistsException("User already exists");
        }

        switch (userType) {
            case CLIENT: {
                Client client = new Client(username, password, address);
                shop.addClient(client);
                userCredentials.storeUserCredentials(client, null);
                break;
            }

            case SUPPLIER: {
                Supplier supplier = new Supplier(username, password, address);
                shop.addSupplier(supplier);
                userCredentials.storeUserCredentials(supplier, null);
                break;
            }

            default:
                break;
        }
    }

    @Override
    public void resetPassword(User user, String newPassword) throws UserNotFoundException {
        if (!userCredentials.getCredentials().containsKey(user.getName())) {
            throw new UserNotFoundException("User not found");
        }

        user.setPassword(newPassword);
        userCredentials.storeUserCredentials(user, newPassword);
    }
}
