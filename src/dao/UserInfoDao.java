package dao;

import pojo.Order;
import pojo.Store;
import pojo.User;
import service.UserManager;

import java.util.ArrayList;
import java.util.List;

/**
 * 这是一个修改消费者和店家信息的数据库访问接口父类，提供一些消费者店家共有类型数据的数据库访问接口
 * 是一个抽象类，子类中可以调用这里的方法
 */
abstract class UserInfoDao {
    private User user;

    UserInfoDao() {
        user = UserManager.getCurrentUser();
    }

    public void setAccount() {
    }

    public void setPassword(String password) {
    }

    public void setIntroduction(String introduction) {
    }

    public void setEmail(String email) {
    }

    public void setTelephone(String telephone) {
    }

    public List<Order> getCompletedOrders() {
        List<Order> completedOrders = new ArrayList<>();
        return completedOrders;
    }
}
