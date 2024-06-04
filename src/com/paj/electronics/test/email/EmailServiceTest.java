package com.paj.electronics.test.email;

import com.paj.electronics.domain.Client;
import com.paj.electronics.email.Email;
import com.paj.electronics.email.EmailService;
import com.paj.electronics.test.ClientFixtures;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmailServiceTest {
  private String body;
  private Client from;
  private List<Client> to;
  private static final int NUMBER_OF_EMAILS = 10;

  @BeforeEach
  public void setup() {
    from = new Client("Shop-no-reply", "shop-no-reply", null);

    to = List.of(ClientFixtures.getClient());
    body = "Order placed!";
  }

  @Test
  public void sendEmailNotificationTest() {
    EmailService emailService = new EmailService();

    for (int i = 0; i < NUMBER_OF_EMAILS; ++i) {
      emailService.sendNotificationEmail(Email.builder()
        .emailTitle("Confirmation for your order")
        .body(body + " " + i)
        .from(from)
        .to(to)
        .build());

      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    assertEquals(NUMBER_OF_EMAILS, emailService.getEmailCount());
    emailService.close();
  }
}
