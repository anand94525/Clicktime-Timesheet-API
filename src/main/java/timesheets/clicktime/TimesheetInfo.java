package timesheets.clicktime;

import timesheets.clicktime.base.BaseClicktime;
import timesheets.clicktime.common.CT_URLS;
import timesheets.clicktime.common.JsonHelper;
import timesheets.clicktime.helper.APIReader;
import timesheets.clicktime.helper.TimesheetInfoHelper;
import timesheets.clicktime.pojo.Session;
import timesheets.clicktime.pojo.Tasks;
import timesheets.clicktime.pojo.TimeOffTypes;
import timesheets.clicktime.pojo.UserInfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import org.apache.commons.lang3.tuple.Pair;

public class TimesheetInfo extends BaseClicktime {

	/**
	 * Method to get time entries having billable hours and time off hours.
	 * 
	 * @param dateFrom
	 *            - start date of time sheet.
	 * @param dateTo
	 *            - to date of time sheet.
	 * @return It returns time sheet data as Map<String, Map<String, Pair<Double,
	 *         Double>>>. 
	 *         1.Outer map will hold user name as a key and value as map.
	 *         2.The value map will contain date as a key and Pair as a value.
	 *         3.First value of pair will contain billable hour and second value of
	 *         pair will contain Time OFF hours such as PTO, company holiday hours.
	 */
	public static Map<String, Map<String, Pair<Double, Double>>> getBillableHours(String dateFrom, String dateTo) {
		Map<String, Map<String, Pair<Double, Double>>> userwiseTimeSheet = new ConcurrentHashMap<>();
		USERS.forEach(i -> {
			Map<String, Pair<Double, Double>> timesheet = TimesheetInfoHelper.collectTimeSheet(dateFrom, dateTo, i, getBillableTasks(i));
			userwiseTimeSheet.put(i.getUsername(), timesheet);
		});
		return userwiseTimeSheet;
	}

	/**
	 * Method to get time entries having billable hours and time off hours.
	 * 
	 * @param users
	 *            - list of UserInfo objects containing username and password.
	 * @param dateFrom
	 *            - start date of time sheet.
	 * @param dateTo
	 *            - to date of time sheet.
	 * @return It returns time sheet data as Map<String, Map<String, Pair<Double,
	 *         Double>>>. 1.Outer map will hold user name as a key and value as map.
	 *         \n 2.The value map will contain date as a key and Pair as a value.\n
	 *         3.First value of pair will contain billable hour and second value of
	 *         pair will contain Time OFF hours such as PTO, company holiday hours.
	 */
	public static Map<String, Map<String, Pair<Double, Double>>> getBillableHours(List<UserInfo> users, String dateFrom,
			String dateTo) {
		Map<String, Map<String, Pair<Double, Double>>> userwiseTimeSheet = new ConcurrentHashMap<>();
		users.forEach(i -> {
			Map<String, Pair<Double, Double>> timesheet = TimesheetInfoHelper.collectTimeSheet(dateFrom, dateTo, i, getBillableTasks(i));
			userwiseTimeSheet.put(i.getUsername(), timesheet);
		});
		return userwiseTimeSheet;
	}
	
	/**
	 * Method to get time entries having hours and time off hours.
	 * 
	 * @param users
	 *            - list of UserInfo objects containing username and password.
	 * @param dateFrom
	 *            - start date of time sheet.
	 * @param dateTo
	 *            - to date of time sheet.
	 * @return It returns time sheet data as Map<String, Map<String, Pair<Double,
	 *         Double>>>. 1.Outer map will hold user name as a key and value as map.
	 *         \n 2.The value map will contain date as a key and Pair as a value.\n
	 *         3.First value of pair will contain billable hour and second value of
	 *         pair will contain Time OFF hours such as PTO, company holiday hours.
	 */
	public static Map<String, Map<String, Pair<Double, Double>>> getAllTimeEntries(List<UserInfo> users, String dateFrom,
			String dateTo) {
		Map<String, Map<String, Pair<Double, Double>>> userwiseTimeSheet = new ConcurrentHashMap<>();
		users.forEach(i -> {
			Map<String, Pair<Double, Double>> timesheet = TimesheetInfoHelper.collectTimeSheet(dateFrom, dateTo, i, getTasks(i));
			userwiseTimeSheet.put(i.getUsername(), timesheet);
		});
		return userwiseTimeSheet;
	}

