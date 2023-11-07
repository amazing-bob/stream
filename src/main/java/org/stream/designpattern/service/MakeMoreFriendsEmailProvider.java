package org.stream.designpattern.service;

import org.stream.designpattern.model.User;

public class MakeMoreFriendsEmailProvider implements EmailProvider {
    @Override
    public String getEmail(User user) {
        return "'Make More Friends' email for " + user.getEmailAddress();
    }
}
