package com.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.qa.base.BaseTest;
import com.qa.dataproviders.DataProviderClass;
import com.qa.listeners.Listeners;
import com.qa.pages.CreateAccountPage;
import com.qa.utils.ConfigReader;

public class TS001 extends Listeners {

	/* Object creation/ instantiation of page objects */
	CreateAccountPage capage;

	String Mandatory_Warning = "This is a required field.";
	String Format_Warning = "Minimum length of this field must be equal or greater than 8 symbols. Leading and trailing spaces will be ignored.";

	@Test(description = "Verify that the Create an Account form contains below mentioned fields : -\r\n" + "\r\n"
			+ "Labels: -\r\n" + "\"First Name\"\r\n" + "\"Last Name\"\r\n" + "\"Email\"\r\n" + "\"Password\"\r\n"
			+ "\"Confirm Password\"\r\n" + "\r\n" + "Textboxes:-\r\n" + "\"First Name\" textbox\r\n"
			+ "\"Last Name\" textbox\r\n" + "\"Email\" textbox\r\n" + "\"Password\" textbox\r\n"
			+ "\"Confirm Password\" textbox\r\n" + "\r\n" + "Buttons:-\r\n"
			+ "\"Create an account\" button", priority = 0, groups = { "sanity" })
	public void TS001_TC001() {

		System.out.println("The thread ID is " + Thread.currentThread().getId());
	
		getDriver().get(ConfigReader.GetCreateAccountPageUrl());
		extentTest.log(Status.INFO, "User opens Create an Account webpage.");

		capage = new CreateAccountPage(getDriver(), wait);

		Assert.assertEquals(capage.GetFirstNameLabel(), "First Name");
		extentTest.log(Status.INFO, "Label of first name field is " + capage.GetFirstNameLabel());

		Assert.assertEquals(capage.GetLastNameLabel(), "Last Name");
		extentTest.log(Status.INFO, "Label of last name field is " + capage.GetLastNameLabel());

		Assert.assertEquals(capage.GetEmailLabel(), "Email");
		extentTest.log(Status.INFO, "Label of email field is " + capage.GetEmailLabel());

		Assert.assertEquals(capage.GetPasswordLabel(), "Password");
		extentTest.log(Status.INFO, "Label of password field is " + capage.GetPasswordLabel());

		Assert.assertEquals(capage.GetConfirmPasswordLabel(), "Confirm Password");
		extentTest.log(Status.INFO, "Label of confirm password field is " + capage.GetConfirmPasswordLabel());

		Assert.assertEquals(capage.GetCreateAccountButtonLabel(), "Create an Account");
		extentTest.log(Status.INFO, "Label of Create An Account field is " + capage.GetCreateAccountButtonLabel());

	}

	@Test(description = "Verify presence of valid placeholder under Password label Textbox. Minimum length of this field must be equal or greater than 8 symbols. Leading and trailing spaces will be ignored.", priority = 1, groups = {
			"smoke" }, dataProvider = "TestData", dataProviderClass = DataProviderClass.class)
	public void TS001_TC002(String Password) {

		System.out.println("The thread ID for Firefox is " + Thread.currentThread().getId());

		getDriver().get(ConfigReader.GetCreateAccountPageUrl());
		extentTest.log(Status.INFO, "User opens Create an Account webpage.");

		capage = new CreateAccountPage(getDriver(), wait);

		capage.EnterPassword(Password);
		extentTest.log(Status.INFO, "User enters any random string in Password textbox");

		Assert.assertEquals(capage.GetPasswordTextboxErrorMessage(), Format_Warning);
		extentTest.log(Status.INFO, "User got password error message as " + capage.GetPasswordTextboxErrorMessage());

	}

