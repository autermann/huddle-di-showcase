package org.n52.huddle.ioc.guice.modules;

import org.n52.huddle.ioc.UserDAO;
import org.n52.huddle.ioc.UserFactory;
import org.n52.huddle.ioc.UserService;
import org.n52.huddle.ioc.guice.AutoLoadedModule;
import org.n52.huddle.ioc.guice.Ignore;
import org.n52.huddle.ioc.impl.UserDAOImpl;
import org.n52.huddle.ioc.impl.UserFactoryImpl;
import org.n52.huddle.ioc.impl.UserServiceImpl;

import com.google.inject.AbstractModule;

@Ignore
public class UserModule extends AbstractModule implements AutoLoadedModule {

    @Override
    protected void configure() {
        bind(UserService.class).to(UserServiceImpl.class);
        bind(UserFactory.class).to(UserFactoryImpl.class);
        bind(UserDAO.class).to(UserDAOImpl.class);
    }
}
