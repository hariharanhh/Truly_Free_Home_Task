package page_Object;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utility_File.Base_Class;

public class Sign_In_Object extends Base_Class{

	public Sign_In_Object() {

		initpage(this);
}
	
	@FindBy(xpath = "//p[@class='jsx-46f6405b54523d64 sub_title']/following-sibling::button[1]")
	private WebElement signupLink;
	

	@FindBy(xpath="//div[@class='flag-container']/following-sibling::input[1]")
	private WebElement signupMobile;
	
	@FindBy(xpath = "//span[text()='CONTINUE']/following::input")
	private WebElement termscond;
	
	@FindBy(xpath = "//button[contains(@class,'MuiButtonBase-root MuiButton-root')]//span[1]")
	private WebElement continuebtn;
	
	@FindBy(xpath = "//button[@type='button']//span[1]")
	private WebElement otpbtn;
	
	@FindBy(xpath = "(//span[text()='(COMING SOON)']/following::input)[1]")
	private WebElement firstName;
	
	@FindBy(xpath = "(//label[contains(@class,'jsx-214831360 input-label')]//input)[2]")
	private WebElement lastName;
	
	@FindBy(xpath = "(//label[contains(@class,'jsx-214831360 input-label')]//input)[3]")
	private WebElement email;
	
	@FindBy(xpath = "//span[text()='DONE']")
	private WebElement doneBtn;
	
	@FindBy(xpath = "//div[contains(@class,'jsx-1005774697 auto_save_card')]//button[1]")
	private WebElement cartBtn;
	
// Login Objects
	
	@FindBy(xpath = "//div[@class='jsx-1990881828 profile_box']//span[1]")
	private WebElement logIn;
	
	@FindBy(xpath = "//div[contains(@class,'intl-tel-input allow-dropdown')]//input[1]")
	private WebElement signinNum;
	
	@FindBy(xpath = "//div[contains(@class,'jsx-4225831484 jss7')]//div[1]")
	private WebElement signinbtn;
	
	@FindBy(xpath = "(//span[text()='Change']/following::input)[1]")
	private WebElement signinOtp;
	
	
	@FindBy(xpath = "(//li[contains(@class,'jsx-2446998146 position-relative-menu')]//div)[2]")
	private WebElement brands;
	
	@FindBy(xpath = "//ul[@class='jsx-2446998146 row containerCustom has-multi justify-content-center pt-4']//following::a[@href='/store/Emani/652ec33ad12e5c37a1839ea2']")
	private WebElement emani;
	
	@FindBy(xpath = "(//a[contains(@class,'jsx-c3ec2b6b129f087d d-block')]//img)[3]")
	private WebElement product;
	
	@FindBy(xpath = "//div[@class='jsx-1005774697 tabs']/following-sibling::h1[1]")
	private WebElement productName;
	
	@FindBy(xpath = "//div[@class='jsx-f7424bbc83273932 subscription_option']//select[1]")
	private WebElement quantity;
	
	@FindBy(xpath = "(//li[contains(@class,'jsx-1508469962 link_item')]//a)[2]")
	private WebElement gotoCart;
	
	@FindBy(xpath = "//div[@class='summary_card']//a[1]")
	private WebElement checkoutBtn;
	
	@FindBy(xpath = "(//div[contains(@class,'jsx-319696017 col-12')]//input)[1]")
	private WebElement detailFname;
	
	@FindBy(xpath = "(//div[contains(@class,'jsx-319696017 col-12')]//input)[2]")
	private WebElement detailLname;
	
	@FindBy(xpath = "//div[contains(@class,'intl-tel-input allow-dropdown')]//input[1]")
	private WebElement detailPhno;
	
	@FindBy(xpath = "(//label[@class='jsx-319696017 input_lable']/following-sibling::input)[1]")
	private WebElement address;
	
	@FindBy(xpath = "(//label[@class='jsx-319696017 input_lable']/following-sibling::input)[2]")
	private WebElement zipCode;
	
	@FindBy(xpath = "(//label[@class='jsx-319696017 input_lable']/following-sibling::input)[3]")
	private WebElement city;

	@FindBy(xpath = "(//input[contains(@class,'jsx-319696017 inputFields')])[3]")
	private WebElement state;
	
	@FindBy(xpath = "(//div[contains(@class,'select__value-container select__value-container--has-value')]//div)[1]")
	private WebElement country;
	
	@FindBy(xpath = "//div[contains(@class,'jsx-39816980 button_container')]//button[1]")
	private WebElement checkContinue;
	
