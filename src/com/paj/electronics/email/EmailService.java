package com.paj.electronics.email;

public class EmailService {
  private final Queue queue = new Queue();
  private final Object monitor = new Object();
  private int emailCount;
  private boolean shouldTerminate;
  private final Thread t;

  public EmailService() {
    t = new Thread(() -> {
      while (true) {
        if (shouldTerminate) {
          return;
        }

        try {
          synchronized (monitor) {
            var email = queue.get();
            email.ifPresent(this::sendEmail);
            monitor.wait();
          }
        } catch (InterruptedException e) {
          e.printStackTrace();
          return;
        }
      }
    });

    t.start();
  }

  private void sendEmail(Email email) {
    System.out.println("Sent email: " + email);
    ++emailCount;
  }

  public void sendNotificationEmail(Email email) {
    synchronized (monitor) {
      if (!shouldTerminate) {
        queue.add(email);
        monitor.notify();
      }
    }
  }

  public int getEmailCount() {
    return emailCount;
  }

  public void close() {
    try {
      shouldTerminate = true;
      synchronized (monitor) {
        monitor.notify();
      }

      t.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
