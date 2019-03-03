package pl.shop.app;

import pl.shop.model.Account;
import pl.shop.model.Address;
import pl.shop.utils.ListUtils;

public class ListAddressMenuCommand implements MenuCommand<Account> {

    @Override
    public String getText() {
        return "List address";
    }

    @Override
    public void execute(Account account) {
        if (account.getCustomer().getAddresses().isEmpty()) {
            System.out.println("No address attached to this account.");
        }

        String list = ListUtils.toNumeratedList(account.getCustomer().getAddresses());
        System.out.println(list);

    }
}
