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
    public static final int NO_SUCH_ACCOUNT = 0;
    public static final int TYPE_CUSTOMER = 1;
    public static final int TYPE_STORE = 2;

    private static User currentUser;
    public static int userType;

    //是否有用户登录
    public static boolean isLogined() {
        return currentUser != null;
    }

    //获取当前登录用户对象，未登录时返回null
    public static User getCurrentUser() {
        return currentUser;
    }

    //获取当前登录用户类型
    public static int getUserType() {
        return userType;
    }

    /**
     * 用户登录，可以自动识别是消费者或商店
     *
     * @param account  账号
     * @param password 密码
     * @return 是否登录成功
     */
    public static boolean login(String account, String password) {
        if (isLoginInputValid(account, password)) {
            if (confirmAccountType(account) == TYPE_CUSTOMER) {
                if (isPasswordCorrect(TYPE_CUSTOMER, account, password)) {
                    Customer customer = new CustomerInfoDao().getCustomerInfoByAccount(account);
                    setCurrentUser(customer, TYPE_CUSTOMER);
                } else return false;
            } else if (confirmAccountType(account) == TYPE_STORE) {
                if (isPasswordCorrect(TYPE_STORE, account, password)) {
                    Store store = new StoreInfoDao().getStoreInfoByAccount(account);
                    setCurrentUser(store, TYPE_STORE);
                } else return false;
            } else return false;
            return true;
        }
        return false;
    }

    /**
     * 消费者注册时调用
     * 逻辑为注册成功后自动登录
     * 建议网页上设置账号，密码，支付密码（或是商店名），其他信息在个人中心设置
     */
    public static boolean registerCustomer(Customer customer) {
        if (isCustomerRegisterInputValid(customer) && confirmAccountType(customer.getAccount()) == NO_SUCH_ACCOUNT) {
            new AccountDao().addNewUserAccount(TYPE_CUSTOMER, customer);
            setCurrentUser(customer, TYPE_CUSTOMER);
            return true;
        } else return false;
    }

    /**
     * 店家注册时调用
     * 逻辑为注册成功后自动登录
     * 建议网页上设置账号，密码，商店名，其他信息在个人中心设置
     */
    public static boolean registerStore(Store store) {
        if (isStoreRegisterInputValid(store) && confirmAccountType(store.getAccount()) == NO_SUCH_ACCOUNT) {
            new AccountDao().addNewUserAccount(TYPE_STORE, store);
            setCurrentUser(store, TYPE_STORE);
            return true;
        } else return false;
    }

    /**
     * 退出登录调用
     */
    public static void logout() {
        setCurrentUser(null, NO_SUCH_ACCOUNT);
    }

    /**
     * 用于登录和注册时判断账号类型以及是否存在
     */
    private static int confirmAccountType(String account) {
        return new AccountDao().findAccountType(account);
    }

    /**
     * 用于登录时判断密码是否正确
     *
     * @param userType 用户类型，消费者或商家
     */
    private static boolean isPasswordCorrect(int userType, String account, String password) {
        return new AccountDao().queryPasswordByAccount(userType, account).equals(password);
    }

    /**
     * 用于登录时判断用户输入是否合法
     */
    private static boolean isLoginInputValid(String account, String password) {
        return account.length() >= 6 && password.length() >= 6;
    }

    /**
     * 以下两个方法用于注册时判断用户输入是否合法
     *
     * @param customer 为方便操作，传入用户对象
     */
    private static boolean isCustomerRegisterInputValid(Customer customer) {
        return customer.getAccount().length() >= 6 && customer.getPassword().length() >= 6
                && customer.getPayPassword().length() >= 6;
    }

    private static boolean isStoreRegisterInputValid(Store store) {
        return store.getAccount().length() >= 6 && store.getPassword().length() >= 6
                && store.getName().length() >= 1;
    }

    /**
     * 当登录或突出登录时设置静态信息
     *
     * @param user 用户对象，退出登录时设为null
     * @param type 用户类型，退出登录时设为NO_SUCH_ACCOUNT
     */
    private static void setCurrentUser(User user, int type) {
        currentUser = user;
        userType = type;
    }

}
