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
@JsonPropertyOrder({ "Active", "Code", "DisplayName", "Name", "Recent", "TaskID" })
public class Tasks {

	@JsonProperty("Active")
	private Boolean active;
	@JsonProperty("Code")
	private String code;
	@JsonProperty("DisplayName")
	private String displayName;
	@JsonProperty("Name")
	private String name;
	@JsonProperty("Recent")
	private Boolean recent;
	@JsonProperty("TaskID")
	private String taskID;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("Active")
	public Boolean getActive() {
		return active;
	}

	@JsonProperty("Active")
	public void setActive(Boolean active) {
		this.active = active;
	}

	@JsonProperty("Code")
	public String getCode() {
		return code;
	}

	@JsonProperty("Code")
	public void setCode(String code) {
		this.code = code;
	}

	@JsonProperty("DisplayName")
	public String getDisplayName() {
		return displayName;
	}

	@JsonProperty("DisplayName")
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	@JsonProperty("Name")
	public String getName() {
		return name;
	}

	@JsonProperty("Name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("Recent")
	public Boolean getRecent() {
		return recent;
	}

	@JsonProperty("Recent")
	public void setRecent(Boolean recent) {
		this.recent = recent;
	}

	@JsonProperty("TaskID")
	public String getTaskID() {
		return taskID;
	}

	@JsonProperty("TaskID")
	public void setTaskID(String taskID) {
		this.taskID = taskID;
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