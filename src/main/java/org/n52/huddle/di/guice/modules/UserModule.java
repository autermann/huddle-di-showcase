package org.n52.huddle.di.guice.modules;

import org.n52.huddle.di.UserDAO;
import org.n52.huddle.di.UserFactory;
import org.n52.huddle.di.UserService;
import org.n52.huddle.di.guice.AutoLoadedModule;
import org.n52.huddle.di.guice.Ignore;
import org.n52.huddle.di.impl.UserDAOImpl;
import org.n52.huddle.di.impl.UserFactoryImpl;
import org.n52.huddle.di.impl.UserServiceImpl;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;

@Ignore
public class UserModule extends AbstractModule implements AutoLoadedModule {

    @Override
    protected void configure() {
        bind(UserService.class).to(UserServiceImpl.class);
        bind(UserFactory.class).to(UserFactoryImpl.class);
        bind(UserDAO.class).to(UserDAOImpl.class);
    }
}
