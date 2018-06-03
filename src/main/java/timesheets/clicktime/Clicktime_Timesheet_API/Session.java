package timesheets.clicktime.Clicktime_Timesheet_API;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"CompanyID",
"SecurityLevel",
"Token",
"UserEmail",
"UserID",
"UserName"
})
public class Session {

@JsonProperty("CompanyID")
private String companyID;
@JsonProperty("SecurityLevel")
private String securityLevel;
@JsonProperty("Token")
private String token;
@JsonProperty("UserEmail")
private String userEmail;
@JsonProperty("UserID")
private String userID;
@JsonProperty("UserName")
private String userName;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("CompanyID")
public String getCompanyID() {
return companyID;
}

@JsonProperty("CompanyID")
public void setCompanyID(String companyID) {
this.companyID = companyID;
}

@JsonProperty("SecurityLevel")
public String getSecurityLevel() {
return securityLevel;
}

@JsonProperty("SecurityLevel")
public void setSecurityLevel(String securityLevel) {
this.securityLevel = securityLevel;
}

@JsonProperty("Token")
public String getToken() {
return token;
}

@JsonProperty("Token")
public void setToken(String token) {
this.token = token;
}

@JsonProperty("UserEmail")
public String getUserEmail() {
return userEmail;
}

@JsonProperty("UserEmail")
public void setUserEmail(String userEmail) {
this.userEmail = userEmail;
}

@JsonProperty("UserID")
public String getUserID() {
return userID;
}

@JsonProperty("UserID")
public void setUserID(String userID) {
this.userID = userID;
}

@JsonProperty("UserName")
public String getUserName() {
return userName;
}

@JsonProperty("UserName")
public void setUserName(String userName) {
this.userName = userName;
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
