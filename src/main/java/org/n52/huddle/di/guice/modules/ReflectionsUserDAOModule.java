package org.n52.huddle.di.guice.modules;

import org.n52.huddle.di.UserDAO;
import org.n52.huddle.di.guice.Ignore;
import org.n52.huddle.di.guice.ReflectionsModule;

@Ignore
public class ReflectionsUserDAOModule extends ReflectionsModule {

    @Override
    protected void configure() {
        findAndBind(UserDAO.class);
    }
}
