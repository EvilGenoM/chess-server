package mobi.mpk.chess.message;

public class CheckNameMessage extends Message {

    public CheckNameMessage(String name) {
        super(name);
    }

    @Override
    public boolean setText(String text) {
        this.text = "checkName "+text;
        return true;
    }

}
