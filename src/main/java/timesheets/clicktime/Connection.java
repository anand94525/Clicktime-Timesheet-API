package timesheets.clicktime;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Connection {
	private Connection() {}
	
	public static Session openConnection(UserInfo userInfo) {

		// Specify the base URL to the RESTful web service
		RestAssured.baseURI = "https://app.clicktime.com/API/1.3/";
		Header header2 = new Header("Authorization", "Basic "+ userInfo.getAuthKey());
		 
		// Get the RequestSpecification of the request that you want to sent
		// to the server. The server is specified by the BaseURI that we have
		// specified in the above step.
		RequestSpecification httpRequest = RestAssured.given().header(header2);
		// Make a request to the server by specifying the method Type and the method URL.
		// This will return the Response from the server. Store the response in a variable.
		Response response = httpRequest.request().get("Session");
 
		// Now let us print the body of the message to see what response
		// we have recieved from the server
		return response.getBody().as(Session.class);
	}
}
