package mobi.mpk.chess.message;

public class JoinMessage extends Message {

    public JoinMessage(String name) {
        super(name);
    }

    public boolean setText(String text) {
        return false;
    }

}
