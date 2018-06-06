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
	 
	 protected static Map<String, String> getTasks(APIReader apiReader) {
		Map<String, String> allTasks = new HashMap<>();
		Session session = apiReader.getSession();
		String tasks = apiReader.execute(String.format(CT_URLS.TASKS.getUrl(), session.getCompanyID(), session.getUserID()));
		allTasks.putAll(((List<Tasks>)JsonHelper.jsonToList(tasks, Tasks.class)).stream().collect(Collectors.toMap(Tasks::getTaskID, Tasks::getDisplayName)));
		
		String tasks1 = apiReader.execute(String.format(CT_URLS.TIME_OFF_TYPES.getUrl(), session.getCompanyID(), session.getUserID()));
		allTasks.putAll(((List<TimeOffTypes>)JsonHelper.jsonToList(tasks1, TimeOffTypes.class)).stream().collect(Collectors.toMap(TimeOffTypes::getTimeOffTypeID, TimeOffTypes::getName)));

		return allTasks;
	}
	 
	 protected static String formatUrl(String url, Object... params) {
		 return String.format(url, params);
	 }
}
