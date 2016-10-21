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
        return fillCustomerInfo(sql);
    }

    /**
     * 用于在登录时根据账号获得消费者信息
     */
    public Customer getCustomerInfoByAccount(String account) {
        String sql = "select * from customer where account=" + account;
        return fillCustomerInfo(sql);
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

    //私有方法，根据查询结果构造一个customer对象
    private Customer fillCustomerInfo(String sql) {
        ResultSet resultSet = DatabaseHelper.executeQuery(sql);
        Customer customer = new Customer();
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

}