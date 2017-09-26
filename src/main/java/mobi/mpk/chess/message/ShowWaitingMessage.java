package mobi.mpk.chess.message;

public class ShowWaitingMessage extends Message {

    public ShowWaitingMessage(String name) {
        super(name);
    }

    public boolean setText(String text) {
        return false;
    }

}
