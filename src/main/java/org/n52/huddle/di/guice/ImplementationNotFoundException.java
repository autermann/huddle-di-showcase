package org.n52.huddle.di.guice;

public class ImplementationNotFoundException extends Exception {

    private static final long serialVersionUID = 1L;

    public ImplementationNotFoundException(Class<?> c) {
        super(String.format("No implementation for %s found", c));
    }
}
