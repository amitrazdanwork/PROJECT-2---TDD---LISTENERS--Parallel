package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;

	/* Data members */
	@FindBy(xpath = "//div[@class='panel header']//ul//li[@data-label='or']//a[contains(text(), 'Sign In')]")
	WebElement signInPageUrl;

	@FindBy(xpath = "//div[@class='panel header']//ul//li//a[contains(text(), 'Create')]")
	WebElement createAnAccountUrl;

	@FindBy(xpath = "//a[contains(@href, 'what-is-new')]")
	WebElement whatsNewLink;

	@FindBy(xpath = "//li//a[@id='ui-id-4' and contains(@href,'women')]")
	WebElement womensLink;

	@FindBy(xpath = "//li//a[@id='ui-id-5' and contains(@href,'men')]")
	WebElement menLink;

	@FindBy(xpath = "//li//a[@id='ui-id-6' and contains(@href,'gear')]")
	WebElement gearLink;

	@FindBy(xpath = "//li//a[@id='ui-id-7' and contains(@href,'training')]")
	WebElement trainingLink;

	@FindBy(xpath = "//li//a[@id='ui-id-8' and contains(@href,'sale')]")
	WebElement saleLink;

	@FindBy(xpath = "//input[@id='search']")
	WebElement searchTextbox;

	@FindBy(xpath = "//button[@title='Search']")
	WebElement searchSubmitButton;

	@FindBy(xpath = "//a[@class='action showcart']")
	WebElement ShowCartLink;

	/* ------------------ Constructor ------------------ */
	public HomePage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*------------------  Member/Action methods --------------------*/

	// Method 1
	public void ClickSignIn() {
		signInPageUrl.click();
	}

	// Method 2
	public void ClickCreateAccount() {
		createAnAccountUrl.click();
	}

	// Method 3
	public void ClickWhatsNewLink() {
		whatsNewLink.click();
	}

	// Method 4
	public void ClickWomenLink() {
		createAnAccountUrl.click();
	}

	// Method 5
	public void ClickMenLink() {
		menLink.click();
	}

	// Method 6
	public void ClickGearLink() {
		createAnAccountUrl.click();
	}

	// Method 7
	public void ClickTrainingLink() {
		trainingLink.click();
	}

	// Method 8
	public void ClickSaleLink() {
		saleLink.click();
	}

	

}
