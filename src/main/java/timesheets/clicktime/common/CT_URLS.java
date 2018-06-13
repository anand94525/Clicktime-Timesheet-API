package timesheets.clicktime.common;

public enum CT_URLS {
	BASE_URI("https://app.clicktime.com/API/1.3/"),
	SESSION("Session"),
	TIME_ENTRIES_DATE("Companies/%s/Users/%s/TimeEntries?date=%s"),
	TIME_ENTRIES_FROM_TO_DATE("Companies/%s/Users/%s/TimeEntries?startdate=%s&enddate=%s"),
	TASKS("Companies/%s/Users/%s/Tasks"),
	TIME_OFF_TYPES("Companies/%s/Users/%s/TimeOffTypes");
	
	
	private String url;
	private CT_URLS(String url) {
		this.url = url;
	}
	
	public String getUrl() {
		return this.url;
	}
}
