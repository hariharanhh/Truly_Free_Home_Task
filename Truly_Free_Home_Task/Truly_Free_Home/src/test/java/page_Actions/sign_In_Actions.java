package page_Actions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import page_Object.Sign_In_Object;
import utility_File.Base_Class;

public class sign_In_Actions extends Base_Class {

	public static void TC_01() {
		click(Sign_In_Object.signIn().getSignLink());
		sendkeys(Sign_In_Object.signIn().getsignMobile(), "9046875698");
		click(Sign_In_Object.signIn().gettermscond());
		click(Sign_In_Object.signIn().getcontinuebtn());

		List<WebElement> otpField = driver.findElements(By.xpath("(//span[text()='Change']/following::input)"));
		for (int i = 1; i <= otpField.size(); i++) {
			WebElement otp = driver.findElement(By.xpath("(//span[text()='Change']/following::input)[" + i + "]"));
			otp.sendKeys("1");
		}

		click(Sign_In_Object.signIn().getotpbtn());
		waits(5);
		sendkeys(Sign_In_Object.signIn().getfirstName(), "steve");
		sendkeys(Sign_In_Object.signIn().getlastName(), "smith");
		sendkeys(Sign_In_Object.signIn().getemail(), "stevesmithcric812529@gmail.com");

		waits(5);

		doubleClick(Sign_In_Object.signIn().getdoneBtn());
		doubleClick(Sign_In_Object.signIn().getdoneBtn());
		doubleClick(Sign_In_Object.signIn().getdoneBtn());
		doubleClick(Sign_In_Object.signIn().getdoneBtn());
		doubleClick(Sign_In_Object.signIn().getdoneBtn());
		waits(5);
	}

