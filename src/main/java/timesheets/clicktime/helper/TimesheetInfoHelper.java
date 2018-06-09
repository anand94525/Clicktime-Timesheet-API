package timesheets.clicktime.helper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import org.apache.commons.lang3.mutable.MutableDouble;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import timesheets.clicktime.common.CT_URLS;
import timesheets.clicktime.common.JsonHelper;
import timesheets.clicktime.pojo.Tasks;
import timesheets.clicktime.pojo.TimeEntryDetails;
import timesheets.clicktime.pojo.TimeOffTypes;

public class TimesheetInfoHelper {
	
	public static Map<String, Pair<Double, Double>> getDatewiseTimeEntries(List<TimeEntryDetails> entryList) {
		Map<String, Pair<Double, Double>> datewiseEntries = new ConcurrentHashMap<>();
		//entryList.forEach(j -> System.out.println(k.toString()));
		entryList.forEach(j -> {
			//Need to refactor, remove duplicate for loops
			MutableDouble timeEntries = new MutableDouble(0);
			j.getTimeEntries().forEach(timeEntry -> {
				timeEntries.add(timeEntry.getHours());
			});
			
			MutableDouble timeOffEntries = new MutableDouble(0);
			j.getTimeOffEntries().forEach(timeOffEntry -> {
				timeOffEntries.add(timeOffEntry.getHours());
			});
			
			Pair<Double, Double> timeOnAndOffEntries = new ImmutablePair<>(timeEntries.doubleValue(), timeOffEntries.doubleValue());
			datewiseEntries.put(j.getDate(), timeOnAndOffEntries);
		});
		return datewiseEntries;
	}
	
	public static Map<String, String> getTasks(APIReader apiReader) {
		Map<String, String> allTasks = new HashMap<>();
		Session session = apiReader.getSession();
		String tasks = apiReader.execute(String.format(CT_URLS.TASKS.getUrl(), session.getCompanyID(), session.getUserID()));
		allTasks.putAll(((List<Tasks>)JsonHelper.jsonToList(tasks, Tasks.class)).stream().collect(Collectors.toMap(Tasks::getTaskID, Tasks::getDisplayName)));
		
		String tasks1 = apiReader.execute(String.format(CT_URLS.TIME_OFF_TYPES.getUrl(), session.getCompanyID(), session.getUserID()));
		allTasks.putAll(((List<TimeOffTypes>)JsonHelper.jsonToList(tasks1, TimeOffTypes.class)).stream().collect(Collectors.toMap(TimeOffTypes::getTimeOffTypeID, TimeOffTypes::getName)));

		return allTasks;
	}
	 
	 public static String formatUrl(String url, Object... params) {
		 return String.format(url, params);
	 }
}
