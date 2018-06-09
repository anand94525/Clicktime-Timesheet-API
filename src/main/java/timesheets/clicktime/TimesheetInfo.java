package timesheets.clicktime;

import timesheets.clicktime.base.BaseClicktime;
import timesheets.clicktime.common.CT_URLS;
import timesheets.clicktime.common.JsonHelper;
import timesheets.clicktime.helper.APIReader;
import timesheets.clicktime.helper.Session;
import timesheets.clicktime.helper.TimesheetInfoHelper;
import timesheets.clicktime.pojo.TimeEntryDetails;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.commons.lang3.tuple.Pair;
import com.fasterxml.jackson.core.type.TypeReference;

public class TimesheetInfo extends BaseClicktime{
	
	//Main method to test.
	public static void main1(String... args) {
		USERS.forEach(i -> {
			APIReader reader = APIReader.openConnection(i);
			System.out.println(getTasks(reader).size());
			getTasks(reader).forEach((x,y)-> System.out.println("key : " + x + " , value : " + y));
		});
	}
	
	//TODO : Need to add logic for filtering billable hours only. Also, Need to refactor code.
	// Map<String, Map<String, Pair<Double, Double>>> should be the return type. 
	// Outer map will hold username as a key and value as map.
	// The value map will contain date as a key and Pair as a value.
	// first value of pair will contain billable hour and second value of pair will contain Time OFF hours such as PTO, company holiday hours.
	public static Map<String, Map<String, Pair<Double, Double>>> getBillableHours(String dateFrom, String dateTo) {
		Map<String, Map<String, Pair<Double, Double>>> userwiseTimeSheet = new ConcurrentHashMap<>();
		USERS.forEach(i -> {
			APIReader reader = APIReader.openConnection(i);
			Session session = reader.getSession();
			String entries = reader.execute(formatUrl(CT_URLS.TIME_ENTRIES_FROM_TO_DATE.getUrl(), session.getCompanyID(), session.getUserID(), dateFrom, dateTo));
			
			TypeReference<List<TimeEntryDetails>> mapType = new TypeReference<List<TimeEntryDetails>>() {};
			List<TimeEntryDetails> entryList = JsonHelper.jsonToObjectList(entries, mapType);
			Map<String, Pair<Double, Double>> datewiseEntries = TimesheetInfoHelper.getDatewiseTimeEntries(entryList);
			userwiseTimeSheet.put(i.getUsername(), datewiseEntries);
		});
		return userwiseTimeSheet;
	}
	
	public static Map<String, Map<String, Pair<Double, Double>>> getBillableHours(String dateFrom) {
		return getBillableHours(dateFrom, dateFrom);
	}

	public static void main(String[] args) {
		Map<String, Map<String, Pair<Double, Double>>> map = getBillableHours("20180502");
		for (Entry<String, Map<String, Pair<Double, Double>>> entry : map.entrySet()) {
			entry.getValue().forEach((i, j) -> System.out.println("User :: " + entry.getKey() + "::: Date :" + i + " Working hours :" + j.getLeft() + " ::: Off hours :" + j.getRight()));
		}
	}
}
