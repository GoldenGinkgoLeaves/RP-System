package dao;

import pojo.Order;
import pojo.Store;
import pojo.User;

import java.util.ArrayList;
import java.util.List;

/**
 * 这是一个修改消费者和店家信息的数据库访问接口父类，提供一些消费者店家共有类型数据的数据库访问接口
 */
abstract class UserInfoDao {
    private User user;

    UserInfoDao(User user) {
        this.user = user;
    }

    UserInfoDao() {
    }

    /**
     * 在操作单个用户的数据信息时，需要先设定当前用户
     *
     * @param user 当前操作的用户
     */
    public void setCurrentUser(User user) {
        this.user = user;
    }

    public void setName(String name) {
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
