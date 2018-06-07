package timesheets.clicktime.pojo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "Date", "Locked", "TimeEntries", "TimeOffEntries", "Timers" })
public class TimeEntryDetails {

	@JsonProperty("Date")
	private String date;
	@JsonProperty("Locked")
	private Boolean locked;
	@JsonProperty("TimeEntries")
	private List<TimeONEntry> timeEntries = null;
	@JsonProperty("TimeOffEntries")
	private List<TimeOffEntry> timeOffEntries = null;
	@JsonProperty("Timers")
	private List<Object> timers = null;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("Date")
	public String getDate() {
		return date;
	}

	@JsonProperty("Date")
	public void setDate(String date) {
		this.date = date;
	}

	@JsonProperty("Locked")
	public Boolean getLocked() {
		return locked;
	}

	@JsonProperty("Locked")
	public void setLocked(Boolean locked) {
		this.locked = locked;
	}

	@JsonProperty("TimeEntries")
	public List<TimeONEntry> getTimeEntries() {
		return timeEntries;
	}

	@JsonProperty("TimeEntries")
	public void setTimeEntries(List<TimeONEntry> timeEntries) {
		this.timeEntries = timeEntries;
	}

	@JsonProperty("TimeOffEntries")
	public List<TimeOffEntry> getTimeOffEntries() {
		return timeOffEntries;
	}

	@JsonProperty("TimeOffEntries")
	public void setTimeOffEntries(List<TimeOffEntry> timeOffEntries) {
		this.timeOffEntries = timeOffEntries;
	}

	@JsonProperty("Timers")
	public List<Object> getTimers() {
		return timers;
	}

	@JsonProperty("Timers")
	public void setTimers(List<Object> timers) {
		this.timers = timers;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}
