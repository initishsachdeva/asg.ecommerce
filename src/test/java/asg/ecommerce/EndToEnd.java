package asg.ecommerce;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
//import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeUnit;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EndToEnd {
	// @SuppressWarnings("unused")
	// private static String proxy2 = System.getProperty("proxy");
	private static String driver2 = System.getProperty("driver");
	private static String input2 = System.getProperty("input");
	private static String output2 = System.getProperty("output");

	private String url = "http://automationpractice.com/index.php";
	private static WebDriver webdriver;

	@BeforeTest
	public void beforeExec() throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", driver2);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		options.addArguments("--no-sandbox");
		// options.addArguments("--proxy-server=" + proxy2);
		options.addArguments("window-size=1920,1080");
		options.addArguments("--start-maximized");
		options.addArguments("--disable-gpu");
		options.addArguments("--disable-extensions");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--ignore-certificate-errors");

		// Create a new
		webdriver = new ChromeDriver(options);
		// webdriver = new ChromeDriver();
		ReadWriteExcel rw = new ReadWriteExcel();
		rw.createfile(output2);
		webdriver.manage().timeouts().implicitlyWait(400, TimeUnit.SECONDS);
//		webdriver.manage().timeouts().pageLoadTimeout(200, TimeUnit.SECONDS);
		webdriver.navigate().to(url);
