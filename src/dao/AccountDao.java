package dao;

import pojo.Customer;
import pojo.Store;
import pojo.User;
import service.UserManager;
import util.DatabaseHelper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 这个Dao用于还在未登录状态，是关于登录或注册的账号查询等方面的用途
 * 另外两个关于用户的Dao确认当前用户已登录时可以调用
 */
public class AccountDao {
    /**
     * 用于判断当前输入账号的类型，还可能是错误账号
     */
    public int findAccountType(String account) {
        if (findAccountInCustomer(account)) {
            return UserManager.TYPE_CUSTOMER;
        } else if (findAccountInStore(account)) {
            return UserManager.TYPE_STORE;
        } else {
            return UserManager.NO_SUCH_ACCOUNT;
        }
    }

    /**
     * 根据输入的账号和用户类型获得密码
     */
    public String queryPasswordByAccount(int userType, String account) {
        String sql;
        if (userType == UserManager.TYPE_CUSTOMER) {
            sql = "select password from customer where account=" + account;
        } else {
            sql = "select password from store where account=" + account;
        }
        ResultSet resultSet = DatabaseHelper.executeQuery(sql);
        String password = null;
        try {
            if (resultSet != null && resultSet.next()) {
                password = resultSet.getString("password");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return password;
    }

    /**
     * 往消费者或店家表中添加一条记录，传入类型和用户对象
     */
    public void addNewUserAccount(int userType, User user) {
        String sql;
        if (userType == UserManager.TYPE_CUSTOMER) {
            sql = "insert into customer(account,password,pay_password) values('" + user.getAccount()
                    + "','" + user.getPassword()
                    + "','" + ((Customer) user).getPayPassword() + "')";
        } else {
            sql = "insert into store(account,password,name) values('" + user.getAccount()
                    + "','" + user.getPassword()
                    + "','" + ((Store) user).getName() + "')";
        }
        DatabaseHelper.executeUpdate(sql);
    }

    /**
     * 从消费者表中找账号
     */
    private boolean findAccountInCustomer(String account) {
        String sql = "select account from customer where account=" + account;
        ResultSet resultSet = DatabaseHelper.executeQuery(sql);
        try {
            if (resultSet != null && resultSet.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 从商店表中找账号
     */
    private boolean findAccountInStore(String account) {
        String sql = "select account from store where account=" + account;
        ResultSet resultSet = DatabaseHelper.executeQuery(sql);
        try {
            if (resultSet != null && resultSet.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}


