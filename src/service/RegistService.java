package service;

import dao.RegistDao;
import pojo.Customer;

/**
 * Created by hurong1993 on 2016/10/19.
 */
public class RegistService {
    public RegistDao registDao=new RegistDao();
    public boolean treckAccount(Customer customer) {
        return registDao.treckAcount(customer);
    }

    public void customerRegist(Customer customer) {
        registDao.customerRegist(customer);
    }
}

