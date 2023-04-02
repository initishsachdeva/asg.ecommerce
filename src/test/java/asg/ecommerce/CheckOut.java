package asg.ecommerce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckOut {
	public WebDriver driver;
	By checkout = By.xpath("//a[@class='button btn btn-default standard-checkout button-medium']");
	By name = By.xpath("//ul[@class='address item box']//li[2]");
	By city = By.xpath("//ul[@class='address item box']//li[3]");
	By state = By.xpath("//ul[@class='address item box']//li[4]");
	By country = By.xpath("//ul[@class='address item box']//li[5]");
	By contact = By.xpath("//ul[@class='address item box']//li[6]");
	By addressPageCheckOut = By.xpath("//button[@class='button btn btn-default button-medium']");
	By tos = By.xpath("//input[@id='cgv']");
	By shippingPageCheckOut = By.xpath("//button[@class='button btn btn-default standard-checkout button-medium']");
	By paybank = By.xpath("//a[@class='bankwire']");
	By confirmOrderBtn = By.xpath("//button[@class='button btn btn-default button-medium']");
	By finalAmount = By.xpath("//span[@class='price']");
	By backOrderBtn = By.xpath("//a[@class='button-exclusive btn btn-default']");

	public CheckOut(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;

	}

	public WebElement clickCheckOut() {

		return driver.findElement(checkout);
	}

	public WebElement getName() {

		return driver.findElement(name);
	}

	public WebElement getCity() {

		return driver.findElement(city);
	}

	public WebElement getState() {

		return driver.findElement(state);
	}

	public WebElement getCountry() {

		return driver.findElement(country);
	}

	public WebElement getContact() {

		return driver.findElement(contact);
	}

	public WebElement clickAddressPageCheckOut() {

		return driver.findElement(addressPageCheckOut);
	}

	public WebElement clickTOS() {

		return driver.findElement(tos);
	}

	public WebElement clickAShippingPageCheckOut() {

		return driver.findElement(shippingPageCheckOut);
	}

	public WebElement clickPaybank() {

		return driver.findElement(paybank);
	}

	public WebElement clickConfirmOrderBtn() {

		return driver.findElement(confirmOrderBtn);
	}

	public WebElement getFinalAmount() {

		return driver.findElement(finalAmount);
	}

	public WebElement clickBackOrderBtn() {

		return driver.findElement(backOrderBtn);
	}
}