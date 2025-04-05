package com.qa.pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateAccountPage {

	WebDriver driver;
	WebDriverWait wait;

	/* Page elements */

	@FindBy(xpath = "//*[@for='firstname']//span")
	WebElement FirstNameLabel;

	@FindBy(xpath = "//*[@for='lastname']//span")
	WebElement LastNameLabel;

	@FindBy(xpath = "//*[@for='email_address']//span")
	WebElement EmailLabel;

	@FindBy(xpath = "//*[@for='password']//span")
	WebElement PasswordLabel;

	@FindBy(xpath = "//*[@for='password-confirmation']//span")
	WebElement ConfirmPasswordLabel;

	@FindBy(xpath = "//*[@title='Create an Account']//span")
	WebElement CreateAccountButtonLabel;

	@FindBy(xpath = "//*[@id='firstname']")
	WebElement FirstNameTextbox;

	@FindBy(xpath = "//*[@id='lastname']")
	WebElement LastNameTextbox;

	@FindBy(xpath = "//*[@id='email_address']")
	WebElement EmailAddressTextbox;

	@FindBy(xpath = "//*[@id='password']")
	WebElement PasswordTextbox;

	@FindBy(xpath = "//*[@id='password-confirmation']")
	WebElement ConfirmPasswordTextbox;

	@FindBy(xpath = "//*[@title='Create an Account']")
	WebElement CreateAccountButton;

	@FindBy(xpath = "//*[@id='firstname-error']")
	WebElement FirstNameError;

	@FindBy(xpath = "//*[@id='lastname-error']")
	WebElement LasttNameError;

	@FindBy(xpath = "//*[@id='email_address-error']")
	WebElement EmailError;

	@FindBy(xpath = "//*[@id='password-error']")
	WebElement PasswordError;

	@FindBy(xpath = "//*[@id='password-confirmation-error']")
	WebElement ConfirmPasswordError;

	/* Constructor */
	public CreateAccountPage(WebDriver driver, WebDriverWait wait) {
		// TODO Auto-generated constructor stub

		this.driver = driver;
		PageFactory.initElements((SearchContext) driver, this);

		this.wait = wait;

	}

	/* Action Methods */

	public String GetFirstNameLabel() {

		if (FirstNameLabel.isDisplayed())
			return FirstNameLabel.getText();
		else
			throw new NoSuchElementException("First Name label is not displayed");
	}

	public String GetLastNameLabel() {

		if (LastNameLabel.isDisplayed())
			return LastNameLabel.getText();
		else
			throw new NoSuchElementException("Last Name label is not displayed");

	}

	public String GetEmailLabel() {

		if (EmailLabel.isDisplayed())
			return EmailLabel.getText();
		else
			throw new NoSuchElementException("Email label is not displayed");
	}

	public String GetPasswordLabel() {
		if (PasswordLabel.isDisplayed())
			return PasswordLabel.getText();
		else
			throw new NoSuchElementException("Password label is not displayed");
	}

	public String GetConfirmPasswordLabel() {

		if (ConfirmPasswordLabel.isDisplayed())
			return ConfirmPasswordLabel.getText();
		else
			throw new NoSuchElementException("Confirm password label is not displayed");
	}

	public void EnterFirstName(String value) {

		if (FirstNameTextbox.isDisplayed())
			FirstNameTextbox.sendKeys(value);
		else
			throw new NoSuchElementException("Not able to enter any value in First Name textbox");
	}

	public void EnterLastName(String value) {

		if (LastNameTextbox.isDisplayed())
			LastNameTextbox.sendKeys(value);
		else
			throw new NoSuchElementException("Not able to enter any value in Last Name textbox");
	}

	public void EnterPassword(String value) {
		if (PasswordTextbox.isDisplayed())
			PasswordTextbox.sendKeys(value);
		else
			throw new NoSuchElementException("Not able to enter any value in Password textbox");
	}

	public void EnterConfirmPassword(String value) {
		if (ConfirmPasswordTextbox.isDisplayed())
			ConfirmPasswordTextbox.sendKeys(value);
		else
			throw new NoSuchElementException("Not able to enter any value in Confirm Password textbox");
	}

	public void EnterEmail(String value) {
		if (EmailAddressTextbox.isDisplayed())
			EmailAddressTextbox.sendKeys(value);
		else
			throw new NoSuchElementException("Not able to enter any value in Email textbox");
	}

	public String GetCreateAccountButtonLabel() {

		if (CreateAccountButtonLabel.isDisplayed())
			return CreateAccountButtonLabel.getText();
		else
			throw new NoSuchElementException("Not able to enter any value in Create An Account textbox");
	}

	public void ClickCreateAccountButton() {

		if (CreateAccountButton.isDisplayed())
			CreateAccountButton.click();
		else
			throw new NoSuchElementException("Not able to enter any value in Create An Account button");
	}

	public boolean CheckEncryptedPassword(String AttributeName) {

		if (PasswordTextbox.getAttribute("type").equalsIgnoreCase("password"))
			return true;
		else
			return false;
	}

	public String GetPasswordTextboxErrorMessage() {
		
			return PasswordError.getText();

	}

	public String GetFirstNameTextboxErrorMessage() {
		return FirstNameError.getText();
	}

	public String GetLastNameTextboxErrorMessage() {
		return LasttNameError.getText();
	}

	public String GetEmailTextboxErrorMessage() {
		return EmailError.getText();
	}

	public String GetConfirmPasswordTextboxErrorMessage() {
		return ConfirmPasswordError.getText();
	}
}
