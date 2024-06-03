package model.user;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import model.Address;

@Data
@Builder
@EqualsAndHashCode(exclude = {"password"})
@ToString(exclude = {"password"})
public class User {
    private final String name;
    private final String password;
    private final Address address;
    private UserType type;
}
