package timesheets.clicktime.common;

public enum CT_URLS {
	SESSION(""),
	TIME_ENTRIES_DATE(""),
	TIME_ENTRIES_FROM_TO_DATE(""),
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
