package timesheets.clicktime.base;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashSet;
import java.util.Properties;
import java.util.Set;

import timesheets.clicktime.pojo.UserInfo;

public class BaseClicktime {
	 protected static final Set<UserInfo> USERS = new LinkedHashSet<>();;
	 static {
	        InputStream is = null;
	        try {
	            Properties prop = new Properties();
	            is = BaseClicktime.class.getResourceAsStream("/timesheets/clicktime/resources/UserInfo.properties");
	            prop.load(is);
	            
	            prop.entrySet().forEach(i-> {
	            	UserInfo userInfo = new UserInfo(i.getKey(), i.getValue());
	            	USERS.add(userInfo);
	            	USERS.size();
	            });
	        } catch (IOException e) {
	        }
	    }
}
