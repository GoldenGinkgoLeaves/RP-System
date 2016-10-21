package pojo;

import dao.CustomerInfoDao;

import java.util.List;

public class Customer extends User {
    private double balance;
    private String path;
    private List<Document> myDocuments;
    private Store defaultStore;
    private String payPassword;

    /**
     * 登录注册时通过简略信息构造
     */
    public Customer(String account, String password, String payPassword) {
        super(account, password);
        this.payPassword = payPassword;
    }

    /**
     * 需要从数据库中获取用户信息时的构造，如：登录时获取用户信息，消费者查看商店信息
     */
    public Customer(int id, int type, String account, String password,
                    String introduction, String email, String telephone,
                    List<Order> completedOrders, double balance, String path,
                    List<Document> myDocuments, Store defaultStore, String payPassword) {
        super(id, type, account, password, introduction, email, telephone, completedOrders);
        this.balance = balance;
        this.path = path;
        this.myDocuments = myDocuments;
        this.defaultStore = defaultStore;
        this.payPassword = payPassword;
    }

    public void updateUserInfo(String password, String introduction, String email, String telephone,
                               String payPassword, Store defaultStore) {
        super.updateUserInfo(password, introduction, email, telephone);
        this.payPassword = payPassword;
        this.defaultStore = defaultStore;
    }

    public double getBalance() {
        return balance;
    }

    public String getPath() {
        return path;
    }

    public List<Document> getMyDocuments() {
        return myDocuments;
    }

    public Store getDefaultStore() {
        return defaultStore;
    }

    public void setDefaultStore(Store defaultStore) {
        this.defaultStore = defaultStore;
        new CustomerInfoDao().setDefaultStore(defaultStore);
    }

    public String getPayPassword() {
        return payPassword;
    }

}
