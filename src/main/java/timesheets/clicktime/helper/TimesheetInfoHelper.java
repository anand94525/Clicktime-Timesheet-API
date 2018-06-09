package timesheets.clicktime.helper;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang3.mutable.MutableDouble;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import timesheets.clicktime.pojo.TimeEntryDetails;

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
}
