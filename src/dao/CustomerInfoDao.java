package dao;

import pojo.Customer;
import pojo.Store;
import service.UserManager;
import util.DatabaseHelper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 提供获得及修改消费者信息的方法，登录后获得用户信息请使用UserManager类
 * 还有一些方法在父类UserInfoDao中
 */
public class CustomerInfoDao extends UserInfoDao {

    public CustomerInfoDao() {
        super();
    }

    /**
     * 这是通过id查找消费者信息的方法，可用于查询不同消费者
     */
    public Customer getCustomerInfoById(int customerId) {
        String sql = "select * from customer where id=" + customerId;
        ResultSet resultSet = DatabaseHelper.executeQuery(sql);
        Customer customer = null;
        try {
            if (resultSet != null && resultSet.next()) {
                customer = new Customer(resultSet.getInt("id"), UserManager.TYPE_CUSTOMER, resultSet.getString("account"),
                        resultSet.getString("password"), resultSet.getString("introduction"), resultSet.getString("email"),
                        resultSet.getString("telephone"), new OrderDao().getCustomerCompletedOrders(),
                        resultSet.getDouble("balance"), resultSet.getString("path"),
                        new DocumentDao().getCustomerAllDocument(),
                        new StoreInfoDao().getStoreInfoById(resultSet.getInt("store_id")),
                        resultSet.getString("payPassword"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    /**
     * 用于在登录时根据账号获得消费者信息
     */
    public int getCustomerIdByAccount(String account) {
        String sql = "select id from customer where account=" + account;
        ResultSet resultSet = DatabaseHelper.executeQuery(sql);
        int id = 0;
        try {
            if (resultSet != null && resultSet.next()) {
                id = resultSet.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    //设置余额
    public void setBalance(double balance) {
        String sql = "update customer set balance='" + balance
                + "' where id='" + UserManager.getCurrentUser().getId() + "'";
        DatabaseHelper.executeUpdate(sql);
    }

    //设置路径
    public void setPath(String path) {
        String sql = "update customer set path='" + path
                + "' where id='" + UserManager.getCurrentUser().getId() + "'";
        DatabaseHelper.executeUpdate(sql);
    }

    //设置默认商店
    public void setDefaultStore(Store defaultStore) {
        String sql = "update customer set store_id" + defaultStore.getId()
                + "where id='" + UserManager.getCurrentUser().getId() + "'";
        DatabaseHelper.executeUpdate(sql);
    }

    //设置支付密码
    public void setPayPassword(String payPassword) {
        String sql = "update customer set pay_password" + payPassword
                + "where id='" + UserManager.getCurrentUser().getId() + "'";
    }
}