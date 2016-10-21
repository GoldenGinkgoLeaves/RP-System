package pojo;

import java.util.Date;
import java.util.List;

public class Order implements Comparable<Order> {

    private int id = 0;//id=0代表还未加入数据库
    private Customer customer;
    private Store store;
    private double price;
    private String code;
    private boolean isPickedUp = false;
    private String evaluation;
    //在这个类中删除了打印类型
    private List<Document> documents;
    private long createTime;

    /**
     * 构造方法，订单生成后一般不允许对其信息进行更改，必须需要消费者，商店和文件列表
     * 在此之中对验证码及逆行自动生成，以及记录订单创建时间
     * 这个构造方法用于创建一个从未被创建过的订单
     *
     * @param customer  消费者
     * @param store     商店
     * @param documents 文件列表
     */
    public Order(Customer customer, Store store, List<Document> documents) {
        this.customer = customer;
        this.store = store;
        this.documents = documents;
        for (Document document : documents) {
            if (document.getPrintType() == Document.PRINT_BLACK) {
                price += document.getPages() * document.getNumberOfCopies() * store.getPriceBlack();
            } else {
                price += document.getPages() * document.getNumberOfCopies() * store.getPriceColor();
            }
        }
        generateCode();
        createTime = new Date().getTime();
    }

    /**
     * 这个构造方法用于从数据库中读取订单信息时使用
     */
    public Order(int id, Customer customer, Store store, double price, String code,
                 boolean isPickedUp, String evaluation, List<Document> documents, long createTime) {
        this.id = id;
        this.customer = customer;
        this.store = store;
        this.price = price;
        this.code = code;
        this.isPickedUp = isPickedUp;
        this.evaluation = evaluation;
        this.documents = documents;
        this.createTime = createTime;
    }

    public String getCode() {
        return code;
    }

    private void generateCode() {
        for (int i = 0; i < 6; i++) {
            code += (int) (Math.random() * 10);
        }
    }

    public Customer getCustomer() {
        return customer;
    }

    public Store getStore() {
        return store;
    }

    public double getPrice() {
        return price;
    }

    public boolean isPickedUp() {
        return isPickedUp;
    }

    public boolean pickUp() {
        if (!isPickedUp) {
            isPickedUp = true;
            return true;
        } else return false;
    }

    public String getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(String evaluation) {
        this.evaluation = evaluation;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    /**
     * 这个是对订单进行按价格排序接口需要的方法
     */
    @Override
    public int compareTo(Order o) {
        if (price > o.getPrice()) return 1;
        else if (price == o.getPrice()) return 0;
        else return -1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getCreateTime() {
        return createTime;
    }
}
