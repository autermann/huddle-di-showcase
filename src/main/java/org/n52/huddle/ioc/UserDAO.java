package org.n52.huddle.ioc;

public interface UserDAO extends BasicDAO<User> {
    User getByLastName(String lastName);
}
