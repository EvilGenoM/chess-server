package mobi.mpk.chessServerSpring.waitinglist;

import mobi.mpk.chessServerSpring.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface WaitingList {

    void addUser(User user);

    void removeUser(String name);

    void removeUser(User user);

    void getUser(String name);

    boolean checkUser(User user);

    List<User> getListUser();

}
