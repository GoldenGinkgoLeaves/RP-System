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

    public List<Order> getCustomerAllOrders() {
        String sql = "select * from `order` where customer_id=" + UserManager.getCurrentUser().getId();
        return getUserOrders(sql);
    }

    public List<Order> getStoreAllOrders() {
        String sql = "select * from `order` where store_id=" + UserManager.getCurrentUser().getId();
        return getUserOrders(sql);
    }

    public List<Order> getCustomerCompletedOrders() {
        String sql = "select * from `order` where customer_id=" + UserManager.getCurrentUser().getId()
                + "and is_picked_up=1";
        return getUserOrders(sql);
    }

    public List<Order> getStoreCompletedOrders() {
        String sql = "select * from `order` where store_id=" + UserManager.getCurrentUser().getId()
                + "and is_picked_up=1";
        return getUserOrders(sql);
    }

    /**
     * 获取当前用户的所有账单
     */
    private List<Order> getUserOrders(String sql) {
        ResultSet resultSet = DatabaseHelper.executeQuery(sql);
        List<Order> orders = new ArrayList<>();
        try {
            if (resultSet != null) {
                while (resultSet.next()) {
                    Customer customer = findCustomerById(resultSet.getInt("customer"));
                    Store store = findStoreById(resultSet.getInt("store"));
                    List<Document> documents = findOrderAllDocument(resultSet.getInt("id"));
                    Order order = new Order(customer, store, documents);
                    order.setPrice(resultSet.getDouble("price"));
                    order.setCode(resultSet.getString("code"));
                    order.setEvaluation(resultSet.getString("evaluation"));
                    orders.add(order);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    private Customer findCustomerById(int customerId) {
        return new CustomerInfoDao().getCustomerInfo(customerId);
    }

    private Store findStoreById(int storeId) {
        return new StoreInfoDao().getStoreInfo(storeId);
    }

    private List<Document> findOrderAllDocument(int orderId) {
        return new DocumentDao().getOrderAllDocuments(orderId);
    }

    public void addNewOrder(Order order) {

    }


}
