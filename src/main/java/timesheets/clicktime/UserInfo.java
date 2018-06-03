package timesheets.clicktime;

import org.apache.commons.codec.binary.Base64;

public class UserInfo {

	private String username;
	private String password;
	
	public UserInfo(Object object, Object object2) {
		this.username = String.valueOf(object);
		this.password = String.valueOf(object2);
	}
	
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	
	public String getAuthKey() {
		// Encode data on your side using BASE64
		byte[] bytesEncoded = Base64.encodeBase64((username + ":" + password).getBytes());
		return new String(bytesEncoded);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserInfo other = (UserInfo) obj;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
}
