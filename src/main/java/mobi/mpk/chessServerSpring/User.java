package mobi.mpk.chessServerSpring;

import java.util.Calendar;

public class User {

    private String name;
    private Calendar timeConnect;

    public User(String name) {

        this.name = name;
        timeConnect = Calendar.getInstance();

    }

    @Override
    public boolean equals(Object o) {

        if(this == o) {
            return true;
        } else if (o == null) {
            return false;
        } else if(o instanceof User) {
            User user = (User) o;
            return this.equals(user.getName());
        }
        return false;

    }

    public String getName() {
        return name;
    }
}
