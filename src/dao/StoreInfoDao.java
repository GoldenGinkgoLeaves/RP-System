package dao;

import pojo.Store;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class StoreInfoDao extends UserInfoDao {

    public StoreInfoDao(Store store) {
        super(store);
    }

    public StoreInfoDao() {
        super();
    }

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

    public Store getStoreInfo(int storeId) {
        return new Store();
    }
}
