package org.n52.huddle.ioc.guice.modules;

import org.n52.huddle.ioc.UserFactory;
import org.n52.huddle.ioc.guice.Ignore;

@Ignore
public class ReflectionsUserFactoryModule extends SingleClassReflectionsModule {
    public ReflectionsUserFactoryModule() {
        super(UserFactory.class);
    }
}
