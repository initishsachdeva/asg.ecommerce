package asg.ecommerce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderHistory {
	public WebDriver driver;
	By orderref = By.xpath("//table[@id='order-list']/tbody/tr[1]/td[1]/a[@class='color-myaccount']");
	By date = By.xpath("//table[@id='order-list']/tbody/tr[1]/td[2]");
	By price = By.xpath("//table[@id='order-list']/tbody/tr[1]/td[3]/span[@class='price']");
	By payment = By.xpath("//table[@id='order-list']/tbody/tr[1]/td[4]");
	By status = By.xpath("//table[@id='order-list']/tbody/tr[1]/td[5]/span[@class='label dark']");

	public OrderHistory(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;

	}

	public WebElement getOrderRef() {

		return driver.findElement(orderref);
	}

	public WebElement getDate() {

		return driver.findElement(date);
	}

	public WebElement getPrice() {

		return driver.findElement(price);
	}

	public WebElement getPayment() {

		return driver.findElement(payment);
	}

	public WebElement getStatus() {

		return driver.findElement(status);
	}

}
