package org.n52.huddle.di.guice.modules;

import org.n52.huddle.di.UserFactory;
import org.n52.huddle.di.guice.Ignore;

@Ignore
public class ReflectionsUserFactoryModule extends SingleClassReflectionsModule {
    public ReflectionsUserFactoryModule() {
        super(UserFactory.class);
    }
}
