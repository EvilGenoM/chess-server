package mobi.mpk.chess.net;


import com.google.gson.Gson;
import mobi.mpk.chess.User;
import mobi.mpk.chess.handlermessage.HandlerMessage;
import mobi.mpk.chess.handlermessage.LobbyHandlerMessage;
import mobi.mpk.chess.message.CheckNameMessage;
import mobi.mpk.chess.message.ManagerMessage;
import mobi.mpk.chess.message.Message;
import mobi.mpk.chess.message.Reply;
import mobi.mpk.chess.message.exception.MessageErrorException;
import mobi.mpk.chess.registry.UserRegistry;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientThread extends Thread {

    private Socket socket;
    private User user;
    private HandlerMessage controller;

    public ClientThread(Socket socket) {

        controller = new LobbyHandlerMessage();
        this.socket = socket;

    }

    public void run() {

        Sender sender = new Sender();
        try {
            DataInputStream in = new DataInputStream(this.socket.getInputStream());
            DataOutputStream out = new DataOutputStream(this.socket.getOutputStream());

            Gson gson = new Gson();
            String line;

            while (true) {

                line = in.readUTF();
                GsonMessage message = gson.fromJson(line, GsonMessage.class);
                Message messageCreateUser = new CheckNameMessage(message.name);
                messageCreateUser.setText(message.text);

                Reply reply = controller.handleMessage(messageCreateUser);

                if (reply.getSuccess()) {
                    user = new User(message.text);
                    UserRegistry.getInstance().addElement(user.getName(), user);
                    UserRegistry.getInstance().addAdress(user, out);
                    out.writeUTF("Success");
                    break;
                }

                out.writeUTF("Error");

            }

            ManagerMessage manager = new ManagerMessage(user.getName());

            while (true) {

                line = in.readUTF();
                GsonMessage message = gson.fromJson(line, GsonMessage.class);
                Message messageRequest = manager.getMessage(message.text);

                Reply reply = controller.handleMessage(messageRequest);
                sender.send(reply);

            }

        } catch (IOException ex) {
            System.out.println(ex);
        } catch (MessageErrorException e) {
            e.printStackTrace();
        }

    }


}