	public static void TC_02() throws AWTException {


		//		try {
		//			TC_01();
		//		} catch (Exception e) {
		//			TC_03();
		//		}

		TC_01();

		//driver.findElement(By.xpath(""));
		List<WebElement> otpField2 = driver.findElements(By.xpath("(//span[text()='Change']/following::input)"));
		for (int i = 1; i <= otpField2.size(); i++) {
			WebElement otp = driver.findElement(By.xpath("(//span[text()='Change']/following::input)[" + i + "]"));
			otp.sendKeys("1");
		}

		moveToElement(Sign_In_Object.signIn().getbrands());
		waits(3);
		click(Sign_In_Object.signIn().getemani());
		waits(3);

		List<WebElement> productsName = driver.findElements(By.xpath("//div[@class='jsx-3233812718 row m-auto']//div[@class='jsx-c3ec2b6b129f087d product_grid_container col-6 col-md-6 col-lg-6 col-xl-4 product_item']//span[@class='jsx-c3ec2b6b129f087d card_title d-inline-block text-truncate w-100']"));
		List<WebElement> productsPrice = driver.findElements(By.xpath("//div[@class='jsx-3233812718 row m-auto']//div[@class='jsx-c3ec2b6b129f087d product_grid_container col-6 col-md-6 col-lg-6 col-xl-4 product_item']//span[@class='jsx-c3ec2b6b129f087d stroke']"));


		Workbook workbook = new XSSFWorkbook();// Create a Workbook
		Sheet sheet = workbook.createSheet("Products");// Create a Sheet
		Row headerRow = sheet.createRow(0);// Create a Row
		Cell headerCell1 = headerRow.createCell(0);// Create cells
		headerCell1.setCellValue("Product Name");
		Cell headerCell2 = headerRow.createCell(1);
		headerCell2.setCellValue("Product Price");
		for (int i = 0; i < productsName.size(); i++) {
			Row row = sheet.createRow(i + 1);

			Cell cell1 = row.createCell(0);
			cell1.setCellValue(productsName.get(i).getText());

			Cell cell2 = row.createCell(1);
			cell2.setCellValue(productsPrice.get(i).getText());
		}
		try (FileOutputStream fileOut = new FileOutputStream("products.xlsx")) {
			workbook.write(fileOut);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// Closing the workbook
			try {
				workbook.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		WebElement text21 = driver.findElement(By.xpath("(//div[@class='jsx-c3ec2b6b129f087d card_content_wrapper pt-0']//descendant::span[@class='jsx-c3ec2b6b129f087d card_title d-inline-block text-truncate w-100'])[3]"));
		String text22 = text21.getText();
		System.out.println(text22);
		waits(3);
		click(Sign_In_Object.signIn().getproduct()); 
		WebElement productname = driver.findElement(By.xpath("//div[@class='jsx-1005774697 tabs']/following-sibling::h1[1]"));
		String productText = productname.getText();
		System.out.println(productText);
		Assert.assertEquals(productText, text22);
		click(Sign_In_Object.signIn().getquantity());
		waits(3);
		String qty ="2";
		Select s=new Select(Sign_In_Object.signIn().getquantity());
		s.selectByVisibleText(qty);
		waits(3);
		click(Sign_In_Object.signIn().getcartBtn());
		waits(3);
		click(Sign_In_Object.signIn().getgotoCart());
		waits(3);

		WebElement cartqnty = driver.findElement(By.xpath("//select[@class='select_option']"));
		Select s1=new Select(cartqnty);
		List<WebElement> allSelectedOptions = s1.getAllSelectedOptions();
		for (int i = 0; i < allSelectedOptions.size(); i++) {
			String text = allSelectedOptions.get(i).getText();
			asserts().assertEquals(qty, text);
			assertAll();
			System.out.println(allSelectedOptions.get(i).getText());
			waits(3);
			click(Sign_In_Object.signIn().getcheckoutBtn());

			// Filling Details Address
			try {
				sendkeys(Sign_In_Object.signIn().getdetailFname(), "Jerrico");
				sendkeys(Sign_In_Object.signIn().getdetailLname(), "Jen");
				sendkeys(Sign_In_Object.signIn().getdetailPhno(), "9566204549");

				sendkeys(Sign_In_Object.signIn().getaddress(), "10 Battery Pl");
				sendkeys(Sign_In_Object.signIn().getzipCode(), "10004");
				sendkeys(Sign_In_Object.signIn().getcity(), "New York");
				scrolltoBottomPage();
				sendkeys(Sign_In_Object.signIn().getstate(), "New York");
				sendkeys(Sign_In_Object.signIn().getcountry(), "United States Of America");


			}

			catch (Exception e) {
				click(Sign_In_Object.signIn().getcheckContinue());
				waits(5);// TODO: handle exception
			}


waits(3);
			click(Sign_In_Object.signIn().getdetailsContinue());
			// Add Card Details
			waits(8);
			System.out.println("clicked");
			click(Sign_In_Object.signIn().getaddcardBtn());
			//Name
			sendkeys(Sign_In_Object.signIn().getcardName(), "Steve");
			waits(2);

			Robot r= new Robot();
			r.keyPress(KeyEvent.VK_TAB);
			r.keyRelease(KeyEvent.VK_TAB);
			waits(3);
			//CardNumber
			RobotSendkeys("4242424242424242");
			r.keyPress(KeyEvent.VK_TAB);
			r.keyRelease(KeyEvent.VK_TAB);
			r.keyRelease(KeyEvent.VK_TAB);
			waits(3);
			RobotSendkeys("111");
			// Date
			waits(2);
			WebElement expireDate = driver.findElement(By.xpath("//div[@class='jsx-65ec41720f925320 form-group mb-3 position-relative']//input[@class='jsx-65ec41720f925320 form-control paymentField']"));
			expireDate.sendKeys("5");
			waits(4);
			//year
			WebElement year = driver.findElement(By.xpath("//div[@class='jsx-65ec41720f925320 form-group mb-1']//input[@class='jsx-65ec41720f925320 form-control paymentField']"));
			year.sendKeys("2026");
			waits(3);
			click(Sign_In_Object.signIn().getaddcardButton());
			waits(3);
			click(Sign_In_Object.signIn().getconfirmorder());
			waits(4);
			driver.findElement(By.cssSelector("svg.close_icon")).click();
			waits(8);

			WebElement profile = driver.findElement(By.xpath("//div[@class='jsx-4ee11fac50694d5a position-relative']//button[@class='jsx-4ee11fac50694d5a menu__button']"));
			profile.click();
            waits(3);
			WebElement logout=driver.findElement(By.xpath("//p[text()='Logout']"));
			logout.click();
		}
	}
	public static void TC_03() {
		click(Sign_In_Object.signIn().getlogIn());
		sendkeys(Sign_In_Object.signIn().getsigninNum(), "9898657845");
		click(Sign_In_Object.signIn().getcontinuebtn());
	}
}
