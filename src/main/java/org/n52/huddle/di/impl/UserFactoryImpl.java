package org.n52.huddle.di.impl;

import org.n52.huddle.di.User;
import org.n52.huddle.di.UserFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserFactoryImpl implements UserFactory {
    private static final Logger log = LoggerFactory.getLogger(UserFactoryImpl.class);
    @Override
    public User create() {
        log.trace("UserFactoryImpl.create()");
        return new UserImpl();
    }
}
