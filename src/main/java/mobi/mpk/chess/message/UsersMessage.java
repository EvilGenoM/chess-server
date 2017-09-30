package mobi.mpk.chess.message;

public class UsersMessage extends Message {

    public UsersMessage(String name) {
        super(name);
    }

    public boolean setText(String text) {

        if (text.equals("lobby")) {
            this.text = text;
            return true;
        } else {
            return false;
        }

    }

}
