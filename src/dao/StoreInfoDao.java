package dao;

import pojo.Order;
import pojo.Store;
import service.UserManager;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class StoreInfoDao extends UserInfoDao {

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

    //设置营业时间
    public void setBusinessHours(LocalTime begin, LocalTime end) {
    }

    //设置黑色打印价格
    public void setPriceBlack(double priceBlack) {
    }

    //设置彩印价格
    public void setPriceColor(double priceColor) {
    }

    //设置地址
    public void setAddress(String address) {
    }

    //修改盈利
    public void setProfit(double profit) {
    }

    //设置店名
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

    public Store getStoreInfoByAccount(String account) {
        return new Store();
    }
}
