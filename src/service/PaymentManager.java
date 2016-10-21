package service;

import dao.CustomerInfoDao;
import dao.OrderDao;
import pojo.Customer;
import pojo.Order;
import pojo.Store;
import pojo.User;

import java.util.Date;

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
     * 获取商家盈利
     */
    public double getProfit() {
        return ((Store) (UserManager.getCurrentUser())).getProfit();
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
            new OrderDao().addNewOrder(order);
            return true;
        } else return false;
    }

    /**
     * 用于领取文件后确认订单已完成
     * 只要有一家点击了都将设置订单为已完成
     * 只有当消费者一定时间（如24小时）不点击已完成，店家才可以点击
     *
     * @return true点击成功，false不可点击
     */
    public boolean confirmOrderCompleted(Order order) {
        if (UserManager.getUserType() == UserManager.TYPE_STORE) {
            long currentTime = new Date().getTime();
            if (currentTime - order.getCreateTime() < 24 * 60 * 60 * 1000) {
                return false;
            }
        }
        order.pickUp();
        new OrderDao().completeOrder(order);
        return true;
    }

    /**
     * 对订单列表进行刷新
     */
    public void refreshOrderList() {

    }

    /**
     * 将生成的订单发给店家用于后续操作，即订单与商家绑定
     *
     * @param order 生成的订单，发往的店家在在order类中
     */
    private void sendOrderToStore(Order order) {
        //TODO 当消费者提交一个订单时，店家如何实时获得这个订单?或者可以考虑店家手动刷新refreshOrderList()？
    }

}
