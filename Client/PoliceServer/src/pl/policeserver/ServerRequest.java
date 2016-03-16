package pl.policeserver;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import interfaces.fascades.ServerFascade;
import interfaces.messages.MessageToClient;
import interfaces.messages.MessageToServer;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import pl.policeserver.serverFascade.ServerFascadeImpl;

public class ServerRequest implements Runnable {

    private Socket socket;
    private ObjectOutputStream out;
    private ObjectInputStream in;
    private PoliceServer mainApp;

    public ServerRequest(Socket connection, PoliceServer mainApp) {
        try {
            this.socket = connection;
            this.out = new ObjectOutputStream(socket.getOutputStream());
            this.in = new ObjectInputStream(socket.getInputStream());
            this.mainApp = mainApp;
        } catch (IOException ex) {
            Logger.getLogger(PoliceServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void send(MessageToClient m) {
        try {
            out.writeObject(m);
        } catch (IOException ex) {
            Logger.getLogger(PoliceServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void receive() {
        try {
            System.out.println(this);
            MessageToServer m = (MessageToServer) in.readObject();
            ServerFascade f = new ServerFascadeImpl(this, mainApp);
            m.executeMessage(f);

        } catch (IOException ex) {
            System.out.println("Blad odczytu wiadomosci od klienta");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PoliceServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void run() {

        try {
            receive();
            in.read();

        } catch (IOException ex) {
            Logger.getLogger(ServerRequest.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                Thread.sleep(2000);
                in.close();
                out.close();
                socket.close();
            } catch (IOException ex) {
                Logger.getLogger(ServerRequest.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(ServerRequest.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
