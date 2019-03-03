import pl.stars.game.GameState;
import pl.stars.game.Server;

final class _44_StarsGameServer {

    public static void main(String[] args) {
        GameState state = new GameState(10, 10);
        state.generateNewGame();

        new Server(state).start();


    }
}
