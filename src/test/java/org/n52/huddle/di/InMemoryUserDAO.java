package org.n52.huddle.di;

import org.n52.huddle.di.UserDAO;
import org.n52.huddle.di.User;
import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Maps;
import com.google.inject.Singleton;

@Singleton
public class InMemoryUserDAO implements UserDAO {
    private static final Logger log = LoggerFactory.getLogger(InMemoryUserDAO.class);
    private long id = 1;
    private final Map<String, User> byName = Maps.newTreeMap();
    private final Map<Long, User> byId = Maps.newTreeMap();

    @Override
    public User getByLastName(String lastName) {
        checkNotNull(lastName, "lastName may not be null");
        return byName.get(lastName);
    }

    @Override
    public User get(long id) {
        return byId.get(Long.valueOf(id));
    }

    @Override
    public long save(User user) {
        checkNotNull(user, "user may not be null");
        checkNotNull(user.getLastName(), "lastName may not be null");
        if (user.getId() <= 0) {
            user.setId(++id);
        }
        log.trace("InMemoryUserDAO.save({})", user);
        byName.put(user.getLastName(), user);
        byId.put(user.getId(), user);
        return user.getId();
    }
}