	@Test(description = "Verify that system generates a validation message when clicking on submit button without filling all the mandatory fields.", priority = 2, groups = {
			"functional" })
	public void TS001_TC003() {

		System.out.println("The thread ID for Firefox is " + Thread.currentThread().getId());

		getDriver().get(ConfigReader.GetCreateAccountPageUrl());
		extentTest.log(Status.INFO, "User opens Create an Account webpage.");

		capage = new CreateAccountPage(getDriver(), wait);
		
		capage.ClickCreateAccountButton();
		extentTest.log(Status.INFO, "User clicked on Create An Account button");

		SoftAssert assert1 = new SoftAssert();
		
		assert1.assertEquals(capage.GetFirstNameTextboxErrorMessage(), Mandatory_Warning);
		extentTest.log(Status.INFO,
				"User got warning message under first name textbox as " + capage.GetFirstNameTextboxErrorMessage());

		assert1.assertEquals(capage.GetLastNameTextboxErrorMessage(), Mandatory_Warning);
		extentTest.log(Status.INFO,
				"User got warning message under last name textbox as " + capage.GetLastNameTextboxErrorMessage());
		// extentTest.log(Status.INFO, "User got warning message under last name textbox
		// as "+capage.GetLastNameTextboxErrorMessage());)

		assert1.assertEquals(capage.GetEmailTextboxErrorMessage(), Mandatory_Warning);
		extentTest.log(Status.INFO,
				"User got warning message under email address textbox as " + capage.GetEmailTextboxErrorMessage());

		assert1.assertEquals(capage.GetPasswordTextboxErrorMessage(), Mandatory_Warning);
		extentTest.log(Status.INFO,
				"User got warning message under password textbox as " + capage.GetPasswordTextboxErrorMessage());

		assert1.assertEquals(capage.GetConfirmPasswordTextboxErrorMessage(), Mandatory_Warning);
		extentTest.log(Status.INFO, "User got warning message under password confirmation textbox as "
				+ capage.GetConfirmPasswordTextboxErrorMessage());

		assert1.assertAll();
	}

	@Test(description = "Verify that entering blank spaces on mandatory fields lead to validation error", priority = 5, groups = {
			"smoke" })
	public void TS001_TC004() {

		System.out.println("The thread ID for Firefox is " + Thread.currentThread().getId());
	
		getDriver().get(ConfigReader.GetCreateAccountPageUrl());
		extentTest.log(Status.INFO, "User opens Create an Account webpage.");

		capage = new CreateAccountPage(getDriver(), wait);

		SoftAssert assert1 = new SoftAssert();

		capage.EnterFirstName(" ");
		extentTest.log(Status.INFO, "User enters white-spaces in first name textbox");

		capage.EnterLastName(" ");
		extentTest.log(Status.INFO, "User enters white-spaces in last name textbox");

		capage.EnterEmail("    ");
		extentTest.log(Status.INFO, "User enters white-spaces in email-address textbox");

		capage.EnterPassword("  ");
		extentTest.log(Status.INFO, "User enters white-spaces in password textbox");

		capage.EnterConfirmPassword("  ");
		extentTest.log(Status.INFO, "User enters white-spaces in confirmation-password textbox");

		capage.ClickCreateAccountButton();
		extentTest.log(Status.INFO, "User clicks on Create An Account button");

		assert1.assertEquals(capage.GetFirstNameTextboxErrorMessage(), Mandatory_Warning);
		extentTest.log(Status.INFO,
				"User got warning message under first name textbox as " + capage.GetFirstNameTextboxErrorMessage());

		assert1.assertEquals(capage.GetLastNameTextboxErrorMessage(), Mandatory_Warning);
		extentTest.log(Status.INFO,
				"User got warning message under last name textbox as " + capage.GetFirstNameTextboxErrorMessage());

		assert1.assertEquals(capage.GetEmailTextboxErrorMessage(), Mandatory_Warning);
		extentTest.log(Status.INFO,
				"User got warning message under email-address textbox as " + capage.GetEmailTextboxErrorMessage());

		assert1.assertEquals(capage.GetPasswordTextboxErrorMessage(), Mandatory_Warning);
		extentTest.log(Status.INFO,
				"User got warning message under password textbox as " + capage.GetPasswordTextboxErrorMessage());

		assert1.assertEquals(capage.GetConfirmPasswordTextboxErrorMessage(), Mandatory_Warning);
		extentTest.log(Status.INFO, "User got warning message under password confirmation textbox"
				+ capage.GetConfirmPasswordTextboxErrorMessage());

		assert1.assertAll();
	}

	@Test(description = "Verify that the password is in encrypted form when entered", priority = 6, groups = {
			"sanity" }, dataProvider = "TestData", dataProviderClass = DataProviderClass.class)
	public void TS001_TC005(String Password) {

		System.out.println("The thread ID for Firefox is " + Thread.currentThread().getId());

		getDriver().get(ConfigReader.GetCreateAccountPageUrl());
		extentTest.log(Status.INFO, "User opens Create an Account webpage.");

		capage = new CreateAccountPage(getDriver(), wait);

		capage.EnterPassword(Password);
		extentTest.log(Status.INFO, "User enters any random string in password textbox");

		Assert.assertTrue(capage.CheckEncryptedPassword("type"));
		extentTest.log(Status.INFO,
				"User validates entered string is converted in its encrypted form in password textbox");

	}
}
