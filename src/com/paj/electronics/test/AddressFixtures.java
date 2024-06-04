package com.paj.electronics.test;

import com.paj.electronics.domain.Address;

public class AddressFixtures {
  public static Address getAddress() {
    return Address.builder()
        .city("Bucharest")
        .street("Tineretului")
        .streetNumber("88")
        .zipCode(100003)
        .telephoneNumber("07400000002")
        .build();
  }
}
