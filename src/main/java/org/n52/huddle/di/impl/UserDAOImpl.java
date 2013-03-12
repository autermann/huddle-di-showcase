package org.n52.huddle.di.impl;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.n52.huddle.di.User;
import org.n52.huddle.di.UserDAO;

import com.google.common.base.Preconditions;

public class UserDAOImpl implements UserDAO {
    private EntityManager em = EntityMangerProvider.getInstance().getEntityManager();

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
    public long save(User t) {
        em.getTransaction().begin();
        Preconditions.checkNotNull(t);
        em.persist(t);
        em.getTransaction().commit();
        return t.getId();
    }
}
