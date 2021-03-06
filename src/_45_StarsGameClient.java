import pl.stars.game.Client;

import java.io.IOException;
import java.net.Socket;

public class _45_StarsGameClient {

    public static void main(String[] args) {
        // try with resources automaticly loses at the end
        try (Socket socket = new Socket("127.0.0.1", 8088);) {

            new Client(socket).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
