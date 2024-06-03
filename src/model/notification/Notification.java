package model.notification;

import lombok.Builder;
import lombok.Data;
import model.user.Customer;

@Data
@Builder
public class Notification {
    private final String title;
    private final String message;
    private final Customer customer;
}
