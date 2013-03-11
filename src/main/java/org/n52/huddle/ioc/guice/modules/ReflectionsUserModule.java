package org.n52.huddle.ioc.guice.modules;

import org.n52.huddle.ioc.UserDAO;
import org.n52.huddle.ioc.UserFactory;
import org.n52.huddle.ioc.UserService;
import org.n52.huddle.ioc.guice.ReflectionsModule;

public class ReflectionsUserModule extends ReflectionsModule {
    @Override
    protected void configure() {
        findAndBind(UserFactory.class);
        findAndBind(UserService.class);
        findAndBind(UserDAO.class);
    }
}
