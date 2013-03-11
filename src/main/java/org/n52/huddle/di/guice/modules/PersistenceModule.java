package org.n52.huddle.di.guice.modules;

import org.n52.huddle.di.guice.AutoLoadedModule;

import com.google.inject.AbstractModule;
import com.google.inject.persist.jpa.JpaPersistModule;

public class PersistenceModule extends AbstractModule implements AutoLoadedModule {

    @Override
    protected void configure() {
        install(new JpaPersistModule("test"));
    }
}
