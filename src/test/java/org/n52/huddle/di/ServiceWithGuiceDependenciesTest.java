package org.n52.huddle.di;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.n52.huddle.di.guice.modules.UserModule;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.util.Modules;

public class ServiceWithGuiceDependenciesTest {
    public static final String LAST_NAME = "lastName";
    public static final String FIRST_NAME = "firstName";
    private UserService service;
    private UserDAO dao;

    @Before
    public void before() {
        Injector injector = Guice.createInjector(Modules.override(new UserModule()).with(new InMemoryModule()));
        this.service = injector.getInstance(UserService.class);
        this.dao = injector.getInstance(UserDAO.class);
    }

    @Test
    public void isInMemoryInstalled() {
        assertThat(this.dao, is(instanceOf(InMemoryUserDAO.class)));
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

    private static class InMemoryModule implements Module {
        @Override
        public void configure(Binder binder) {
            binder.bind(UserDAO.class).to(InMemoryUserDAO.class);
        }
    }
}
