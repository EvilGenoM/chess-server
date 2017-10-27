package mobi.mpk.chessServerSpring.model;

public class Message {

    private MessageType type;
    private String content;
    private String sender;

    public MessageType getType() {
        return type;
    }

    public String getContent() {
        return content;
    }

    public String getSender() {
        return sender;
    }

    public void setType(MessageType type) {
        this.type = type;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public enum  MessageType {

        REQUEEST, CONNECT, LEAVE, CREATE_USER,
        JOIN, JOIN_REQUEST_YES, JOIN_REQUEST_NO, JOIN_UNSUCCESS, JOIN_SUCCESS,
        GAME_START, GAME, GAME_COLOR, GAME_MOVE, GAME_RESULT_MOVE, GAME_DISCONNECT,
        RANDOM_GAME, RANDOM_GAME_WAIT, GAME_RESULT_MOVE_SUCCESS, GAME_RESULT_MOVE_UNSUCCESS, CHANGE_USERNAME;

    }

}
