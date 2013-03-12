package org.n52.huddle.di.guice;

import java.lang.reflect.Modifier;
import java.util.Iterator;
import java.util.Set;

import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Predicate;
import com.google.common.collect.Sets;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.persist.PersistService;

public class Implementations {
    private static final Logger log = LoggerFactory.getLogger(Implementations.class);
    private static final Reflections reflections = new Reflections("org.n52");
    private static final Injector injector = Guice.createInjector(findModules());

    static {
        injector.getInstance(PersistService.class).start();
    }

    public static Injector getInjector() {
        return injector;
    }

    public static <T> Class<? extends T> find(Class<T> clazz) throws ImplementationNotFoundException {
        Set<Class<? extends T>> classes = reflections.getSubTypesOf(clazz);
        log.debug("Found implementations for {}: {}", clazz, classes);
        IsInstantiable instantiable = new IsInstantiable();
        Iterator<Class<? extends T>> i = classes.iterator();
        while (i.hasNext()) {
            Class<? extends T> impl = i.next();
            if (instantiable.apply(impl)) {
                return impl;
            }
        }
        throw new ImplementationNotFoundException(clazz);
    }

    public static <T> Set<Class<? extends T>> findAll(Class<T> clazz) {
        final Set<Class<? extends T>> subTypes = reflections.getSubTypesOf(clazz);
        log.debug("Found subtypes of {}: {}", clazz, subTypes);
        return Sets.filter(subTypes, new IsInstantiable());
    }

    protected static Set<Module> findModules() {
        Set<Class<? extends AutoLoadedModule>> modules = findAll(AutoLoadedModule.class);
        Set<Module> instances = Sets.newHashSetWithExpectedSize(modules.size());
        for (Class<? extends Module> module : modules) {
            try {
                log.debug("Adding module {}", module);
                instances.add(module.newInstance());
            } catch (Throwable e) {
                log.error("Error instantiating module", e);
            }
        }
        return instances;
    }

    private Implementations() {
    }

    private static class IsInstantiable implements Predicate<Class<?>> {
        @Override
        public boolean apply(Class<?> input) {
            int mod = input.getModifiers();
            return !Modifier.isAbstract(mod) && !Modifier.isInterface(mod)
                   && !input.isAnnotationPresent(Ignore.class);
        }
    }
}
