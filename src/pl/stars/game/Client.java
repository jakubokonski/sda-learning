package pl.stars.game;

import java.io.*;
import java.net.Socket;

public final class Client {

    private final Socket socket;

    public Client(Socket socket) {
        this.socket = socket;
    }

    public void start() {
        // otwarcie zasobów do komunikacji
        try (BufferedReader reader = getReader();
             PrintWriter writer = getWriter();
             BufferedReader consoleReader = getConsoleReader()){

            System.out.println("What is your name?");
            // czytamy imie z konsoli
            String name = consoleReader.readLine();
            // wysyłamy imie do serwera
            writer.println(name);

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("From server: " + line);
                System.out.println("Your shot:");
                String message = consoleReader.readLine();

                writer.println(message);
            }


        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

//    private String bot() {
//        int x;
//        int y;
//        String shot;
//        for (x = 0; x <= 9; x++) {
//            shot = "@{" + x + "," + 0 + "}";
//        }return shot;
//    }

    private BufferedReader getConsoleReader() {
        return new BufferedReader(new InputStreamReader(System.in));
    }

    private PrintWriter getWriter() throws IOException {
        return new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
    }

    private BufferedReader getReader() throws IOException {
        return new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }
}
