package dao;

import pojo.Customer;
import util.DatabaseHelper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by hurong1993 on 2016/10/19.
 */
public class RegistDao {
    public boolean treckAcount(Customer customer) {
        String sql="select * from customer where account='"+ customer.getAccount()+"'";
        ResultSet rs = DatabaseHelper.executeQuery(sql);
        try {
            if (rs.next()){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void customerRegist(Customer customer) {
        String sql = "insert into customer(id,account,password,telephone)values('"+ customer.getId()+"','"+ customer.getAccount()+"','"+ customer.getPassword()+"','"+ customer.getTelephone()+"')";
        DatabaseHelper.executeUpdate(sql);
    }
}
