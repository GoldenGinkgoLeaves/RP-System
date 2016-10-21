package dao;

import pojo.Order;
import pojo.Store;
import service.UserManager;
import util.DatabaseHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class StoreInfoDao extends UserInfoDao {

    public StoreInfoDao() {
        super();
    }

    /**
     * 从数据库计算获得盈利，一般情况下直接从对象中获取
     */
    public double getProfit() {
        String sql = "select sum(price) as sum_of_profit from `order` where store_id=" + UserManager.getCurrentUser().getId();
        ResultSet resultSet = DatabaseHelper.executeQuery(sql);
        double profit = 0;
        try {
            if (resultSet != null && resultSet.next()) {
                profit = resultSet.getDouble("sum_of_profit");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return profit;
    }

    /**
     * 查询所有店家信息，可用于消费者查看时使用
     */
    public List<Store> getAllStoresInfo() {
        String sql = "select * from store";
        return fillStoreInfo(sql);
    }

    /**
     * 通过id查询店家信息
     */
    public Store getStoreInfoById(int storeId) {
        String sql = "select * from store where id=" + storeId;
        return fillStoreInfo(sql).get(0);
    }

    /**
     * 通过账号查询店家信息，可用于登录时
     */
    public Store getStoreInfoByAccount(String account) {
        String sql = "select * from store where account" + account;
        return fillStoreInfo(sql).get(0);
    }

    /**
     * 用ResultSet构造一个Store对象
     */
    private List<Store> fillStoreInfo(String sql) {
        ResultSet resultSet = DatabaseHelper.executeQuery(sql);
        List<Store> stores = new ArrayList<>();
        try {
            while (resultSet != null && resultSet.next()) {
                Store store = new Store();
                store.setId(resultSet.getInt("id"));
                store.setAccount(resultSet.getString("account"));
                store.setPassword(resultSet.getString("introduction"));
                store.setEmail(resultSet.getString("email"));
                store.setTelephone(resultSet.getString("telephone"));
                store.setName(resultSet.getString("name"));
                store.setPriceBlack(resultSet.getDouble("black_price"));
                store.setPriceColor(resultSet.getDouble("color_price"));
                LocalTime begin = LocalTime.parse(resultSet.getString("begin_time"));
                LocalTime end = LocalTime.parse(resultSet.getString("end_time"));
                store.setBusinessHours(new Store.BusinessHours(begin, end));
                store.setAddress(resultSet.getString("address"));
                store.setProfit(getProfit());
                stores.add(store);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stores;
    }

    //设置营业时间
    public void setBusinessHours(LocalTime beginTime, LocalTime endTime) {
        String begin = beginTime.getHour() + ":" + beginTime.getMinute();
        String end = endTime.getHour() + ":" + endTime.getMinute();
        String sql = "update store set begin_time='" + begin + "' ,end_time='" + end
                + "' where id=" + UserManager.getCurrentUser().getId();
        DatabaseHelper.executeUpdate(sql);
    }

    //设置黑色打印价格
    public void setPriceBlack(double priceBlack) {
        String sql = "update store set black_price=" + priceBlack
                + "where id=" + UserManager.getCurrentUser().getId();
        DatabaseHelper.executeUpdate(sql);
    }

    //设置彩印价格
    public void setPriceColor(double priceColor) {
        String sql = "update store set color_price=" + priceColor
                + "where id=" + UserManager.getCurrentUser().getId();
        DatabaseHelper.executeUpdate(sql);
    }

    //设置地址
    public void setAddress(String address) {
        String sql = "update store set address=" + address
                + "where id=" + UserManager.getCurrentUser().getId();
        DatabaseHelper.executeUpdate(sql);
    }

    //设置店名
    public void setName(String name) {
        String sql = "update store set name=" + name
                + "where id=" + UserManager.getCurrentUser().getId();
        DatabaseHelper.executeUpdate(sql);
    }

}
