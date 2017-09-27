package mobi.mpk.chess.waitinglist;

import mobi.mpk.chess.User;

import java.util.List;

public interface WaitingList {

    void addUser(User user);

    void removeUser(String name);

    void removeUser(User user);

    void getUser(String name);

    List<User> getListUser();

}
