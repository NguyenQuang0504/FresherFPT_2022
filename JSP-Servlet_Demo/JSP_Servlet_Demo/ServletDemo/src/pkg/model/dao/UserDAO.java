package pkg.model.dao;

import pkg.model.bean.UserBean;

public class UserDAO {

    
    public UserBean getUserByUserName(String userName) {
        //Call database, select thong tin user voi tham so userName
        
        //Gia su call thanh cong va gia tri tra ve nhu sau
        
        //Gia su userName ton tai trong DB
        if ("hieuvt8".equals(userName)) {
            String password = "hieuvt8"; //password lay tu database thong qua userName
            UserBean user = new UserBean();
            user.setUserName(userName);
            user.setPassword(password);
            return user;
        } else {
            return null;
        }
        
    }
}
