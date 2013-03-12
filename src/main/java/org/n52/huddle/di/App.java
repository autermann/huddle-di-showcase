package org.n52.huddle.di;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {
    private static final Logger log = LoggerFactory.getLogger(App.class);

    private final UserService userService = Configuration.getInstance().getService();
    private final int count = Configuration.getInstance().getUserCount();

    public void run() {
        String[] ids = new String[count];

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

    public static void main(String[] args) {
        new App().run();
    }
}
