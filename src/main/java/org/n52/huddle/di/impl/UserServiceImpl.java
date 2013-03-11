package org.n52.huddle.di.impl;

import static com.google.common.base.Preconditions.checkNotNull;

import org.n52.huddle.di.User;
import org.n52.huddle.di.UserDAO;
import org.n52.huddle.di.UserFactory;
import org.n52.huddle.di.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class UserServiceImpl implements UserService {
    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
    private UserFactory factory;
    private UserDAO dao;

    @Inject
    public UserServiceImpl(UserFactory factory, UserDAO dao) {
        checkNotNull(factory, "factory may not be null");
        checkNotNull(dao, "dao may not be null");
        this.dao = dao;
        this.factory = factory;
    }

    @Override
    public User registerUser(String firstName, String lastName) {
        log.trace("UserServiceImpl.registerUser({}, {})", firstName, lastName);
        User user = create(firstName, lastName);
        dao.save(user);
        return user;
    }

    protected User create(String firstName, String lastName) {
        checkNotNull(firstName, "firstName");
        checkNotNull(lastName, "lastName");
        return factory.create().setFirstName(firstName).setLastName(lastName);
    }

    @Override
    public User getUser(String lastName) {
        return dao.getByLastName(lastName);
    }

}
