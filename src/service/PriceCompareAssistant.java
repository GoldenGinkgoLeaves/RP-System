package service;

import dao.StoreInfoDao;
import pojo.Document;
import pojo.Order;
import pojo.Store;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 比价助手，可以得到当前选定文件下低价（订单）店家的排序
 * 在这里传入待打印列表，为每家店生成虚拟订单
 * 对虚拟订单按价格排序，根据排序的订单可以得到店家价格等需要展示的信息
 */
public class PriceCompareAssistant {
    List<Document> documentsToBePrinted;
    List<Store> availableStores;
    List<Order> orderList;

    public List<Order> getCheapestOrder(List<Document> documentsToBePrinted) {
        this.documentsToBePrinted = documentsToBePrinted;
        availableStores = new StoreInfoDao().getAllStoresInfo();
        orderList = new ArrayList<>();
        for (Store store : availableStores) {
            orderList.add(new Order(null, store, documentsToBePrinted));
        }
        Collections.sort(orderList);
        return orderList;
    }
}
