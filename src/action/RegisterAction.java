package action;

import pojo.Customer;
import service.UserManager;

import java.util.Objects;

/**
 * Created by hurong1993 on 2016/10/19.
 */
public class RegisterAction {

    public Customer customer = new Customer();

    /**
     * 用户注册
     * @return 返回yes，注册成功；否则注册失败
     */
    public String registerCustomer() {
        boolean result=UserManager.registerCustomer(customer);
        if (result){
            return "yes";
        }
        else{
            return "no";
        }
    }
}
