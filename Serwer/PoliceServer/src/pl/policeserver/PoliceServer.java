package pl.policeserver;


import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.person.user.User;

public class PoliceServer {

    private static PoliceServer server;
    private ServerSocket serverSocket;
    private ExecutorService executorService = Executors.newFixedThreadPool(10);
    private ConcurrentHashMap<String, User> map = new ConcurrentHashMap<String, User>();

    public static void main(String[] args) throws IOException {
        server = new PoliceServer();
        server.runServer();
    }
    private void runServer() {
        int serverPort = 2516;
        try {
            System.out.println("Starting Server");
            serverSocket = new ServerSocket(serverPort);
            while (true) {
                System.out.println("Waiting for request");
                try {
                    Socket s = serverSocket.accept();
                    System.out.println("Processing request");
                    executorService.submit(new ServerRequest(s, this));
                } catch (IOException ioe) {
                    System.out.println("Error accepting connection");
                    ioe.printStackTrace();
                }
            }
        } catch (IOException e) {
            System.out.println("Error starting Server on " + serverPort);
            e.printStackTrace();
        }
    }
    public boolean checkSession(User u)
    {
        Boolean ret = false;
        if (map.get(u.getSessionId())!=null) ret = true;
        return ret;
    }
    public void createSession(User u) {
            try {
                SecureRandom prng = SecureRandom.getInstance("SHA1PRNG");
                String ret = Integer.toString(prng.nextInt());
                u.setSessionId(ret);
                map.put(ret, u);
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(PoliceServer.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    private void stopServer() {
        executorService.shutdownNow();
        try {
            serverSocket.close();
        } catch (IOException e) {
            System.out.println("Error in server shutdown");
            e.printStackTrace();
        }
        System.exit(0);
    }

}
