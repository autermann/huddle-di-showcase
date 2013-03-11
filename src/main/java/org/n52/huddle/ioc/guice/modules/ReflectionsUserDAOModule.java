package org.n52.huddle.ioc.guice.modules;

import org.n52.huddle.ioc.UserDAO;
import org.n52.huddle.ioc.guice.Ignore;
import org.n52.huddle.ioc.guice.ReflectionsModule;

@Ignore
public class ReflectionsUserDAOModule extends ReflectionsModule {

    @Override
    protected void configure() {
        findAndBind(UserDAO.class);
    }
}
