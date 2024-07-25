package utility_File;

import static org.testng.Assert.fail;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base_Class {

		public static WebDriver driver;
		private static FileInputStream f;
		private static JavascriptExecutor js;
		private static Actions actions;
		private static WebDriverWait wait;
		public static Robot r;

		@BeforeClass
		public static void openbrowser() {
			openBrowser("chrome");

		}
		public static void RobotSendkeys(String s) {
			try {
				r = new  Robot();
			} catch (AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			   for (char key : s.toCharArray()) {
	               int keyCode = KeyEvent.getExtendedKeyCodeForChar(key);
	               r.keyPress(keyCode);
	               r.keyRelease(keyCode);
	               r.delay(100);
	           }
			   }
		
		
		public static void openBrowser(String browser) {
			switch (browser) {
			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;

			case "edge":
				driver = new EdgeDriver();
				break;
			case "firefox":
				driver = new FirefoxDriver();
				break;
			default:
				System.out.println("Please enter valid browser name");
				break;
			}
		}

		public static void initpage(Object obj) {
			PageFactory.initElements(driver, obj);
		}

		public static String Read_Property(String key) {
			try {
				f = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\Config.properties");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			Properties p = new Properties();
			String property = "";
			try {
				p.load(f);
				property = p.getProperty(key);

			} catch (IOException e) {
				e.printStackTrace();
			}

			return property;
		}
		@BeforeMethod
      public static void lauchUrl() {
			urlLaunch(Read_Property("url"));
	}
		public static void urlLaunch(String url) {
			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		}

		public static WebElement waitsforclick(WebElement w) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			return wait.until(ExpectedConditions.elementToBeClickable(w));
		}

		public static String currentUrl() {
			String currentUrl = driver.getCurrentUrl();
			return currentUrl;
		}

		public static String title() {
			String title = driver.getTitle();
			return title;
		}

		public static void navigateToUrl(String url) {
			driver.navigate().to(url);
		}

		public static void switchtoSecondWindow() {
			try {
				String parentwindow = driver.getWindowHandle();
				Set<String> allwindows = driver.getWindowHandles();
				for (String x : allwindows) {
					if (!x.equals(parentwindow)) {
						driver.switchTo().window(x);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		public static void switchtoMultipleWindow(int index) {
			try {
				String cId = driver.getWindowHandle();
				Set<String> pId = driver.getWindowHandles();
				List<String> li = new ArrayList<String>();
				li.addAll(pId);
				driver.switchTo().window(li.get(index));
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException();

			}

		}

		public static void switchtoIframe(String options, Object value) {
			try {
				if (options.equalsIgnoreCase("index")) {
					driver.switchTo().frame(Integer.parseInt((String) value));
				} else if (options.equalsIgnoreCase("name")) {
					driver.switchTo().frame((String) value);
				} else if (options.equalsIgnoreCase("element")) {
					driver.switchTo().frame((WebElement) value);
				}
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}

		public static void switchtoDefualtContent() {
			try {
				driver.switchTo().defaultContent();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public static void scrollUpandScrollDownusingElement(WebElement elementlocator) {
			try {
				js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView();", elementlocator);
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException();

			}
		}

		public static void highlightElement(WebElement element) {
			try {
				String originalStyle = element.getAttribute("style");
				js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",
						element);

				Thread.sleep(1000);
				js.executeScript("arguments[0].setAttribute('style', '" + originalStyle + "');", element);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		public static void click(WebElement w) {
			try {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
				wait.until(ExpectedConditions.elementToBeClickable(w));
				js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click()", w);
			} catch (Exception e) {
				js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click()", w);
			}

		}

		public static void screenshot(String name) {
			TakesScreenshot tk = (TakesScreenshot) driver;
			File src = tk.getScreenshotAs(OutputType.FILE);
			File f = new File(System.getProperty("user.dir" + "\\Screenshots\\" + name + ".png"));
			try {
				FileUtils.copyFile(src, f);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		public static void ElementIsDisplayed(WebElement w) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(w));
			w.isDisplayed();
		}

		public static void doubleClick(WebElement element) {
			try {
				actions = new Actions(driver);
				actions.doubleClick(element).build().perform();
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException();

			}
		}

		public static void dropdown(WebElement dropdownlocator, String drop) {
			try {
				Select sc = new Select(dropdownlocator);
				if (drop.equalsIgnoreCase("value")) {
					sc.selectByValue(drop);
				} else if (drop.equalsIgnoreCase("visibletext")) {
					sc.selectByVisibleText(drop);
				} else if (drop.equalsIgnoreCase("index")) {
					sc.selectByIndex(Integer.parseInt(drop));
				}

			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException();
			}
		}

		public static void sendkeys(WebElement elementlocator, String inputvalue) {
			try {
				elementlocator.sendKeys(inputvalue);
			} catch (Exception e) {
				js.executeScript("arguments[0].setAttribute('value','" + inputvalue + "')", elementlocator);
			}
		}

		public static void scrolltoBottomPage() {
			try {
				js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException();

			}
		}

		public static void ClickByOffset(int x, int y) {
			actions = new Actions(driver);
			actions.moveByOffset(x, y).click().perform();
		}

		public static void rightClick() {
			actions = new Actions(driver);
			actions.contextClick().perform();
		}

		public static void elementRightClick(WebElement e) {
			actions = new Actions(driver);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.elementToBeClickable(e));
			actions.contextClick(e).perform();
		}

		public static void doubleClick() {
			actions = new Actions(driver);
			actions.doubleClick().perform();
		}

		public static void elementdoubleClick(WebElement e) {
			actions = new Actions(driver);
			actions.doubleClick(e).perform();
		}

		public static void dragAndDrop(WebElement e1, WebElement e2) {
			actions = new Actions(driver);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.elementToBeClickable(e1));
			actions.dragAndDrop(e1, e2).perform();
		}

		public static void moveToElement(WebElement e) {
			actions = new Actions(driver);
			actions.moveToElement(e).perform();
		}

		public static void useKey(int j) {
			try {
				r = new Robot();
			} catch (AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			r.keyPress(j);
			r.keyRelease(j);
		}

		public static WebElement verifyTextIsPresent(String tag, String s) {
			try {
				WebElement element = driver.findElement(By.xpath("//" + tag + "[text()='" + s + "']"));
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
				wait.until(ExpectedConditions.textToBePresentInElement(element, s));
				element.isDisplayed();
			} catch (Exception e) {
				fail(s+" Text Not Present");
			}
			return driver.findElement(By.xpath("//" + tag + "[text()='" + s + "']"));
			

		}

		public static String verifyAttribute(WebElement w, String attributename) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(w));
			String attribute = w.getAttribute(attributename);
			return attribute;
		}

		protected static SoftAssert softAssert;

		public static SoftAssert asserts() {
			if (softAssert == null) {
				softAssert = new SoftAssert();
			}
			return softAssert;
		}

		public static void assertAll() {
			if (softAssert != null) {
				softAssert.assertAll();
				softAssert = new SoftAssert(); // Reset the softAssert instance after asserting all
			}
		}

		public static void waits(int i) {
			try {
				Thread.sleep(1000 * i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		public static void openNewTab(WebElement w, int i) {
			moveToElement(w);
			waits(2);
			elementRightClick(w);
			useKey(KeyEvent.VK_DOWN);
			useKey(KeyEvent.VK_ENTER);
			waits(2);
			switchtoMultipleWindow(i);
		}

	

		static FileOutputStream output;

		public static Object DynamicwriteProperty(String key, String value) {
			Properties properties = new Properties();
			String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\DynamicConfig.properties";
			try (FileInputStream fileInputStream = new FileInputStream(filePath)) {
				properties.load(fileInputStream);
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			Object setProperty = properties.setProperty(key, value);
			try (FileOutputStream fileOutputStream = new FileOutputStream(filePath)) {
				properties.store(fileOutputStream, null);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return setProperty;
		}

		public static String DynamicRead_Property(String key) {
			try {
				f = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\resources\\DynamicConfig.properties");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			Properties p = new Properties();
			String property = "";
			try {
				p.load(f);
				property = p.getProperty(key);

			} catch (IOException e) {
				e.printStackTrace();
			}

			return property;
		}

		public static void mouseClick(WebElement e) {
			actions = new Actions(driver);
			actions.moveToElement(e).click().perform();
		}

		public static void resetBrowser() {
			driver.manage().deleteAllCookies();
			js = (JavascriptExecutor) driver;
			js.executeScript("window.localStorage.clear();");
			js.executeScript("window.sessionStorage.clear();");
			driver.navigate().refresh();
		}

		
	

	}


