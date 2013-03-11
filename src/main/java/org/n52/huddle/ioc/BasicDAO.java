package org.n52.huddle.ioc;

public interface BasicDAO<T> {
    T get(long id);
    long save(T t);
}
