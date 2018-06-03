package timesheets.clicktime;

import timesheets.clicktime.base.Users;
import timesheets.clicktime.Connection;
import timesheets.clicktime.Session;
public class TimesheetInfo extends Users{

	public static void main(String... args) {
		USERS.forEach(i -> {
			Session session = Connection.openConnection(i);
			System.out.println("User id is =>  " + session.getUserName());
		});
	}
	
}
