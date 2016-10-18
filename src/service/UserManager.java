package service;

import pojo.User;

/**
 * 一个全局的静态类，用以全局判断当前系统的使用者
 * 对账号的管理，包含用户登录和注册等的后台逻辑处理
 */
public class UserManager {
    private static User currentUser;

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(User currentUser) {
        UserManager.currentUser = currentUser;
    }

    public static void login(User user) {
        currentUser = user;
    }

    /**
     * 注意勿忘更新数据库
     */
    public static void register() {

    }

    public static void logout() {
    }
}
