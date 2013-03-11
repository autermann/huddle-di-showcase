package org.n52.huddle.ioc.impl;

import org.n52.huddle.ioc.User;
import org.n52.huddle.ioc.UserFactory;
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
