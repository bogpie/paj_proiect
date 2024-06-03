package model;

import lombok.Builder;
import lombok.Data;


/**
 * @ Data:
 * A shortcut for @ToString, @EqualsAndHashCode, @Getter
 * on all fields, @Setter on all non-final fields,
 * and @RequiredArgsConstructor
 * Address: A class that represents an address with the following fields:
 * country, city, street, streetNumber, zipCode, telephoneNumber
 */
@Builder
@Data
public class Address {
    private String country;
    private String city;
    private String street;
    private int streetNo;
    private int zipCode;
    private String telephoneNumber;

}