	/**
	 * Method to get time entries having billable hours and time off hours.
	 * 
	 * @param userInfo
	 *            - UserInfo objects containing username and password.
	 * @param dateFrom
	 *            - start date of time sheet.
	 * @param dateTo
	 *            - to date of time sheet.
	 * @return It returns time sheet data as Map<String, Map<String, Pair<Double,
	 *         Double>>>. 1.Outer map will hold user name as a key and value as map.
	 *         \n 2.The value map will contain date as a key and Pair as a value.\n
	 *         3.First value of pair will contain billable hour and second value of
	 *         pair will contain Time OFF hours such as PTO, company holiday hours.
	 */
	public static Map<String, Map<String, Pair<Double, Double>>> getBillableHours(UserInfo userInfo, String dateFrom,
			String dateTo) {
		Map<String, Map<String, Pair<Double, Double>>> userwiseTimeSheet = new ConcurrentHashMap<>();
		Map<String, Pair<Double, Double>> timesheet = TimesheetInfoHelper.collectTimeSheet(dateFrom, dateTo, userInfo, getBillableTasks(userInfo));
		userwiseTimeSheet.put(userInfo.getUsername(), timesheet);
		return userwiseTimeSheet;
	}
	
	/**
	 * Method to get time entries having hours and time off hours.
	 * 
	 * @param userInfo
	 *            - UserInfo objects containing username and password.
	 * @param dateFrom
	 *            - start date of time sheet.
	 * @param dateTo
	 *            - to date of time sheet.
	 * @return It returns time sheet data as Map<String, Map<String, Pair<Double,
	 *         Double>>>. 1.Outer map will hold user name as a key and value as map.
	 *         \n 2.The value map will contain date as a key and Pair as a value.\n
	 *         3.First value of pair will contain billable hour and second value of
	 *         pair will contain Time OFF hours such as PTO, company holiday hours.
	 */
	public static Map<String, Map<String, Pair<Double, Double>>> getAllTimeEntries(UserInfo userInfo, String dateFrom,
			String dateTo) {
		Map<String, Map<String, Pair<Double, Double>>> userwiseTimeSheet = new ConcurrentHashMap<>();
		Map<String, Pair<Double, Double>> timesheet = TimesheetInfoHelper.collectTimeSheet(dateFrom, dateTo, userInfo, getTasks(userInfo));
		userwiseTimeSheet.put(userInfo.getUsername(), timesheet);
		return userwiseTimeSheet;
	}

	/**
	 * Method to get time entries having billable hours and time off hours.
	 * 
	 * @param dateFrom
	 *            - start date of time sheet.
	 * @param dateTo
	 *            - to date of time sheet.
	 * @return It returns time sheet data as Map<String, Map<String, Pair<Double,
	 *         Double>>>. 1.Outer map will hold user name as a key and value as map.
	 *         \n 2.The value map will contain date as a key and Pair as a value.\n
	 *         3.First value of pair will contain billable hour and second value of
	 *         pair will contain Time OFF hours such as PTO, company holiday hours.
	 */
	public static Map<String, Map<String, Pair<Double, Double>>> getBillableHours(String dateFrom) {
		return getBillableHours(dateFrom, dateFrom);
	}

	/**
	 * Method to get time entries having billable hours and time off hours.
	 * 
	 * @param users
	 *            - list of UserInfo objects containing username and password.
	 * @param dateFrom
	 *            - start date of time sheet.
	 * @param dateTo
	 *            - to date of time sheet.
	 * @return It returns time sheet data as Map<String, Map<String, Pair<Double,
	 *         Double>>>. 1.Outer map will hold user name as a key and value as map.
	 *         \n 2.The value map will contain date as a key and Pair as a value.\n
	 *         3.First value of pair will contain billable hour and second value of
	 *         pair will contain Time OFF hours such as PTO, company holiday hours.
	 */
	public static Map<String, Map<String, Pair<Double, Double>>> getBillableHours(List<UserInfo> users,
			String dateFrom) {
		return getBillableHours(users, dateFrom, dateFrom);
	}
	
	/**
	 * Method to get time entries having hours and time off hours.
	 * 
	 * @param users
	 *            - list of UserInfo objects containing username and password.
	 * @param dateFrom
	 *            - start date of time sheet.
	 * @param dateTo
	 *            - to date of time sheet.
	 * @return It returns time sheet data as Map<String, Map<String, Pair<Double,
	 *         Double>>>. 1.Outer map will hold user name as a key and value as map.
	 *         \n 2.The value map will contain date as a key and Pair as a value.\n
	 *         3.First value of pair will contain billable hour and second value of
	 *         pair will contain Time OFF hours such as PTO, company holiday hours.
	 */
	public static Map<String, Map<String, Pair<Double, Double>>> getAllTimeEntries(List<UserInfo> users,
			String dateFrom) {
		return getAllTimeEntries(users, dateFrom, dateFrom);
	}

