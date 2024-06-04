package com.paj.electronics.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude = "password")
public abstract class User {
  private Address address;
  private String name;
  private String password;
}
