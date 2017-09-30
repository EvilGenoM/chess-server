package mobi.mpk.chess.net;


import com.google.gson.Gson;
import mobi.mpk.chess.User;
import mobi.mpk.chess.handlermessage.HandlerMessage;
import mobi.mpk.chess.handlermessage.LobbyHandlerMessage;
import mobi.mpk.chess.handlermessage.ManagerHandlerMessage;
import mobi.mpk.chess.message.CheckNameMessage;
import mobi.mpk.chess.message.manager.ManagerMessage;
import mobi.mpk.chess.message.Message;
import mobi.mpk.chess.message.reply.Reply;
import mobi.mpk.chess.message.exception.MessageErrorException;
import mobi.mpk.chess.registry.GameRegistry;
import mobi.mpk.chess.registry.UserRegistry;
import mobi.mpk.chess.waitinglist.ClassicWaitingList;
import mobi.mpk.chess.waitinglist.WaitingList;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.rmi.registry.Registry;

public class ClientThread extends Thread {

    private Socket socket;
    private User user;
    private HandlerMessage controller;
    private Sender sender;

    public ClientThread(Socket socket) {

        controller = new LobbyHandlerMessage();
        this.socket = socket;
        sender = new Sender();

    }

    public void run() {

        try {
            DataInputStream in = new DataInputStream(this.socket.getInputStream());
            DataOutputStream out = new DataOutputStream(this.socket.getOutputStream());

            Gson gson = new Gson();
            String line;

            createUser(in, out);

            ManagerMessage manager = new ManagerMessage(user.getName());
            ManagerHandlerMessage managerHandlerMessage = new ManagerHandlerMessage();

            while (true) {

                try {

                line = in.readUTF();
                GsonMessage message = gson.fromJson(line, GsonMessage.class);

                Message messageRequest = null;
                messageRequest = manager.getMessage(message.text);

                controller = managerHandlerMessage.getHandlerMessage(user);
                Reply reply = controller.handleMessage(messageRequest);

                sender.send(reply);

                } catch (MessageErrorException e) {

                    Reply reply = new Reply(user.getName());
                    reply.addUser(user);
                    reply.setText("Not valid message");
                    sender.send(reply);

                }

            }

        } catch (IOException ex) {
            UserRegistry.getInstance().removeElement(user.getName());
            UserRegistry.getInstance().removeAdress(user);
            GameRegistry.getInstance().removeElementKey(user);
            ClassicWaitingList.getInstance().removeUser(user);
            System.out.println(ex);
        }

    }

    private void createUser(DataInputStream in, DataOutputStream out) throws IOException {

        Gson gson = new Gson();

        String line;

        while (true) {

            line = in.readUTF();
            GsonMessage message = gson.fromJson(line, GsonMessage.class);
            Message messageCreateUser = new CheckNameMessage(message.text);
            messageCreateUser.setText(message.text);

            Reply reply = controller.handleMessage(messageCreateUser);

            if (reply.getSuccess()) {

                user = new User(message.text);
                UserRegistry.getInstance().addElement(user.getName(), user);
                UserRegistry.getInstance().addAdress(user, out);

                reply.addUser(user);
                reply.setText("Success");

                sender.send(reply);
                break;

            }

            GsonMessage gsonMessage = new GsonMessage("Server", "Error name");
            String gsonString = gson.toJson(gsonMessage);

            out.writeUTF(gsonString);

        }

    }


}
