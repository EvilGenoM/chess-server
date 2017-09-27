package mobi.mpk.chess.net;


import com.google.gson.Gson;
import mobi.mpk.chess.message.ManagerMessage;
import mobi.mpk.chess.message.Message;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientThread extends Thread {

    private Socket socket;

    public ClientThread(Socket socket){

        this.socket = socket;

    }

    public void run(){

        try{
            DataInputStream in = new DataInputStream(this.socket.getInputStream());
            DataOutputStream out = new DataOutputStream(this.socket.getOutputStream());

            Sender sender = new Sender();
            Gson gson = new Gson();
            String line;

            while(true){

                line = in.readUTF();
                Message message = gson.fromJson(line, Message.class);

//                ManagerMessage manager = new ManagerMessage(" ");

            }

        } catch (IOException ex) {
            System.out.println(ex);
        }

    }


}
