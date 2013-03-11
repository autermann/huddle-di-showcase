package org.n52.huddle.di.guice.modules;

import org.n52.huddle.di.UserDAO;
import org.n52.huddle.di.UserFactory;
import org.n52.huddle.di.UserService;
import org.n52.huddle.di.guice.ReflectionsModule;

public class ReflectionsUserModule extends ReflectionsModule {
    @Override
    protected void configure() {
        findAndBind(UserFactory.class);
        findAndBind(UserService.class);
        findAndBind(UserDAO.class);
    }
}
