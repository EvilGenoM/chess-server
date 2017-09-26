package mobi.mpk.chess.message;

public class ExpectMessage extends Message {

    public ExpectMessage(String name) {
        super(name);
    }

    public boolean setText(String text) {
        return false;
    }

}
