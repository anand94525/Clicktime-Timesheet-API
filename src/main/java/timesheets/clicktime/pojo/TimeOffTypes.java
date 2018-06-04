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
@JsonPropertyOrder({ "Active", "Name", "RequiresApproval", "TimeOffTypeID" })
public class TimeOffTypes {

	@JsonProperty("Active")
	private Boolean active;
	@JsonProperty("Name")
	private String name;
	@JsonProperty("RequiresApproval")
	private Boolean requiresApproval;
	@JsonProperty("TimeOffTypeID")
	private String timeOffTypeID;
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

	@JsonProperty("Name")
	public String getName() {
		return name;
	}

	@JsonProperty("Name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("RequiresApproval")
	public Boolean getRequiresApproval() {
		return requiresApproval;
	}

	@JsonProperty("RequiresApproval")
	public void setRequiresApproval(Boolean requiresApproval) {
		this.requiresApproval = requiresApproval;
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