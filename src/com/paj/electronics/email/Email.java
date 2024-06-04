package com.paj.electronics.email;

import com.paj.electronics.domain.Client;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Builder
@Getter
@ToString
public class Email {
  private Client from;
  private List<Client> to;
  private List<Client> cc;
  private String emailTitle;
  private String body;
}