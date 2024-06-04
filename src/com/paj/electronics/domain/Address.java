package com.paj.electronics.domain;

import lombok.*;

@Builder
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Address {
  private String country;
  private String city;
  private String street;
  private String streetNumber;
  private int zipCode;
  private String telephoneNumber;
}
