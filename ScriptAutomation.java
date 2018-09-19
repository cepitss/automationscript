public class CreateAccount {
	
	WebDriver driver = new ChromeDriver();
	String baseUrl = "http://automationpractice.com/index.php";
	
	String LOGIN = By.className("login");
	String NEW_EMAIL = By.id("email_create");
	String CREATE_ACCOUNT = By.id("SubmitCreate");

	String INVALID_EMAIL = By.xpath("//*[@id='create_account_error']");
	String invalidEmailMessage = "Invalid email address";
	
	String VALID_EMAIL = By.xpath("//*[@id='noSlide']/h1");
	String validEmailMessage = "CREATE AN ACCOUNT";
	
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
	String errorMessage = "There are 13 errors";
	String errorEmailMessage = "email is invalid.";
	String errorPasswordMessage = "passwd is invalid.";
	String errorPostalCodeMessage = "The Zip/Postal code you've entered is invalid. It must follow this format: 00000.";
	String errorMobilePhoneMessage = "phone_mobile is invalid.";
	String errorHomePhoneMessage = "You must register at least one phone number.";
	
	String SUCCESS_SUBMIT = By.xpath("//*[@id='center_column']/p");
	String successMessage = "Welcome to your account. Here you can manage all of your personal information and orders.";
	
	// Test Valid Email
	public void invalidEmail() {	
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
		
        //check message
		WebElement validMessage = driver.findElement(VALID_EMAIL);
		
		String actualValidMessage = validMessage.getText().trim();
		
		assertTrue("Page isnt right", actualValidMessage.contains(validEmailMessage));
			 
		//close web
        driver.close();		
	}
	
	// Test Invalid Email
	public void invalidEmail() {	
        //open web	
		driver.get(baseUrl);	

		//click signin button	
		WebElement loginButton = driver.findElement(LOGIN);
		loginButton.click();	
		
        //input email
		WebElement newEmailField = driver.findElement(NEW_EMAIL);
		newEmailField.sendKeys("coba@gmail");
		
        //click create an account button
		WebElement createButton = driver.findElement(CREATE_ACCOUNT);
		createButton.click();
		
        //check message
		WebElement errorInvalidMessage = driver.findElement(INVALID_EMAIL);
		
		String actualInvalidMessage = errorInvalidMessage.getText().trim();
		
		assertTrue("Incorrect Details Message", actualInvalidMessage.contains(invalidEmailMessage));
			   
		//close web
        driver.close();
	}
	
	// Test Success Create an Account
	public void successCreate() {	
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
		
		//input mobile phone
		WebElement phoneField = driver.findElement(MOBILE);
		phoneField.sendKeys("081234567890");
		
		//input alias
		WebElement aliasField = driver.findElement(ALIAS);
		aliasField.sendKeys("Alias");
		
        //click register button
		WebElement submitButton = driver.findElement(SUBMIT_ACCOUNT);
		submitButton.click();
		
		//check message
		WebElement expectedSuccessMessage = driver.findElement(SUCCESS_SUBMIT);
		
		String actualSuccessMessage = expectedSuccessMessage.getText().trim();
		
		assertTrue("Error", actualSuccessMessage.contains(successMessage));
			   
		//close web
        driver.close();
	}
	
	// Test Mandatory Field
	public void checkMandatory() {	
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
		firstNameField.sendKeys("");
		
		//input last name in your personal information section
		WebElement lastNameField = driver.findElement(LAST_NAME);
		lastNameField.sendKeys("");
		
		//input email
		WebElement emailField = driver.findElement(EMAIL);
		emailField.sendKeys("");
		
		//input password
		WebElement passwordField = driver.findElement(PASSWORD);
		passwordField.sendKeys("");
		
		//input first name in your address section
		WebElement firstNameAddressField = driver.findElement(FIRSTNAME);
		firstNameAddressField.sendKeys("");
		
		//input last name in your address section
		WebElement lastNameAddressField = driver.findElement(LASTNAME);
		lastNameAddressField.sendKeys("");
		
		//input address
		WebElement addressField = driver.findElement(ADDRESS);
		addressField.sendKeys("");
		
		//input city
		WebElement cityField = driver.findElement(CITY);
		cityField.sendKeys("");
		
		//select state
		Select stateDropdown = driver.findElement(STATE);
		stateDropdown.selectByValue("");
		
		//input postal code
		WebElement postalCodeField = driver.findElement(POSTCODE);
		postalCodeField.sendKeys("");
		
		//select country
		Select countryDropdown = driver.findElement(COUNTRY);
		countryDropdown.selectByValue("");
		
		//input mobile phone
		WebElement phoneField = driver.findElement(MOBILE);
		phoneField.sendKeys("");
		
		//input alias
		WebElement aliasField = driver.findElement(ALIAS);
		aliasField.sendKeys("");
		
        //click register button
		WebElement submitButton = driver.findElement(SUBMIT_ACCOUNT);
		submitButton.click();
		
		//check message
		WebElement expectedErrorMessage = driver.findElement(ERROR_SUBMIT);
		
		String actualErrorMessage = expectedErrorMessage.getText().trim();
		
		assertTrue("Error", actualErrorMessage.contains(errorMessage));
			   
		//close web
        driver.close();
	}
	
	// Test Email in Form Create an Account
	public void invalidEmailAccount() {	
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
		
        //input email
		WebElement newEmailField = driver.findElement(EMAIL);
		newEmailField.sendKeys("coba@gmail");
		
        //click register button
		WebElement submitButton = driver.findElement(SUBMIT_ACCOUNT);
		submitButton.click();
		
		//check message
		WebElement expectedErrorMessage = driver.findElement(ERROR_SUBMIT);
		
		String actualErrorMessage = expectedErrorMessage.getText().trim();
		
		assertTrue("Error", actualErrorMessage.contains(errorEmailMessage));
			   
		//close web
        driver.close();
	}
	
	// Test Password (min : 5 characters)
	public void passwordLessThan5Characters() {	
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
		
        //input password
		WebElement passwordField = driver.findElement(PASSWORD);
		passwordField.sendKeys("123");
		
        //click register button
		WebElement submitButton = driver.findElement(SUBMIT_ACCOUNT);
		submitButton.click();
		
        //check message
		WebElement expectedErrorMessage = driver.findElement(ERROR_SUBMIT);
		
		String actualErrorMessage = expectedErrorMessage.getText().trim();
		
		assertTrue("Error", actualErrorMessage.contains(errorPasswordMessage));
			   
		//close web
        driver.close();			   
	}
	
	// Test Postal Code (Postal code should be 5 numbers)
	public void postalCodeLessThan5Numbers() {	
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
		
        //input postal code less than 5 number
		WebElement postalCodeField = driver.findElement(POSTCODE);
		postalCodeField.sendKeys("123");
		
        //click register button
		WebElement submitButton = driver.findElement(SUBMIT_ACCOUNT);
		submitButton.click();
		
        //check message
		WebElement expectedErrorMessage = driver.findElement(ERROR_SUBMIT);
		
		String actualErrorMessage = expectedErrorMessage.getText().trim();
		
		assertTrue("Error", actualErrorMessage.contains(errorPostalCodeMessage));
		
		//close web
        driver.close();		
	}
	
	// Test Postal Code (Postal code should be numeric)
	public void postalCodeLessThan5Numbers() {	
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
		
        //input postal code except numeric
		WebElement postalCodeField = driver.findElement(POSTCODE);
		postalCodeField.sendKeys("ABC!@)");
		
        //click register button
		WebElement submitButton = driver.findElement(SUBMIT_ACCOUNT);
		submitButton.click();
		
        //check message
		WebElement expectedErrorMessage = driver.findElement(ERROR_SUBMIT);
		
		String actualErrorMessage = expectedErrorMessage.getText().trim();
		
		assertTrue("Error", actualErrorMessage.contains(errorPostalCodeMessage));
		
		//close web
        driver.close();		
	}
	
	// Test Mobile Phone (Mobile phone should be numeric)
	public void mobilePhoneCharacter() {	
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
		
        //input mobile phone except numeric
		WebElement phoneField = driver.findElement(MOBILE);
		phoneField.sendKeys("abcdefghij");
		
        //click register button
		WebElement submitButton = driver.findElement(SUBMIT_ACCOUNT);
		submitButton.click();
		
        //check message
		WebElement expectedErrorMessage = driver.findElement(ERROR_SUBMIT);
		
		String actualErrorMessage = expectedErrorMessage.getText().trim();
		
		assertTrue("Error", actualErrorMessage.contains(errorMobilePhoneMessage));
		
		//close web
        driver.close();		
	}
	
	// Test Mandatory Mobile Phone
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
		
        //input home phone
		WebElement phoneField = driver.findElement(PHONE);
		phoneField.sendKeys("021808888888");
		
        //click register button
		WebElement submitButton = driver.findElement(SUBMIT_ACCOUNT);
		submitButton.click();
		
        //check message
		WebElement expectedErrorMessage = driver.findElement(ERROR_SUBMIT);
		
		String actualErrorMessage = expectedErrorMessage.getText().trim();
		
		assertTrue("Error", actualErrorMessage.contains(errorHomePhoneMessage));
		
		//close web
        driver.close();		
	}
}