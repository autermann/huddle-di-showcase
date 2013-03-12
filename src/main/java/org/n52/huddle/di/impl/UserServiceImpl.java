package org.n52.huddle.di.impl;

import static com.google.common.base.Preconditions.checkNotNull;

import org.n52.huddle.di.Configuration;
import org.n52.huddle.di.User;
import org.n52.huddle.di.UserDAO;
import org.n52.huddle.di.UserFactory;
import org.n52.huddle.di.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserServiceImpl implements UserService {
    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
    private UserFactory factory;
    private UserDAO dao;

    public UserServiceImpl() {
        this.dao = Configuration.getInstance().getDAO();
        this.factory = Configuration.getInstance().getFactory();
    }

    @Override
    public User registerUser(String firstName, String lastName) {
        log.trace("UserServiceImpl.registerUser({}, {})", firstName, lastName);
        User user = create(firstName, lastName);
        getDao().save(user);
        return user;
    }

    protected User create(String firstName, String lastName) {
        checkNotNull(firstName, "firstName");
        checkNotNull(lastName, "lastName");
        return getFactory().create().setFirstName(firstName).setLastName(lastName);
    }

    @Override
    public User getUser(String lastName) {
        return getDao().getByLastName(lastName);
    }

    protected UserFactory getFactory() {
        return factory;
    }

    protected UserDAO getDao() {
        return dao;
    }

}
