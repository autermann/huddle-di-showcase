package org.n52.huddle.di;

public interface BasicDAO<T> {
    T get(long id);
    long save(T t);
}
