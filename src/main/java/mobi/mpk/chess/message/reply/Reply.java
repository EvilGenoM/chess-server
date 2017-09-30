package mobi.mpk.chess.message.reply;


import mobi.mpk.chess.User;

import java.util.LinkedList;
import java.util.List;

public class Reply {

    private List<User> users;
    private String name;
    private String text;
    private boolean isSuccess;

    public Reply(String name) {

        this.name = name;
        users = new LinkedList<>();

    }

    public boolean setText(String text) {
        this.text = text;
        return true;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public List<User> getUser() {
        return users;
    }

    public boolean getSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public String getText() {
        return text;
    }

    public String getName() {
        return name;
    }
}