//		Thread.sleep(1000);
//		webdriver.manage().window().maximize();
	}


	@AfterTest
	public void close() {
		webdriver.quit();
	}
	@Test

	public static void login() throws InterruptedException, IOException {
		Registration reg = new Registration(webdriver);
		reg.clickSignIn().click();
		Thread.sleep(1000);
		reg.logId().sendKeys("nitishsachdeva39@gmail.com");
		reg.logPwd().sendKeys("123456");
		Thread.sleep(500);
		reg.signIn().click();
		String expectedUrl = "http://automationpractice.com/index.php?controller=my-account";
		String actualUrl = webdriver.getCurrentUrl();
		if (actualUrl.equalsIgnoreCase(expectedUrl)) {
			System.out.println("existing user");
		} else {
			reg.sendEmailAddress().sendKeys("nitishofficial@icloud.com");
			Thread.sleep(500l);
			reg.clickCreateAccBtn().click();
			ReadWriteExcel rc = new ReadWriteExcel();// object of the class
			NewUser user = new NewUser(webdriver);
			String a = rc.readExcel(1, 2, "signin", input2);
			String b = "Mr";
			String firstName = rc.readExcel(2, 2, "signin", input2);
			String lastName = rc.readExcel(3, 2, "signin", input2);
			String pass = rc.readExcel(4, 2, "signin", input2);
			String address = rc.readExcel(8, 2, "signin", input2);
			String city = rc.readExcel(9, 2, "signin", input2);
			String postcode = rc.readExcel(11, 2, "signin", input2).toString();
			String number = rc.readExcel(13, 2, "signin", input2).toString();

			System.out.println(a);
			if (a.equalsIgnoreCase(b)) {
				Thread.sleep(1000);
				System.out.println(user.selectTitle1());
				user.selectTitle1().click();
			} else {
				Thread.sleep(100);
				user.selectTitle2().click();
			}
			user.firstName().sendKeys(firstName);
			user.lastName().sendKeys(lastName);
			user.password().sendKeys(pass);
			Select drpDate = new Select(user.date());
			Select drpMonth = new Select(user.month());
			Select drpYear = new Select(user.year());
			String date = (rc.readExcel(5, 2, "signin", input2)).toString();
			drpDate.selectByValue(date);
			String month = (rc.readExcel(6, 2, "signin", input2)) + " ";
			Thread.sleep(100);
			drpMonth.selectByVisibleText(month);
			String year = (rc.readExcel(7, 2, "signin", input2)).toString();
			drpYear.selectByValue(year);
			user.address().sendKeys(address);
			Thread.sleep(100);
			user.city().sendKeys(city);
			Select drpState = new Select(user.state());
			String state = (rc.readExcel(10, 2, "signin", input2));
			Thread.sleep(100);
			drpState.selectByVisibleText(state);
			user.postcode().sendKeys(postcode);
			Select drpCountry = new Select(user.country());
			String country = (rc.readExcel(12, 2, "signin", input2));
			Thread.sleep(100);
			drpCountry.selectByVisibleText(country);
			Thread.sleep(100);
			user.mobileNum().sendKeys(number);
			Thread.sleep(100);
			user.register().click();
		}
			ReadWriteExcel search = new ReadWriteExcel();
			Cart items = new Cart(webdriver);
			String product3 = search.readExcel(3, 0, "prodSearch", input2);
			items.addSearch().sendKeys(product3);
			Thread.sleep(500);
			items.clickSearch().click();
			Thread.sleep(1000);
			Actions act = new Actions(webdriver);
			act.moveToElement(items.stock()).build().perform();
			items.colorWhite().click();
			Thread.sleep(1000);
			items.selectQuantity3().clear();
			items.selectQuantity3().sendKeys("15");
			Select drpSize3 = new Select(items.size3());
			String size3 = (search.readExcel(3, 2, "prodSearch", input2));
			Thread.sleep(100);
			drpSize3.selectByVisibleText(size3);
			items.cartBtn3().click();
			Thread.sleep(1000);
			WebDriverWait wait = new WebDriverWait(webdriver, 120);
			wait.until(ExpectedConditions.elementToBeClickable(items.continueShopping));
			items.continueShopping().click();
			Thread.sleep(1000);

			String product1 = search.readExcel(1, 0, "prodSearch", input2);
			items.addSearch().clear();
			items.addSearch().sendKeys(product1);
			Thread.sleep(500);
			items.clickSearch().click();
			Thread.sleep(1000);
			act.moveToElement(items.stock()).build().perform();
			items.colorGreen().click();
			Thread.sleep(1000);
			items.selectQuantity3().clear();
			items.selectQuantity3().sendKeys("10");
			Select drpSize1 = new Select(items.size1());
			String size1 = (search.readExcel(1, 2, "prodSearch", input2));
			Thread.sleep(100);
			drpSize1.selectByVisibleText(size1);
			items.cartBtn3().click();
			Thread.sleep(1000);
			wait.until(ExpectedConditions.elementToBeClickable(items.continueShopping));
			items.continueShopping().click();
			Thread.sleep(1000);

			String product2 = search.readExcel(2, 0, "prodSearch", input2);
			items.addSearch().clear();
			items.addSearch().sendKeys(product2);
			Thread.sleep(500);
			items.clickSearch().click();
			Thread.sleep(1000);
			act.moveToElement(items.stock()).build().perform();
			items.colorBlue().click();
			Thread.sleep(1000);
			items.selectQuantity3().clear();
			items.selectQuantity3().sendKeys("12");
			Select drpSize2 = new Select(items.size2());
			String size2 = (search.readExcel(2, 2, "prodSearch", input2));
			Thread.sleep(100);
			drpSize2.selectByVisibleText(size2);
			items.cartBtn3().click();
			Thread.sleep(1000);
			wait.until(ExpectedConditions.elementToBeClickable(items.continueShopping));
			items.continueShopping().click();
			Thread.sleep(1000);
			
			ReadWriteExcel out = new ReadWriteExcel();
			Cart details = new Cart(webdriver);
			details.clickCartBtn().click();
			System.out.println(details.getProdName3().getText());
			String name3 = details.getProdName3().getText();
			// out.write(1,0,name3,"Product");
			String sku3 = details.getSku3().getText().substring(6);
			String[] details1 = details.getColor3().getText().split(",");
			String[] data3 = details1[0].split(":");
			String color3 = data3[1];
			// out.write(1, 1,color3,"Product");
			data3 = details1[1].split(":");
			String size33 = data3[1];
			// out.write(1, 2,size3,"Product");
			String quant3 = details.getQuant3().getAttribute("value");
			System.out.println("total" + "  " + quant3);

			// out.write(1, 3,quant3,"Product");
			String currency3 = details.getPrice3().getText().substring(1);
			String price3 = currency3;
			// out.write(1, 4,price3,"Product");
			List<String> detailsProduct3 = new ArrayList<String>();

			detailsProduct3.add(name3);
			detailsProduct3.add(color3);
			detailsProduct3.add(sku3);
			detailsProduct3.add(size33);
			detailsProduct3.add(quant3);
			detailsProduct3.add(price3);
			out.write(detailsProduct3, "Product", output2);
			detailsProduct3.clear();
			Thread.sleep(1000);
//---------------------------------------------Step6 Part2-----------------------------------------------------------------------------------
			String name1 = details.getProdName1().getText();
			// out.write(1,0,name3,"Product");
			String sku1 = details.getSku1().getText().substring(6);
			String[] details2 = details.getColor1().getText().split(",");
			String[] data1 = details2[0].split(":");
			String color1 = data1[1];
			// out.write(1, 1,color3,"Product");
			data1 = details2[1].split(":");
			String size11 = data1[1];
			// out.write(1, 2,size3,"Product");
			String quant1 = details.getQuant1().getAttribute("value");
			// out.write(1, 3,quant3,"Product");
			String currency1 = details.getPrice1().getText().substring(1);
			String price1 = currency1;

			// out.write(1, 4,price3,"Product");
			// List<String> detailsProduct1=new ArrayList<String>();

			detailsProduct3.add(name1);
			detailsProduct3.add(color1);
			detailsProduct3.add(sku1);
			detailsProduct3.add(size11);
			detailsProduct3.add(quant1);
			detailsProduct3.add(price1);
			out.write(detailsProduct3, "Product", output2);
			detailsProduct3.clear();
			Thread.sleep(1000);

//		*/
//-----------------------------------Step6 Part3-----------------------------------------------------------------------------------------------

			String name2 = details.getProdName2().getText();
			// out.write(1,0,name3,"Product");
			String sku2 = details.getSku2().getText().substring(6);
			String[] details3 = details.getColor2().getText().split(",");
			String[] data2 = details3[0].split(":");
			String color2 = data2[1];
			// out.write(1, 1,color3,"Product");
			data2 = details3[1].split(":");
			String size22 = data2[1];
			// out.write(1, 2,size3,"Product");
			String quant2 = details.getQuant2().getAttribute("value");
			// out.write(1, 3,quant3,"Product");
			String currency2 = details.getPrice2().getText().substring(1);
			String price2 = currency2;
			// out.write(1, 4,price3,"Product");

			// List<String> detailsProduct2=new ArrayList<String>();

			detailsProduct3.add(name2);
			detailsProduct3.add(color2);
			detailsProduct3.add(sku2);
			detailsProduct3.add(size22);
			detailsProduct3.add(quant2);
			detailsProduct3.add(price2);
			out.write(detailsProduct3, "Product", output2);
			detailsProduct3.clear();
			Thread.sleep(1000);

//-----------------------------------------------------Step7------------------------------------------------------------------------	
			String total_prod = details.getTotalProducts().getText().substring(1);
			String totProds = total_prod;

			String total_ship = details.getTotalShipping().getText().substring(1);
			String totShip = total_ship;

			String total_price = details.getTotalPrice().getText().substring(1);
			String totPrice = total_price;

			List<String> totalProduct = new ArrayList<String>();

			totalProduct.add(totProds);
			totalProduct.add(totShip);
			totalProduct.add(totPrice);
			out.write(totalProduct, "Price", output2);
			totalProduct.clear();
			Thread.sleep(1000);
//

//---------------------------Remove Product3-----------------------------------------------------------------------------------------
//----------------------------------------Step8--------------------------------------------------------------------------------------	
			String product33 = out.readExcel(3, 0, "prodSearch", input2);
			if (name3.equalsIgnoreCase(product3)) {
				details.delProduct3().click();
			} else {
				System.out.println("Try Again");
			}
			Thread.sleep(1000);
			Thread.sleep(1000);
			Thread.sleep(1000);

//----------------------------------------------Step9------------------------------------------------------------------------------------------
			String newname1 = details.getNewProd1().getText();
			// out.write(1,0,name3,"Product");
			String newsku1 = details.getNewSku1().getText().substring(6);
			String[] newdetails1 = details.getNewColor1().getText().split(",");
			String[] newdata1 = newdetails1[0].split(":");
			String newcolor1 = newdata1[1];
			// out.write(1, 1,color3,"Product");
			newdata1 = newdetails1[1].split(":");
			String newsize1 = newdata1[1];
			// out.write(1, 2,size3,"Product");
			String newquant1 = details.getNewQuant1().getAttribute("value");
			// out.write(1, 3,quant3,"Product");
			String newcurrency1 = details.getNewPrice1().getText().substring(1);
			String newprice1 = newcurrency1;
			// out.write(1, 4,price3,"Product");

			detailsProduct3.add(newname1);
			detailsProduct3.add(newcolor1);
			detailsProduct3.add(newsku1);
			detailsProduct3.add(newsize1);
			detailsProduct3.add(newquant1);
			detailsProduct3.add(newprice1);
			out.write(detailsProduct3, "Product", output2);
			detailsProduct3.clear();
			Thread.sleep(1000);

			String newname2 = details.getNewProd2().getText();
			// out.write(1,0,name3,"Product");
			String newsku2 = details.getNewSku2().getText().substring(6);
			String[] newdetails2 = details.getNewColor2().getText().split(",");
			String[] newdata2 = newdetails2[0].split(":");
			String newcolor2 = newdata2[1];
			// out.write(1, 1,color3,"Product");
			newdata2 = newdetails2[1].split(":");
			String newsize2 = newdata2[1];
			// out.write(1, 2,size3,"Product");
			String newquant2 = details.getNewQuant2().getAttribute("value");
			// out.write(1, 3,quant3,"Product");
			String newcurrency2 = details.getNewPrice2().getText().substring(1);
			String newprice2 = newcurrency2;
			// out.write(1, 4,price3,"Product");

			detailsProduct3.add(newname2);
			detailsProduct3.add(newcolor2);
			detailsProduct3.add(newsku2);
			detailsProduct3.add(newsize2);
			detailsProduct3.add(newquant2);
			detailsProduct3.add(newprice2);
			out.write(detailsProduct3, "Product", output2);
			detailsProduct3.clear();
			Thread.sleep(1000);

//---------------------------------Step10---------------------------------------------------------------------------------------------------
			String newtotal_prod = details.getNewTotalProducts().getText().substring(1);
			String newtotProds = newtotal_prod;

			String newtotal_ship = details.getNewTotalShipping().getText().substring(1);
			String newtotShip = newtotal_ship;

			String newtotal_price = details.getNewTotalPrice().getText().substring(1);
			String newtotPrice = newtotal_price;

			totalProduct.add(newtotProds);
			totalProduct.add(newtotShip);
			totalProduct.add(newtotPrice);
			out.write(totalProduct, "Price", output2);
			totalProduct.clear();
			Thread.sleep(1000);
			Thread.sleep(1000);
//-------------------------------------------Step11---------------------------------------------------------------------------------------
			details.getNewQuant1().clear();
			Thread.sleep(1000);
			Thread.sleep(1000);
			details.getNewQuant1().sendKeys("20");
			Thread.sleep(1000);
			Thread.sleep(1000);
			webdriver.navigate().refresh();
			Thread.sleep(1000);
//----------------------------------------Step12------------------------------------------------------------------------------------
			String newname3 = details.getNewProd1().getText();
			// out.write(1,0,name3,"Product");
			String newsku3 = details.getNewSku1().getText().substring(6);
			String[] newdetails3 = details.getNewColor1().getText().split(",");
			String[] newdata3 = newdetails3[0].split(":");
			String newcolor3 = newdata3[1];
			// out.write(1, 1,color3,"Product");
			newdata3 = newdetails3[1].split(":");
			String newsize3 = newdata3[1];
			// out.write(1, 2,size3,"Product");
			String newquant3 = details.getNewQuant1().getAttribute("value");
			// out.write(1, 3,quant3,"Product");
			String newcurrency3 = details.getNewPrice1().getText().substring(1);
			String newprice3 = newcurrency3;
			// out.write(1, 4,price3,"Product");

			detailsProduct3.add(newname3);
			detailsProduct3.add(newcolor3);
			detailsProduct3.add(newsku3);
			detailsProduct3.add(newsize3);
			detailsProduct3.add(newquant3);
			detailsProduct3.add(newprice3);
			out.write(detailsProduct3, "Product", output2);
			detailsProduct3.clear();
			Thread.sleep(1000);

			String newname4 = details.getNewProd2().getText();
			// out.write(1,0,name3,"Product");
			String newsku4 = details.getNewSku2().getText().substring(6);
			String[] newdetails4 = details.getNewColor2().getText().split(",");
			String[] newdata4 = newdetails4[0].split(":");
			String newcolor4 = newdata4[1];
			// out.write(1, 1,color3,"Product");
			newdata4 = newdetails4[1].split(":");
			String newsize4 = newdata4[1];
			// out.write(1, 2,size3,"Product");
			String newquant4 = details.getNewQuant2().getAttribute("value");
			// out.write(1, 3,quant3,"Product");
			String newcurrency4 = details.getNewPrice2().getText().substring(1);
			String newprice4 = newcurrency4;
			// out.write(1, 4,price3,"Product");

			detailsProduct3.add(newname4);
			detailsProduct3.add(newcolor4);
			detailsProduct3.add(newsku4);
			detailsProduct3.add(newsize4);
			detailsProduct3.add(newquant4);
			detailsProduct3.add(newprice4);
			out.write(detailsProduct3, "Product", output2);
			detailsProduct3.clear();
			Thread.sleep(1000);

//---------------------------------Step13---------------------------------------------------------------------------------------------------
			String newtotal_prod1 = details.getNewTotalProducts().getText().substring(1);
			String newtotProds1 = newtotal_prod1;

			String newtotal_ship1 = details.getNewTotalShipping().getText().substring(1);
			String newtotShip1 = newtotal_ship1;

			String newtotal_price1 = details.getNewTotalPrice1().getText().substring(1);
			String newtotPrice1 = newtotal_price1;

			totalProduct.add(newtotProds1);
			totalProduct.add(newtotShip1);
			totalProduct.add(newtotPrice1);
			out.write(totalProduct, "Price", output2);
			totalProduct.clear();
			Thread.sleep(1000);
			Thread.sleep(1000);

			ReadWriteExcel rw = new ReadWriteExcel();
			CheckOut chkout = new CheckOut(webdriver);
//--------------------------------Step14-------------------------------------------------------------------------------------------------		
			chkout.clickCheckOut().click();
			String[] name = chkout.getName().getText().split(" ");
			String firstName = name[0];
			System.out.println(firstName);
			String lastName = name[1];
			System.out.println(lastName);

			String address = chkout.getCity().getText();
			System.out.println(address);
			String[] combine = chkout.getState().getText().split(" ");
			String city = combine[0];
			String city1 = city.substring(0, city.length() - 1);
			System.out.println(city1);

			String state = combine[1];
			System.out.println(state);

			String postal = combine[2];
			System.out.println(postal);

			String country = chkout.getCountry().getText();
			System.out.println(country);

			String contact = chkout.getContact().getText();
			System.out.println(contact);

			List<String> checkout = new ArrayList<String>();

			checkout.add(firstName);
			checkout.add(lastName);
			checkout.add(address);
			checkout.add(city1);
			checkout.add(state);
			checkout.add(postal);
			checkout.add(country);
			checkout.add(contact);

			rw.write(checkout, "Registration", output2);
			checkout.clear();
			Thread.sleep(1000);
			Thread.sleep(1000);

//---------------------------------------------------Step15-------------------------------------------------------
			chkout.clickAddressPageCheckOut().click();
			String actUrl = webdriver.getCurrentUrl();
			String expUrl = "http://automationpractice.com/index.php?controller=order";
			if (actUrl.equalsIgnoreCase(expUrl)) {
				System.out.println("Shipping page displayed");
			}
			Thread.sleep(1000);
			chkout.clickTOS().click();
			Thread.sleep(1000);
			chkout.clickAShippingPageCheckOut().click();
			Thread.sleep(1000);
			chkout.clickPaybank().click();
			Thread.sleep(1000);
			chkout.clickConfirmOrderBtn().click();
			Thread.sleep(1000);
			Thread.sleep(1000);

//-------------------------------------------------------Step16---------------------------------------------------------------
			String finalamount = chkout.getFinalAmount().getText().substring(1);
			checkout.add(finalamount);
			rw.write(checkout, "Order Confirmation", output2);
			checkout.clear();
			Thread.sleep(1000);
			Thread.sleep(1000);
			chkout.clickBackOrderBtn().click();
			Thread.sleep(1000);
			Thread.sleep(1000);
//---------------------------------------------------Step17-------------------------------------------------------------------
			OrderHistory oh = new OrderHistory(webdriver);

			String orderRef = oh.getOrderRef().getText();
			String orderDate = oh.getDate().getText();
			String orderPrice = oh.getPrice().getText().substring(1);
			String orderPaymentMethod = oh.getPayment().getText();
			String orderStatus = oh.getStatus().getText();

			checkout.add(orderRef);
			checkout.add(orderDate);
			checkout.add(orderPrice);
			checkout.add(orderPaymentMethod);
			checkout.add(orderStatus);
			rw.write(checkout, "Order History", output2);
			checkout.clear();
			Thread.sleep(1000);
			Thread.sleep(1000);

		}
	
}