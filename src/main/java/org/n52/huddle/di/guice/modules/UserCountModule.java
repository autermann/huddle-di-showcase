package org.n52.huddle.di.guice.modules;

import org.n52.huddle.di.App;
import org.n52.huddle.di.guice.AutoLoadedModule;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

public class UserCountModule extends AbstractModule implements AutoLoadedModule {
    @Override
    protected void configure() {
        bind(Integer.class).annotatedWith(Names.named(App.TEST_USER_COUNT)).toInstance(20);
    }
}
