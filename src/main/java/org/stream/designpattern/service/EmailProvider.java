package org.stream.designpattern.service;

import org.stream.designpattern.model.User;

public interface EmailProvider {
    String getEmail(User user);
}
