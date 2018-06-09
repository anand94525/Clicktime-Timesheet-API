package timesheets.clicktime.base;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.stream.Collectors;

import timesheets.clicktime.common.CT_URLS;
import timesheets.clicktime.common.JsonHelper;
import timesheets.clicktime.helper.APIReader;
import timesheets.clicktime.helper.Session;
import timesheets.clicktime.pojo.Tasks;
import timesheets.clicktime.pojo.TimeOffTypes;
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
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
}
