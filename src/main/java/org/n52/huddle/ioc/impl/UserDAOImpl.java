package org.n52.huddle.ioc.impl;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.n52.huddle.ioc.User;
import org.n52.huddle.ioc.UserDAO;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;
import com.google.inject.persist.Transactional;

public class UserDAOImpl implements UserDAO {
    @Inject
    private EntityManager em;

    @Override
    public User getByLastName(String lastName) {
        final CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<UserImpl> q = cb.createQuery(UserImpl.class);
        q.where(cb.equal(q.from(UserImpl.class).get(UserImpl.LAST_NAME), lastName));
        return em.createQuery(q).getSingleResult();
    }

    @Override
    public User get(long id) {
        return em.find(User.class, id);
    }

    @Override
    @Transactional
    public long save(User t) {
        Preconditions.checkNotNull(t);
        em.persist(t);
        return t.getId();
    }
}
