package org.stream.designpattern.service;

import org.stream.designpattern.model.User;

public class VerifyYourEmailAddressEmailProvider implements EmailProvider {
    @Override
    public String getEmail(User user) {
        return "'Verify Your Email Address' email  for " + user.getEmailAddress();
    }
}
