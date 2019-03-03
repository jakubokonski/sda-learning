package pl.shop.app;

import pl.shop.utils.OptionSelector;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class MenuSelector<T> { // generic class, contains commands list

    private final T context; // definiujemy zmienną context generycznego typu T
    private final List<MenuCommand<T>> commands;
    private final OptionSelector<String> selector;

    MenuSelector(T context, List<MenuCommand<T>> commands) {
        this.context = context;
        this.commands = commands;

        List<String> options = new ArrayList<>();
        for (MenuCommand<T> command : commands) {
            options.add(command.getText());
        }
        this.selector = new OptionSelector<>(options);
    }

    @SafeVarargs // override constructor
    public MenuSelector(T context, MenuCommand<T> ...commands) {
        this(context, Arrays.asList(commands));
    }

    void select() {
        while (true) {
            int menu = selector.select();
            MenuCommand<T> command = commands.get(menu - 1);
            command.execute(context);
            if (command.isExit()) {
                return;
            }
        }
    }

}
