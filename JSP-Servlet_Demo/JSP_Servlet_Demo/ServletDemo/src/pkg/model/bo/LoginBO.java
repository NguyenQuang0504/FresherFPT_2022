package pkg.model.bo;

import pkg.model.bean.UserBean;
import pkg.model.dao.UserDAO;

public class LoginBO {

    public boolean checkLoginInfo(UserBean user) {
        UserDAO userDAO = new UserDAO();
        UserBean userInfo = userDAO.getUserByUserName(user.getUserName());
        
        if (userInfo != null) {
            return true;
        } else {
            return false;
        }
    }
}
