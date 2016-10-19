package pojo;

import java.util.List;

public class Order implements Comparable<Order> {

    private Customer customer;
    private Store store;

    public void setCode(String code) {
        this.code = code;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    private double price;
    private String code;
    private boolean isPickedUp;
    private String evaluation;
    //在这个类中删除了打印类型
    private List<Document> documents;

    //构造方法，必须需要消费者，商店和文件列表
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
    }

    public String getCode() {
        return code;
    }

    private void generateCode() {
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

    public boolean pickUp(boolean pickedUp) {
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

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

    @Override
    public int compareTo(Order o) {
        if (price > o.getPrice()) return 1;
        else if (price == o.getPrice()) return 0;
        else return -1;
    }
}
