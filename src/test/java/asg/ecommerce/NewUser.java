package asg.ecommerce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewUser {
	public WebDriver driver;

	By titleCheck1 = By.xpath("//div[@id='uniform-id_gender1']");
	By titleCheck2 = By.xpath("//div[@id='uniform-id_gender2']");
	By fname = By.xpath("//input[@id='customer_firstname']");
	By lname = By.xpath("//input[@id='customer_lastname']");
	By password = By.xpath("//input[@id='passwd']");
	By date = By.xpath("//select[@id='days']");
	By month = By.xpath("//select[@id='months']");
	By year = By.xpath("//select[@id='years']");
	By address = By.xpath("//input[@id='address1']");
	By city = By.xpath("//input[@id='city']");
	By state = By.xpath("//select[@id='id_state']");
	By postcode = By.xpath("//input[@id='postcode']");
	By country = By.xpath("//select[@id='id_country']");
	By number = By.xpath("//input[@id='phone_mobile']");
	By register = By.xpath("//button[@id='submitAccount']");

	public NewUser(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;

	}

	public WebElement selectTitle1() {

		return driver.findElement(titleCheck1);
	}

	public WebElement selectTitle2() {

		return driver.findElement(titleCheck2);
	}

	public WebElement firstName() {

		return driver.findElement(fname);
	}

	public WebElement lastName() {

		return driver.findElement(lname);
	}

	public WebElement password() {

		return driver.findElement(password);
	}

	public WebElement date() {

		return driver.findElement(date);
	}

	public WebElement month() {

		return driver.findElement(month);
	}

	public WebElement year() {

		return driver.findElement(year);
	}

	public WebElement address() {

		return driver.findElement(address);
	}

	public WebElement city() {

		return driver.findElement(city);
	}

	public WebElement state() {

		return driver.findElement(state);
	}

	public WebElement postcode() {

		return driver.findElement(postcode);
	}

	public WebElement country() {

		return driver.findElement(country);
	}

	public WebElement mobileNum() {

		return driver.findElement(number);
	}

	public WebElement register() {

		return driver.findElement(register);
	}
}
