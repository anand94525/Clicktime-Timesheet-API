package timesheets.clicktime.base;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashSet;
import java.util.Properties;
import java.util.Set;

import timesheets.clicktime.UserInfo;

public class Users {
	 protected static final Set<UserInfo> USERS = new LinkedHashSet<>();;
	 static {
	        InputStream is = null;
	        try {
	            Properties prop = new Properties();
	            is = Users.class.getResourceAsStream("UserInfo.properties");
	            prop.load(is);
	            
	            prop.entrySet().forEach(i-> {
	            	UserInfo userInfo = new UserInfo(i.getKey(), i.getValue());
	            	USERS.add(userInfo);
	            	USERS.size();
	            });
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
}
