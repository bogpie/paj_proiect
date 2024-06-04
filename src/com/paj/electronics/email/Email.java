package com.paj.electronics.email;

import com.paj.electronics.domain.user.Client;
import com.paj.electronics.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Builder
@Getter
public class Email {
    private User from;
    private List<Client> to;
    private List<Client> cc;
    private String emailTitle;
    private String body;

    @Override
    public String toString() {
        return "Email from " + from + " to " + to + " with title " + emailTitle
                + ":\nand body:\n\t" + body;
    }
}