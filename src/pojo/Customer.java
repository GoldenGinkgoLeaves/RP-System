package pojo;

import java.util.List;

public class Customer extends User {
    private double balance;
    private String path;
    private List<Document> myDocuments;
    private List<Store> oftenUsedStores;
    private Store defaultStore;
    private String payPassword;

    /**
     * 在文件管理页面添加一些待打印文件
     */
    public void addSomeDocument(List<Document> documents) {

    }

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

    public List<Store> getOftenUsedStores() {
        return oftenUsedStores;
    }

    public void setOftenUsedStores(List<Store> oftenUsedStores) {
        this.oftenUsedStores = oftenUsedStores;
    }

    public Store getDefaultStore() {
        return defaultStore;
    }

    public void setDefaultStore(Store defaultStore) {
        this.defaultStore = defaultStore;
    }

    public String getPayPassword() {
        return payPassword;
    }

    public void setPayPassword(String payPassword) {
        this.payPassword = payPassword;
    }
}
