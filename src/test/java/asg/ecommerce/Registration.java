package asg.ecommerce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Registration {
	public WebDriver driver;
	By signin = By.xpath("//a[@class='login']");
	By email = By.xpath("//input[@id='email_create']");
	By createAccountBtn = By.xpath("//button[@id='SubmitCreate']");
	By id = By.xpath("//input[@id='email']");
	By password = By.xpath("//input[@id='passwd']");
	By login = By.xpath("//button[@id='SubmitLogin']");

	public Registration(WebDriver webdriver) {
		// TODO Auto-generated constructor stub
		this.driver = webdriver;

	}

	public WebElement clickSignIn() {

		return driver.findElement(signin);
	}

	public WebElement sendEmailAddress() {

		return driver.findElement(email);
	}

	public WebElement clickCreateAccBtn() {

		return driver.findElement(createAccountBtn);
	}

	public WebElement logId() {

		return driver.findElement(id);
	}

	public WebElement logPwd() {

		return driver.findElement(password);
	}

	public WebElement signIn() {

		return driver.findElement(login);
	}

}