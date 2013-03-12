package org.n52.huddle.di;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.n52.huddle.di.impl.UserFactoryImpl;
import org.n52.huddle.di.impl.UserServiceImpl;

public class ServiceTest {
    public static final String LAST_NAME = "lastName";
    public static final String FIRST_NAME = "firstName";
    private UserService service;
    private UserFactory factory;
    private UserDAO dao;

    @Before
    public void before() {
        this.factory = new UserFactoryImpl();
        this.dao = new InMemoryUserDAO();
        this.service = new TestableUserServiceImpl();
    }

    @Test
    public void safe() {
        User user = service.registerUser(FIRST_NAME, LAST_NAME);
        assertThat(user, is(notNullValue()));
        assertThat(user, is(equalTo(dao.getByLastName(LAST_NAME))));
        assertThat(user.getLastName(), is(LAST_NAME));
        assertThat(user.getFirstName(), is(FIRST_NAME));
        assertThat(user.getId(), is(greaterThan(Long.valueOf(0))));
        assertThat(service.getUser(LAST_NAME), is(equalTo(user)));
    }

    private class TestableUserServiceImpl extends UserServiceImpl {
        TestableUserServiceImpl() {
            /* do not call super() */
        }

        @Override
        protected UserFactory getFactory() {
            return ServiceTest.this.factory;
        }

        @Override
        protected UserDAO getDao() {
            return ServiceTest.this.dao;
        }
    }
}
