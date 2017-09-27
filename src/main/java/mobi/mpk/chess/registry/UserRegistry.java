package mobi.mpk.chess.registry;

import mobi.mpk.chess.User;

import java.util.concurrent.ConcurrentHashMap;

public class UserRegistry<K, E> extends Registry<K, E> {

    private static UserRegistry<String, User> instance;

    private UserRegistry(){
        value = new ConcurrentHashMap<K, E>();
    }

    public static UserRegistry<String, User> getInstance() {
        if (instance == null) {
            synchronized (UserRegistry.class) {
                instance = new UserRegistry<String, User>();
            }
        }
        return instance;
    }

}
