package timesheets.clicktime;

import timesheets.clicktime.base.BaseClicktime;
import timesheets.clicktime.common.CT_URLS;
import timesheets.clicktime.common.JsonHelper;
import timesheets.clicktime.helper.APIReader;
import timesheets.clicktime.helper.Session;
import timesheets.clicktime.pojo.TimeEntryDetails;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
public class TimesheetInfo extends BaseClicktime{
	
	//Main method to test.
	public static void main1(String... args) {
		USERS.forEach(i -> {
			APIReader reader = APIReader.openConnection(i);
			System.out.println(getTasks(reader).size());
			getTasks(reader).forEach((x,y)-> System.out.println("key : " + x + " , value : " + y));
		});
	}
	
	//TODO : Need to add logic _ In progress
	// Map<String, Map<String, Pair<Double, Double>>> should be the return type. 
	// Outer map will hold username as a key and value as map.
	// The value map will contain date as a key and Pair as a value.
	// first value of pair will contain billable hour and second value of pair will contain Time OFF hours such as PTO, company holiday hours.
	public static Map<String, Map<String, List<String>>> getBillableHours(String dateFrom, String dateTo) {
		USERS.forEach(i -> {
			APIReader reader = APIReader.openConnection(i);
			Session session = reader.getSession();
			String entries = reader.execute(formatUrl(CT_URLS.TIME_ENTRIES_FROM_TO_DATE.getUrl(), session.getCompanyID(), session.getUserID(), dateFrom, dateTo));
			// TODO
			//List<Double> billableHours = (List<Double>) JsonHelper.readJson(entries, "$[*].TimeEntries[*].Hours");
			//billableHours.forEach(j -> System.out.println("Hours : " + j));
			
//			JSONArray objects = (JSONArray) JsonHelper.readJson(entries, "$[*]");
//			for(int j=0; j < objects.size(); j++) {
//				objects.get(0)
//				Map<String, List<String>> dateWiseTimeSheet = new HashMap<>();
//			}
			TypeReference<List<TimeEntryDetails>> mapType = new TypeReference<List<TimeEntryDetails>>() {};
			List<TimeEntryDetails> entryList = JsonHelper.jsonToObjectList(entries, mapType);
			entryList.forEach(k -> System.out.println(k.toString()));
		});
		return null;
	}
	
	public static void main(String[] args) {
		getBillableHours("20180501", "20180503");
	}
}
