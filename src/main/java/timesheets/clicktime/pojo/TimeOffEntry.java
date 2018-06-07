package timesheets.clicktime.pojo;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "Comment", "Date", "Hours", "TimeOffEntryID", "TimeOffTypeID" })
public class TimeOffEntry {

	@JsonProperty("Comment")
	private String comment;
	@JsonProperty("Date")
	private String date;
	@JsonProperty("Hours")
	private Double hours;
	@JsonProperty("TimeOffEntryID")
	private String timeOffEntryID;
	@JsonProperty("TimeOffTypeID")
	private String timeOffTypeID;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("Comment")
	public String getComment() {
		return comment;
	}

	@JsonProperty("Comment")
	public void setComment(String comment) {
		this.comment = comment;
	}

	@JsonProperty("Date")
	public String getDate() {
		return date;
	}

	@JsonProperty("Date")
	public void setDate(String date) {
		this.date = date;
	}

	@JsonProperty("Hours")
	public Double getHours() {
		return hours;
	}

	@JsonProperty("Hours")
	public void setHours(Double hours) {
		this.hours = hours;
	}

	@JsonProperty("TimeOffEntryID")
	public String getTimeOffEntryID() {
		return timeOffEntryID;
	}

	@JsonProperty("TimeOffEntryID")
	public void setTimeOffEntryID(String timeOffEntryID) {
		this.timeOffEntryID = timeOffEntryID;
	}

	@JsonProperty("TimeOffTypeID")
	public String getTimeOffTypeID() {
		return timeOffTypeID;
	}

	@JsonProperty("TimeOffTypeID")
	public void setTimeOffTypeID(String timeOffTypeID) {
		this.timeOffTypeID = timeOffTypeID;
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