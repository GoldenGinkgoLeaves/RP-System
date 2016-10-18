package service;

import pojo.Order;
import pojo.Store;
import pojo.User;

import java.util.ArrayList;
import java.util.List;

public class OrderManager {
    /**
     * 根据当前是哪个用户对象查看他的账单
     *
     * @param user 使用多态同时兼容消费者和店家
     * @return 返回一个订单列表
     */
    public List<Order> getAllOrders(User user) {
        List<Order> orderList = new ArrayList<>();
        return orderList;
    }

    /**
     * @param number 与以上基本同功能，本方法只获取前number条订单
     */
    public List<Order> getRecentOrders(User user, int number) {
        List<Order> orderList = new ArrayList<>();
        return orderList;
    }

    /**
     * 将生成的订单发给店家用于后续操作，即订单与商家绑定
     *
     * @param order 生成的订单
     * @param store 发往的店家
     */
    public void sendOrderToStore(Order order, Store store) {

    }
}
