package pl.stars.game;

import java.io.*;
import java.net.Socket;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class ClientHandler  implements Runnable {

    private static final Pattern MSG_PATTERN = Pattern.compile("@\\{(\\d+),(\\d+)\\}");
    // \\d+ spodiewamy się liczby z wielu cyfr, w nawiasach żeby to zgrupować i móc się do tego odwołać

    private final Socket socket;
    private final GameState gameState;

    ClientHandler(Socket socket, GameState gameState) {
        this.socket = socket;
        this.gameState = gameState;
    }

    @Override
    public void run() {
        try (BufferedReader reader = getReader();
             PrintWriter writer = getWriter();) {

            // odczytujemy wpis klienta - imię
            String name = reader.readLine();
            System.out.println("Client connected: " + name);

            // komunikat zwrotny hello
            writer.println("Hello " + name);

            // komuniakacja z klientem
            String line;
            while ((line = reader.readLine()) != null) {
                // parsowanie wiadomości, czy wiadomość jest poprawna format to name + pozycja strzału: @(x,y) - protokół
                // matcher sprawdza czy linie pasuje do wzroca
                Matcher matcher = MSG_PATTERN.matcher(line);
                if (matcher.matches()) {
                    // warunki zamienione na metodę
                    handleUserInput(writer, name, matcher);
                } else {
                    writer.println("Your message is invalid");
                }
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void handleUserInput(PrintWriter writer, String name, Matcher matcher) {
        int x = Integer.valueOf(matcher.group(1));
        int y = Integer.valueOf(matcher.group(2));

        if (gameState.tryShot(name, x, y)) {
            System.out.println("Good Shot. " + name + " Congratulations!");
            if (gameState.isOver()) {
                System.out.println("Game Over. See results:");
                gameState.printLeaders();
                gameState.generateNewGame();
                System.out.println("Server generated new game!");
            } else {
                gameState.printShots();
                gameState.printLeaders();
            }
            writer.println("Well done. You hit the star!");
        } else {
            writer.println("Ughhhh... try again. Good luck.");
        }
    }

    private PrintWriter getWriter() throws IOException {
        return new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
    }

    private BufferedReader getReader() throws IOException {
        return new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }
}
