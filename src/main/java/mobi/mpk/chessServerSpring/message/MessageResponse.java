package mobi.mpk.chessServerSpring.message;


public class MessageResponse {

    private String username;
    private String text;
    private ComandType comand;
    private MessageType type;

    public MessageResponse() {

    }

    public MessageResponse(String username, String text, ComandType comand, MessageType type) {

        this.username = username;
        this.text = text;
        this.comand = comand;
        this.type = type;

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }

    public ComandType getComand() {
        return comand;
    }

    public void setComand(ComandType comand) {
        this.comand = comand;
    }

    public enum MessageType {

        RANDOM_GAME_START, RANDOM_GAME_WAIT, RANDOM_GAME_CANCEL,
        GAME_START, GAME_COLOR, GAME_STOP,
        MOVE, MOVE_RESULT;

    }

    public enum  ComandType {

        GAME, LOBBY;

    }

}
