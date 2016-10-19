package action;

import pojo.Customer;
import service.RegistService;

import java.util.Objects;

/**
 * Created by hurong1993 on 2016/10/19.
 */
public class RegistAction {
    public RegistService registService = new RegistService();
    public Customer customer = new Customer();
    public String password1;

    public String customerResist() {
        boolean treck = registService.treckAccount(customer);
        if (this.customer.getAccount() == null || this.customer.getAccount().trim().equals("")) {
            return "accountnull";
        } else if (!Objects.equals(password1, customer.getPassword())) {
            return "nosame";
        } else if (treck) {
            System.out.println("one");
            return "exit";
        } else {
            registService.customerRegist(customer);
            return "yes";
        }
    }
}
