package mobi.mpk.chessServerSpring.registry;

import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

@Component
public class UserRegistry<String, User> extends Registry<String, User> {

    public UserRegistry() {

        values = new ConcurrentHashMap<String, User>();

    }

}
