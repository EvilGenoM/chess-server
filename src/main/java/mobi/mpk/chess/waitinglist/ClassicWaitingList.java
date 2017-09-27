package mobi.mpk.chess.waitinglist;

import mobi.mpk.chess.User;
import mobi.mpk.chess.registry.UserRegistry;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ClassicWaitingList implements WaitingList {

    private static ClassicWaitingList instance;
    private ConcurrentMap<String, User> users;

    private ClassicWaitingList(){
        users = new ConcurrentHashMap<String, User>();
    }

    public static ClassicWaitingList getInstance() {
        if (instance == null) {
            synchronized (UserRegistry.class) {
                instance = new ClassicWaitingList();
            }
        }
        return instance;
    }

    @Override
    public void addUser(User user) {
        users.putIfAbsent(user.getName(), user);
    }

    @Override
    public void removeUser(String name) {
        users.remove(name);
    }

    @Override
    public void removeUser(User user) {
        users.remove(user.getName(), user);
    }

    @Override
    public void getUser(String name) {
        users.get(name);
    }

    @Override
    public List<User> getListUser() {

        List<User> list = new ArrayList<User>();

        for (User user : users.values()) {
            list.add(user);
        }

        return list;

    }

}
