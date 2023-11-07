package org.stream.designpattern.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;


@Getter
@ToString
public class User {
    private int id;
    private String name;
    private String emailAddress;
    private boolean isVerified;
    private List<Integer> friendUserIds = new ArrayList<>();
    private LocalDateTime createdAt;

    public User(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.emailAddress = builder.emailAddress;
        this.isVerified = builder.isVerified;
        this.createdAt = builder.createdAt;
        this.friendUserIds = builder.friendUserIds;
    }

    public static Builder builder(int id, String name) {
        return new Builder(id, name);
    }

    public Optional<String> getEmailAddress() {
        return Optional.ofNullable(emailAddress);
    }

    public static class Builder {
        private int id;
        private String name;
        public String emailAddress;
        public boolean isVerified;
        public List<Integer> friendUserIds = new ArrayList<>();
        public LocalDateTime createdAt;

        public Builder(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public Builder with(Consumer<Builder> consumer) {
            consumer.accept(this);
            return this;
        }

//        public Builder withEmailAddress(String emailAddress) {
//            this.emailAddress = emailAddress;
//            return this;
//        }
//
//        public Builder withVerified(boolean isVerified) {
//            this.isVerified = isVerified;
//            return this;
//        }
//
//        public Builder withCreatedAt(LocalDateTime createdAt) {
//            this.createdAt = createdAt;
//            return this;
//        }
//
//        public Builder withFreindUserIds(List<Integer> friendUserIds) {
//            this.friendUserIds = friendUserIds;
//            return this;
//        }

        public User build() {
            return new User(this);
        }


    }

}
