package org.stream.advenced.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Setter
@Getter
@ToString
@Accessors(chain = true)
public class User {
    private int id;
    private String name;
    private String emailAddress;
    private boolean isVerified;
    private List<Integer> friendUserIds;
    private LocalDateTime createdAt;

    public Optional<String> getEmailAddress() {
        return Optional.ofNullable(emailAddress);
    }

}
