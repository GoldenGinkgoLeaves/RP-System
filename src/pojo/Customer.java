package pojo;

import dao.CustomerInfoDao;

import java.util.List;

public class Customer extends User {
    private double balance;
    private String path;
    private List<Document> myDocuments;
    private Store defaultStore;
    private String payPassword;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<Document> getMyDocuments() {
        return myDocuments;
    }

    public void setMyDocuments(List<Document> myDocuments) {
        this.myDocuments = myDocuments;
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

    public void setPayPassword(String payPassword) {
        this.payPassword = payPassword;
        new CustomerInfoDao().setPayPassword(payPassword);
    }
}
