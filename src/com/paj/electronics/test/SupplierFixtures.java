package com.paj.electronics.test;

import com.paj.electronics.domain.user.Address;
import com.paj.electronics.domain.user.Supplier;

public class SupplierFixtures {
    public static Supplier getSupplier() {
        return new Supplier("Ionel", "123", Address.builder()
                .city("Bucharest")
                .street("Tineretului")
                .streetNumber("86")
                .zipCode(100001)
                .telephoneNumber("07400000100")
                .build());
    }
}
