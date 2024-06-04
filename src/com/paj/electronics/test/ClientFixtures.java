package com.paj.electronics.test;

import com.paj.electronics.domain.user.Address;
import com.paj.electronics.domain.user.Client;

public class ClientFixtures {
    public static Client getClient() {
        return new Client("John", "1234", Address.builder()
                .city("Bucharest")
                .street("Tineretului")
                .country("Romania")
                .streetNumber("85")
                .zipCode(100000)
                .telephoneNumber("07400000000")
                .build());
    }
}
