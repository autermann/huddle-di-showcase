package org.n52.huddle.ioc;

public interface BaseEntity<T extends BaseEntity<T>> {
    long getId();

    T setId(long id);

}
