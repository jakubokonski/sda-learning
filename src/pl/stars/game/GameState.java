package pl.stars.game;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Collections.reverseOrder;
import static java.util.Map.Entry.comparingByValue;

public final class GameState {

    private int counter = 0; // zliczanie gwiazdek zestrzeloych
    private final char[][] board; // plansza cała
    private final char[][] shots; // plansza gwiazdek
    private final Map<String, Integer> leaders; // tablica wyników

    public GameState(int x, int y) { // jak duża plansza gry, konstruktor
        board = new char[x][y];
        shots = new char[x][y];
        leaders = new HashMap<>();
    }

    //metoda synchronizowana (wszystkie musza być) - nowa gra
    public synchronized void generateNewGame() {
        Random random = new Random();
        // tworzenie planszy - losowo generujemy gwiazdki na polach
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (random.nextInt(100) % 3 == 0) {
                    board[i][j] = '*';
                    counter++;
                } else {
                    board[i][j] = '_';
                }
                shots[i][j] = '_';
            }
        }
    }

    // drukujemy planszę
    public synchronized void print() {
        for (char[] chars : board) {
            System.out.println(Arrays.toString(chars));
        }
    }

    // drukujemy plansze strzałów
    public synchronized void printShots() {
        for (char[] chars : shots) {
            System.out.println(Arrays.toString(chars));
        }
    }

    // tworzymy mapę liderów, zmieniamy mape w entrySet, na który juz możemy dodać stream, stream sortujemy w odwróconej kolejności po wartości a nie kluczu
    public synchronized void printLeaders() {
        Map<String, Integer> sorted = leaders
                .entrySet()
                .stream()
                .sorted(reverseOrder(comparingByValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));
        System.out.println(sorted);
    }

    public synchronized boolean tryShot(String name, int x, int y) {
        if (isOutOfBounds(x, y) || board[x][y] != '*') {
            return false;
        }

        board[x][y] = 'T';
        shots[x][y] = 'T';
        counter--;
        if (leaders.containsKey(name)) {
            leaders.put(name, leaders.get(name) + 1);
        } else {
            leaders.put(name, 1);
        }
        return true;
    }

    public synchronized boolean isOver() {
        return counter == 0;
    }

    private boolean isOutOfBounds(int x, int y) {
        return (x < 0 || x >= board.length) || (y < 0 || y >= board[x].length);
    }
}
