package timesheets.clicktime.helper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import org.apache.commons.lang3.mutable.MutableDouble;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import com.fasterxml.jackson.core.type.TypeReference;

import timesheets.clicktime.common.CT_URLS;
import timesheets.clicktime.common.JsonHelper;
import timesheets.clicktime.pojo.Session;
import timesheets.clicktime.pojo.Tasks;
import timesheets.clicktime.pojo.TimeEntryDetails;
import timesheets.clicktime.pojo.TimeOffTypes;
import timesheets.clicktime.pojo.UserInfo;

public class TimesheetInfoHelper {
	
	public static Map<String, Pair<Double, Double>> getDatewiseTimeEntriesMap(List<TimeEntryDetails> entryList, Map<String, String> tasks) {
		Map<String, Pair<Double, Double>> datewiseEntries = new ConcurrentHashMap<>();
		//entryList.forEach(j -> System.out.println(k.toString()));
		entryList.forEach(j -> {
			//Need to refactor, remove duplicate for loops
			MutableDouble timeEntries = new MutableDouble(0);
			j.getTimeEntries().forEach(timeEntry -> {
				if(tasks.containsKey(timeEntry.getTaskID())) {
					timeEntries.add(timeEntry.getHours());
				}
			});
			
			MutableDouble timeOffEntries = new MutableDouble(0);
			j.getTimeOffEntries().forEach(timeOffEntry -> {
				if(tasks.containsKey(timeOffEntry.getTimeOffEntryID())) {
					timeOffEntries.add(timeOffEntry.getHours());
				}
			});
			
			Pair<Double, Double> timeOnAndOffEntries = new ImmutablePair<>(timeEntries.doubleValue(), timeOffEntries.doubleValue());
			datewiseEntries.put(j.getDate(), timeOnAndOffEntries);
		});
		return datewiseEntries;
	}
	
	
	public static void collectBillableHoursAndTimeOff(String dateFrom, String dateTo,
			Map<String, Map<String, Pair<Double, Double>>> userwiseTimeSheet, UserInfo userInfo, Map<String, String> tasks) {
			APIReader reader = new APIReader(userInfo);
			Session session = reader.getConnection().getSession();
			String entries = reader.execute(TimesheetInfoHelper.formatUrl(CT_URLS.TIME_ENTRIES_FROM_TO_DATE.getUrl(),
					session.getCompanyID(), session.getUserID(), dateFrom, dateTo));

			TypeReference<List<TimeEntryDetails>> mapType = new TypeReference<List<TimeEntryDetails>>() {
			};
			List<TimeEntryDetails> entryList = JsonHelper.jsonToObjectList(entries, mapType);
			Map<String, Pair<Double, Double>> datewiseEntries = TimesheetInfoHelper.getDatewiseTimeEntriesMap(entryList,
					tasks);
			userwiseTimeSheet.put(userInfo.getUsername(), datewiseEntries);
		}
	
	 public static String formatUrl(String url, Object... params) {
		 return String.format(url, params);
	 }
}
