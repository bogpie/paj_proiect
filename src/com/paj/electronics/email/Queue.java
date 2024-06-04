package com.paj.electronics.email;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Queue {
  private final List<Email> emailList;

  public Queue() {
    emailList = new ArrayList<>();
  }

  public Optional<Email> get() {
    if (!emailList.isEmpty()) {
      return Optional.ofNullable(emailList.remove(emailList.size() - 1));
    }

    return Optional.empty();
  }

  public void add(Email email) {
    emailList.add(email);
  }
}
