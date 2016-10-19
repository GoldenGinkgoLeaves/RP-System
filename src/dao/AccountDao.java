package dao;

import util.DatabaseHelper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 这个Dao用于还在未登录状态，是关于登录或注册的账号查询等方面的用途
 * 另外两个关于用户的Dao确认当前用户已登录时可以调用
 */
public class AccountDao {
    public static final int NO_SUCH_ACCOUNT = 0;
    public static final int TYPE_CUSTOMER = 1;
    public static final int TYPE_STORE = 2;

    /**
     * 用于判断当前输入账号到的类型，还可能是错误账号
     */
    public int findAccountType(String account) {
        if (findAccountInCustomer(account)) {
            return TYPE_CUSTOMER;
        } else if (findAccountInStore(account)) {
            return TYPE_STORE;
        } else {
            return NO_SUCH_ACCOUNT;
        }
    }

    public String queryPasswordByAccount(int userType, String account) {
        String sql;
        if (userType == TYPE_CUSTOMER) {
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
