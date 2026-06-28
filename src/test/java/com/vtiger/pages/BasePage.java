package com.vtiger.pages;

import com.vtiger.sptesDefinitions.basesteps;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class BasePage {

    public WebDriver driver;
    public WebDriverWait wait;

    public BasePage(WebDriver driver)
    {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    }


    public void setInput(WebElement elm, String data,String msg)
    {
        try {
            wait.until(ExpectedConditions.visibilityOf(elm));
            elm.clear();
            elm.sendKeys(data);
            basesteps.logger.pass(msg+"  "+getScreenshot());
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            basesteps.logger.fail("unable to enter data due to error "+e.getMessage()+"  "+getScreenshot());
        }

    }

    public void clickElement(WebElement elm, String msg)
    {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(elm));
            elm.click();
            basesteps.logger.pass(msg+"  "+getScreenshot());
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            basesteps.logger.fail("Unable to click due to error "+e.getMessage()+" "+getScreenshot());
        }

    }

    public void ElementVisible(WebElement elm, String msg)
    {
        try {
            wait.until(ExpectedConditions.visibilityOf(elm));
            elm.isDisplayed();
            basesteps.logger.pass(msg+"  "+getScreenshot());
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            basesteps.logger.fail("No element present due to error  "+e.getMessage()+"  "+getScreenshot());
        }

    }

    public static String getScreenshot()
    {
        Date d = new Date();
        DateFormat ft = new SimpleDateFormat("ddMMyyyyhhmmss");
        String fileName = ft.format(d);
        String path = System.getProperty("user.dir") + "/src/test/java/com/vtiger/reports/screenshot/"+fileName+".png";
        TakesScreenshot ts = ((TakesScreenshot)basesteps.driver);
        File SrcFile=ts.getScreenshotAs(OutputType.FILE);
        //Move image file to new destination
        File DestFile=new File(path);
        //Copy file at destination
        try {
            FileUtils.copyFile(SrcFile, DestFile);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String imagepath = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href='"+path+"'><span class='label time-taken grey lighten-1 white-text'>Screenshot</span><a>";
        return imagepath;
    }



}
