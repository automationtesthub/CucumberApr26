package com.vtiger.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadPage extends BasePage {

    public WebDriver driver;



    public LeadPage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
        //PageFactory.initElements(driver,LoginPage.class);
    }

    @FindBy(name = "lastname")
    WebElement tb_lastname;

    @FindBy(xpath = "//input[@name='company']")
    WebElement tb_company;

    @FindBy(xpath = "//input[@name='button']")
    WebElement btn_save;





    public void createlead(String lname,String comp)
    {
        setLastname(lname);
        setCompany(comp);
        clickSave();

    }

    public void setLastname(String lname)
    {
        setInput(tb_lastname,lname,lname+" has been entered into lastname fields");
    }

    public void setCompany(String comp)
    {
        setInput(tb_company,comp,comp+" has been entered in company fields");
    }

    public void clickSave()
    {
        clickElement(btn_save,"Clicked on Save button");
    }









}
