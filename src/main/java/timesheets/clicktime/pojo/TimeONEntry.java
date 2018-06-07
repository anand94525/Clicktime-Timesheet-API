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
@JsonPropertyOrder({ "BreakTime", "Comment", "Date", "Hours", "ISOEndTime", "ISOStartTime", "JobID", "OptionalData",
		"PhaseID", "SubPhaseID", "TaskID", "TimeEntryID", "Timer" })
public class TimeONEntry {

	@JsonProperty("BreakTime")
	private Double breakTime;
	@JsonProperty("Comment")
	private String comment;
	@JsonProperty("Date")
	private String date;
	@JsonProperty("Hours")
	private Double hours;
	@JsonProperty("ISOEndTime")
	private Object iSOEndTime;
	@JsonProperty("ISOStartTime")
	private Object iSOStartTime;
	@JsonProperty("JobID")
	private String jobID;
	@JsonProperty("OptionalData")
	private Object optionalData;
	@JsonProperty("PhaseID")
	private Object phaseID;
	@JsonProperty("SubPhaseID")
	private Object subPhaseID;
	@JsonProperty("TaskID")
	private String taskID;
	@JsonProperty("TimeEntryID")
	private String timeEntryID;
	@JsonProperty("Timer")
	private Object timer;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("BreakTime")
	public Double getBreakTime() {
		return breakTime;
	}

	@JsonProperty("BreakTime")
	public void setBreakTime(Double breakTime) {
		this.breakTime = breakTime;
	}

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

	@JsonProperty("ISOEndTime")
	public Object getISOEndTime() {
		return iSOEndTime;
	}

	@JsonProperty("ISOEndTime")
	public void setISOEndTime(Object iSOEndTime) {
		this.iSOEndTime = iSOEndTime;
	}

	@JsonProperty("ISOStartTime")
	public Object getISOStartTime() {
		return iSOStartTime;
	}

	@JsonProperty("ISOStartTime")
	public void setISOStartTime(Object iSOStartTime) {
		this.iSOStartTime = iSOStartTime;
	}

	@JsonProperty("JobID")
	public String getJobID() {
		return jobID;
	}

	@JsonProperty("JobID")
	public void setJobID(String jobID) {
		this.jobID = jobID;
	}

	@JsonProperty("OptionalData")
	public Object getOptionalData() {
		return optionalData;
	}

	@JsonProperty("OptionalData")
	public void setOptionalData(Object optionalData) {
		this.optionalData = optionalData;
	}

	@JsonProperty("PhaseID")
	public Object getPhaseID() {
		return phaseID;
	}

	@JsonProperty("PhaseID")
	public void setPhaseID(Object phaseID) {
		this.phaseID = phaseID;
	}

	@JsonProperty("SubPhaseID")
	public Object getSubPhaseID() {
		return subPhaseID;
	}

	@JsonProperty("SubPhaseID")
	public void setSubPhaseID(Object subPhaseID) {
		this.subPhaseID = subPhaseID;
	}

	@JsonProperty("TaskID")
	public String getTaskID() {
		return taskID;
	}

	@JsonProperty("TaskID")
	public void setTaskID(String taskID) {
		this.taskID = taskID;
	}

	@JsonProperty("TimeEntryID")
	public String getTimeEntryID() {
		return timeEntryID;
	}

	@JsonProperty("TimeEntryID")
	public void setTimeEntryID(String timeEntryID) {
		this.timeEntryID = timeEntryID;
	}

	@JsonProperty("Timer")
	public Object getTimer() {
		return timer;
	}

	@JsonProperty("Timer")
	public void setTimer(Object timer) {
		this.timer = timer;
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