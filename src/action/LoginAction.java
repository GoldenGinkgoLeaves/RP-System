package action;

import service.UserManager;

/**
 * Created by hurong1993 on 2016/10/20.
 */
public class LoginAction {
    public String account;
    public String password;
    public String login(){
        boolean result= UserManager.login(account,password);
        if (result){
            return "y";
        }
        else {
            return "n";
        }
    }
}
