package mobi.mpk.chessServerSpring.waitinglist;

import mobi.mpk.chessServerSpring.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class ClassicWaitingList implements WaitingList {

    private Map<String, User> users;

    public ClassicWaitingList(){
        users = new ConcurrentHashMap<String, User>();
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
    public boolean checkUser(User user) {

        return users.containsValue(user);

    }

    @Override
    public boolean isEmpty() {
        return users.isEmpty();
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
