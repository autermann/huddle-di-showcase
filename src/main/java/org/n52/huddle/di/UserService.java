package org.n52.huddle.di;

public interface UserService {

    User getUser(String lastName);

    User registerUser(String firstName, String lastName);
}
