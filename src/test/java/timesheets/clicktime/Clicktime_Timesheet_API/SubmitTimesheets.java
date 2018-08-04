package timesheets.clicktime.Clicktime_Timesheet_API;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SubmitTimesheets {

	public static void main(String[] args) {
		System.setProperty("webdriver.firefox.marionette","/home/abc/geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://weather.innotas.com/home.pa");
		System.out.println("abcs");
	}

}
