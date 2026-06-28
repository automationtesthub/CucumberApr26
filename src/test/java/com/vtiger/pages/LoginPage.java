package com.vtiger.pages;

import com.vtiger.sptesDefinitions.basesteps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage{

   public WebDriver driver;

   //String username = "//input[@name='user_name']";

   // By username = By.name("user_name");

   // WebElement username = driver.findElement(By.name("user_name"));

    public LoginPage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
        //PageFactory.initElements(driver,LoginPage.class);
    }

    @FindBy(name = "user_name")
    WebElement tb_username;

    @FindBy(xpath = "//input[@name='user_password']")
    WebElement tb_password;

    @FindBy(xpath = "//input[@name='Login']")
    WebElement btn_login;

    @FindBy(xpath = "//*[contains(text(),'You must specify a valid username and password.')]")
    WebElement txt_Error_msg;



    public void login(String userid,String pwd)
    {
       setUsername(userid);
       setPassword(pwd);
       clickLogin();

    }

    public void setUsername(String userid)
    {
        setInput(tb_username,userid,"Userid "+userid+" has been entered in userid fields");

    }

    public void setPassword(String pwd)
    {
        setInput(tb_password,pwd,"Password "+pwd+" has been entered in password fields");
    }

    public void clickLogin()
    {
        clickElement(btn_login,"Login button clicked");
    }

    public void verifyErrorMsg()
    {
        ElementVisible(txt_Error_msg,"Error message validated");
    }







}
