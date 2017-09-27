package mobi.mpk.chess.message;


public class ReplyMessage extends Message {

    public ReplyMessage(String name) {
        super(name);
    }

    public boolean setText(String text) {
        this.text = text;
        return true;
    }

}
