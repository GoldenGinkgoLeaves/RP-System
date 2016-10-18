package pojo;

import dao.StoreInfoDao;

import java.time.LocalTime;
import java.util.List;

public class Store extends User {
    private String name;
    private double priceBlack;//纯黑价格
    private double priceColor;//彩印价格
    private BusinessHours businessHours;//营业时间
    private String address;//地址
    private double profit;//盈利
    private List<Order> ongoingOrders;//正在进行的订单


    public double getPriceBlack() {
        return priceBlack;
    }

    public void setPriceBlack(double priceBlack) {
        this.priceBlack = priceBlack;
    }

    public double getPriceColor() {
        return priceColor;
    }

    public void setPriceColor(double priceColor) {
        this.priceColor = priceColor;
    }

    public BusinessHours getBusinessHours() {
        return businessHours;
    }

    public void setBusinessHours(BusinessHours businessHours) {
        this.businessHours = businessHours;
    }


    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    public List<Order> getOngoingOrders() {
        return ongoingOrders;
    }

    public void setOngoingOrders(List<Order> ongoingOrders) {
        this.ongoingOrders = ongoingOrders;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 对营业时间的一些处理，包括设定营业时间和判断当前时间是否在营业时间内
     */
    public class BusinessHours {
        private LocalTime beginTime;
        private LocalTime endTime;

        public BusinessHours(LocalTime beginTime, LocalTime endTime) {
            this.beginTime = beginTime;
            this.endTime = endTime;
        }

        public BusinessHours() {
            beginTime = LocalTime.parse("00:00:00");
            endTime = LocalTime.parse("23:59:59");
        }

        public void setBusinessHours(String begin, String end) {
            beginTime = LocalTime.parse(begin);
            endTime = LocalTime.parse(end);
            new StoreInfoDao().setBusinessHours(beginTime, endTime);
        }

        public void setBusinessHours(LocalTime begin, LocalTime end) {
            beginTime = begin;
            endTime = end;
            new StoreInfoDao().setBusinessHours(beginTime, endTime);
        }

        boolean inBusinessHours() {
            LocalTime currentTime = LocalTime.now();
            return currentTime.isAfter(beginTime) && currentTime.isBefore(endTime);
        }
    }
}
