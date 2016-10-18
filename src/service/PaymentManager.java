package service;

import pojo.Customer;
import pojo.User;

/**
 * 提供用户支付订单、查询余额、收益和充值的方法等
 */
public class PaymentManager {
    /**
     * 获取用户余额
     *
     * @param user 消费者或店家
     * @return 余额
     */
    public double getBalance(User user) {
        double balance = 0;
        return balance;
    }

    /**
     * 充值
     *
     * @param customer 只能是消费者
     * @param amount   充值金额
     * @return 是否成功
     */
    public boolean recharge(Customer customer, double amount) {
        return true;
    }

    public boolean payForOrder() {
        return true;
    }
}
