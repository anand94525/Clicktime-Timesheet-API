package timesheets.clicktime.common;

public enum CT_URLS {
	SESSION(""),
	TIME_ENTRIES_DATE(""),
	TIME_ENTRIES_FROM_TO_DATE(""),
	TASKS("https://app.clicktime.com//API/1.3/Companies/%s/Users/%s/Tasks");
	
	private String url;
	private CT_URLS(String url) {
		this.url = url;
	}
	
	public String getUrl() {
		return this.url;
	}
}
