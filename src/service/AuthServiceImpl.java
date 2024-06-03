package service;

import exceptions.InvalidLoginException;
import exceptions.NoUserFoundException;
import exceptions.UserAlreadyExistsException;
import model.Shop;
import model.Vault;
import model.user.Customer;
import model.user.CustomerType;
import model.user.Supplier;
import model.user.User;
import org.apache.log4j.Logger;

import java.util.Optional;

import static model.user.UserType.CUSTOMER;

public class AuthServiceImpl implements AuthService {
    private Vault vault;
    private Shop shop;

    @Override
    public boolean login(String username, String password)
            throws NoUserFoundException, InvalidLoginException {
        Optional<String> actualPasswordOptional = Optional.ofNullable(
                vault.getCredentials().get(username)
        );

        if (actualPasswordOptional.isEmpty()) {
            throw new NoUserFoundException(
                    "User " + username + " not found"
            );
        }

        String actualPassword = actualPasswordOptional.get();
        if (!password.equals(actualPassword)) {
            throw new InvalidLoginException(
                    "Password for user " + username + " is invalid"
            );
        }

        Logger.getLogger(AuthServiceImpl.class).info("User " + username + " logged in");

        return true;
    }

    @Override
    public void signUp(User tmpUser) throws UserAlreadyExistsException {
        if (vault.getCredentials().get(tmpUser.getName()) == null) {
            throw new UserAlreadyExistsException(
                    "User " + tmpUser.getName() + " already exists"
            );
        }

        switch (tmpUser.getType()) {
            case CUSTOMER -> {
                Customer customer = (Customer) tmpUser;

            }
            case SUPPLIER -> {
                 Supplier supplier = (Supplier) tmpUser;
            }
        }
    }

    @Override
    public void resetPassword(User user, String newPassword)
            throws NoUserFoundException {

    }
}
