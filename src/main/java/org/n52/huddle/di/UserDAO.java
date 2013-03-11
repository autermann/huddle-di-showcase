package org.n52.huddle.di;

public interface UserDAO extends BasicDAO<User> {
    User getByLastName(String lastName);
}
