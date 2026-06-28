package com.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage extends BasePage {

    public WebDriver driver;



    public AccountPage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
        //PageFactory.initElements(driver,LoginPage.class);
    }

    @FindBy(name = "accountname")
    WebElement tb_accountname;

    @FindBy(xpath = "//input[@name='button']")
    WebElement btn_save;





    public void createaccount(String acc)
    {
        setAccountname(acc);
        clickSave();

    }

    public void setAccountname(String acc)
    {
        setInput(tb_accountname,acc,acc+" has been entered into account name fields");
    }



    public void clickSave()
    {
        clickElement(btn_save,"Clicked on Save button");
    }









}
