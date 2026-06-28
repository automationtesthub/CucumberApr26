package com.vtiger.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    public WebDriver driver;



    public HomePage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);

    }

    @FindBy(linkText = "Home")
    WebElement lnk_home;

    @FindBy(linkText = "Logout")
    WebElement lnk_logout;

    @FindBy(linkText = "New Lead")
    WebElement lnk_NewLead;

    @FindBy(linkText = "New Account")
    WebElement lnk_NewAccount;




    public void clickNewAccount()
    {
        clickElement(lnk_NewAccount,"Link new Account clicked");
    }

    public void clickNewLead()
    {
        clickElement(lnk_NewLead,"Link new lead clicked");
    }

    public void clickLogout()
    {
        clickElement(lnk_logout,"Link Logout clicked");
    }

    public void clickHome()
    {
        clickElement(lnk_home,"Link Home clicked");
    }

    public void verifyLogout()
    {
        ElementVisible(lnk_logout," Link Logout is displayed");
    }
    public void verifyHome()
    {
        ElementVisible(lnk_home,"Link Home is displayed");
    }







}
