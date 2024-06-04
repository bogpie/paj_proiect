package com.paj.electronics.exceptions;

public class EmailServiceException extends RuntimeException {
  public EmailServiceException(String message) {
    super(message);
  }

  public EmailServiceException(Throwable t) {
    super(t);
  }
}
