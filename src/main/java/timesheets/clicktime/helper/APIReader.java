package timesheets.clicktime.helper;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import timesheets.clicktime.common.CT_URLS;
import timesheets.clicktime.pojo.Session;
import timesheets.clicktime.pojo.UserInfo;

public class APIReader {
	private Connection connection;
	public APIReader(UserInfo userInfo) {
		connection = new Connection(userInfo);
	}
	
	public Connection getConnection() {
		return this.connection;
	}
	/*private RequestSpecification httpRequest = null;
	private Session session = null;
	
	public static APIReader getConnection(UserInfo userInfo) {
		
		// Specify the base URL to the RESTful web service
		RestAssured.baseURI = CT_URLS.BASE_URI.getUrl();
		Header header2 = new Header("Authorization", "Basic "+ userInfo.getAuthKey());
		 
		APIReader apiReader = new APIReader();
		// Get the RequestSpecification of the request that you want to sent
		// to the server. The server is specified by the BaseURI that we have
		// specified in the above step.
		apiReader.httpRequest = RestAssured.given().header(header2);
		return apiReader;
	}
	
	public Session getSession() {
		if(this.session != null) {
			return this.session;
		}
		try {
			// Make a request to the server by specifying the method Type and the method URL.
			// This will return the Response from the server. Store the response in a variable.
			Response response = this.httpRequest.request().get(CT_URLS.SESSION.getUrl());
	 
			// Now let us print the body of the message to see what response
			// we have recieved from the server
			this.session = response.getBody().as(Session.class);
			return this.session;
		} catch(NullPointerException e) {
			throw new RuntimeException("Connection was not stablished, make sure to call openConnection() method first before calling getSession().");
		}
	}*/
	
	public String execute(String apiURL) {
		Response response = null;
		try {
		// Make a request to the server by specifying the method Type and the method URL.
		// This will return the Response from the server. Store the response in a variable.
		 response = this.getConnection().getRequest().request().get(apiURL);
		} catch(NullPointerException e) {
			throw new RuntimeException("Connection was not stablished, make sure to call openConnection() method first before calling execute().");
		}
		 
		// Now let us print the body of the message to see what response
		// we have recieved from the server
		return response.getBody().asString();
	}
}
