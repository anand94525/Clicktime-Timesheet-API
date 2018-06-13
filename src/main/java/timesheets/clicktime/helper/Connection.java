package timesheets.clicktime.helper;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import timesheets.clicktime.common.CT_URLS;
import timesheets.clicktime.pojo.Session;
import timesheets.clicktime.pojo.UserInfo;

public class Connection {
	private RequestSpecification httpRequest = null;
	private Session session = null;
	private UserInfo userInfo = null;

	public Connection(UserInfo userInfo) {
		this.userInfo = userInfo;
	}


	public RequestSpecification getRequest() {
		if (httpRequest != null) {
			return httpRequest;
		}
		// Specify the base URL to the RESTful web service
		RestAssured.baseURI = CT_URLS.BASE_URI.getUrl();
		Header header2 = new Header("Authorization", "Basic " + userInfo.getAuthKey());
		this.httpRequest = RestAssured.given().header(header2);
		return httpRequest;
	}

	public Session getSession() {
		if (this.session != null) {
			return this.session;
		}

		try {
			Response response = this.getRequest().request().get(CT_URLS.SESSION.getUrl());
			this.session = response.getBody().as(Session.class);
			return this.session;
		} catch (NullPointerException e) {
			throw new RuntimeException("Connection was not stablished, make sure credentials are corrects.");
		}
	}
}
