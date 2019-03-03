package pl.shop.app;

import pl.shop.model.Account;
import pl.shop.utils.ListUtils;

public class ListOrdersMenuCommand implements MenuCommand<Account> {
    @Override
    public String getText() {
        return "List orders";
    }

    @Override
    public void execute(Account account) {
        if (account.getOrders().isEmpty()) {
            System.out.println("Orders list is empty.");
        }

        String list = ListUtils.toNumeratedList(account.getOrders());
        System.out.println(list);
    }
}
