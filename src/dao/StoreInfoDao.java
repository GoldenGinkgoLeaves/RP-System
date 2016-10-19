package dao;

import pojo.Order;
import pojo.Store;
import service.UserManager;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class StoreInfoDao extends UserInfoDao {
    private String name;
    private double priceBlack;//纯黑价格
    private double priceColor;//彩印价格
    private Store.BusinessHours businessHours;//营业时间
    private String address;//地址
    private double profit;//盈利
    private List<Order> ongoingOrders;//正在进行的订单

    public StoreInfoDao() {
        super();
    }

    /**
     * 查询所有店家信息，可用于消费者查看时使用
     */
    public List<Store> getAllStoresInfo() {
        List<Store> storeList = new ArrayList<>();
        return storeList;
    }

    public void setBusinessHours(LocalTime begin, LocalTime end) {
    }

    public void setPriceBlack(double priceBlack) {
    }

    public void setPriceColor(double priceColor) {
    }

    public void setAddress(String address) {
    }

    public void setProfit(double profit) {
    }

    public void setName(String name) {
    }

    /**
     * 向订单表中添加一个正在进行的订单
     */
    public void addOngoingOrder(Order ongoingOrder) {

    }

    /**
     * 将订单表中一个正在进行的订单设置为已完成
     */
    public void completeOngoingOrder(Order ongoingOrder) {

    }

    /**
     * 通过id查询店家信息
     */
    public Store getStoreInfoById(int storeId) {
        return new Store();
    }

    /**
     * 获得当前登录的店家的信息
     */
    public Store getLoginStoreInfo() {
        return getStoreInfoById(UserManager.getCurrentUser().getId());
    }

    public Store getStoreInfoByAccount(String account) {
        return new Store();
    }
}
