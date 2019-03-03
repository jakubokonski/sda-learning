package pl.shop.app;

public interface MenuCommand<T> { // generic interface, so <T>

    // methods:
    String getText(); // tekst nad menu

    void execute(T context); // (T ... ) - czasem konto, czasem lista kont, lub zamówienie

    // go back:
    default boolean isExit() {
        return false; // by default no exit
    }
}
