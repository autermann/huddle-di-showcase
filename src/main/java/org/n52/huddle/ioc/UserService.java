package org.n52.huddle.ioc;

public interface UserService {

    User getUser(String lastName);

    User registerUser(String firstName, String lastName);
}
