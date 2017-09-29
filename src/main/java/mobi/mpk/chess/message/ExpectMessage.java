package mobi.mpk.chess.message;

public class ExpectMessage extends Message {

    public ExpectMessage(String name) {
        super(name);
    }

    public boolean setText(String text) {

        if (text.equals("expect")) {
            this.text = text;
            return true;
        } else {
            return false;
        }

    }

}
