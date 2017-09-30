package mobi.mpk.chess.message;

public class LobbyMessage extends Message {

    public LobbyMessage(String name) {
        super(name);
    }

    public boolean setText(String text) {

        if (text.equals("users")) {
            this.text = text;
            return true;
        } else {
            return false;
        }

    }

}