	@FindBy(xpath = "//button[text()='Continue']")
	private WebElement detailsContinue;
	
	@FindBy(xpath = "//div[@class='jsx-3023080569 payment_content']/following-sibling::button[1]")
	private WebElement addcardBtn;
	
	@FindBy(xpath = "(//div[contains(@class,'jsx-65ec41720f925320 form-group')]//input)[1]")
	private WebElement cardName;
	
	@FindBy(xpath = "//input[@name='card_number']")
	private WebElement cardNum;
	
	@FindBy(xpath = "//form[@id='cvv-form']//label[@class='visuallyhidden']")
	private WebElement cardCvv;
	
	@FindBy(xpath = "((//div[contains(@class,'jsx-65ec41720f925320 form-group')]//input)[2]")
	private WebElement expiryMonth;
	
	@FindBy(xpath = "(//div[contains(@class,'jsx-65ec41720f925320 form-group')]//input)[3]")
	private WebElement expiryYear;
	
	@FindBy(xpath = "(//div[contains(@class,'jsx-65ec41720f925320 form-group')]//input)[3]")
	private WebElement orderandCheckout;
	
	@FindBy(xpath = "//button[@id='sumbitbutton']")
	private WebElement addcardButton;
	
	@FindBy(xpath = "//div[contains(@class,'jsx-39816980 button_container')]//button[1]")
	private WebElement confirmorder;
	
	@FindBy(xpath = "//a[@class='jsx-1739826010 buton_container ']")
	private WebElement continueShop;
	
	@FindBy(css ="svg.close_icon")
	private WebElement closeIcon;
	
	
	public WebElement getSignLink() {
		return signupLink;
	}
	
	public WebElement getsignMobile() {
		return signupMobile;
	}
	
	public WebElement gettermscond() {
		return termscond;
	}
	
	public WebElement getcontinuebtn() {
		return continuebtn;
	}
	
	
	public WebElement getotpbtn() {
		return otpbtn;
	}
	
	public WebElement getfirstName() {
		return firstName;
	}
	public WebElement getlastName() {
		return lastName;
	}
	public WebElement getemail() {
		return email;
	}
	public WebElement getdoneBtn() {
		return doneBtn;
	}
	
	public WebElement getlogIn() {
		return logIn;
	}
	
	public WebElement getsigninNum() {
		return signinNum;
	}
	
	public WebElement getsigninbtn() {
		return signinbtn;
	}
	
	public WebElement getbrands() {
		return brands;
	}
	
	public WebElement getemani() {
		return emani;
	}
	
	public WebElement getproduct() {
		return product;
	}
	
	public WebElement getproductName() {
		return productName;
	}
	
	public WebElement getquantity() {
		return quantity;
	}
	
	public WebElement getcartBtn() {
		return cartBtn;
	}
	
	public WebElement getgotoCart() {
		return gotoCart;
	}
	
	public WebElement getcheckoutBtn() {
		return checkoutBtn;
	}
	
	public WebElement getdetailFname() {
		return detailFname;
	}
	
	public WebElement getdetailLname() {
		return detailLname;
	}
	
	public WebElement getdetailPhno() {
		return detailPhno;
	}
	
	public WebElement getaddress() {
		return address;
	}
	
	public WebElement getzipCode() {
		return zipCode;
	}
	
	public WebElement getcity() {
		return city;
	}
	
	public WebElement getstate() {
		return state;
	}
	
	public WebElement getcountry() {
		return country;
	}
	
	public WebElement getcheckContinue() {
		return checkContinue;
	}
	
	public WebElement getdetailsContinue() {
		return detailsContinue;
	}
	
	public WebElement getaddcardBtn() {
		return addcardBtn;
	}
	
	public WebElement getcardName() {
		return cardName;
	}
	
	public WebElement getcardNum() {
		return cardNum;
	}
	
	public WebElement getcardCvv() {
		return cardCvv;
	}
	
	public WebElement getexpiryMonth() {
		return expiryMonth;
	}
	
	public WebElement getexpiryYear() {
		return expiryYear;
	}
	
	public WebElement getorderandCheckout() {
		return orderandCheckout;
	}
	
	public WebElement getaddcardButton() {
		return addcardButton;
	}
	
	public WebElement getconfirmorder() {
		return confirmorder;
	}
	
	public WebElement getcloseIcon() {
		return closeIcon;
	}
	
	public WebElement getcontinueShop() {
		return continueShop;
	}
	
	public static Sign_In_Object signIn() {

		Sign_In_Object sign = new Sign_In_Object();
		return sign;
		
	}

	
	
	
	
	
	
	
	
}