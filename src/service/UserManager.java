package service;

import dao.AccountDao;
import dao.CustomerInfoDao;
import dao.StoreInfoDao;
import pojo.Customer;
import pojo.Store;
import pojo.User;

/**
 * 一个全局的静态类，用以全局判断当前系统的使用者
 * 对账号的管理，包含用户登录和注册等的后台逻辑处理
 */
public class UserManager {
    private static User currentUser;
    public static int userType;

    public static boolean isLogined() {
        return currentUser != null;
    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(User currentUser) {
        UserManager.currentUser = currentUser;
    }

    public static boolean login(String account, String password) {
        if (isLoginInputValid(account, password)) {
            if (confirmAccountType(account) == AccountDao.TYPE_CUSTOMER) {
                if (isPasswordCorrect(AccountDao.TYPE_CUSTOMER, account, password)) {
                    Customer customer = new CustomerInfoDao().getCustomerInfoByAccount(account);
                    currentUser = customer;
                    userType = AccountDao.TYPE_CUSTOMER;
                } else return false;
            } else if (confirmAccountType(account) == AccountDao.TYPE_STORE) {
                if (isPasswordCorrect(AccountDao.TYPE_STORE, account, password)) {
                    Store store = new StoreInfoDao().getStoreInfoByAccount(account);
                    currentUser = store;
                    userType = AccountDao.TYPE_STORE;
                } else return false;
            }
            return true;
        }
        return false;
    }

    /**
     * 注意勿忘更新数据库
     */
    public static boolean register(User user, int type) {
        currentUser = user;
        userType = type;
        return true;
    }

    public static void logout() {
        currentUser = null;
        userType = AccountDao.NO_SUCH_ACCOUNT;
    }

    /**
     * 用于登录和注册时判断账号类型以及是否存在
     */
    private static int confirmAccountType(String account) {
        return new AccountDao().findAccountType(account);
    }

    private static boolean isPasswordCorrect(int userType, String account, String password) {
        return new AccountDao().queryPasswordByAccount(userType, account).equals(password);
    }

    private static boolean isLoginInputValid(String account, String password) {
        return account.length() >= 6 && password.length() >= 6;
    }

    private static boolean isRegisterInputValid(User user) {
        //TODO 注册时需要填入什么信息？
        return true;
    }

    public static int getUserType() {
        return userType;
    }
}
