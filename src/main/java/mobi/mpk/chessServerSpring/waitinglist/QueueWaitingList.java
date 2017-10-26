package mobi.mpk.chessServerSpring.waitinglist;

import mobi.mpk.chessServerSpring.User;
import mobi.mpk.chessServerSpring.registry.UserRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Priority;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.PriorityBlockingQueue;

@Component
public class QueueWaitingList implements WaitingList {

    private Queue<User> users;

    @Autowired
    private UserRegistry userRegistry;

    public QueueWaitingList() {

        users = new ConcurrentLinkedQueue<>();

    }

    @Override
    public void addUser(User user) {

        users.offer(user);

    }

    @Override
    public void removeUser(String name) {

        Queue<User> fakeQueue = new PriorityQueue();
        User userDelete = (User) userRegistry.getElement(name);

        for(User user : users) {

            if (users.peek().equals(userDelete)) {
                users.poll();
            } else {
                fakeQueue.offer(users.poll());
            }

        }

        for(User user : fakeQueue) {

            users.offer(fakeQueue.poll());

        }

    }

    @Override
    public void removeUser(User userDelete) {

        Queue<User> fakeQueue = new PriorityQueue();

        for(User user : users) {

            if (users.peek().equals(userDelete)) {
                users.poll();
            } else {
                fakeQueue.offer(users.poll());
            }

        }

        for(User user : fakeQueue) {

            users.offer(fakeQueue.poll());

        }

    }

    @Override
    public void getUser(String name) {

    }

    public User getUser() {

        return users.peek();

    }

    public User pollUser() {

        return users.poll();

    }

    @Override
    public boolean checkUser(User user) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return users.isEmpty();
    }

    @Override
    public List<User> getListUser() {
        return null;
    }
}
