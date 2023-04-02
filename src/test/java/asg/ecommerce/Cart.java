package asg.ecommerce;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Cart {
	public WebDriver driver;
	By searchText = By.xpath("//input[@id='search_query_top']");
	By searchBtn = By.xpath("//button[@name='submit_search']");
	By colorList = By.xpath("//ul[@class='color_to_pick_list clearfix']");
	By white = By.xpath("//ul[@class='color_to_pick_list clearfix']//li[1]");
	By stock = By.xpath("//span[@class='available-now']");
	By quantity3 = By.xpath("//input[@id='quantity_wanted']");
	By size1 = By.xpath("//select[@id='group_1']");
	By size2 = By.xpath("//select[@id='group_1']");
	By size3 = By.xpath("//select[@id='group_1']");
	By cartBtn3 = By.xpath("//span[contains(text(),'Add to cart')]");
	By continueShopping = By.xpath("//span[@class='continue btn btn-default button exclusive-medium']");
	By green = By.xpath("//ul[@class='color_to_pick_list clearfix']//li[1]");
	By blue = By.xpath("//ul[@class='color_to_pick_list clearfix']//li[2]");
	By cartBtn = By.xpath("//div[@class='shopping_cart']/a");
	By cartTable = By.xpath("//table[@id='cart_summary']");
//----------------------	Product3 Details--------------------------------------------------------------------------
	By prodName3 = By.xpath("//table[@id='cart_summary']/tbody/tr[1]/td[2]/p[@class='product-name']");
	By skuName3 = By.xpath("//table[@id='cart_summary']/tbody/tr[1]/td[2]/small[@class='cart_ref']");
	By color3 = By.xpath("//table[@id='cart_summary']/tbody/tr[1]/td[2]/small/a");
	By quant3 = By.xpath(
			"//table[@id='cart_summary']/tbody/tr[1]/td[5]/input[@class='cart_quantity_input form-control grey']");
	By price3 = By.xpath("//table[@id='cart_summary']/tbody/tr[1]/td[6]/span[@id='total_product_price_2_8_368610']");
//--------------------------------------------Product1 Details---------------------------------------------------------------------	
	By prodName1 = By.xpath("//table[@id='cart_summary']/tbody/tr[2]/td[2]/p[@class='product-name']");
	By skuName1 = By.xpath("//table[@id='cart_summary']/tbody/tr[2]/td[2]/small[@class='cart_ref']");
	By color1 = By.xpath("//table[@id='cart_summary']/tbody/tr[2]/td[2]/small/a");
	By quant1 = By.xpath(
			"//table[@id='cart_summary']/tbody/tr[2]/td[5]/input[@class='cart_quantity_input form-control grey']");
	By price1 = By.xpath("//table[@id='cart_summary']/tbody/tr[2]/td[6]/span[@id='total_product_price_7_38_368610']");
//----------------------------------------Product2-----------------------------------------------------------------------------------------	
	By prodName2 = By.xpath("//table[@id='cart_summary']/tbody/tr[3]/td[2]/p[@class='product-name']");
	By skuName2 = By.xpath("//table[@id='cart_summary']/tbody/tr[3]/td[2]/small[@class='cart_ref']");
	By color2 = By.xpath("//table[@id='cart_summary']/tbody/tr[3]/td[2]/small/a");
	By quant2 = By.xpath(
			"//table[@id='cart_summary']/tbody/tr[3]/td[5]/input[@class='cart_quantity_input form-control grey']");
	By price2 = By.xpath("//table[@id='cart_summary']/tbody/tr[3]/td[6]/span[@id='total_product_price_1_6_368610']");
//---------------------------------Total Billing------------------------------------------------------------------------	
	By total_products = By.xpath("//table[@id='cart_summary']/tfoot/tr[1]/td[3]");
	By total_shipping = By.xpath("//table[@id='cart_summary']/tfoot/tr[3]/td[2]");
	By total_price = By.xpath("//table[@id='cart_summary']/tfoot/tr[7]/td[2]");
	By del_product3 = By.xpath("//table[@id='cart_summary']/tbody/tr[1]/td[7]/div/a");
//------------------------------After removing product3-------------------------------------------
	By newprodName1 = By.xpath("//table[@id='cart_summary']/tbody/tr[1]/td[2]/p[@class='product-name']");
	By newskuName1 = By.xpath("//table[@id='cart_summary']/tbody/tr[1]/td[2]/small[@class='cart_ref']");
	By newcolor1 = By.xpath("//table[@id='cart_summary']/tbody/tr[1]/td[2]/small/a");
	By newquant1 = By.xpath(
			"//table[@id='cart_summary']/tbody/tr[1]/td[5]/input[@class='cart_quantity_input form-control grey']");
	By newprice1 = By.xpath("//table[@id='cart_summary']/tbody/tr[1]/td[6]");
	By newprodName2 = By.xpath("//table[@id='cart_summary']/tbody/tr[2]/td[2]/p[@class='product-name']");
	By newskuName2 = By.xpath("//table[@id='cart_summary']/tbody/tr[2]/td[2]/small[@class='cart_ref']");
	By newcolor2 = By.xpath("//table[@id='cart_summary']/tbody/tr[2]/td[2]/small/a");
	By newquant2 = By.xpath(
			"//table[@id='cart_summary']/tbody/tr[2]/td[5]/input[@class='cart_quantity_input form-control grey']");
	By newprice2 = By.xpath("//table[@id='cart_summary']/tbody/tr[2]/td[6]");

	// ----------------------New Total----------------------------------------------
	By newtotal_products = By.xpath("//table[@id='cart_summary']/tfoot/tr[1]/td[3]");
	By newtotal_shipping = By.xpath("//table[@id='cart_summary']/tfoot/tr[3]/td[2]");
	By newtotal_price = By.xpath("//table[@id='cart_summary']/tfoot/tr[6]/td[2]");
//-----------------------------After adding 10 more elements to cart------------------------------------------------------------------------
	By newtotal_price1 = By.xpath("//table[@id='cart_summary']/tfoot/tr[7]/td[2]");

	public Cart(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;

	}

	public WebElement cartTable() {

		return driver.findElement(cartTable);

	}

	public WebElement addSearch() {

		return driver.findElement(searchText);
	}

	public WebElement stock() {
		return driver.findElement(stock);
	}

	public WebElement clickSearch() {

		return driver.findElement(searchBtn);
	}

	public List<WebElement> colorList() {
		return driver.findElements(colorList);
	}

	public WebElement colorWhite() {
		return driver.findElement(white);
	}

	public WebElement selectQuantity3() {
		return driver.findElement(quantity3);
	}

	public WebElement size3() {
		return driver.findElement(size3);
	}

	public WebElement cartBtn3() {
		return driver.findElement(cartBtn3);
	}

	public WebElement continueShopping() {
		return driver.findElement(continueShopping);
	}

	public WebElement colorGreen() {
		return driver.findElement(green);
	}

	public WebElement colorBlue() {
		return driver.findElement(blue);
	}

	public WebElement size1() {
		return driver.findElement(size1);
	}

	public WebElement size2() {
		return driver.findElement(size2);
	}

	public WebElement clickCartBtn() {
		return driver.findElement(cartBtn);
	}

	public WebElement getProdName3() {
		return driver.findElement(prodName3);
	}

	public WebElement getSku3() {
		return driver.findElement(skuName3);
	}

	public WebElement getColor3() {
		return driver.findElement(color3);
	}

	public WebElement getQuant3() {
		return driver.findElement(quant3);
	}

	public WebElement getPrice3() {
		return driver.findElement(price3);
	}

	public WebElement getProdName1() {
		return driver.findElement(prodName1);
	}

	public WebElement getSku1() {
		return driver.findElement(skuName1);
	}

	public WebElement getColor1() {
		return driver.findElement(color1);
	}

	public WebElement getQuant1() {
		return driver.findElement(quant1);
	}

	public WebElement getPrice1() {
		return driver.findElement(price1);
	}

	public WebElement getProdName2() {
		return driver.findElement(prodName2);
	}

	public WebElement getSku2() {
		return driver.findElement(skuName2);
	}

	public WebElement getColor2() {
		return driver.findElement(color2);
	}

	public WebElement getQuant2() {
		return driver.findElement(quant2);
	}

	public WebElement getPrice2() {
		return driver.findElement(price2);
	}

	public WebElement getTotalProducts() {
		return driver.findElement(total_products);
	}

	public WebElement getTotalShipping() {
		return driver.findElement(total_shipping);
	}

	public WebElement getTotalPrice() {
		return driver.findElement(total_price);
	}

	public WebElement delProduct3() {
		return driver.findElement(del_product3);
	}

	public WebElement getNewProd1() {

		return driver.findElement(newprodName1);

	}

	public WebElement getNewSku1() {

		return driver.findElement(newskuName1);

	}

	public WebElement getNewColor1() {

		return driver.findElement(newcolor1);

	}

	public WebElement getNewQuant1() {

		return driver.findElement(newquant1);

	}

	public WebElement getNewPrice1() {

		return driver.findElement(newprice1);

	}

	public WebElement getNewProd2() {

		return driver.findElement(newprodName2);

	}

	public WebElement getNewSku2() {

		return driver.findElement(newskuName2);

	}

	public WebElement getNewColor2() {

		return driver.findElement(newcolor2);

	}

	public WebElement getNewQuant2() {

		return driver.findElement(newquant2);

	}

	public WebElement getNewPrice2() {

		return driver.findElement(newprice2);

	}

	public WebElement getNewTotalProducts() {
		return driver.findElement(newtotal_products);
	}

	public WebElement getNewTotalShipping() {
		return driver.findElement(newtotal_shipping);
	}

	public WebElement getNewTotalPrice() {
		return driver.findElement(newtotal_price);
	}

	public WebElement getNewTotalPrice1() {
		return driver.findElement(newtotal_price1);
	}
}