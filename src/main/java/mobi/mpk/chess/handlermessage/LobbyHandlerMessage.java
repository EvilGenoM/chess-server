package mobi.mpk.chess.handlermessage;

import mobi.mpk.chess.User;
import mobi.mpk.chess.command.*;
import mobi.mpk.chess.message.Message;
import mobi.mpk.chess.message.ReplyMessage;
import mobi.mpk.chess.registry.UserRegistry;

import java.util.Date;

public class LobbyHandlerMessage implements HandlerMessage {

    public ReplyMessage handleMessage(Message message) {

        ReplyMessage replyMessage = new ReplyMessage("Server");

        String name = message.getName();

        if(isNameNotExist(name)){
            replyMessage.setText("Error");
            return replyMessage;
        }

        String text = message.getText();

        String resultComand = executeCommand(name, text);

        replyMessage.setText(resultComand);

        return replyMessage;

    }

    private boolean isNameNotExist(String name){

        User user = UserRegistry.getInstance().getElement(name);

        if(user == null){
            return true;
        } else {
            return false;
        }

    }

    private String executeCommand(String nameUser1, String text){

        String[] splitCommand = text.split(" ");
        Command command;

        switch (splitCommand[0]){
            case "lobby":

                command = new ShowUsersExpectGameCommand();
                return command.execute();

            case "listPlayers":

                command = new ShowUsersAppCommand();
                return command.execute();

            case "join":

                String nameUser2 = splitCommand[1];
                command = new JoinPlayerCommand(nameUser1, nameUser2);
                return command.execute();

            case "expect":

                command = new ExpectGameCommand(nameUser1);
                return command.execute();

            default:
                return "Error";
        }

    }

}
