package service;

import dao.CustomerInfoDao;
import dao.OrderDao;
import pojo.Customer;
import pojo.Order;
import pojo.Store;
import pojo.User;

/**
 * 提供用户支付订单、查询余额、收益和充值的方法等
 */
public class PaymentManager {
    /**
     * 获取用户余额
     */
    public double getBalance() {
        return ((Customer) (UserManager.getCurrentUser())).getBalance();
    }

    /**
     * 充值，参数为金额,返回充值后的余额
     */
    public double recharge(double amount) {
        double newBalance = getBalance() + amount;
        new CustomerInfoDao().setBalance(newBalance);
        return newBalance;
    }

    /**
     * 消费者为一个订单进行支付
     *
     * @param payPassword 验证支付密码是否正确
     * @param order       进行支付的订单
     * @return 是否支付成功
     */
    public boolean payForOrder(String payPassword, Order order, Store store) {
        if (((Customer) (UserManager.getCurrentUser())).getPayPassword().equals(payPassword)) {
            double newBalance = getBalance() - order.getPrice();
            if (newBalance < 0) return false;
            new CustomerInfoDao().setBalance(newBalance);
            sendOrderToStore(order);
            return true;
        } else return false;
    }

    /**
     * 用于领取文件后确认订单已完成
     */
    public void confirmOrderCompleted(Order order) {
        //TODO 消费者点击已完成，不点击则一定时间后可由店家点击完成
        order.pickUp();
        new OrderDao().completeOrder(order);
    }

    /**
     * 将生成的订单发给店家用于后续操作，即订单与商家绑定
     *
     * @param order 生成的订单，发往的店家在在order类中
     */
    private void sendOrderToStore(Order order) {
        new OrderDao().addNewOrder(order);
        //TODO 当消费者提交一个订单时，店家如何实时获得这个订单。可以考虑店家手动刷新？
    }


}
