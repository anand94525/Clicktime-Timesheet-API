package timesheets.clicktime;

import timesheets.clicktime.base.BaseClicktime;
import timesheets.clicktime.helper.APIReader;

import java.util.List;
import java.util.Map;
public class TimesheetInfo extends BaseClicktime{
	
	//Main method to test.
	public static void main(String... args) {
		USERS.forEach(i -> {
			APIReader reader = APIReader.openConnection(i);
			System.out.println(getTasks(reader).size());
			getTasks(reader).forEach((x,y)-> System.out.println("key : " + x + " , value : " + y));
		});
	}
	
	//TODO : Need to add logic
	public static Map<String, Map<String, List<String>>> getBillableHours(String dateFrom, String dateTo) {
		return null;
	}
}
