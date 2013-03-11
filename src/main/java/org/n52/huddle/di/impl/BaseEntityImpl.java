package org.n52.huddle.di.impl;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.n52.huddle.di.BaseEntity;

@MappedSuperclass
public abstract class BaseEntityImpl<T extends BaseEntity<T>> implements BaseEntity<T>, Serializable {
    @Id
    @GeneratedValue
    private long id;

    @Override
    public long getId() {
        return this.id;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T setId(long id) {
        this.id = id;
        return (T) this;
    }
}
