package pl.shop.app;

import pl.shop.model.Account;

import java.util.List;

public final class ShopApp {

    private final MenuSelector<List<Account>> menuSelector;

    public ShopApp(List<Account> accounts) {
        this.menuSelector = new MenuSelector<List<Account>>(
                accounts,
                new CreateAccountMenuCommand(),
                new ListAccountsMenuCommand(),
                new SelectAccountMenuCommand(),
                new SaveAppStateMenuCommand(),
                new ExitMenuCommand<>("Exit")
        );
    }

    public void run () {
        menuSelector.select();
    }
}
