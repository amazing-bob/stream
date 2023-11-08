package org.stream.designpattern.service;

import org.stream.designpattern.model.User;

public class InternalUserService extends AbstractUserService{
    @Override
    protected boolean validateUser(User user) {
        System.out.println("Validating internal user " + user.getName());
        return user.getName() != null;
    }

    @Override
    protected void writeToDB(User user) {
        System.out.println("Writing to " + user.getName() + " to internal DB");
    }
}
