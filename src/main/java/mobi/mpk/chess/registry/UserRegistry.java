package mobi.mpk.chess.registry;

import mobi.mpk.chess.User;

import java.io.DataOutputStream;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class UserRegistry<K, E> extends Registry<K, E> {

    private static UserRegistry<String, User> instance;
    private ConcurrentMap<User, DataOutputStream> adressUser;

    private UserRegistry() {
        value = new ConcurrentHashMap<K, E>();
        adressUser = new ConcurrentHashMap<User, DataOutputStream>();
    }

    public static UserRegistry<String, User> getInstance() {
        if (instance == null) {
            synchronized (UserRegistry.class) {
                instance = new UserRegistry<String, User>();
            }
        }
        return instance;
    }

    public void addAdress(User user, DataOutputStream out) {

        this.adressUser.putIfAbsent(user, out);

    }

    public DataOutputStream getAdress(User user) {

        return adressUser.get(user);

    }

}
