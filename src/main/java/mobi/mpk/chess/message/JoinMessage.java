package mobi.mpk.chess.message;

public class JoinMessage extends Message {

    public JoinMessage(String name) {
        super(name);
    }

    public boolean setText(String text) {

        String[] textCommand = text.split(" ");

        if (textCommand[0].equals("join")) {
            this.text = text;
            return true;
        } else {
            return false;
        }

    }

}
