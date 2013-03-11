package org.n52.huddle.di.guice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.AbstractModule;

public abstract class ReflectionsModule extends AbstractModule implements AutoLoadedModule {
    private static final Logger log = LoggerFactory.getLogger(ReflectionsModule.class);

    protected <T> void findAndBind(Class<T> type) {
        try {
            Class<? extends T> impl = Implementations.find(type);
            log.debug("Binding {} to {}", type, impl);
            bind(type).to(impl);
        } catch (ImplementationNotFoundException e) {
            addError(e);
        }
    }
}