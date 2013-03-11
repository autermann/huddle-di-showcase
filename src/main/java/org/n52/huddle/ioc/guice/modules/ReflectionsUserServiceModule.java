package org.n52.huddle.ioc.guice.modules;

import org.n52.huddle.ioc.UserService;
import org.n52.huddle.ioc.guice.Ignore;

@Ignore
public class ReflectionsUserServiceModule extends SingleClassReflectionsModule {
    public ReflectionsUserServiceModule() {
        super(UserService.class);
    }
}
