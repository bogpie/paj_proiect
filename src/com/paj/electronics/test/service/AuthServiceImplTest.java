package com.paj.electronics.test.service;

import com.paj.electronics.domain.*;
import com.paj.electronics.domain.user.Client;
import com.paj.electronics.domain.user.Supplier;
import com.paj.electronics.domain.user.UserType;
import com.paj.electronics.exceptions.InvalidCredentialsException;
import com.paj.electronics.exceptions.UserAlreadyExistsException;
import com.paj.electronics.exceptions.UserNotFoundException;
import com.paj.electronics.service.auth.AuthService;
import com.paj.electronics.service.auth.AuthServiceImpl;
import com.paj.electronics.test.AddressFixtures;
import com.paj.electronics.test.ClientFixtures;
import com.paj.electronics.test.SupplierFixtures;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AuthServiceImplTest {
    private static final String INVALID_CLIENT = "Invalid client";
    private AuthService authService;
    Client client;

    @BeforeEach
    public void setUp() {
        Shop shop = new Shop();
        UserCredentials userCredentials = UserCredentials.getInstance();
        authService = new AuthServiceImpl(userCredentials, shop);
        client = ClientFixtures.getClient();
        shop.addClient(client);
        Supplier supplier = SupplierFixtures.getSupplier();
        shop.addSupplier(supplier);
        userCredentials.storeUserCredentials(client);
        userCredentials.storeUserCredentials(supplier);
    }

    @Test
    @SneakyThrows
    public void testLogin_Success() {
        assertTrue(authService.login("John", "1234"));
        assertTrue(authService.login("Ionel", "123"));
    }

    @Test
    @SneakyThrows
    public void testLogin_Failed() {
        Exception exception = assertThrows(
                InvalidCredentialsException.class,
                () -> authService.login("John", "124")
        );
        assertEquals("Invalid credentials", exception.getMessage());
        exception = assertThrows(InvalidCredentialsException.class, () -> authService.login("Ionel", "122"));
        assertEquals("Invalid credentials", exception.getMessage());
    }

    @Test
    @SneakyThrows
    public void testSingUp_Client() {
        authService.signUp("Marcel", "321", AddressFixtures.getAddress(), UserType.CLIENT);
        assertTrue(authService.login("Marcel", "321"));
    }

    @Test
    @SneakyThrows
    public void testSingUp_ClientExists() {
        Exception exception = assertThrows(UserAlreadyExistsException.class, () -> authService.signUp(
                "John", "321", AddressFixtures.getAddress(), UserType.CLIENT)
        );
        assertEquals("User already exists", exception.getMessage());
    }

    @Test
    @SneakyThrows
    public void testSingUp_Supplier() {
        authService.signUp("Bob", "321", AddressFixtures.getAddress(), UserType.CLIENT);
        assertTrue(authService.login("Bob", "321"));
    }

    @Test
    @SneakyThrows
    public void testSingUp_SupplierExists() {
        Exception exception = assertThrows(UserAlreadyExistsException.class,
                () -> authService.signUp("Bob", "321", AddressFixtures.getAddress(), UserType.CLIENT)
        );
        assertEquals("User already exists", exception.getMessage());
    }

    @Test
    @SneakyThrows
    public void resetPasswordTest() {
        authService.resetPassword(client, "20");
        assertTrue(authService.login("John", "20"));
    }

    @Test
    @SneakyThrows
    public void resetPasswordTest_ClientNotFound() {
        client.setName(INVALID_CLIENT);
        Exception exception = assertThrows(UserNotFoundException.class, () -> authService.resetPassword(client, "20"));
        assertEquals("User not found", exception.getMessage());
    }
}