	/**
	 * Method to get time entries having billable hours and time off hours.
	 * 
	 * @param userInfo
	 *            - UserInfo objects containing username and password.
	 * @param dateFrom
	 *            - start date of time sheet.
	 * @param dateTo
	 *            - to date of time sheet.
	 * @return It returns time sheet data as Map<String, Map<String, Pair<Double,
	 *         Double>>>. 1.Outer map will hold user name as a key and value as map.
	 *         \n 2.The value map will contain date as a key and Pair as a value.\n
	 *         3.First value of pair will contain billable hour and second value of
	 *         pair will contain Time OFF hours such as PTO, company holiday hours.
	 */
	public static Map<String, Map<String, Pair<Double, Double>>> getBillableHours(UserInfo userInfo, String dateFrom) {
		return getBillableHours(userInfo, dateFrom, dateFrom);
	}
	
	/**
	 * Method to get time entries having hours and time off hours.
	 * 
	 * @param userInfo
	 *            - UserInfo - object containing username and password.
	 * @param dateFrom
	 *            - start date of time sheet.
	 * @param dateTo
	 *            - to date of time sheet.
	 * @return It returns time sheet data as Map<String, Map<String, Pair<Double,
	 *         Double>>>. 1.Outer map will hold user name as a key and value as map.
	 *         \n 2.The value map will contain date as a key and Pair as a value.\n
	 *         3.First value of pair will contain billable hour and second value of
	 *         pair will contain Time OFF hours such as PTO, company holiday hours.
	 */
	public static Map<String, Map<String, Pair<Double, Double>>> getAllTimeEntries(UserInfo userInfo, String dateFrom) {
		return getAllTimeEntries(userInfo, dateFrom, dateFrom);
	}
	
	/**
	 * Method to get all tasks specific to given user.
	 * @param userInfo - UserInfo object having user details required to call API.
	 * @return tasks as Map - Map will have key as task id and value as task name.
	 */
	public static Map<String, String> getTasks(UserInfo userInfo) {
		APIReader apiReader = new APIReader(userInfo);
		Map<String, String> allTasks = new HashMap<>();
		Session session = apiReader.getConnection().getSession();
		String tasks = apiReader.execute(String.format(CT_URLS.TASKS.getUrl(), session.getCompanyID(), session.getUserID()));
		allTasks.putAll(((List<Tasks>)JsonHelper.jsonToList(tasks, Tasks.class)).stream().collect(Collectors.toMap(Tasks::getTaskID, Tasks::getDisplayName)));
		
		String tasks1 = apiReader.execute(String.format(CT_URLS.TIME_OFF_TYPES.getUrl(), session.getCompanyID(), session.getUserID()));
		allTasks.putAll(((List<TimeOffTypes>)JsonHelper.jsonToList(tasks1, TimeOffTypes.class)).stream().collect(Collectors.toMap(TimeOffTypes::getTimeOffTypeID, TimeOffTypes::getName)));

		return allTasks;
	}
	
	/**
	 * Method to get billable and off time related tasks specific to given user.
	 * @param userInfo - UserInfo object having user details required to call API.
	 * @return tasks as Map - Map will have key as task id and value as task name.
	 */
	public static Map<String, String> getBillableTasks(UserInfo userInfo) {
		Map<String, String> tasks = getTasks(userInfo);
		Map<String, String> billableTasks = tasks.entrySet().stream().filter(i -> i.getValue().matches("(\\d+)(B - )(.*)")).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		billableTasks.putAll(tasks.entrySet().stream().filter(i -> ("Company Holiday".equals(i.getValue()) || "PTO".equals(i.getValue()))).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));
		return billableTasks;
	}

	// Main method to test
	public static void main(String[] args) {
		Map<String, Map<String, Pair<Double, Double>>> map = getAllTimeEntries(new UserInfo("anands@xpanxion.co.in", "3bash19"), "20180502", "20180508");
		for (Entry<String, Map<String, Pair<Double, Double>>> entry : map.entrySet()) {
			entry.getValue().forEach((i, j) -> System.out.println("User :: " + entry.getKey() + "::: Date :" + i
					+ " Working hours :" + j.getLeft() + " ::: Off hours :" + j.getRight()));
		}
	}
}
