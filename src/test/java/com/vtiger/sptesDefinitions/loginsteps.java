package com.vtiger.sptesDefinitions;

import com.aventstack.extentreports.ExtentTest;
import com.codoid.products.exception.FilloException;
import com.vtiger.pages.AccountPage;
import com.vtiger.pages.HomePage;
import com.vtiger.pages.LeadPage;
import com.vtiger.pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class loginsteps extends basesteps{

    @BeforeAll
    public static void initiation() throws FilloException, IOException {
        createExtentReport();
        readExcelData("Sheet1");
        readconfig();
    }

    @Before
    public void setup(Scenario scenario)
    {
        TCName = scenario.getName().trim();
        logger = extent.createTest(TCName);
    }

    @After
    public void tierdown(Scenario scenario)
    {
        System.out.println("After hook executed");
        byte[] screenshot = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.BYTES);
        //FileUtils.copyFile(screenshot,new File("target/test.png"));
        System.out.println("Screenshot size: " + screenshot.length);
        System.out.println(driver);
        scenario.attach(
                screenshot,
                "image/png",
                scenario.getName()
        );

        extent.flush();
        driver.quit();
    }



    @Given("user should be on login page")
    public void user_should_be_on_login_page() throws Exception {


       // System.exit(0);
        if(prop.getProperty("browser").equalsIgnoreCase("firefox"))
        {
            driver = new FirefoxDriver();
        }
        else if(prop.getProperty("browser").equalsIgnoreCase("edge"))
        {
            driver = new EdgeDriver();
        }
        else if(prop.getProperty("browser").equalsIgnoreCase("headless"))
        {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless=new");
            driver = new ChromeDriver(options);
        }
        else
        {
            driver = new ChromeDriver();
        }


        driver.manage().window().maximize();
        driver.get(prop.getProperty("AppUrl"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(prop.getProperty("implicitwait"))));
        lp = new LoginPage(driver);
        hp = new HomePage(driver);
        ldp = new LeadPage(driver);
        acp = new AccountPage(driver);
        logger.info("url :"+prop.getProperty("AppUrl"));
    }

    @When("user enters the valid credentials and click on login button")
    public void login()
    {
      lp.login(dt.get(TCName).get("Userid"),dt.get(TCName).get("Password"));
    }

    @Then("user should be navigated to home page")
    public void validate_home_page()
    {

       hp.verifyHome();
    }

    @And("user can see the logout link on home page")
    public void validate_logout()
    {

       hp.verifyLogout();
    }

    @When("user enters the invalid credentials and click on login button")
    public void user_enters_the_invalid_credentials_and_click_on_login_button() {


        lp.login(dt.get(TCName).get("Userid"),dt.get(TCName).get("Password"));
    }
    @Then("user can see the error message")
    public void user_can_see_the_error_message() {
        lp.verifyErrorMsg();
    }

    @When("user enters the invalid credentials username as {string} and password as {string} and click on login button")
    public void user_enters_the_invalid_credentials_username_as_and_password_as_and_click_on_login_button(String userid, String pwd) {


        lp.login(userid,pwd);

    }
}
