package mobi.mpk.chess.handlermessage;

import mobi.mpk.chess.User;
import mobi.mpk.chess.command.*;
import mobi.mpk.chess.message.Message;
import mobi.mpk.chess.message.reply.Reply;
import mobi.mpk.chess.registry.UserRegistry;


public class LobbyHandlerMessage implements HandlerMessage {

    public Reply handleMessage(Message message) {

        Reply reply = new Reply("Server");

        String name = message.getName();

        if (isNameNotExist(name)) {
            if (checkName(message.getText())) {
                reply.setText("Success");
                reply.setSuccess(true);
                return reply;
            } else {
                reply.setText("This name exist...");
                return reply;
            }
        }

        String text = message.getText();

        String resultComand = executeCommand(name, text);

        reply.setText(resultComand);
        reply.addUser(UserRegistry.getInstance().getElement(name));

        return reply;

    }

    private boolean checkName(String name) {
        if (!UserRegistry.getInstance().checkKey(name)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isNameNotExist(String name) {

        User user = UserRegistry.getInstance().getElement(name);

        if (user == null) {
            return true;
        } else {
            return false;
        }

    }

    private String executeCommand(String nameUser1, String text) {

        String[] splitCommand = text.split(" ");
        Command command;

        switch (splitCommand[0]) {
            case "lobby":

                command = new ShowUsersExpectGameCommand();
                return command.execute();

            case "users":

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
                return "Error command";
        }

    }

}
