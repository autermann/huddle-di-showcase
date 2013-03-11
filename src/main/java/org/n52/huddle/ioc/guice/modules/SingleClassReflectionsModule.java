package org.n52.huddle.ioc.guice.modules;

import org.n52.huddle.ioc.guice.ReflectionsModule;

import com.google.common.base.Preconditions;

public abstract class SingleClassReflectionsModule extends ReflectionsModule {
    private Class<?> type;

    public SingleClassReflectionsModule(Class<?> type) {
        Preconditions.checkNotNull(type);
        this.type = type;
    }

    @Override
    protected void configure() {
        findAndBind(type);
    }
}
