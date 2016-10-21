package dao;

import pojo.Customer;
import pojo.Document;
import pojo.Order;
import pojo.Store;
import service.UserManager;
import util.DatabaseHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDao {

    /**
     * 在数据库里添加一条订单
     */
    public void addNewOrder(Order order) {
        String sql = "insert into `order`(customer_id,store_id,code,price,evaluation,is_picked_up,create_time) values('" +
                order.getCustomer().getId() + "','" +
                order.getStore().getId() + "','" +
                order.getCode() + "','" +
                order.getPrice() + "','" +
                order.getEvaluation() + "','" +
                order.isPickedUp() + "','" +
                order.getCreateTime() + "')";
        DatabaseHelper.executeUpdate(sql);
    }

    /**
     * 将某未完成订单设置为已完成
     */
    public void completeOrder(Order order) {
        String sql = "update `order` set is_picked_up=1 where id=" + order.getId();
        DatabaseHelper.executeUpdate(sql);
    }

    /**
     * 获取消费者所有的订单
     */
    public List<Order> getCustomerAllOrders() {
        String sql = "select * from `order` where customer_id=" + UserManager.getCurrentUser().getId();
        return getUserOrders(sql);
    }

    /**
     * 获取商店所有订单
     */
    public List<Order> getStoreAllOrders() {
        String sql = "select * from `order` where store_id=" + UserManager.getCurrentUser().getId();
        return getUserOrders(sql);
    }

    /**
     * 获取消费者已完成订单
     */
    public List<Order> getCustomerCompletedOrders() {
        String sql = "select * from `order` where customer_id=" + UserManager.getCurrentUser().getId()
                + "and is_picked_up=1";
        return getUserOrders(sql);
    }

    /**
     * 获取商店已完成订单
     */
    public List<Order> getStoreCompletedOrders() {
        String sql = "select * from `order` where store_id=" + UserManager.getCurrentUser().getId()
                + "and is_picked_up=1";
        return getUserOrders(sql);
    }

    /**
     * 获取消费者正在进行的订单
     */
    public List<Order> getCustomerOngoingOrders() {
        String sql = "select * from `order` where customer_id=" + UserManager.getCurrentUser().getId()
                + "and is_picked_up=0";
        return getUserOrders(sql);
    }

    /**
     * 获取商店正在进行的订单
     */
    public List<Order> getStoreOngoingOrders() {
        String sql = "select * from `order` where store_id=" + UserManager.getCurrentUser().getId()
                + "and is_picked_up=0";
        return getUserOrders(sql);
    }

    /**
     * 获取当前用户的所有账单
     * public Order(int id, Customer customer, Store store, double price, String code,
     * boolean isPickedUp, String evaluation, List<Document> documents, long createTime)
     */
    private List<Order> getUserOrders(String sql) {
        ResultSet resultSet = DatabaseHelper.executeQuery(sql);
        List<Order> orders = new ArrayList<>();
        try {
            if (resultSet != null) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    Customer customer = findCustomerById(resultSet.getInt("customer"));
                    Store store = findStoreById(resultSet.getInt("store"));
                    double price = resultSet.getDouble("price");
                    String code = resultSet.getString("code");
                    boolean isPickedUp = resultSet.getBoolean("is_picked_up");
                    String evaluation = resultSet.getString("evaluation");
                    List<Document> documents = findOrderAllDocument(resultSet.getInt("id"));
                    long createTime = resultSet.getLong("create_time");
                    Order order = new Order(id, customer, store, price, code, isPickedUp, evaluation, documents, createTime);
                    orders.add(order);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    /**
     * 使用其他Dao获取消费者信息
     */
    private Customer findCustomerById(int customerId) {
        return new CustomerInfoDao().getCustomerInfoById(customerId);
    }

    /**
     * 使用其他Dao获取商店信息
     */
    private Store findStoreById(int storeId) {
        return new StoreInfoDao().getStoreInfoById(storeId);
    }

    /**
     * 使用其他Dao获取订单中所有文件
     */
    private List<Document> findOrderAllDocument(int orderId) {
        return new DocumentDao().getOrderAllDocuments(orderId);
    }


}
