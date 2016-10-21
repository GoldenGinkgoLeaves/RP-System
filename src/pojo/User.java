package pojo;

import java.util.List;

/**
 * 所有两类用户的父类，存储与处理用户的基本信息
 */
public abstract class User {
    private int id;
    private int type;//用于在针对父类的Dao方法中确定用户类型
    private String account;
    private String password;
    private String introduction;
    private String email;
    private String telephone;
    private List<Order> completedOrders;

    /**
     * 登录注册时通过简略信息构造
     */
    public User(String account, String password) {
        this.account = account;
        this.password = password;
    }

    /**
     * 需要从数据库中获取用户信息时的构造，如：登录时获取用户信息，消费者查看商店信息
     */
    public User(int id, int type, String account, String password,
                String introduction, String email, String telephone, List<Order> completedOrders) {
        this.id = id;
        this.type = type;
        this.account = account;
        this.password = password;
        this.introduction = introduction;
        this.email = email;
        this.telephone = telephone;
        this.completedOrders = completedOrders;
    }

    public void updateUserInfo(String password, String introduction, String email, String telephone) {
        this.password = password;
        this.introduction = introduction;
        this.email = email;
        this.telephone = telephone;
    }

    public String getAccount() {
        return account;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephone() {
        return telephone;
    }

    public List<Order> getCompletedOrders() {
        return completedOrders;
    }

    public String getIntroduction() {
        return introduction;
    }

    public int getId() {
        return id;
    }

    public int getType() {
        return type;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setType(int type) {
        this.type = type;
    }
}
