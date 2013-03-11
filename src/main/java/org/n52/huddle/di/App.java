package org.n52.huddle.di;

import java.util.UUID;

import org.n52.huddle.di.guice.Implementations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Inject;

public class App {
    private static final Logger log = LoggerFactory.getLogger(App.class);
    public static void main(String[] args) {
        Implementations.getInjector().getInstance(App.class).run();
    }
    @Inject
    private UserService userService;

    public void run() {
        String[] ids = new String[100];

        for (int i = 0; i < ids.length; ++i) {

            User u = userService.registerUser(String.valueOf(i),
                                              ids[i] = UUID.randomUUID().toString());
            log.debug("Registered {}", u);
        }

        for (int i = 0; i < ids.length; ++i) {
            final User user = userService.getUser(ids[i]);
            if (user == null) {
                throw new NullPointerException();
            } else {
                log.debug("Loaded {}", user);
            }
        }
    }

}
