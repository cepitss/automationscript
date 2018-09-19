public class BugFound {
	
	WebDriver driver = new ChromeDriver();
	String baseUrl = "http://automationpractice.com/index.php";
	
	String LOGIN = By.className("login");
	String NEW_EMAIL = By.id("email_create");
	String CREATE_ACCOUNT = By.id("SubmitCreate");
	
	String FIRST_NAME = By.id("customer_firstname");
	String LAST_NAME = By.id("customer_lastname");
	String EMAIL = By.id("email");
	String PASSWORD = By.id("passwd");
	
	String FIRSTNAME = By.id("firstname");
	String LASTNAME = By.id("lastname");
	String ADDRESS = By.id("address1");
	String CITY = By.id("city");
	String STATE = By.id("id_state");
	String POSTCODE = By.id("postcode");
	String COUNTRY = By.id("id_country");
	String PHONE = By.id("phone");
	String MOBILE = By.id("phone_mobile");
	String ALIAS = By.id("alias");
	
	String SUBMIT_ACCOUNT = By.id("SubmitAccount");
	
	String ERROR_SUBMIT = By.xpath("//*[@id='center_column']/div");
	String errorMessage = "You must register at least one phone number.";
	
	// Bug
	public void mandatoryMobile() {	
        //open web	
		driver.get(baseUrl);	

		//click signin button	
		WebElement loginButton = driver.findElement(LOGIN);
		loginButton.click();
		
        //input email
		WebElement newEmailField = driver.findElement(NEW_EMAIL);
		newEmailField.sendKeys("coba@gmail.com");
		
        //click create an account button
		WebElement createButton = driver.findElement(CREATE_ACCOUNT);
		createButton.click();
		
        //input first name in your personal information section
		WebElement firstNameField = driver.findElement(FIRST_NAME);
		firstNameField.sendKeys("Ini");
		
		//input last name in your personal information section
		WebElement lastNameField = driver.findElement(LAST_NAME);
		lastNameField.sendKeys("Budi");
		
		//input email
		WebElement emailField = driver.findElement(EMAIL);
		emailField.sendKeys("coba@gmail.com");
		
		//input password
		WebElement passwordField = driver.findElement(PASSWORD);
		passwordField.sendKeys("12345");
		
		//input first name in your address section
		WebElement firstNameAddressField = driver.findElement(FIRSTNAME);
		firstNameAddressField.sendKeys("Ini");
		
		//input last name in your address section
		WebElement lastNameAddressField = driver.findElement(LASTNAME);
		lastNameAddressField.sendKeys("Ani");
		
		//input address
		WebElement addressField = driver.findElement(ADDRESS);
		addressField.sendKeys("Jalan Budaya Kita No. 14");
		
		//input city
		WebElement cityField = driver.findElement(CITY);
		cityField.sendKeys("Jakarta");
		
		//select state
		Select stateDropdown = driver.findElement(STATE);
		stateDropdown.selectByValue("1");
		
		//input postal code
		WebElement postalCodeField = driver.findElement(POSTCODE);
		postalCodeField.sendKeys("12345");
		
		//select country
		Select countryDropdown = driver.findElement(COUNTRY);
		countryDropdown.selectByValue("21");
		
		//input home phone
		WebElement phoneField = driver.findElement(PHONE);
		phoneField.sendKeys("021808888888");
		
		//input alias
		WebElement aliasField = driver.findElement(ALIAS);
		aliasField.sendKeys("Alias");
		
        //click register button
		WebElement submitButton = driver.findElement(SUBMIT_ACCOUNT);
		submitButton.click();
		
		//check message
		WebElement expectedMessage = driver.findElement(ERROR_SUBMIT);
		
		String actualMessage = expectedMessage.getText().trim();
		
		assertTrue("Not Passed", actualMessage.contains(errorMessage));
			   
		//close web
        driver.close();
	}
}