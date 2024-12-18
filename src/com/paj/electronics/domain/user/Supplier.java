package com.paj.electronics.domain.user;


import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Supplier extends User {
    public Supplier(String username, String password, Address address) {
        super.setAddress(address);
        super.setName(username);
        super.setPassword(password);
    }

    @Override
    public String toString() {
        return "Supplier " + "\"" + this.getName() + "\"";
    }
}
