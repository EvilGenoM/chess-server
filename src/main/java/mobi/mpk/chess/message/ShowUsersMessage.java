package mobi.mpk.chess.message;

public class ShowUsersMessage extends Message {

    public ShowUsersMessage(String name) {
        super(name);
    }

    public boolean setText(String text) {
        return false;
    }

}
