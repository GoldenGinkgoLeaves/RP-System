package pojo;

import java.util.List;

/**
 * 所有两类用户的父类，存储与处理用户的基本信息
 */
public abstract class User {
    private int type;//用于在针对父类的Dao方法中确定用户类型
    private int id;
    private String account;
    private String password;
    private String introduction;
    private String email;
    private String telephone;
    private List<Order> completedOrders;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public List<Order> getCompletedOrders() {
        return completedOrders;
    }

    public void setCompletedOrders(List<Order> completedOrders) {
        this.completedOrders = completedOrders;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
