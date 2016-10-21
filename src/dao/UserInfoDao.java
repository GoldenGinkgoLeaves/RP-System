package dao;

import pojo.Order;
import pojo.Store;
import pojo.User;
import service.UserManager;
import util.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * 这是一个修改消费者和店家信息的数据库访问接口父类，提供一些消费者店家共有类型数据的数据库访问接口
 * 是一个抽象类，子类中可以调用这里的方法
 * 在构造这个Dao的时候就已经确定操作的是当前登录用户，当然也包含不针对此用户的操作
 */
public class UserInfoDao {
    private User user;

    /**
     * 构造时即获取当前用户
     */
    public UserInfoDao() {
        user = UserManager.getCurrentUser();
    }

    /**
     * @return 获得用户已完成订单列表
     */
    public List<Order> getCompletedOrders() {
        if (user.getType() == UserManager.TYPE_CUSTOMER) {
            return new OrderDao().getCustomerCompletedOrders();
        } else {
            return new OrderDao().getStoreCompletedOrders();
        }
    }

    /**
     * @return 获取用户未完成订单列表
     */
    public List<Order> getOngoingOrders() {
        if (user.getType() == UserManager.TYPE_CUSTOMER) {
            return new OrderDao().getCustomerOngoingOrders();
        } else {
            return new OrderDao().getStoreOngoingOrders();
        }
    }

    /**
     * 设置账号
     */
    public void setAccount(String account) {
        String sql;
        if (user.getType() == UserManager.TYPE_CUSTOMER) {
            sql = "update customer set account=" + account + "where id=" + user.getId();
        } else {
            sql = "update store set account=" + account + "where id=" + user.getId();
        }
        DatabaseHelper.executeUpdate(sql);
    }

    /**
     * 设置密码
     */
    public void setPassword(String password) {
        String sql;
        if (user.getType() == UserManager.TYPE_CUSTOMER) {
            sql = "update customer set password=" + password + "where id=" + user.getId();
        } else {
            sql = "update store set password=" + password + "where id=" + user.getId();
        }
        DatabaseHelper.executeUpdate(sql);
    }

    /**
     * 设置介绍
     */
    public void setIntroduction(String introduction) {
        String sql;
        if (user.getType() == UserManager.TYPE_CUSTOMER) {
            sql = "update customer set introduction=" + introduction + "where id=" + user.getId();
        } else {
            sql = "update store set introduction=" + introduction + "where id=" + user.getId();
        }
        DatabaseHelper.executeUpdate(sql);
    }

    /**
     * 设置电子邮件
     */
    public void setEmail(String email) {
        String sql;
        if (user.getType() == UserManager.TYPE_CUSTOMER) {
            sql = "update customer set email=" + email + "where id=" + user.getId();
        } else {
            sql = "update store set email=" + email + "where id=" + user.getId();
        }
        DatabaseHelper.executeUpdate(sql);
    }

    /**
     * 设置电话
     */
    public void setTelephone(String telephone) {
        String sql;
        if (user.getType() == UserManager.TYPE_CUSTOMER) {
            sql = "update customer set telephone=" + telephone + "where id=" + user.getId();
        } else {
            sql = "update store set telephone=" + telephone + "where id=" + user.getId();
        }
        DatabaseHelper.executeUpdate(sql);
    }

}
