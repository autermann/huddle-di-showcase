package org.n52.huddle.di;

public interface User extends BaseEntity<User> {
    String getLastName();
    User setLastName(String lastName);
    String getFirstName();
    User setFirstName(String firstName);
}
