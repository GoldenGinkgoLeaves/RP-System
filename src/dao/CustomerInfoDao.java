package dao;

import pojo.Customer;
import pojo.Document;
import pojo.Order;
import pojo.Store;
import util.DatabaseHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerInfoDao extends UserInfoDao {

    public CustomerInfoDao(Customer customer) {
        super(customer);
    }

    public CustomerInfoDao() {
        super();
    }

//    public List<Customer> getAllCustomersInfo() {
//        List<Customer> customerList = new ArrayList<>();
//        return customerList;
//    }

    public void setBalance(double balance) {
    }

    public void setPath(String path) {
    }

    public void setDefaultStore(Store defaultStore) {
    }

    public Customer getCustomerInfo(int customerId) {
        String sql = "select * from customer where id=" + customerId;
        Customer customer = new Customer();
        ResultSet resultSet = DatabaseHelper.executeQuery(sql);
        try {
            if (resultSet != null && resultSet.next()) {
                customer.setId(resultSet.getInt("id"));
                customer.setAccount(resultSet.getString("account"));
                customer.setPassword(resultSet.getString("introduction"));
                customer.setEmail(resultSet.getString("email"));
                customer.setTelephone(resultSet.getString("telephone"));
                customer.setPath(resultSet.getString("path"));
                customer.setBalance(resultSet.getDouble("balance"));
                customer.setPayPassword(resultSet.getString("payPassword"));
                customer.setCompletedOrders(new OrderDao().getCustomerCompletedOrders());
                customer.setMyDocuments(new DocumentDao().getCustomerAllDocument());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new Customer();
    }

    private int id;
    private String account;
    private String password;
    private String introduction;
    private String email;
    private String telephone;
    private List<Order> completedOrders;
    private double balance;
    private String path;
    private List<Document> myDocuments;
    private Store defaultStore;
    private String payPassword;
}