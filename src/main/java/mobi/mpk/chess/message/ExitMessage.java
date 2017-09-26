package mobi.mpk.chess.message;

public class ExitMessage extends Message {

    public ExitMessage(String name) {
        super(name);
    }

    public boolean setText(String text) {

        if(text.equals("exit")){
            this.text = text;
            return true;
        } else {
            return false;
        }

    }

}
