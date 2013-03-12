package org.n52.huddle.di.impl;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EntityMangerProvider {
    private static final Logger log = LoggerFactory.getLogger(EntityMangerProvider.class);
    private static EntityMangerProvider instance;

    public static EntityMangerProvider getInstance() {
        return instance == null ? instance = new EntityMangerProvider() : instance;
    }

    private EntityMangerProvider() {
    }

    public EntityManager getEntityManager() {
        return null;
    }

}
