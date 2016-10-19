package dao;

import pojo.Customer;
import pojo.Document;
import pojo.Order;
import pojo.Store;
import service.UserManager;
import util.DatabaseHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CustomerInfoDao extends UserInfoDao {

    public CustomerInfoDao() {
        super();
    }

    /**
     * 这是通过id查找消费者信息的方法，可用于查询不通消费者
     */
    public Customer getCustomerInfoById(int customerId) {
        String sql = "select * from customer where id=" + customerId;
        Customer customer = new Customer();
        ResultSet resultSet = DatabaseHelper.executeQuery(sql);
        try {
            if (resultSet != null && resultSet.next()) {
                customer.setId(resultSet.getInt("id"));
                customer.setAccount(resultSet.getString("account"));
                customer.setPassword(resultSet.getString("introduction"));
                customer.setEmail(resultSet.getString("email"));
                customer.setTelephone(resultSet.getString("telephone"));
                customer.setPath(resultSet.getString("path"));
                customer.setBalance(resultSet.getDouble("balance"));
                customer.setPayPassword(resultSet.getString("payPassword"));
                customer.setCompletedOrders(new OrderDao().getCustomerCompletedOrders());
                customer.setMyDocuments(new DocumentDao().getCustomerAllDocument());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    /**
     * 用于在登录时根据账号获得消费者信息
     */
    public Customer getCustomerInfoByAccount(String account) {
        return new Customer();
    }

    /**
     * 这是查询当前登录用户的信息的方法
     */
    public Customer getLoginCustomerInfo() {
        return getCustomerInfoById(UserManager.getCurrentUser().getId());
    }

    public void setBalance(double balance) {
    }

    public void setPath(String path) {
    }

    public void setDefaultStore(Store defaultStore) {
    }

    public void setPayPassword(double payPassword) {

    }

}