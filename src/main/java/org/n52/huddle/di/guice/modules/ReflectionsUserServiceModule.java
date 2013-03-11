package org.n52.huddle.di.guice.modules;

import org.n52.huddle.di.UserService;
import org.n52.huddle.di.guice.Ignore;

@Ignore
public class ReflectionsUserServiceModule extends SingleClassReflectionsModule {
    public ReflectionsUserServiceModule() {
        super(UserService.class);
    }
}
