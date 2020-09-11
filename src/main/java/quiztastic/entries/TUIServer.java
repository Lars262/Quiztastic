package quiztastic.entries;

import quiztastic.ui.Protocol;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class TUIServer implements Runnable {


    private final Socket socket;


    public TUIServer(Socket socket) {

        this.socket = socket;

    }


    @Override

    public void run() {

        try {

            Scanner in = new Scanner(socket.getInputStream());

            PrintWriter out = new PrintWriter(socket.getOutputStream());

            new Protocol(in, out).run();

            socket.close();

        } catch (IOException e) {

            e.printStackTrace();

        }

    }


    public static volatile boolean keepRunning = true;

    public static void main(String[] args) throws IOException {

        final int port = 6060;

        final ServerSocket serverSocket = new ServerSocket(port);


        while (keepRunning) {

            Socket socket = serverSocket.accept();

            System.out.println("[CONNECTED] " + socket.getInetAddress()
                    + " port " + socket.getPort()
                    + " server port " + socket.getLocalPort());

            Thread thread = new Thread(new TUIServer(socket));

            thread.start();

        }

    }

}