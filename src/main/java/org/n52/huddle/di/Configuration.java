package org.n52.huddle.di;

import org.n52.huddle.di.impl.UserDAOImpl;
import org.n52.huddle.di.impl.UserFactoryImpl;
import org.n52.huddle.di.impl.UserServiceImpl;

public class Configuration {
    private static Configuration instance;

    public static Configuration getInstance() {
        return instance == null ? instance = new Configuration() : instance;
    }
    private UserDAO dao;
    private UserFactory factory;
    private UserService service;

    private Configuration() {
    }

    public UserDAO getDAO() {
        return this.dao == null ? this.dao = new UserDAOImpl() : this.dao;
    }

    public UserFactory getFactory() {
        return this.factory == null ? this.factory = new UserFactoryImpl() : this.factory;
    }

    public UserService getService() {
        return this.service == null ? this.service = new UserServiceImpl() : this.service;
    }

    public int getUserCount() {
        return 20;
    }
}
