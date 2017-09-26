package mobi.mpk.chess.message;

public abstract class Message {

    private String name;
    protected String text;

    public Message(String name){

        this.name = name;

    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }

    public abstract boolean setText(String text);

}
