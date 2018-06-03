package timesheets.clicktime;

import timesheets.clicktime.base.Users;
import timesheets.clicktime.base.Tasks;
import timesheets.clicktime.common.CT_URLS;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import timesheets.clicktime.APIReader;
import timesheets.clicktime.Session;
public class TimesheetInfo extends Users{
	
	private Map<String, String> getTasks(APIReader apiReader) {
		Session session = apiReader.getSession();
		String tasks = apiReader.execute(String.format(CT_URLS.TASKS.getUrl(), session.getCompanyID(), session.getUserID()));
		System.out.println("User id is =>  " + tasks);
		return null;
	}

	public static void main(String... args) {
		USERS.forEach(i -> {
			APIReader reader = APIReader.openConnection(i);
			Session session = reader.getSession();
			String tasks = reader.execute(String.format(CT_URLS.TASKS.getUrl(), session.getCompanyID(), session.getUserID()));
			//TODO : Mapping not working, need to check.
			List<Tasks> map = new Gson().fromJson(tasks, new TypeToken<List<Tasks>>(){}.getType());
			//TODO : AS: Need to fix it.
			Map<String, String> taskIdNameMap = map.stream().collect(Collectors.toMap(Tasks::getTaskID, Tasks::getDisplayName));
			//map.forEach((x,y)-> System.out.println("key : " + x + " , value : " + y));
			System.out.println("User id is =>  " + tasks);
		});
	}
	
//	public static Map<String, Map<String, List<String>>> getBillableHours(String dateFrom, String dateTo) {
//		
//	}
}
