package bean;

import java.util.ArrayList;
import java.util.List;

public class Account {

	
	private String userName;
	private String password;

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public static List showListUser() {
		List<Account> userList = new ArrayList<Account>();
		
		for (int i = 0; i < 2; i ++) {
			Account account = new Account();
			account.setUserName("account_" + i);
			account.setPassword("password_" + i);
			userList.add(account);
		}
		
		return userList;
	}
}
